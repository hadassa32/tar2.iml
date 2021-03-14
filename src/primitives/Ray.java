package primitives;

public class Ray {
    // Point of origin
    private Point3D POO;

    // Ray direction
    private Vector _direction;

    // ****** Constructors ********* //

    public Ray(Ray ray){
        this.POO = ray.getPOO();
        this._direction = ray.getDirection();
    }

    public Ray(Point3D poo, Vector direction){
        this.POO = new Point3D(poo._x, poo._y, poo._z);
        this._direction = new Vector ( direction);
        this._direction.normalize();
    }
public Ray(){}
    // ****** Getters/Setters ********* //

 /*   public void setPOO(Point3D poo) {
        this.POO = new Point3D(poo._x, poo._y, poo._z);            }
    public void setDirection(Vector _direction) {
        this._direction = new Vector( _direction);  }
*/
    public Vector  getDirection() {
        return new Vector( _direction); }
    public Point3D getPOO() {
        return new Point3D(POO._x, POO._y, POO._z);
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return POO.equals(ray.POO) && _direction.equals(ray._direction);
    }
}
