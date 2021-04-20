package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {
    /**
     * test for plane get normal function @link geometries.Plane# getNormal(primitives.Point3D)}.
     */
    @Test
    void getNormal() {

        Plane P = new Plane(new Point3D(6,7,8), new Vector(4,5,6));
        Vector v1 = P._normal;
        Vector v2 = P.getNormal(new Point3D(3,4,5));
        assertEquals(v1, v2);
    }
    public void getNormal() {

        // ============ Equivalence Partitions Tests ==============
        Vector point = new Vector(1,2,3);
        Plane pl = new Plane(new Point3D(1,2,3), new Point3D(4,5,6), new Point3D(-3,5,4));
        Vector normal = pl.getNormal(new Point3D(1,2,3));
        assertTrue("the normal is not orthogonal to direct vector on the plane", isZero(normal.dotProduct(new Vector(1,2,3).subtract(new Vector(-3,5,4)))));
    }
    @Test
    public void findIntsersections() {

        Plane plane = new Plane(new Point3D(1,1,0), new Vector(0,0,1));

        // ============ Equivalence Partitions Tests ==============

        assertEquals("ray intersects the plane", List.of(new Point3D(1,0,0)),
                plane.findIntersections(new Ray(new Point3D(0,0,-1), new Vector(1,0,1))));
        assertNull("ray does'nt intersect the plane", plane.findIntersections(new Ray(new Point3D(0,0,-1), new Vector(1,0,-1))));

        assertNull("the ray is parallel and not included in the plane", plane.findIntersections(new Ray(new Point3D(1,1,1), new Vector(0,1,0))));
        assertEquals("the ray is orthogonal and before the plane", List.of(new Point3D(1,1,0)),
                plane.findIntersections(new Ray(new Point3D(1,1,-1), new Vector(0,0,1))));

        assertNull("the ray is orthogonal and in the plane",
                plane.findIntersections(new Ray(new Point3D(1,1,0), new Vector(0,0,1))));

        assertEquals("the ray is orthogonal and after the plane", List.of(new Point3D(1,1,0)),
                plane.findIntersections(new Ray(new Point3D(1,1,1), new Vector(0,0,-1))));
        assertNull("the ray is neither orthogonal nor parallel to and begins at the plane",
                plane.findIntersections(new Ray(new Point3D(2,2,0), new Vector(1,1,1))));

        assertNull("the ray is neither orthogonal nor parallel to the plane and begins in " +
                "the same point which appears as reference point in the plane", plane.findIntersections(new Ray(new Point3D(1,1,0), new Vector(1,1,1))));
    }
}
