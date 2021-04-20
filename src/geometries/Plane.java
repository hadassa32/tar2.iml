package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Plane implements Geometry {
    Point3D p;
    primitives.Vector normal;

    @Override
    public String toString() {
        return "Plane{" +
                "p=" + p +
                ", normal=" + normal +
                '}';
    }

    /**
     * @param p1 point 1
     * @param p2 point 2
     * @param p3 point 3
     */
    /*public Plane(Point3D p1, Point3D p2, Point3D p3) {
        Vector U = new Vector (p1, p2);
        Vector V = new Vector (p1, p3);
        Vector N = U.crossProduct(V);

        N.normalize();

        this.normal=N.scale(-1);
        this.p=p1;
    }*/
    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        p = p1;
        normal = null;
    }

    public Plane(Point3D p, Vector normal) {
        this.p = p;
        this.normal = normal.normalized();
    }

    /**
     * @param point of Point3D in plane
     * @return Normal for plane
     */
    @Override
    public Vector getNormal(Point3D point) {
        return normal;
    }

    /*because polygon
     * @return vector normal in a plane
     */
    public Vector getNormal() {
        return getNormal(new Point3D(0, 0, 0));
    }

    /********getter********/
    public Point3D getP() {
        return p;
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        Point3D p0 = ray.getPOO();
        Vector v = ray.getDirection();
        if (p.equals(p0)) {
            return List.of(p); }
        double nv = normal.dotProduct(v);
        if (isZero(nv)) // ray is parallel to the plane - no intersections
            return null;

        double t = alignZero(normal.dotProduct(v) / nv);
        return t <= 0 ? null : List.of(ray.getTargetPoint(t));
    }

}

