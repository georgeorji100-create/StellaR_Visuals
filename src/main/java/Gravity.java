/**
 * Chisom Ndy-Orji
 * Quarter 1 Project
 * Gravitational Interactions
 */
public class Gravity
{
    // Fields
    private double gravConstant;
    private double gravForce;

    // Default Gravity
    public Gravity()
    {
        // Gravitational constant.
        gravConstant = 6.67e-11;

        // Example/default force.
        gravForce = 3.54e22;
    }

    // Find Gravity
    public Gravity(
            Star starName,
            Planet planetName)
    {
        gravConstant = 6.67e-11;

        gravForce =
                calculateGravForce(
                        starName,
                        planetName);
    }

    // Calculate gravitational force.
    public double calculateGravForce(
            Star starName,
            Planet planetName)
    {
        // Use the Distance class instead of
        // calculating distance again here.
        Distance distanceCalculator =
                new Distance();

        // Get distance in meters.
        double distance =
                distanceCalculator.calculateDistanceM(
                        starName,
                        planetName);

        // F = G * M * m / r²
        double force =
                gravConstant
                        * starName.getMass()
                        * planetName.getMass()
                        / (distance * distance);

        return force;
    }

    // Print Gravity and Distance.
    public void ShowData(
            Star starName,
            Planet planetName)
    {
        Distance distanceCalculator =
                new Distance();

        System.out.println(
                "Distance(m) between "
                        + starName.getName()
                        + " and "
                        + planetName.getName()
                        + ": "
                        + distanceCalculator.calculateDistanceM(
                        starName,
                        planetName));

        System.out.println(
                "Gravity(N) between "
                        + starName.getName()
                        + " and "
                        + planetName.getName()
                        + ": "
                        + calculateGravForce(
                        starName,
                        planetName));
    }
}