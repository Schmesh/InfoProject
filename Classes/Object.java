package Classes;

import javax.swing.*;

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

    public void setTriangles(Triangle[] triangles) {

    }

    public static class Window {
        JFrame window;

        Window(){
            //Creates a new Classes.Object.Window and makes it visible
            window = new JFrame("test");
            window.setVisible(true);
            window.pack();
            window.setLocationRelativeTo(null);
            window.setSize(300, 300);
            //stops Program when the window is closed
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    }
}
