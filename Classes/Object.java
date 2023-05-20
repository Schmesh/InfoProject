package Classes;


abstract public class Object {
    //Body


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

    public void setTriangles(Triangle[] triangles) {

    }

}
