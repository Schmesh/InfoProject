package Classes;

public class Cuboid extends Object{

    //Classes.Point pos = Center
    Cuboid(double[]xyzSize, double[] pos){
        super(pos, 12);

        Triangle[] cuboidTriangles = new Triangle[12];
        Point[][] trianglePoints = new Point[12][3];


        //Front (positive X)
        cuboidTriangles[0] = new Triangle(trianglePoints[0]);

        setTriangles(cuboidTriangles);
        cuboidTriangles = null;
        trianglePoints = null;
    }
}

