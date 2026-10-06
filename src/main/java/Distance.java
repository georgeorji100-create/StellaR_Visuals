
/**
 * Chisom Ndy-Orji
 * Quarter 1 Project
 * Distance Caluculator
 */
public class Distance
{
    // Fields
    private double distanceAu;
    private double distanceMeters;

    //Calacute Distance
    public double calculateDistanceAU(Star starName, Planet planetName)
    {
        double xDifference = planetName.getX() - starName.getX();
        double yDifference = planetName.getY() - starName.getY();
        double zDifference = planetName.getZ() - starName.getZ();
        
        distanceAu = Math.sqrt(xDifference * xDifference 
                            + yDifference * yDifference 
                            + zDifference * zDifference);
                            
        return distanceAu;
    }
    
    public double calculateDistanceM(Star starName, Planet planetName)
    {
        double xDifference = planetName.getX() - starName.getX();
        double yDifference = planetName.getY() - starName.getY();
        double zDifference = planetName.getZ() - starName.getZ();
        
        distanceAu = Math.sqrt(xDifference * xDifference 
                            + yDifference * yDifference 
                            + zDifference * zDifference);
        
        double auToMeters = 1.496e11;
        
        distanceMeters = distanceAu * auToMeters;
        
        return distanceMeters;
    }
    
    //Print Distance
    public void ShowDistance(Star starName, Planet planetName)
    {
        double distanceMeters = calculateDistanceM(starName, planetName);
        double distanceAu = calculateDistanceAU(starName, planetName);
        
        System.out.println("Distance(m) between " + starName.getName() + " and " 
                            + planetName.getName() + ": " + distanceMeters);
        System.out.println("Distance(AU) between " + starName.getName() + " and " 
                            + planetName.getName() + ": " + distanceAu);
    }
}