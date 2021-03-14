package primitives;

import static primitives.Point3D.ZERO;

public class Vector extends Point3D {
    Point3D _head;
    /**
     * head getter
     * @param v a vector
     */
    public Vector(Vector v) {
        this(v._head);
    }

    /**
     * @param p a point
     */
    /******************constractors*****************/
    public Vector(Point3D p) {
        super(p._x.coord, p._y.coord, p._z.coord);
        if (p.equals(ZERO)) {
            throw new IllegalArgumentException("ZERO point not valid for vector");
        }
       _head = new Point3D(p._x.coord, p._y.coord, p._z.coord);
    }

    public Vector(Point3D p,Point3D p2) {
        super(p._x.coord, p._y.coord, p._z.coord);
        _head=p.subtract(p2);
        if (p.equals(ZERO)) {
            throw new IllegalArgumentException("ZERO point not valid for vector");
        }
        _head = new Point3D(p._x.coord, p._y.coord, p._z.coord);
    }

    public Vector(double x,double y, double z) {
        super(x, y,z);
        _head = new Point3D(x, y,z);
        if (_head.equals(ZERO)) {
            throw new IllegalArgumentException("ZERO point not valid for vector");
        }
    }

    public Vector(Coordinate x, Coordinate y, Coordinate z) {
        super(x, y, z);
    }
/**********************getter********************/
    /**
     * @return a point3D
     */
    public Point3D getHead (){

        return new Point3D(_head._x.coord, _head._y.coord, _head._z.coord);
    }
/*****************function**********************/
    /**
     *  Calculates addition vector between this vector to other vector
     * @param vector vector
     * @return addition vector between two vectors
     */
    public Vector add(Vector vector) {

        return new Vector(this._head.add(vector));
    }

    /**
     * Calculates subtract vector between this vector to other vector
     * @param vector vector
     * @return subtract vector between two vectors
     */
    public Vector subtract(Vector vector) {
        return new Vector(this._head.subtract(vector));
    }

    /**
     * Return the vector multiplied by the scale
     * @param scalingFacor to calculate scalar
     * @return the vector multiplied by the scale
     */
    public Vector scale(double scalingFacor) {
        return new Vector( new Point3D(
                        new Coordinate(scalingFacor * _head._x.coord),
                        new Coordinate(scalingFacor * _head._y.coord),
                        new Coordinate(scalingFacor * _head._z.coord)));
    }

    /**
     * @param o an object
     * @return return boolean and equals
     */
    /*************************equals********************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return _head.equals(vector._head);
    }

    /**
     * Calculates dot product between two vectors
     * @param v an vector to calculate dotProduct
     * @return dot product between this vector to other vector
     */
    public double dotProduct(Vector v) {
        return (this._head._x.coord * v._head._x.coord +
                this._head._y.coord * v._head._y.coord +
                this._head._z.coord * v._head._z.coord);
    }

    /**
     * Calculates cross product between two vectors
     * @param v a vector to calculate crossProduct
     * @return cross product between this vector to other vector
     */
    public Vector crossProduct(Vector v) {
        double w1 = this._head._y.coord * v._head._z.coord - this._head._z.coord * v._head._y.coord;
        double w2 = this._head._z.coord * v._head._x.coord - this._head._x.coord * v._head._z.coord;
        double w3 = this._head._x.coord * v._head._y.coord - this._head._y.coord * v._head._x.coord;
        return new Vector( new Point3D(w1, w2, w3));
    }

    /**
     * Return the squared vector's length
     * @return the squared vector's length     */
    public double lengthSquared() {
        double xx = this._head._x.coord * this._head._x.coord;
        double yy = this._head._y.coord * this._head._y.coord;
        double zz = this._head._z.coord * this._head._z.coord;

        return xx + yy + zz;
    }

    /**
     * Return the vector's length
     * @return the vector's length
     **/
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    /**
     * @return the same Vector after normalisation
     * @throws ArithmeticException if length = 0
     */
    public Vector normalize() {

        double x = this._head._x.coord;
        double y = this._head._y.coord;
        double z = this._head._z.coord;

        double length = this.length();

        if (length == 0)
            throw new ArithmeticException("divide by Zero");

        this._head._x = new Coordinate(x / length);
        this._head._y = new Coordinate(y / length);
        this._head._z = new Coordinate(z / length);

        return this;
    }

    /**
     * Return the normalized vector
     * @return normalized vector
     */
    public Vector normalized() {
        Vector vector = new Vector( this);
        vector.normalize();
        return vector;
    }


}

