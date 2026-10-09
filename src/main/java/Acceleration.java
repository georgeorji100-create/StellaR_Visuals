
/**
 * Chisom Ndy-Orji
 * Quarter 1 Project
 * Acceleration Calculator
 */
public class Acceleration
{
    // Gravitational constant: m^3 / (kg * s^2).
    private final double G = 6.6743e-11;

    // Convert coordinate differences from AU to meters.
    private final double AU_TO_METERS = 1.496e11;

    // Calculate acceleration in the X direction.
    public double calculateAX(Star star, Planet planet)
    {
        Distance distanceCalculator = new Distance();

        double distance = distanceCalculator.calculateDistanceM(star, planet);

        double dx = (star.getX() - planet.getX()) * AU_TO_METERS;

        return G * star.getMass() * dx / (distance * distance * distance);
    }

    // Calculate acceleration in the Y direction.
    public double calculateAY(Star star, Planet planet)
    {
        Distance distanceCalculator = new Distance();

        double distance = distanceCalculator.calculateDistanceM(star, planet);

        double dy = (star.getY() - planet.getY()) * AU_TO_METERS;

        return G * star.getMass() * dy / (distance * distance * distance);
    }

    // Calculate acceleration in the Z direction.
    public double calculateAZ(Star star, Planet planet)
    {
        Distance distanceCalculator = new Distance();

        double distance = distanceCalculator.calculateDistanceM(star, planet);

        double dz = (star.getZ() - planet.getZ()) * AU_TO_METERS;

        return G * star.getMass() * dz / (distance * distance * distance);
    }
}