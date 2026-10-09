import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.PerspectiveCamera;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import java.util.Scanner;
import javafx.scene.transform.Rotate;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;

public class Main extends Application
{
    private static Star star;
    private static Planet planet;

    private static Simulation simulation;
    private static double simulationSpeed = 1000000.0;
    private static final double MAX_PHYSICS_STEP = 100;

    @Override
    public void start(Stage stage)
    {
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
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(100000);

        camera.setTranslateX(0);
        camera.setTranslateY(0);
        camera.setTranslateZ(-1000);

        scene.setCamera(camera);

        cameraControls(scene, camera);

        stage.setTitle("StellaR System Simulation");
        stage.setScene(scene);
        stage.show();

        // Run the physics repeatedly while the JavaFX window is open.
        AnimationTimer timer = new AnimationTimer()
        {
            private long lastUpdate = 0;
            private int debugCounter = 0;

            @Override
            public void handle(long now)
            {
                // Skip the first frame to establish a starting timestamp.
                if (lastUpdate == 0)
                {
                    lastUpdate = now;
                    return;
                }

                // Convert real time from nanoseconds to seconds.
                double elapsedSeconds = (now - lastUpdate) / 1e9;
                lastUpdate = now;

                double elapsed = Math.min(elapsedSeconds, 0.05);

                double timeStep = elapsed * simulationSpeed;

                int steps = Math.max
                        (
                            1, (int) Math.ceil(timeStep / MAX_PHYSICS_STEP)
                        );

                double dt = timeStep / steps;

                for (int i = 0; i < steps; i++)
                {
                    simulation.physicsImplement(star, planet, dt);
                }

                simulation.updatePlanetDisplay();

                //Debugger
                debugCounter++;

                if (debugCounter >= 60)
                {
                    simulation.printOrbitalDistance();
                    debugCounter = 0;
                }
            }
        };

        timer.start();
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
        Group cameraPivot = new Group();

        Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
        Rotate rotateX = new Rotate(-20, Rotate.X_AXIS);

        cameraPivot.getTransforms().addAll(rotateY, rotateX);

        camera.setTranslateX(0);
        camera.setTranslateY(0);
        camera.setTranslateZ(-1000);

        cameraPivot.getChildren().add(camera);

        ((Group) scene.getRoot()).getChildren().add(cameraPivot);

        scene.setCamera(camera);

        final double[] mouseX = {0};
        final double[] mouseY = {0};

        scene.setOnMousePressed(event ->
        {
            mouseX[0] = event.getSceneX();
            mouseY[0] = event.getSceneY();
        });

        scene.setOnMouseDragged(event ->
        {
            double dx = event.getSceneX() - mouseX[0];
            double dy = event.getSceneY() - mouseY[0];

            rotateY.setAngle(rotateY.getAngle() + dx * 0.4);

            double newAngleX = rotateX.getAngle() + dy * 0.4;
            rotateX.setAngle(Math.max(-85, Math.min(85, newAngleX)));

            mouseX[0] = event.getSceneX();
            mouseY[0] = event.getSceneY();
        });

        // Scroll to zoom in and out.
        scene.setOnScroll(event ->
        {
            double zoomAmount = event.getDeltaY() * 0.5;
            double newZ = camera.getTranslateZ() + zoomAmount;

            // Prevent zooming too close or too far away.
            camera.setTranslateZ(Math.max(-5000, Math.min(-200, newZ)));
        });

        // Keyboard controls.
        scene.setOnKeyPressed(event ->
        {
            double speed = 20;

            switch (event.getCode())
            {
                // Move forward and backward.
                case W:
                    camera.setTranslateZ(
                            Math.min(-200, camera.getTranslateZ() + speed));
                    break;

                case S:
                    camera.setTranslateZ(
                            Math.max(-5000, camera.getTranslateZ() - speed));
                    break;

                // Move left and right.
                case A:
                    camera.setTranslateX(camera.getTranslateX() - speed);
                    break;

                case D:
                    camera.setTranslateX(camera.getTranslateX() + speed);
                    break;

                // Move vertically.
                case Q:
                    camera.setTranslateY(camera.getTranslateY() - speed);
                    break;

                case E:
                    camera.setTranslateY(camera.getTranslateY() + speed);
                    break;

                // Reset the camera to its starting position.
                case R:
                    rotateX.setAngle(-20);
                    rotateY.setAngle(0);

                    camera.setTranslateX(0);
                    camera.setTranslateY(0);
                    camera.setTranslateZ(-1000);
                    break;

                default:
                    break;
            }
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