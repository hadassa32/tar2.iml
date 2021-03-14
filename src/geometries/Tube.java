/*package geometries;

public class Tube {
}
*/
package geometries;

import primitives.Point3D;
import primitives.*;


public class Tube {
    protected Ray r;
    protected double radius;

    /************ contractors **********/
    /**
     * Constructor for Tube class, gets a radius and a ray and creates a new match tube
     * @param radius radius from radicalGeometry class
     * @param r the ray
     */
    public Tube(double radius, Ray r) {
        this.radius=radius;
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
}







 /* Vector vec1=point.subtract(r.getPOO());
        double proje=vec1.dotProduct(r.getDirection());
        Vector vec2=r.getDirection().scale(proje);
        Vector check=vec1.subtract(vec2);
        return check.normalize();*/
