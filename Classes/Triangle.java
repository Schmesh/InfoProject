package Classes;

import java.awt.*;

public class Triangle {
    Color color = new Color(100,100,100);

    public Point[] p = new Point[3];;



    Triangle(Point[] pInput){
        //Points
        p[0] = pInput[0];
        p[1] = pInput[1];
        p[2] = pInput[2];
    }
    Triangle(Point[] pInput,Color color){
        //Points
        p[0] = pInput[0];
        p[1] = pInput[1];
        p[2] = pInput[2];
        this.color = color;

    }

    public void setColor(Color color){
        this.color = color;
    }
}