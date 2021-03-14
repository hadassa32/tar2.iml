package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {
    @Test
    public void getNormal() {

        Cylinder c = new Cylinder(1.0, new Ray(new Point3D(0, 0, 1), new Vector(0, 1, 0)), 1d);
        //point in the side of the cylinder
        assertEquals("Bad nornal for Cylinder", new Vector(0, 0, 1), (Supplier<String>) c.getNormal(new Point3D(0, 0.5, 2)));
        //point in the 1side of the cylinder
        assertEquals("Bad nornal for Cylinder", new Vector(0, 1, 0), (Supplier<String>) c.getNormal(new Point3D(0, 0, 2)));
        //point in the 2side of the cylinder
        assertEquals("Bad nornal for Cylinder", new Vector(0, 1, 0), (Supplier<String>) c.getNormal(new Point3D(0, 1, 2)));
    }
}