import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.PerspectiveCamera;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import java.util.Scanner;
import javafx.scene.transform.Rotate;

public class Main extends Application
{
    private static Star star;
    private static Planet planet;

    private static Simulation simulation;

    @Override
    public void start(Stage stage)
    {
        // Create the simulation using the star and planet
        // selected by the user.
        simulation = new Simulation(star, planet);

        // Create the 3D scene.
        Scene scene = new Scene(
                simulation.getRoot(),
                1000,
                700,
                true);

        // Dark background to represent space.
        scene.setFill(Color.rgb(5, 5, 20));

        // Create the 3D camera.
        PerspectiveCamera camera = new PerspectiveCamera();

        camera.setTranslateX(0);
        camera.setTranslateY(0);
        camera.setTranslateZ(-500);

        scene.setCamera(camera);

        // Set up keyboard and mouse controls.
        cameraControls(scene, camera);

        stage.setTitle("StellaR System Simulation");

        stage.setScene(scene);

        stage.show();
    }

    // Ask the user which objects they want to create.
    public static void choose()
    {
        Scanner scanner = new Scanner(System.in);

        // STAR SELECTION
        System.out.println("Create a star:");
        System.out.println("1. Default Sun");
        System.out.println("2. Custom Star");
        System.out.print("Enter your choice: ");

        int starChoice = scanner.nextInt();

        if (starChoice == 1)
        {
            // Create the default Sun.
            star = new Star(false);
        }
        else
        {
            // Create a custom star.
            star = new Star(true);
        }

        // PLANET SELECTION
        System.out.println("Create a Planet:");
        System.out.println("1. Default Earth");
        System.out.println("2. Custom Planet");
        System.out.print("Enter your choice: ");

        int planetChoice = scanner.nextInt();

        if (planetChoice == 1)
        {
            // Create the default Earth.
            planet = new Planet(false);
        }
        else
        {
            // Create a custom planet.
            planet = new Planet(true);
        }
    }

    // Set up camera movement and rotation.
    public void cameraControls(Scene scene, PerspectiveCamera camera)
    {
        // Create separate rotations for the X and Y axes.
        Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
        Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);

        camera.getTransforms().addAll(rotateX, rotateY);

        // Keyboard controls.
        scene.setOnKeyPressed(event ->
        {
            double angle = Math.toRadians(rotateY.getAngle());

            // Determine which direction the camera is facing.
            double forwardX = Math.sin(angle);
            double forwardZ = Math.cos(angle);

            double speed = 10;

            switch (event.getCode())
            {
                // Move forward.
                case W:
                    camera.setTranslateX(
                            camera.getTranslateX() + forwardX * speed);

                    camera.setTranslateZ(
                            camera.getTranslateZ() + forwardZ * speed);
                    break;

                // Move backward.
                case S:
                    camera.setTranslateX(
                            camera.getTranslateX() - forwardX * speed);

                    camera.setTranslateZ(
                            camera.getTranslateZ() - forwardZ * speed);
                    break;

                // Strafe right.
                case D:
                    camera.setTranslateX(
                            camera.getTranslateX() + forwardZ * speed);

                    camera.setTranslateZ(
                            camera.getTranslateZ() - forwardX * speed);
                    break;

                // Strafe left.
                case A:
                    camera.setTranslateX(
                            camera.getTranslateX() - forwardZ * speed);

                    camera.setTranslateZ(
                            camera.getTranslateZ() + forwardX * speed);
                    break;

                // Move upward.
                case Q:
                    camera.setTranslateY(
                            camera.getTranslateY() - speed);
                    break;

                // Move downward.
                case E:
                    camera.setTranslateY(
                            camera.getTranslateY() + speed);
                    break;

                // Reset camera.
                case R:
                    camera.setTranslateX(0);
                    camera.setTranslateY(0);
                    camera.setTranslateZ(-500);

                    rotateX.setAngle(0);
                    rotateY.setAngle(0);
                    break;

                // Add a new star or planet.
                case N:

                    Scanner scanner = new Scanner(System.in);

                    System.out.println("Add Planet/Star:");
                    System.out.println("1. Create Star");
                    System.out.println("2. Create Planet");
                    System.out.print("Enter your choice: ");

                    int addChoice = scanner.nextInt();

                    if (addChoice == 1)
                    {
                        // Create a new star.
                        star = new Star(false);

                        System.out.print("Enter star X position (AU): ");
                        double sX = scanner.nextDouble();

                        System.out.print("Enter star Y position (AU): ");
                        double sY = scanner.nextDouble();

                        star.changePosition(sX, sY, 0);

                        // Add the star to the JavaFX scene.
                        simulation.addStar(star);
                    }
                    else
                    {
                        // Create a new planet.
                        planet = new Planet(false);

                        System.out.print("Enter planet X position (AU): ");
                        double pX = scanner.nextDouble();

                        System.out.print("Enter planet Y position (AU): ");
                        double pY = scanner.nextDouble();

                        planet.changePosition(pX, pY, 0);

                        // Add the planet to the JavaFX scene.
                        simulation.addPlanet(planet);
                    }

                    break;
            }
        });

        // Zoom in and out with the mouse wheel.
        scene.setOnScroll(event ->
        {
            double zoom = event.getDeltaY();

            camera.setTranslateZ(
                    camera.getTranslateZ() + zoom);
        });

        // Store the mouse's previous position.
        final double[] mouseX = {0};
        final double[] mouseY = {0};

        scene.setOnMousePressed(event ->
        {
            mouseX[0] = event.getSceneX();
            mouseY[0] = event.getSceneY();
        });

        // Rotate the camera when dragging the mouse.
        scene.setOnMouseDragged(event ->
        {
            double changeX =
                    event.getSceneX() - mouseX[0];

            double changeY =
                    event.getSceneY() - mouseY[0];

            double mouseSensitivity = 0.05;

            rotateY.setAngle(
                    rotateY.getAngle()
                            + changeX * mouseSensitivity);

            rotateX.setAngle(
                    rotateX.getAngle()
                            + changeY * mouseSensitivity);

            mouseX[0] = event.getSceneX();
            mouseY[0] = event.getSceneY();
        });
    }

    public static void main(String[] args)
    {
        // Get the user's star and planet choices
        // before launching JavaFX.
        choose();

        // Start the JavaFX application.
        launch(args);
    }
}