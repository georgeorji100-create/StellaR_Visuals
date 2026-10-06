import java.util.Scanner;

/**
 * Chisom Ndy-Orji
 * Quarter 1 Project
 * Planet Information
 */
public class Planet
{
    //Fields
    private String planetName;
    private double mass;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private double radius;
    private double surfTemp;

    public Planet (boolean custom)
    {
        if (custom)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter planet name: ");
            planetName = scanner.nextLine();

            System.out.print("Enter planet mass: ");
            mass = scanner.nextDouble();

            System.out.print("Enter planet X position: ");
            mass = scanner.nextDouble();

            System.out.print("Enter planet Y position: ");
            mass = scanner.nextDouble();

            System.out.print("Enter planet radius: ");
            mass = scanner.nextDouble();

            System.out.print("Enter planet surface temperatre: ");
            mass = scanner.nextDouble();
        }

        else
        {
            planetName = "Earth";
            mass = 5.9722e24;
            xPosition = 1;
            yPosition = 0;
            zPosition = 0;
            radius = 6.371e6;
            surfTemp = 15;
        }
    }

    // Getter Methods
    public String getName()
    {
        return planetName;
    }

    public double getMass()
    {
        return mass;
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

    public double getsurfTemp()
    {
        return surfTemp;
    }

    // Setter Methods
    public void setName(String newName)
    {
        planetName = newName;
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

    public void setSurfTemp(double newTempF)
    {
        radius = newTempF;
    }

    // Change Position
    public void changePosition(double newX, double newY, double newZ)
    {
        xPosition = newX;
        yPosition = newY;
        zPosition = newZ;
    }

    // Print Position
    public void printPosition()
    {
        System.out.println("Planet " + planetName + " coordinates: (" + xPosition + ", "
                + yPosition + ", " + zPosition + ")");
    }
}