package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point3DTest {

    Point3D p1 = new Point3D( 0.0d, 0.5d, 1.0d);
    Point3D p2 = new Point3D( 0.00000001d, 0.49999999d, 1d);

    @Test
    void testEquals() {
        assertEquals(p1, p2);
    }

    @Test
    void testToString() {
        System.out.println("th first point is: " + p1);
        System.out.println("th first point is: " + p2);

    }
   /* add Point3D to vector
  return Point3D
  */

    @Test
    void add() {
        Vector p1 = new Vector(1, 2, 3);
        Point3D result = new Point3D(2,3,4).add(p1);
        assertEquals(new Point3D(3,5,7),result,"ERROR: Point - Point does not work correctly");

    }

}