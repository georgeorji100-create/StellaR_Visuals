import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.PerspectiveCamera;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import java.util.Scanner;

public class Main extends Application
{
    private static Star star;
    private static Planet planet;

    @Override
    public void start(Stage stage)
    {
        Simulation simulation = new Simulation(star, planet);

        Scene scene = new Scene(
                simulation.getRoot()
                ,1000
                ,700
                ,true);

        scene.setFill(Color.rgb(5, 5, 20));

        PerspectiveCamera camera = new PerspectiveCamera();

        camera.setTranslateX(0);
        camera.setTranslateY(0);
        camera.setTranslateZ(-500);

        scene.setCamera(camera);

        stage.setTitle("StellaR System Simulation");

        stage.setScene(scene);

        stage.show();
    }

    public static void choose()
    {
        Scanner scanner = new Scanner(System.in);

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

        System.out.println("Create a Planet:");
        System.out.println("1. Default Earth");
        System.out.println("2. Custom Planet");
        System.out.print("Enter your choice: ");

        int planetChoice = scanner.nextInt();

        if (planetChoice == 1)
        {
            // Create the default earth.
            planet = new Planet(false);
        }
        else
        {
            // Create a custom planet.
            star = new Star(true);
        }
    }

    public static void main(String[] args)
    {
        choose();
        launch(args);
    }
}
