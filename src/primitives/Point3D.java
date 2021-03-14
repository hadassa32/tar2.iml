package primitives;

/**
 * POINT3D class for repersentive a point in 3D
 */
public class Point3D {
    public static final Point3D ZERO = new Point3D(0.0, 0.0, 0.0);
    /*final*/ Coordinate _x;
    /*final*/ Coordinate _y;
    /*final*/ Coordinate _z;


    public Point3D(Coordinate x, Coordinate y, Coordinate z) {

        _x = new Coordinate(x.coord) ;
        _y = new Coordinate(y.coord);
        _z = new Coordinate(z.coord);
    }
    /*********constractor***********/
    /**
     * @param _x coordinte on the x axis
     * @param _y coordinte on the y axis
     * @param _z coordinte on the z axis
     */

    /*
     * @return new Coordinate
     */
    public Point3D(double _x, double _y, double _z) {

        this(new Coordinate(_x),new Coordinate(_y),new Coordinate(_z));
    }



    /***************TO String And equals***********/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return _x.equals( point3D._x) &&
                _y.equals( point3D._y) &&
                _z.equals( point3D._z);
    }


    @Override
    public String toString() {
        return "Point3D{" +
                "_x=" + _x +
                ", _y=" + _y +
                ", _z=" + _z +
                '}';
    }

    public Vector subtract(Point3D p) {
        return new Vector( new Point3D(
                this._x.coord - p._x.coord,
                this._y.coord - p._y.coord,
                this._z.coord - p._z.coord));
    }

    public Point3D add(Vector v)
    {
        return new Point3D(
                this._x.coord+v._head._x.coord,
                this._y.coord+v._head._y.coord,
                this._z.coord+v._head._z.coord
        );
    }

    /**
     *
     * @param  other
     * @return (x2-x1)^2 + (y2-y1)^2 + (z2-z1)^2
     */
    public double distanceSquared(Point3D other)
    {
        return ( (other._x.coord - this._x.coord) * (other._x.coord - this._x.coord) +
                (other._y.coord - this._y.coord) * (other._y.coord - this._y.coord) +
                (other._z.coord - this._z.coord) * (other._z.coord - this._z.coord));
    }

    /**
     * *
     * @param other
     * @return euclidean distance between 2  3D points
     */
    public double distance (Point3D other){
        return Math.sqrt(distanceSquared(other));
    }


}







/* public double getX() {
        double x = this._x.coord;
        return x;
    }

    public double getY() {
        double y = this._y.coord;
        return y;
    }

    public double getZ() {
        double z = this._z.coord;
        return z;
    }*/

 /* public Point3D subStract(Point3D p1) {
        return  (new Point3D(
                p1.getX()-this.getX(),
                p1.getY()-this.getY(),
                p1.getZ()-this.getZ()
        ));
    }*/





