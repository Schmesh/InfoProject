package Classes;

public class Object {
    //Körper
    private Triangle[] triangles;

    //Coords
    private double[] xyz;


    Object(double[]xyz, int numberTriangles){
        triangles = new Triangle[numberTriangles];
        this.xyz = xyz;
    }

    public double[] getCoords(){
        return xyz;
    }
}
