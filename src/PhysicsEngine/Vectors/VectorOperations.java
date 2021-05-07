package PhysicsEngine.Vectors;

import PhysicsEngine.InterfacesImplementations.Vector3d;
import PhysicsEngine.titan.Vector3dInterface;

import java.util.ArrayList;

public class VectorOperations {

    /**
     * Sum all Vector3d objects of an ArrayList together
     * @return a the sum all vectors as another vector3dInterface
     */
    public static Vector3dInterface sumAll(ArrayList<Vector3dInterface> vectors) {
        Vector3dInterface sum = new Vector3d();

        for (int i = 0; i < vectors.size(); i++) {
            sum.add(vectors.get(i));
        }
        return sum;
    }

    /**
     *  Given two vector I approximate their direction to the mean vector between them
     *
     *  @param v1 is the first vector
     *  @param v2 is the second vector
     *  @return The direction resulting from the mean of the two vectors
     */
    public static Vector3dInterface directionVector(Vector3dInterface v1, Vector3dInterface v2) {
        Vector3dInterface output = new Vector3d();

        double newX = (v1.getX() + v2.getX()) / 2;
        double newY = (v1.getY() + v2.getY()) / 2;
        double newZ = (v1.getZ() + v2.getZ()) / 2;
        output.setX(newX);
        output.setY(newY);
        output.setZ(newZ);

        return output;
    }
}
