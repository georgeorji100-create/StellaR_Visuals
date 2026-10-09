import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

public class Simulation
{
    private Planet planet;
    private Sphere planetary;
    private Group root;

    // Converts real star radius into JavaFX screen size.
    private double scaleFactor = 50 / 6.957e8;

    // Converts AU into JavaFX screen distance.
    private double distanceScale = 250;

    public Simulation(Star star, Planet planet)
    {
        this.planet = planet;
        root = new Group();

        // Move the origin to the center of the screen.
        root.setTranslateX(0);
        root.setTranslateY(0);

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
        double planetRadius = Math.max(planet.getRadius() * scaleFactor, 5);
        planetary = new Sphere(planetRadius);

        planetary.setTranslateX(planet.getX() * distanceScale);
        planetary.setTranslateY(planet.getY() * distanceScale);
        planetary.setTranslateZ(planet.getZ() * distanceScale);

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

    public void physicsImplement(Star star, Planet planet, double timeStep)
    {
        // Create the calculators.
        Acceleration accelerationCalculator = new Acceleration();
        Velocity velocityCalculator = new Velocity();

        // 1. Calculate acceleration in all three directions.
        double ax = accelerationCalculator.calculateAX(star, planet);
        double ay = accelerationCalculator.calculateAY(star, planet);
        double az = accelerationCalculator.calculateAZ(star, planet);

        // 2. Update the planet's velocity.
        velocityCalculator.updateVelocity(planet, ax, ay, az, timeStep);

        // 3. Update the planet's position.
        planet.updatePosition(timeStep);
    }

    public void updatePlanetDisplay()
    {
        // Convert Earth's position from AU into JavaFX screen units.
        double screenX = planet.getX() * distanceScale;
        double screenY = planet.getY() * distanceScale;
        double screenZ = planet.getZ() * distanceScale;

        // Move the visible Earth sphere to the calculated coordinates.
        planetary.setTranslateX(screenX);
        planetary.setTranslateY(screenY);
        planetary.setTranslateZ(screenZ);
    }

    //Debugger
    public void printOrbitalDistance()
    {
        // Calculate the distance from the Sun to Earth in AU.
        double x = planet.getX();
        double y = planet.getY();
        double z = planet.getZ();

        double distance = Math.sqrt(x * x + y * y + z * z);

        System.out.printf("Sun-Earth distance: " + distance);
    }

    // Gives Main access to the JavaFX Group.
    public Group getRoot()
    {
        return root;
    }
}