
package geometries;
import primitives.*;

public class Triangle extends Polygon {
    private Point3D _p1;
    private Point3D _p2;
    private Point3D _p3;
/*******************constractors*************/
    /**
     *
     * @param _p1 point one
     * @param _p2 point two
     * @param _p3 point three
     * @param vertices other
     */
    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3, Point3D... vertices) {
        super(vertices);
        this._p1 = _p1;
        this._p2 = _p2;
        this._p3 = _p3;
    }

    public Triangle(Point3D p1,Point3D p2,Point3D p3) {
        super(p1,p2,p3);//constructor of father

    }

    /**
     * Return a normal to a point on the triangle
     * @param point a point on the triangle
     * @return a normal to a point on the triangle
     */
    public Vector getNormal(Point3D point) {
        return null;
    }

    public Point3D get_p1() {
        return _p1;
    }
    public Point3D get_p2() {
        return _p2;
    }
    public Point3D get_p3() {
        return _p3;
    }

  /************* to string *************/
    @Override
    public String toString() {
        return "Triangle{" +
                "_p1=" + _p1 +
                ", _p2=" + _p2 +
                ", _p3=" + _p3 +
                '}';
    }
}