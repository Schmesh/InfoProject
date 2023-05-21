package Classes;

public class Hitbox {
    private Point[] points;
    private Point pos;

    private double[] xyzSize;

    Hitbox(Point Pos, double[]xyzSize){
        this.xyzSize = xyzSize;
        pos = Pos;
        points = new Point[8];

        for (int i=0; i<8;i++){
            points[i]=new Point(0,0,0);
        }
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

    public Point getPos(){return pos;}

    public double[] getXyzSize(){return xyzSize;}

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
        if (    Math.abs(hitbox.getPos().getXYZ()[0]-pos.getXYZ()[0])<hitbox.getXyzSize()[0]/2+xyzSize[0]/2 &&
                Math.abs(hitbox.getPos().getXYZ()[1]-pos.getXYZ()[1])<hitbox.getXyzSize()[1]/2+xyzSize[1]/2 &&
                Math.abs(hitbox.getPos().getXYZ()[2]-pos.getXYZ()[2])<hitbox.getXyzSize()[2]/2+xyzSize[2]/2){
            b = true;
        }
        return b;
    }
}