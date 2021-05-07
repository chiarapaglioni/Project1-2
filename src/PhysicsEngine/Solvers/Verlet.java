package PhysicsEngine.Solvers;

import PhysicsEngine.Vectors.VectorOperations;
import PhysicsEngine.titan.StateInterface;
import PhysicsEngine.titan.Vector3dInterface;
import PhysicsEngine.Probe.Probe;

import java.util.ArrayList;

/**
 * PhysicsEngine.PhysicsEngine.Planets.Solvers.Verlet solver
 *
 * @author Chiara
 */
public class Verlet {

    //Get the masses of all planets
    private double[] MASSES = new double[] {};
    private final double grav = 6.674E-11;

    private final ArrayList<Vector3dInterface> positions = new ArrayList<>();
    private final ArrayList<Vector3dInterface> previousPositions = new ArrayList<>();
    private final ArrayList<Vector3dInterface> velocities= new ArrayList<>();
    private final Vector3dInterface[] acceleration;

    private final ArrayList<StateInterface> states = new ArrayList<>();

    private final double timeStep;
    private final double numOfSteps;

    public Verlet(StateInterface y0, double timeStep, double numOfSteps) {
        this.states.add(y0);        //Add first state to array of all states

        //Get positions of first state of all planets as Vector3dIntefaces and add them to the positions array
        //Also add previous positions to the previousPositions array

        //Get velocities of all planets and add them to the velocities Arraylist

        //Initialize acceleration vector
        acceleration = new Vector3dInterface[positions.size()];

        //Update accelerations
        //updateAccelerations();

        //Initialize timeStep and numOfSteps
        this.timeStep = timeStep;
        this.numOfSteps = numOfSteps;
    }

    /**
     * Use velocity PhysicsEngine.PhysicsEngine.Planets.Solvers.Verlet on first step to get previous and present position
     * (See formulas backward and forward formulas result in the PhysicsEngine.PhysicsEngine.Planets.Solvers.Verlet formula)
     *
     * @return array with all the different states
     */
    public ArrayList<StateInterface> doVerlet() {
        nextPositionVV();
        addNewState(1);

        for (int i = 2; i < numOfSteps; i++) {
            nextPosition();
            addNewState(i * timeStep);
        }
        return this.states;
    }

    /**
     *  Evaluate next position
     */
    public void nextPosition() {
        for (int i = 0; i < positions.size(); i++) {

            Vector3dInterface pos = positions.get(i).mul(2);
            Vector3dInterface pre_pos = previousPositions.get(i).mul(-1);
            Vector3dInterface acc = acceleration[i].mul(timeStep * timeStep);

            ArrayList<Vector3dInterface> vs = new ArrayList<>();
            vs.add(pos);
            vs.add(pre_pos);
            vs.add(acc);

            previousPositions.set(i, positions.get(i));
            //Implement a way to sum all element of the vector
            positions.set(i, VectorOperations.sumAll(vs));
        }
        updateAcceleration();
    }

    /**
     *
     */
    public void nextPositionVV() {

        //Update position
        for (int i = 0; i < positions.size(); i++) {

            Vector3dInterface pos = positions.get(i);
            Vector3dInterface vel = velocities.get(i).mul(timeStep);
            Vector3dInterface acc = acceleration[i].mul(timeStep * timeStep * (0.5));

            ArrayList<Vector3dInterface> vs = new ArrayList<>();
            vs.add(pos);
            vs.add(vel);
            vs.add(acc);

            positions.set(i, VectorOperations.sumAll(vs));
        }
        updateAcceleration();
    }

    /**
     *
     */
    public void updateAcceleration() {

        for (int i = 0; i < positions.size(); i++) {

            Vector3dInterface body1 = positions.get(i);
            double mass1 = MASSES[i]; //Copy array of masses into new array mass1

            ArrayList<Vector3dInterface> forces = new ArrayList<>();

            for (int j = 0; j < positions.size(); j++) {
                if (j != i) {
                    Vector3dInterface body2 = positions.get(j);
                    double mass2 = MASSES[j];
                    forces.add(gravitationalPull(mass1, mass2, body1, body2));
                }
            }
            acceleration[i] = VectorOperations.sumAll(forces).mul(1/mass1);
        }
    }

    /**
     *
     */
    public void addProbe(Probe probe, Vector3dInterface position, Vector3dInterface velocity) {

        double[] massesWithProbe = new double[MASSES.length + 1];
        System.arraycopy(MASSES, 0, massesWithProbe, 0, MASSES.length);
        massesWithProbe[massesWithProbe.length -1] = probe.mass;
        MASSES = massesWithProbe;

        positions.add(position);
        previousPositions.add(position);
        velocities.add(velocity);
    }

    /**
     *
     * @param mass1
     * @param mass2
     * @param p1
     * @param p2
     * @return
     */
    private Vector3dInterface gravitationalPull(double mass1, double mass2, Vector3dInterface p1, Vector3dInterface p2) {
        double distance = p2.dist(p1);
        Vector3dInterface forceDirection = VectorOperations.directionVector(p1, p2);
        double force = grav * mass1 * mass2 / Math.pow(distance, 2);
        return forceDirection.mul(force);
    }

    /**
     *  Add new state to the states array
     */
    private void addNewState(double time) {
        //states.add(new State(time, new ArrayList<>(this.positions), this.velocities));
    }
}