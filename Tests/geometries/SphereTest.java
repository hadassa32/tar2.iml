package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {
    /**
     * test for sphere get normal @link geometries.Sphere# getNormal(primitves.Point3D)}.
     */
    @Test
    void getNormal() {
        Sphere sp = new Sphere(5, new Point3D(0,0,0));
        assertEquals(new Vector(1,0,0),sp.getNormal(new Point3D(5,0,0)));


        Sphere s=new Sphere(1.0,new Point3D(0,0,1));
        assertEquals("Bad normal for Shprere",new Vector(0,0,1), (Supplier<String>) s.getNormal(new Point3D(0,0,2)));

    }

}