package Classes;


import java.awt.*;

abstract public class Object {
    //Body
    private Color color = new Color(100, 100, 100);

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
        this.triangles = triangles;
    }

    public Triangle[] getTriangles(){
        return triangles;
    }

    public void setColor(int r, int g, int b) {
        color = new Color(r,g,b);
        for (Triangle tri : getTriangles()){
            tri.setColor(color);
        }
    }
}
