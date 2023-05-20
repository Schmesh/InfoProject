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

    public Point returnPoint(int index){
        return points[index];
    }

    public boolean checkCollision(Point point){

    }
}