import java.util.Scanner;

/**
 * Chisom Ndy-Orji
 * Quarter 1 Project
 * Planet Information
 */
public class Planet
{
    // Fields
    private String planetName;
    private double mass;

    // Position in AU.
    private double xPosition;
    private double yPosition;
    private double zPosition;

    // Physical properties.
    private double radius;
    private double surfTemp;

    // Velocity in meters per second.
    private double xVelocity;
    private double yVelocity;
    private double zVelocity;

    public Planet(boolean custom)
    {
        if (custom)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter planet name: ");
            planetName = scanner.nextLine();

            System.out.print("Enter planet mass: ");
            mass = scanner.nextDouble();

            System.out.print("Enter planet X position (AU): ");
            xPosition = scanner.nextDouble();

            System.out.print("Enter planet Y position (AU): ");
            yPosition = scanner.nextDouble();

            System.out.print("Enter planet Z position (AU): ");
            zPosition = scanner.nextDouble();

            System.out.print("Enter planet radius (m): ");
            radius = scanner.nextDouble();

            System.out.print(
                    "Enter planet surface temperature in Kelvin: ");

            surfTemp = scanner.nextDouble();
        }
        else
        {
            // Default Earth.
            planetName = "Earth";

            mass = 5.9722e24;

            xPosition = 1;
            yPosition = 0;
            zPosition = 0;

            radius = 6.371e6;

            surfTemp = 288;

            // Earth's approximate orbital velocity.
            xVelocity = 0;
            yVelocity = 29780;
            zVelocity = 0;
        }
    }

    
    // GETTER METHODS
    

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

    // Velocity getters.

    public double getXVelocity()
    {
        return xVelocity;
    }

    public double getYVelocity()
    {
        return yVelocity;
    }

    public double getZVelocity()
    {
        return zVelocity;
    }

    
    // SETTER METHODS
    

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

    public void setSurfTemp(double newTemp)
    {
        surfTemp = newTemp;
    }

    // Velocity setters.

    public void setXVelocity(double newVelocity)
    {
        xVelocity = newVelocity;
    }

    public void setYVelocity(double newVelocity)
    {
        yVelocity = newVelocity;
    }

    public void setZVelocity(double newVelocity)
    {
        zVelocity = newVelocity;
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
                "Planet " + planetName
                        + " coordinates: ("
                        + xPosition + ", "
                        + yPosition + ", "
                        + zPosition + ")");
    }
}