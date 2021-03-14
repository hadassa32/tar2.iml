
package geometries;
import primitives.*;

public abstract class Sphere implements Geometry {
    protected Point3D _center;
    protected double radius;

    /**
     *
     * @param radius OF SPHERE
     * @param _center OF SPHERE
     */
    /************constractors****/
    /**
     * Constructor for Sphere class, gets a radius and a center point3D, and creates a new sphere
     * @param radius radius of a sphere
     * @param center a point3D, the center point of a sphere
     */
    public Sphere(double radius, Point3D center) {
        this.radius=radius;
        this._center = center;
    }

    /**********getter**********/
    public Point3D get_center() {
        return _center;
    }
    /*****************to string  ***********/

    @Override
    public String toString() {
        return "Sphere{" +
                "_center=" + _center +
                '}';
    }
    @Override
    public Vector getNormal(Point3D point) {
        return null;
    }
}
