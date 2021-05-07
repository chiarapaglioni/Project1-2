package PhysicsEngine.Vectors;

import PhysicsEngine.InterfacesImplementations.Vector3d;
import PhysicsEngine.titan.Vector3dInterface;

import java.util.ArrayList;

public class VectorOperations {

    /**
     * TO BE IMPLEMENTED!!!
     * Sum all vectors together
     * @return a the sum all vectors as another vector3dInterface
     */
    public static Vector3dInterface sumAll(ArrayList<Vector3dInterface> vectors) {
        Vector3dInterface sum = new Vector3d();

        for (int i = 0; i < vectors.size(); i++) {

        }
        return sum;
    }

    /**
     *  TO BE IMPLEMENTED!!!
     *  Get the direction of the two vectors
     */
    public static Vector3dInterface directionVector(Vector3dInterface v1, Vector3dInterface v2) {
        Vector3dInterface output = new Vector3d();

        return output;
    }
}
