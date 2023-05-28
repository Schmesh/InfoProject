package Classes;

import java.util.Vector;

public class RegularPolygon {
    Point pos;
    int numberSides;
    double direction; //in grad, 0=x-Richtung, Rotation gegen den Uhrzeigersinn, 90 = y-Richtung
    Point[] points;

    RegularPolygon(int numberSides, double radius, double PosX, double PosY){
        pos.setX(PosX);
        pos.setY(PosY);
        this.numberSides = numberSides;
        direction=0;
        points = new Point[numberSides];

        //Set Points
        for (int i=0; i<numberSides;i++){
            double angle =(i*(360/numberSides));
            points[i]=new Point(Math.cos(Math.toRadians(angle))+PosX,Math.sin(Math.toRadians(angle))+PosY,0);
        }
    }

    public void computePoints(double PosX, double PosY, double direction){
        //Set Points
        for (int i=0; i<numberSides;i++){
            double angle =(i*(360/numberSides))+direction;
            points[i]=new Point(Math.cos(Math.toRadians(angle))+PosX,Math.sin(Math.toRadians(angle))+PosY,0);
        }
    }

    public void Rotate(double angle){
        //Rotiert gegen den Uhrzeigersinn
        computePoints(pos.getXYZ()[0], pos.getXYZ()[1], angle);
    }

    public boolean checkCollision(RegularPolygon polygon){ //Check collision using SAT
        RegularPolygon p1 = this;
        RegularPolygon p2 = polygon;

        for (int i=0; i<2; i++){
            //Swaps Polygons for second Iteration
            if(i==1){
                RegularPolygon pTemp = p1;
                p1 = p2;
                p2 = pTemp;
            }
            int numberSides = p1.numberSides;

            for (int a=0; a<numberSides;a++){
                int b = a+1%numberSides;
                //Create Axis of Projection
                double[] axisProj = new double[]{-(p1.points[b].getY()-p1.points[a].getY()),p1.points[b].getX()-p1.points[a].getX()};

                //Project shape1 onto the Axis and get min and max
                double min_r1 =-100000; double max_r1 = 100000;

                for (int z=0; z<p1.numberSides;z++){
                    //Dot Product
                    double q = p1.points[z].getX()*axisProj[0] + p1.points[z].getY()*axisProj[2];
                    min_r1 = Math.min(min_r1,q);
                    max_r1 = Math.max(max_r1,q);
                }


                //Project shape2 onto the Axis and get min and max
                double min_r2 =-100000; double max_r2 = 100000;

                for (int z=0; z<p2.numberSides;z++){
                    //Dot Product
                    double q = p2.points[z].getX()*axisProj[0] + p2.points[z].getY()*axisProj[2];
                    min_r2 = Math.min(min_r2,q);
                    max_r2 = Math.max(max_r2,q);
                }

                if(!(max_r2>=min_r1 && max_r1 >= min_r2)){
                    return false;
                }

            }
        }
        return true;
    }
}