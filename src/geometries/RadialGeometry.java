package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.List;

public abstract class RadialGeometry {
    protected  double radius;

    /**
     *
     * @param radius
     */

    public RadialGeometry(double radius) {
        if(radius <= 0){
            throw new IllegalArgumentException("radious can not be <= 0");
        }
        this.radius = radius;
    }

    public double getR() {
        return radius;
    }
    public abstract List<Point3D> findIntersections(Ray ray);

}
