
/**
 * Chisom Ndy-Orji
 * Quarter 1 Project
 * Graviational Interactions
 */
public class Gravity
{
    //Fields
    private double gravConstant;
    private double gravForce;
    
    //Default Gravity
    public Gravity()
    {
        gravConstant = 6.67e-11;
        gravForce = 3.54e22;
    }
    
    //Find Gravity
    public Gravity(Star starName, Planet planetName)
    {
        gravConstant = 6.67e-11;
        gravForce = calculateGravForce(starName, planetName);
    }
    
    //Calacute Distance
    public double calculateDistance(Star starName, Planet planetName)
    {
        double xDifference = planetName.getX() - starName.getX();
        double yDifference = planetName.getY() - starName.getY();
        double zDifference = planetName.getZ() - starName.getZ();
        
        double distanceAu = Math.sqrt(xDifference * xDifference 
                            + yDifference * yDifference 
                            + zDifference * zDifference);
                            
        double auToMeters = 1.496e11;
        
        double distanceMeters = distanceAu * auToMeters;
        
        return distanceMeters;
    }
    
    //Calculate Gravitional Force
    public double calculateGravForce(Star starName, Planet planetName)
    {    
        double distance = calculateDistance(starName, planetName);
        
        double force = gravConstant * starName.getMass() * planetName.getMass() / (distance * distance);
        
        return force;
    }
    
    //Print Gravity and Distance
    public void ShowData(Star starName, Planet planetName)
    {
        System.out.println("Distance(m) between " + starName.getName() + " and " 
                            + planetName.getName() + ": " + calculateDistance(starName, planetName));
        System.out.println("Gravity(N) between " + starName.getName() + " and " 
                            + planetName.getName() + ": " + calculateGravForce(starName, planetName));
    }
}