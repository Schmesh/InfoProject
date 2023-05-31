package Classes;

import java.util.Vector;

public class RegularPolygon {
    //Coordinates
    public double x;
    public double y;


    int numberSides;
    double direction; //in grad, 0=x-Richtung, Rotation gegen den Uhrzeigersinn, 90 = y-Richtung
    Point[] points;

    RegularPolygon(int numberSides, double radius, double posX, double posY){
        x=posX;
        y=posY;
        this.numberSides = numberSides;
        direction=0;
        points = new Point[numberSides];

        //Set Points
        for (int i=0; i<numberSides;i++){
            double angle =(i*(360/numberSides));
            points[i]=new Point(Math.cos(Math.toRadians(angle))*radius+posX,Math.sin(Math.toRadians(angle))*radius+posY,0);
        }
    }

    public void computePoints(){
        //Set Points
        for (int i=0; i<numberSides;i++){
            double angle =(i*(360/numberSides))+direction;
            points[i]=new Point(Math.cos(Math.toRadians(angle))+x,Math.sin(Math.toRadians(angle))+y,0);
        }
    }

    public void setDirection(double direction){
        this.direction = direction%360;
        computePoints();
    }

    public void move(double dx, double dy){
        x += dx;
        y += dy;
    }
}