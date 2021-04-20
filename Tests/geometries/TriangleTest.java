package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

/* test for triangle get normal function @link geometries.Triangle# getNormal(primitives.Point3D)}.*/

class TriangleTest {
    @Test
    public void getNormal() {
        Triangle tr = new Triangle(new Point3D(0,0,1), new Point3D(1,1,1), new Point3D(1,0,1));
        assertEquals(new Vector(0d,0d,-1d),tr.getNormal(null));
    }
    public void testConstructor() {
        // ============ Equivalence Partitions Tests ==============
        //TC01:with two same points and so it's not a triangle it's a vector
        try {
            new Triangle( new Point3D(0, 0, 0), new Point3D(0, 0, 0), new Point3D(1, 2, 3));
            fail("Constructed a vector not a triangle ");
        } catch (IllegalArgumentException e) {

        }
        public void getNormal() {
            // ============ Equivalence Partitions Tests ==============
            Triangle tr = new Triangle(new Point3D(0,0,1), new Point3D(1,0,0), new Point3D(0,1,0));
            double sqrtLen = Math.sqrt(1d / 3);
            Vector normal = tr.getNormal(new Point3D(0,0,1));
            assertEquals("Bad normal to triangle", new Vector(sqrtLen, sqrtLen, sqrtLen), normal);
        }

/**
 * we test if when we have intersection witch ray and triangle we find intersection if exist amd if he found the right intersection
 */
        @Test
        public void findIntersections() {
            // ============ Equivalence Partitions Tests ==============
            //TC01 inside triangle
            Ray ray = new Ray(new Point3D(-4, 4, 3), new Vector(4, -2, -1));
            Triangle triangle = new Triangle(new Point3D(0, 0, 0), new Point3D(0, 6, 0), new Point3D(0, 0, 8));
            List<Point3D> intersectionsList = triangle.findIntersections(ray);
            assertNotNull( intersectionsList,"must be not empty");
            assertEquals( 1, intersectionsList.size(),"must be equal to 1");
            assertEquals( new Point3D(0, 2, 2), intersectionsList.get(0),"must be the same");

            //TC02 outside against edge
            ray = new Ray(new Point3D(5, 6, 0), new Vector(0, 0, -1));
            intersectionsList = triangle.findIntersections(ray);
            assertNull( intersectionsList,"must be empty");


            //TC02 outside against vertex
            ray = new Ray(new Point3D(-1, -1, 0), new Vector(0, 0, -1));
            intersectionsList = triangle.findIntersections(ray);
            assertNull( intersectionsList,"must be empty");


            // =============== Boundary Values Tests ==================

            //ray starts "before" the plane
            //TC10 on edge
            ray = new Ray(new Point3D(-2, 0, 5), new Vector(1, 0, -1));
            intersectionsList = triangle.findIntersections(ray);
            assertNull( intersectionsList,"must be empty");

            // TC12 in vertex
            ray = new Ray(new Point3D(6, 0, 1), new Vector(1, 0, -1));
            intersectionsList = triangle.findIntersections(ray);
            assertNull( intersectionsList,"must be not empty");

            // TC13 on edge continuation
            ray = new Ray(new Point3D(10, 0, 0), new Vector(0, 0, -1));
            intersectionsList = triangle.findIntersections(ray);
            assertNull( intersectionsList,"must be empty");
        }

}