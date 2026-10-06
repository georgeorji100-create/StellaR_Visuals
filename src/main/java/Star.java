import java.util.Scanner;

/**
 * Chisom Ndy-Orji
 * Quarter 1 Project
 * Star Information
 */

public class Star
{
    //Fields
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

    //Default Constructor
    public Star (boolean custom)
    {
        if (custom)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter star name: ");
            starName = scanner.nextLine();

            System.out.print("Enter mass: ");
            mass = scanner.nextDouble();

            System.out.print("Enter hydrogen percentage: ");
            pcentHydrogen = scanner.nextDouble();

            System.out.print("Enter helium percentage: ");
            pcentHelium = scanner.nextDouble();

            System.out.print("Enter heavy element percentage: ");
            pcentHeavyElements =  scanner.nextDouble();

            System.out.print("Enter X coordinate: ");
            xPosition = scanner.nextDouble();

            System.out.print("Enter Y coordinate: ");
            yPosition = scanner.nextDouble();

            System.out.print("Enter Z coordinate: ");
            zPosition = scanner.nextDouble();

            System.out.print("Enter radius: ");
            radius = scanner.nextDouble();

            System.out.print("Enter surface temperature: ");
            surfTemp = scanner.nextDouble();
        }

        else
        {
            // Create the Sun
            this.starName = "Sun";
            this.mass = 1.989e30;
            this.pcentHydrogen = 71.0;
            this.pcentHelium = 27.1;
            this.pcentHeavyElements = 1.9;
            this.xPosition = 0;
            this.yPosition = 0;
            this.zPosition = 0;
            this.radius = 6.957e8;
            this.surfTemp = 5800;
        }
    }

    //Getter Methods
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

    //Setter Methods
    public void setName(String newName)
    {
        starName = newName;
    }

    public void setX(double newX)
    {
        xPosition = newX;
    }

    public void setY(double newY)
    {
        yPosition = newY;
    }

    public void setZ(double newZ)
    {
        zPosition = newZ;
    }

    public void setRadius(double newRadius)
    {
        radius = newRadius;
    }

    public void setSurfTemp(double newTemp)
    {
        surfTemp = newTemp;
    }

    //Change Position
    public void changePosition(double newX, double newY, double newZ)
    {
        xPosition = newX;
        yPosition = newY;
        zPosition = newZ;
    }

    //Print Position
    public void printPosition()
    {
        System.out.println("Star " + starName + " coordinates: (" + xPosition + ", " + yPosition + ", " + zPosition + ")");
    }
}