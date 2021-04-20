
package geometries;
import primitives.*;

import java.util.Objects;

public class Cylinder extends Tube {
    private final double hieght;

/*************constructors**********/
    /**
     *
     * @param radius radius from radical geometry
     * @param r ray from tube
     * @param hieght of cylinder
     */
    public Cylinder(double radius, Ray r, double hieght) {
        super(radius, r);
        this.hieght = hieght;
    }

    /************getter***************/
    public double getHieght() { return hieght; }
    /***************to string*********/
    @Override
    public String toString() {
        return "Cylinder{" +
                "hieght=" + hieght +
                '}';
    }

    /**
     * @param point of Point3D
     * @return Normal for cylinder
     */
    public Vector getNormal(Point3D point) {
        return null;
    }

}
