package Classes;

public abstract class PolygonCollision {

    static public boolean checkCollision(RegularPolygon polygon1, RegularPolygon polygon2){ //Check collision using SAT
        RegularPolygon p1 = polygon1;
        RegularPolygon p2 = polygon2;
        p1.computePoints();
        p2.computePoints();

        for (int i=0; i<2; i++){
            //Swaps Polygons for second Iteration
            if(i==1){
                RegularPolygon pTemp = p1;
                p1 = p2;
                p2 = pTemp;
            }
            int numberSides = p1.numberSides;

            for (int a=0; a<numberSides;a++)
            {
                int b = (a+1)%numberSides;
                //Create Axis of Projection
                double[] axisProj = new double[]{-(p1.points[b].getY()-p1.points[a].getY()),p1.points[b].getX()-p1.points[a].getX()};
                //Normalizes the vector
                double d = Math.sqrt(axisProj[0]*axisProj[0]+axisProj[1]*axisProj[1]);
                axisProj = new double[]{axisProj[0]/d, axisProj[1]/d};
                //Project shape1 onto the Axis and get min and max
                double min_r1 =1000000; double max_r1 = -1000000;
                for (int z=0; z<p1.numberSides;z++)
                {
                    //Dot Product
                    double q = p1.points[z].getX()*axisProj[0] + p1.points[z].getY()*axisProj[1];
                    min_r1 = Math.min(min_r1,q);
                    max_r1 = Math.max(max_r1,q);
                }


                //Project shape2 onto the Axis and get min and max
                double min_r2 =100000; double max_r2 = -100000;

                for (int z=0; z<p2.numberSides;z++)
                {
                    //Dot Product
                    double q = p2.points[z].getX()*axisProj[0] + p2.points[z].getY()*axisProj[1];
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


    static public boolean applyCollision(RegularPolygon polygon1, RegularPolygon polygon2){ //Check and Apply collision using SAT
        RegularPolygon p1 = polygon1;
        RegularPolygon p2 = polygon2;
        double overlap = 100000;

        for (int i=0; i<2; i++){
            //Swaps Polygons for second Iteration
            if(i==1){
                RegularPolygon pTemp = p1;
                p1 = p2;
                p2 = pTemp;
            }
            int numberSides = p1.numberSides;

            for (int a=0; a<numberSides;a++){
                int b = (a+1)%numberSides;
                //Create Axis of Projection
                double[] axisProj = new double[]{-(p1.points[b].getY()-p1.points[a].getY()),p1.points[b].getX()-p1.points[a].getX()};
                //Normalizes the vector
                double d = Math.sqrt(axisProj[0]*axisProj[0]+axisProj[1]*axisProj[1]);
                axisProj = new double[]{axisProj[0]/d, axisProj[1]/d};
                //Project shape1 onto the Axis and get min and max
                double min_r1 =1000000; double max_r1 = -1000000;

                for (int z=0; z<p1.numberSides;z++){
                    //Dot Product
                    double q = p1.points[z].getX()*axisProj[0] + p1.points[z].getY()*axisProj[1];
                    min_r1 = Math.min(min_r1,q);
                    max_r1 = Math.max(max_r1,q);
                }


                //Project shape2 onto the Axis and get min and max
                double min_r2 =100000; double max_r2 = -100000;

                for (int z=0; z<p2.numberSides;z++){
                    //Dot Product
                    double q = p2.points[z].getX()*axisProj[0] + p2.points[z].getY()*axisProj[1];
                    min_r2 = Math.min(min_r2,q);
                    max_r2 = Math.max(max_r2,q);
                }

                //Calculate Overlap along the axis and store minimum
                overlap = Math.min(Math.min(max_r1,max_r2)-Math.max(min_r1,min_r2),overlap);

                if(!(max_r2>=min_r1 && max_r1 >= min_r2)){
                    return false;
                }

            }
        }
        //objects have collided and have to be displaced
        double[] d = new double[]{p2.x-p1.x, p2.y- p1.y};
        double s = Math.sqrt(d[0]*d[0]+d[1]*d[1]);

        p1.x -= overlap*d[0]/s;
        p1.y -= overlap*d[1]/s;
        return true;
    }


}
