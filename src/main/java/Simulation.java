import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

public class Simulation
{
    private Group root;

    // Converts real star radius into JavaFX screen size.
    private double scaleFactor = 50 / 6.957e8;

    // Converts AU into JavaFX screen distance.
    // 1 AU = 150 screen units.
    private double distanceScale = 150;

    public Simulation(Star star, Planet planet)
    {
        root = new Group();

        // Move the origin to the center of the screen.
        root.setTranslateX(500);
        root.setTranslateY(350);

        
        // STAR
        

        double starRadius =
                star.getRadius() * scaleFactor;

        Sphere stellar =
                new Sphere(starRadius);

        // Convert the star's position into JavaFX coordinates.
        stellar.setTranslateX(
                star.getX() * distanceScale);

        stellar.setTranslateY(
                star.getY() * distanceScale);

        stellar.setTranslateZ(
                star.getZ() * distanceScale);

        PhongMaterial stellarMaterial =
                new PhongMaterial();

        // Change star color based on temperature.
        if (star.getSurfTemp() > 2000 &&
                star.getSurfTemp() <= 3900)
        {
            stellarMaterial.setDiffuseColor(Color.DARKRED);
        }
        else if (star.getSurfTemp() > 3900 &&
                star.getSurfTemp() <= 5300)
        {
            stellarMaterial.setDiffuseColor(Color.ORANGE);
        }
        else if (star.getSurfTemp() > 5300 &&
                star.getSurfTemp() <= 6000)
        {
            stellarMaterial.setDiffuseColor(Color.YELLOW);
        }
        else if (star.getSurfTemp() > 6000 &&
                star.getSurfTemp() <= 7300)
        {
            stellarMaterial.setDiffuseColor(Color.LIGHTYELLOW);
        }
        else if (star.getSurfTemp() > 7300 &&
                star.getSurfTemp() <= 10000)
        {
            stellarMaterial.setDiffuseColor(Color.WHITE);
        }
        else if (star.getSurfTemp() > 10000 &&
                star.getSurfTemp() <= 33000)
        {
            stellarMaterial.setDiffuseColor(Color.LIGHTBLUE);
        }
        else if (star.getSurfTemp() > 33000)
        {
            stellarMaterial.setDiffuseColor(Color.BLUEVIOLET);
        }

        stellar.setMaterial(stellarMaterial);

        root.getChildren().add(stellar);

        
        // PLANET
        

        // Make sure very small planets are still visible.
        double planetRadius =
                Math.max(
                        planet.getRadius() * scaleFactor,
                        5);

        Sphere planetary =
                new Sphere(planetRadius);

        planetary.setTranslateX(
                planet.getX() * distanceScale);

        planetary.setTranslateY(
                planet.getY() * distanceScale);

        planetary.setTranslateZ(
                planet.getZ() * distanceScale);

        PhongMaterial planetaryMaterial =
                new PhongMaterial();

        planetaryMaterial.setDiffuseColor(Color.BLUE);

        planetary.setMaterial(planetaryMaterial);

        root.getChildren().add(planetary);
    }

    // Add a new star to the simulation.
    public void addStar(Star star)
    {
        double starRadius =
                star.getRadius() * scaleFactor;

        Sphere stellar =
                new Sphere(starRadius);

        stellar.setTranslateX(
                star.getX() * distanceScale);

        stellar.setTranslateY(
                star.getY() * distanceScale);

        stellar.setTranslateZ(
                star.getZ() * distanceScale);

        PhongMaterial stellarMaterial =
                new PhongMaterial();

        stellarMaterial.setDiffuseColor(Color.YELLOW);

        stellar.setMaterial(stellarMaterial);

        root.getChildren().add(stellar);
    }

    // Add a new planet to the simulation.
    public void addPlanet(Planet planet)
    {
        double planetRadius =
                Math.max(
                        planet.getRadius() * scaleFactor,
                        5);

        Sphere planetary =
                new Sphere(planetRadius);

        planetary.setTranslateX(
                planet.getX() * distanceScale);

        planetary.setTranslateY(
                planet.getY() * distanceScale);

        planetary.setTranslateZ(
                planet.getZ() * distanceScale);

        PhongMaterial planetaryMaterial =
                new PhongMaterial();

        planetaryMaterial.setDiffuseColor(Color.BLUE);

        planetary.setMaterial(planetaryMaterial);

        root.getChildren().add(planetary);
    }

    // Gives Main access to the JavaFX Group.
    public Group getRoot()
    {
        return root;
    }
}