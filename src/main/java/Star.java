import java.util.Scanner;

/**
 * Chisom Ndy-Orji
 * Quarter 1 Project
 * Star Information
 */
public class Star
{
    // Fields
    private String starName;
    private double mass;

    private double pcentHydrogen;
    private double pcentHelium;
    private double pcentHeavyElements;

    private double xPosition;
    private double yPosition;
    private double zPosition;

    private double radius;
    private double surfTemp;

    public Star(boolean custom)
    {
        if (custom)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter star name: ");
            starName = scanner.nextLine();

            System.out.print("Enter star mass: ");
            mass = scanner.nextDouble();

            System.out.print("Enter percentage of hydrogen: ");
            pcentHydrogen = scanner.nextDouble();

            System.out.print("Enter percentage of helium: ");
            pcentHelium = scanner.nextDouble();

            System.out.print(
                    "Enter percentage of heavy elements: ");

            pcentHeavyElements = scanner.nextDouble();

            System.out.print("Enter star X position (AU): ");
            xPosition = scanner.nextDouble();

            System.out.print("Enter star Y position (AU): ");
            yPosition = scanner.nextDouble();

            System.out.print("Enter star Z position (AU): ");
            zPosition = scanner.nextDouble();

            System.out.print("Enter star radius (m): ");
            radius = scanner.nextDouble();

            System.out.print(
                    "Enter star surface temperature (K): ");

            surfTemp = scanner.nextDouble();
        }
        else
        {
            // Default Sun.
            starName = "Sun";

            mass = 1.989e30;

            pcentHydrogen = 71.0;
            pcentHelium = 27.1;
            pcentHeavyElements = 1.9;

            xPosition = 0;
            yPosition = 0;
            zPosition = 0;

            radius = 6.957e8;

            surfTemp = 5800;
        }
    }

    
    // GETTER METHODS
    

    public String getName()
    {
        return starName;
    }

    public double getMass()
    {
        return mass;
    }

    public double getHydrogenContent()
    {
        return pcentHydrogen;
    }

    public double getHeliumContent()
    {
        return pcentHelium;
    }

    public double getHeavyElementContent()
    {
        return pcentHeavyElements;
    }

    public double getX()
    {
        return xPosition;
    }

    public double getY()
    {
        return yPosition;
    }

    public double getZ()
    {
        return zPosition;
    }

    public double getRadius()
    {
        return radius;
    }

    public double getSurfTemp()
    {
        return surfTemp;
    }

    
    // CHANGE POSITION
    

    public void changePosition(
            double newX,
            double newY,
            double newZ)
    {
        xPosition = newX;
        yPosition = newY;
        zPosition = newZ;
    }

    
    // PRINT POSITION
    

    public void printPosition()
    {
        System.out.println(
                "Star " + starName
                        + " coordinates: ("
                        + xPosition + ", "
                        + yPosition + ", "
                        + zPosition + ")");
    }
}