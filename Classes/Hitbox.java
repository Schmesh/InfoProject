package Classes;

public class Hitbox {
    private Point[] points;
    private Point pos;

    Hitbox(Point Pos, double[]xyzSize){
        pos = Pos;
        points = new Point[8];
        //Corners
        points[0].setXyz(Pos.getXYZ()[0]-(xyzSize[0]/2), Pos.getXYZ()[1]-(xyzSize[1]/2), Pos.getXYZ()[2]-(xyzSize[2]/2) );
        points[1].setXyz(Pos.getXYZ()[0]-(xyzSize[0]/2), Pos.getXYZ()[1]-(xyzSize[1]/2), Pos.getXYZ()[2]+(xyzSize[2]/2) );
        points[2].setXyz(Pos.getXYZ()[0]-(xyzSize[0]/2), Pos.getXYZ()[1]+(xyzSize[1]/2), Pos.getXYZ()[2]-(xyzSize[2]/2) );
        points[3].setXyz(Pos.getXYZ()[0]-(xyzSize[0]/2), Pos.getXYZ()[1]+(xyzSize[1]/2), Pos.getXYZ()[2]+(xyzSize[2]/2) );
        points[4].setXyz(Pos.getXYZ()[0]+(xyzSize[0]/2), Pos.getXYZ()[1]-(xyzSize[1]/2), Pos.getXYZ()[2]-(xyzSize[2]/2) );
        points[5].setXyz(Pos.getXYZ()[0]+(xyzSize[0]/2), Pos.getXYZ()[1]-(xyzSize[1]/2), Pos.getXYZ()[2]+(xyzSize[2]/2) );
        points[6].setXyz(Pos.getXYZ()[0]+(xyzSize[0]/2), Pos.getXYZ()[1]+(xyzSize[1]/2), Pos.getXYZ()[2]-(xyzSize[2]/2) );
        points[7].setXyz(Pos.getXYZ()[0]+(xyzSize[0]/2), Pos.getXYZ()[1]+(xyzSize[1]/2), Pos.getXYZ()[2]+(xyzSize[2]/2) );
    }

    public Point getPoint(int index){
        return points[index];
    }

    public boolean checkCollision(Point point){
        if (    point.getXYZ()[0]>points[0].getXYZ()[0] && point.getXYZ()[0]<points[4].getXYZ()[0] &&   //Control X Overlap
                point.getXYZ()[1]>points[0].getXYZ()[1] && point.getXYZ()[1]<points[3].getXYZ()[1] &&   //Control Y Overlap
                point.getXYZ()[2]>points[1].getXYZ()[2] && point.getXYZ()[2]<points[2].getXYZ()[2]){    //Control Z Overlap
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkCollision(Hitbox hitbox){
        boolean b = false;
        for (int i =0; i<8; i++){
            if (checkCollision(hitbox.getPoint(i))){
                b=true;
            }
        }
        return b;
    }
}