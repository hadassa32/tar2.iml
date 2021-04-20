package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class TubeTest {
    /**
     * test for tube get normal function @link geometries.Tube# getNormal(primitives.Point3D)}.
     * }
     */
    @Test
    void getNormal() {

        //Tube t= new Tube(new Ray(new Point3D(3,5,8),new Vector(4,7,6)), 4);
        //Vector n=t.getNormal(new Point3D(4,2,1));
        //Vector check=new Vector(0.6736255682471604, 0.21987778192043828, -0.7056077910719512);
        //assertEquals(check, n);

        Tube tb = new Tube(1, new Ray(new Point3D(0,0,1), new Vector(0, 1, 0)));
        assertEquals(new Vector(0,0,1),tb.getNormal(new Point3D(0,0.5,2)));
        /**
         * Test method for
         * {@link geometries.Tube#getNormal(primitives.Point3D)}.
         */

        // ============ Equivalence Partitions Tests ==============



        // ============ Equivalence Partitions Tests ==============
        //Test simple Tube
        Ray r = new Ray(new Point3D(0, 1, 0), new Vector(0, 1, 0));
        Tube t1 = new Tube(4, r);
        assertEquals("not good normal", new Vector(1, 0, 0), t1.getNormal(new Point3D(4, 0, 0)));

        //another Test
        Ray r1 = new Ray(Point3D.ZERO, new Vector(1, 1, 0));
        Tube t2 = new Tube(2, r1);
        assertEquals("", new Vector(0, 0, 1), t2.getNormal(new Point3D(2, 2, 2)));
        // =============== Boundary Values Tests ==================
        //Test point null
        try {
            t2.getNormal(null);
        } catch (Exception e) {
            assertTrue(e instanceof NullPointerException);
        }
    }

}

