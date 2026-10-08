/**
 * Chisom Ndy-Orji
 * Quarter 1 Project
 * Acceleration Calculator
 */
public class Acceleration
{
    // Calculate the acceleration caused by gravity.
    public double calculateAcceleration(
            Star star,
            Planet planet)
    {
        // Create a Gravity object.
        Gravity gravity = new Gravity();

        // Calculate the gravitational force.
        double force = gravity.calculateGravForce(star, planet);

        // Newton's Second Law:
        // a = F / m
        double acceleration = force / planet.getMass();

        return acceleration;
    }
}