package geometries;

import primitives.*;

/**
 * interface for all geometries with getNormal
 */
public interface Geometry {
    /**
     * Return normal to geometry
     * @param point a point on the geometry, that the normal is a normal to the geometry from this point
     * @return normal to geometry
     */
    Vector getNormal(Point3D point);


}
