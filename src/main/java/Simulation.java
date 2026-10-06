import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

public class Simulation
{
    private Group root;

    public Simulation(Star star, Planet planet)
    {
        root = new Group();
        root.setTranslateX(500);
        root.setTranslateY(350);

        //Scale
        double scaleFactor = 50 / 6.957e8;

        //1AU is equal to 150 screen units
        double distanceScale = 150;


        //Star
        double starRadius = star.getRadius() * scaleFactor;


        Sphere stellar = new Sphere(starRadius);

        stellar.setTranslateX(star.getX()*distanceScale);
        stellar.setTranslateY(star.getY()*distanceScale);
        stellar.setTranslateZ(star.getZ()*distanceScale);

        PhongMaterial stellarMaterial = new PhongMaterial();
        stellarMaterial.setDiffuseColor(Color.YELLOW);
        stellar.setMaterial(stellarMaterial);

        root.getChildren().add(stellar);


        //Planet
        double planetRadius = Math.max(planet.getRadius()*scaleFactor, 5);

        Sphere planetary = new Sphere(planetRadius);

        planetary.setTranslateX(planet.getX()*distanceScale);
        planetary.setTranslateY(planet.getY()*distanceScale);
        planetary.setTranslateZ(planet.getZ()*distanceScale);

        PhongMaterial planetaryMaterial = new PhongMaterial();
        planetaryMaterial.setDiffuseColor(Color.BLUE);
        planetary.setMaterial(planetaryMaterial);

        root.getChildren().add(planetary);
    }

    public Group getRoot()
    {
        return root;
    }
}
