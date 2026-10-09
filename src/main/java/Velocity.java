
/**
 * Chisom Ndy-Orji
 * Quarter 1 Project
 * Velocity Calculator
 */
public class Velocity
{
    // velocity in the X direction.
    public double calculateXVelocity(double currentVelocity, double acceleration, double timeStep)
    {
        return currentVelocity + acceleration * timeStep;
    }

    // velocity in the Y direction.
    public double calculateYVelocity( double currentVelocity, double acceleration, double timeStep)
    {
        return currentVelocity + acceleration * timeStep;
    }

    // velocity in the Z direction.
    public double calculateZVelocity(double currentVelocity, double acceleration, double timeStep)
    {
        return currentVelocity + acceleration * timeStep;
    }

    // Update all three velocity components for a planet.
    public void updateVelocity(Planet planet, double ax, double ay, double az, double timeStep)
    {
        // Calculate the new velocity in each direction.
        double newXVelocity = calculateXVelocity(
                planet.getXVelocity(), ax, timeStep);

        double newYVelocity = calculateYVelocity(
                planet.getYVelocity(), ay, timeStep);

        double newZVelocity = calculateZVelocity(
                planet.getZVelocity(), az, timeStep);

        // Store the updated velocities in the Planet object.
        planet.setXVelocity(newXVelocity);
        planet.setYVelocity(newYVelocity);
        planet.setZVelocity(newZVelocity);
    }
}