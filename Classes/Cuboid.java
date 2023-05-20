package Classes;

public class Cuboid extends Object{

    private double[] pos;
    private double[] size;
    Cuboid(double[]size, double[] pos){
        super(pos, 12);

        this.pos = pos;
        this.size = size;

        //====Create Points====
        Triangle[] cuboidTriangles = new Triangle[12];
        Point[][] trianglePoints = new Point[12][3];

        //Right (positive X)
        trianglePoints[0][0] = new Point(size[0]*0.5+pos[0],size[1]*-0.5+pos[1], size[2]*-0.5+pos[2]);//+--
        trianglePoints[0][0] = new Point(size[0]*0.5+pos[0],size[1]*-0.5+pos[1], size[2]*0.5+pos[2]);//+-+
        trianglePoints[0][0] = new Point(size[0]*0.5+pos[0],size[1]*0.5+pos[1], size[2]*-0.5+pos[2]);//++-
        cuboidTriangles[0] = new Triangle(trianglePoints[0]);
        trianglePoints[0][0] = new Point(size[0]*0.5+pos[0],size[1]*-0.5+pos[1], size[2]*0.5+pos[2]);//+-+
        trianglePoints[0][0] = new Point(size[0]*0.5+pos[0],size[1]*0.5+pos[1], size[2]*0.5+pos[2]);//+++
        trianglePoints[0][0] = new Point(size[0]*0.5+pos[0],size[1]*0.5+pos[1], size[2]*-0.5+pos[2]);//++-
        cuboidTriangles[1] = new Triangle(trianglePoints[1]);




        //====update triangles and remove unnecessary objects====
        setTriangles(cuboidTriangles);
        cuboidTriangles = null;
        trianglePoints = null;
    }
}

