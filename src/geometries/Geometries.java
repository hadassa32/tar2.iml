package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable {
    List<Intersectable>Intersectable;
    public Geometries() {
        Intersectable=new LinkedList<>();
    }
    private void add(Intersectable... intersectables) {
        for (Intersectable Item:intersectables) {
            this.Intersectable.add(Item);
        }
    }

    public Geometries(Intersectable...Intersectables) {
        for (Intersectable Item:Intersectables) {
            this.Intersectable=new LinkedList<>();
            add(Intersectables);
            
        }
    }
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> result = null;
        for(Intersectable element: Intersectable)
        {
            List<Point3D>elemList = element.findIntersections(ray);
            if(elemList != null){
                if(result == null)
                {
                    result = new LinkedList<>();
                }

                result.addAll(elemList);
            }
        }

        return result;
    }
    /*@Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersections = null;
        for (Intersectable geometry :Intersectable) {
            List<Point3D> tempIntersections = geometry.findIntersections(ray);
            if (tempIntersections != null) {
                if (intersections == null)
                    intersections = new ArrayList<Point3D>();
                intersections.addAll(tempIntersections);
            }
        }
        return intersections;
    }*/
}
