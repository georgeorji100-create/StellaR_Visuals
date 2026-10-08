/**
 * Chisom Ndy-Orji
 * Quarter 1 Project
 * Distance Calculator
 */
public class Distance
{
    // Fields
    private double distanceAu;
    private double distanceMeters;

    // Calculate distance in AU.
    public double calculateDistanceAU(
            Star starName,
            Planet planetName)
    {
        // Find the difference in each coordinate.
        double xDifference =
                planetName.getX() - starName.getX();

        double yDifference =
                planetName.getY() - starName.getY();

        double zDifference =
                planetName.getZ() - starName.getZ();

        // 3D distance formula.
        distanceAu =
                Math.sqrt(
                        xDifference * xDifference
                                + yDifference * yDifference
                                + zDifference * zDifference);

        return distanceAu;
    }

    // Calculate distance in meters.
    public double calculateDistanceM(
            Star starName,
            Planet planetName)
    {
        // First calculate the distance in AU.
        distanceAu =
                calculateDistanceAU(starName, planetName);

        // Convert AU to meters.
        double auToMeters = 1.496e11;

        distanceMeters =
                distanceAu * auToMeters;

        return distanceMeters;
    }

    // Print both distance measurements.
    public void ShowDistance(
            Star starName,
            Planet planetName)
    {
        double distanceMeters =
                calculateDistanceM(starName, planetName);

        double distanceAu =
                calculateDistanceAU(starName, planetName);

        System.out.println(
                "Distance(m) between "
                        + starName.getName()
                        + " and "
                        + planetName.getName()
                        + ": "
                        + distanceMeters);

        System.out.println(
                "Distance(AU) between "
                        + starName.getName()
                        + " and "
                        + planetName.getName()
                        + ": "
                        + distanceAu);
    }
}