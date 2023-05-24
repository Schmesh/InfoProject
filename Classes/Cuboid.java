package Classes;

public class Cuboid extends Object{

    private double[] pos;
    private double[] size;
    public Cuboid(double[]size, double[] pos){
        super(pos, 12);

        this.pos = pos;
        this.size = size;

        //====Create Points====
        Triangle[] cuboidTriangles = new Triangle[12];
        Point[][] trianglePoints = new Point[12][3];


        //Bottom (negative Z)
        trianglePoints[10][0] = new Point(size[0]*-0.5+pos[0],size[1]*-0.5+pos[1], size[2]*-0.5+pos[2]);//---
        trianglePoints[10][1] = new Point(size[0]*0.5+pos[0],size[1]*-0.5+pos[1], size[2]*-0.5+pos[2]);//+--
        trianglePoints[10][2] = new Point(size[0]*-0.5+pos[0],size[1]*+0.5+pos[1], size[2]*-0.5+pos[2]);//-+-
        cuboidTriangles[10] = new Triangle(trianglePoints[10]);
        trianglePoints[11][0] = new Point(size[0]*0.5+pos[0],size[1]*-0.5+pos[1], size[2]*-0.5+pos[2]);//+--
        trianglePoints[11][1] = new Point(size[0]*0.5+pos[0],size[1]*0.5+pos[1], size[2]*-0.5+pos[2]);//++-
        trianglePoints[11][2] = new Point(size[0]*-0.5+pos[0],size[1]*0.5+pos[1], size[2]*-0.5+pos[2]);//-+-
        cuboidTriangles[11] = new Triangle(trianglePoints[11]);
        //Left (negative X)
        trianglePoints[2][0] = new Point(size[0]*-0.5+pos[0],size[1]*0.5+pos[1], size[2]*-0.5+pos[2]);//-+-
        trianglePoints[2][1] = new Point(size[0]*-0.5+pos[0],size[1]*0.5+pos[1], size[2]*0.5+pos[2]);//-++
        trianglePoints[2][2] = new Point(size[0]*-0.5+pos[0],size[1]*-0.5+pos[1], size[2]*-0.5+pos[2]);//---
        cuboidTriangles[2] = new Triangle(trianglePoints[2]);
        trianglePoints[3][0] = new Point(size[0]*-0.5+pos[0],size[1]*0.5+pos[1], size[2]*0.5+pos[2]);//-++
        trianglePoints[3][1] = new Point(size[0]*-0.5+pos[0],size[1]*-0.5+pos[1], size[2]*0.5+pos[2]);//--+
        trianglePoints[3][2] = new Point(size[0]*-0.5+pos[0],size[1]*-0.5+pos[1], size[2]*-0.5+pos[2]);//---
        cuboidTriangles[3] = new Triangle(trianglePoints[3]);
        //Right (positive x)
        trianglePoints[0][0] = new Point(size[0]*0.5+pos[0],size[1]*-0.5+pos[1], size[2]*-0.5+pos[2]);//+--
        trianglePoints[0][1] = new Point(size[0]*0.5+pos[0],size[1]*-0.5+pos[1], size[2]*0.5+pos[2]);//+-+
        trianglePoints[0][2] = new Point(size[0]*0.5+pos[0],size[1]*0.5+pos[1], size[2]*-0.5+pos[2]);//++-
        cuboidTriangles[0] = new Triangle(trianglePoints[0]);
        trianglePoints[1][0] = new Point(size[0]*0.5+pos[0],size[1]*-0.5+pos[1], size[2]*0.5+pos[2]);//+-+
        trianglePoints[1][1] = new Point(size[0]*0.5+pos[0],size[1]*0.5+pos[1], size[2]*0.5+pos[2]);//+++
        trianglePoints[1][2] = new Point(size[0]*0.5+pos[0],size[1]*0.5+pos[1], size[2]*-0.5+pos[2]);//++-
        cuboidTriangles[1] = new Triangle(trianglePoints[1]);
        //Front (negative Y)
        trianglePoints[4][0] = new Point(size[0]*-0.5+pos[0],size[1]*-0.5+pos[1], size[2]*-0.5+pos[2]);//---
        trianglePoints[4][1] = new Point(size[0]*-0.5+pos[0],size[1]*-0.5+pos[1], size[2]*0.5+pos[2]);//--+
        trianglePoints[4][2] = new Point(size[0]*0.5+pos[0],size[1]*-0.5+pos[1], size[2]*-0.5+pos[2]);//+--
        cuboidTriangles[4] = new Triangle(trianglePoints[4]);
        trianglePoints[5][0] = new Point(size[0]*-0.5+pos[0],size[1]*-0.5+pos[1], size[2]*0.5+pos[2]);//--+
        trianglePoints[5][1] = new Point(size[0]*0.5+pos[0],size[1]*-0.5+pos[1], size[2]*0.5+pos[2]);//+-+
        trianglePoints[5][2] = new Point(size[0]*0.5+pos[0],size[1]*-0.5+pos[1], size[2]*-0.5+pos[2]);//+--
        cuboidTriangles[5] = new Triangle(trianglePoints[5]);
        //Back (positive Y)
        trianglePoints[6][0] = new Point(size[0]*0.5+pos[0],size[1]*0.5+pos[1], size[2]*-0.5+pos[2]);//++-
        trianglePoints[6][1] = new Point(size[0]*0.5+pos[0],size[1]*0.5+pos[1], size[2]*0.5+pos[2]);//+++
        trianglePoints[6][2] = new Point(size[0]*-0.5+pos[0],size[1]*0.5+pos[1], size[2]*-0.5+pos[2]);//-+-
        cuboidTriangles[6] = new Triangle(trianglePoints[6]);
        trianglePoints[7][0] = new Point(size[0]*0.5+pos[0],size[1]*0.5+pos[1], size[2]*0.5+pos[2]);//+++
        trianglePoints[7][1] = new Point(size[0]*-0.5+pos[0],size[1]*0.5+pos[1], size[2]*0.5+pos[2]);//-++
        trianglePoints[7][2] = new Point(size[0]*-0.5+pos[0],size[1]*0.5+pos[1], size[2]*-0.5+pos[2]);//-+-
        cuboidTriangles[7] = new Triangle(trianglePoints[7]);
        //Top (positive Z)
        trianglePoints[8][0] = new Point(size[0]*-0.5+pos[0],size[1]*0.5+pos[1], size[2]*0.5+pos[2]);//-++
        trianglePoints[8][1] = new Point(size[0]*0.5+pos[0],size[1]*0.5+pos[1], size[2]*0.5+pos[2]);//+++
        trianglePoints[8][2] = new Point(size[0]*-0.5+pos[0],size[1]*-0.5+pos[1], size[2]*0.5+pos[2]);//--+
        cuboidTriangles[8] = new Triangle(trianglePoints[8]);
        trianglePoints[9][0] = new Point(size[0]*0.5+pos[0],size[1]*0.5+pos[1], size[2]*0.5+pos[2]);//+++
        trianglePoints[9][1] = new Point(size[0]*0.5+pos[0],size[1]*-0.5+pos[1], size[2]*0.5+pos[2]);//+-+
        trianglePoints[9][2] = new Point(size[0]*-0.5+pos[0],size[1]*-0.5+pos[1], size[2]*0.5+pos[2]);//--+
        cuboidTriangles[9] = new Triangle(trianglePoints[9]);
        /*
        */
        this.setTriangles(cuboidTriangles);


        //====update triangles and remove unnecessary objects====
        //setTriangles(cuboidTriangles);
        cuboidTriangles = null;
        trianglePoints = null;
    }
    public void move(double[] distance){
        int triangleLength = getTriangles().length;
        for (int i = 0; i < triangleLength; i++){
            getTriangles()[i].p[0].move(distance);
            getTriangles()[i].p[1].move(distance);
            getTriangles()[i].p[2].move(distance);
            renderTools.addVector(pos,distance);
        }
    }

    //public void rotateZ(double[] rot){
    //    int triangleLength = getTriangles().length;
    //    for (int i =0; i < triangleLength; i++){
    //        getTriangles()[i].p[0] = renderTools.rotatePointOriginZ()
    //    }
    //
    //
    //}

}

