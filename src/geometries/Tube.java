/*package geometries;

public class Tube {
}
*/
package geometries;

import primitives.Point3D;
import primitives.*;

import java.util.List;


public class Tube extends RadialGeometry implements Geometry {
    protected Ray r;

    /************ contractors **********/
    /**
     * Constructor for Tube class, gets a radius and a ray and creates a new match tube
     * @param radius radius from radicalGeometry class
     * @param r the ray
     */
    public Tube(double radius, Ray r) {
        super(radius);
        this.r = r;
    }
    /*public Tube(){
        this.r=new Ray();
    }*/

  /*  @Override
    public Ray getR() {
        return r;
    }
*/
    /********to string************/
    @Override
    public String toString() {
        return "Tube{" +
                "r=" + r +
                '}';
    }
    public Vector getNormal(Point3D point) {
       return null;

    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }
}







 /* Vector vec1=point.subtract(r.getPOO());
        double proje=vec1.dotProduct(r.getDirection());
        Vector vec2=r.getDirection().scale(proje);
        Vector check=vec1.subtract(vec2);
        return check.normalize();*/
