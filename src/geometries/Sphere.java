
package geometries;
import primitives.*;

import java.util.List;

import static primitives.Util.alignZero;

public abstract class Sphere extends RadialGeometry implements Geometry {
    protected Point3D _center;

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
        super(radius);
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

    /**
     * find intersections point3D with sphere
     * @param ray ray for casting
     * @return list of intersections point3D or null if there were not found
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        Point3D p0 = ray.getPOO();
        Vector v = ray.getDirection();
        Vector u;
        try {
            u = _center.subtract(p0);   // p0 == _center
        } catch (IllegalArgumentException e) {
            return List.of(ray.getTargetPoint(radius));
        }
        double tm = alignZero(v.dotProduct(u));
        double dSquared = (tm == 0) ? u.lengthSquared() : u.lengthSquared() - tm * tm;
        double thSquared = alignZero(radius * radius - dSquared);

        if (thSquared <= 0) return null;

        double th = alignZero(Math.sqrt(thSquared));
        if (th == 0) return null;

        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);
        if (t1 <= 0 && t2 <= 0) return null;
        if (t1 > 0 && t2 > 0) return List.of(ray.getTargetPoint(t1), ray.getTargetPoint(t2)); //P1 , P2
        if (t1 > 0)
            return List.of(ray.getTargetPoint(t1));
        else
            return List.of(ray.getTargetPoint(t2));
    }

}

