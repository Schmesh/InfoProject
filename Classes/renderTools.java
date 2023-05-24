package Classes;

public class renderTools {

    //projects 3d to 2d coordinate (y is not used for rendering but for optimizations later on)
    public static double[] project3d2d(double[] inputCoordinate, double fov, double screenHeight, double screenWidth){ //, double distanceToScreen, double viewDistance
        double[] output = new double[3];

        output[0] = ((screenHeight/screenWidth)*( 1/ Math.tan( Math.toRadians(fov)/2 ) )*inputCoordinate[0]) / inputCoordinate[1];
        output[1] = 0;  //inputCoordinate[1]*(viewDistance/(viewDistance-distanceToScreen))-((viewDistance*distanceToScreen)/(viewDistance-distanceToScreen)); //y calc disabled for now
        output[2] = ( ( 1/ Math.tan( Math.toRadians(fov)/2 ) ) * -inputCoordinate[2]) / inputCoordinate[1];

        output[0] += 1;
        output[2] += 1;

        output[0] *= 0.5*screenWidth;
        output[2] *= 0.5*screenHeight;

        return output;
    }


    public static double[] addVector(double[] v1, double[] v2){
        return new double[]{v1[0]+v2[0],v1[1]+v2[1],v1[2]+v2[2]};
    }

    public static double[] subVector(double[] v1, double[] v2){
        return new double[]{v1[0]-v2[0],v1[1]-v2[1],v1[2]-v2[2]};
    }

    public static double[] multVector(double[] v1, double number){
        return new double[]{v1[0]*number,v1[1]*number,v1[2]*number};
    }

    public static double[] divVector(double[] v1, double number){
        return new double[]{v1[0]/number,v1[1]/number,v1[2]/number};
    }




    //says how similar 2 normalized vectors are for -1.0 being opposite directions to 1.0 being the same vector
    public static double dotProduct(double[] v1, double[] v2){
        return v1[0]*v2[0]+v1[1]*v2[1]+v1[2]*v2[2];
    }
    public static double vectorLength(double[] v){
        return Math.sqrt(dotProduct(v,v));
    }

    //normalizes the vector
    public static double[] normalizeVector(double[] v){
        double length = vectorLength(v);
        return new double[]{v[0]/length,v[1]/length,v[2]/length};
    }

    //generates a vector perpendicular to the 2 input vectors
    public static double[] crossProduct(double[] v1, double[] v2){
        double[] returnVector = new double[3];
        returnVector[0] = v1[1]*v2[2]-v1[2]*v2[1];
        returnVector[1] = v1[2]*v2[0]-v1[0]*v2[2];
        returnVector[2] = v1[0]*v2[1]-v1[1]*v2[0];
        return multVector(returnVector,-1);
    }

    //gets the normal of a triangle face (a vector that points in the direction the triangle is facing) used for deciding if triangles get rendered and shading
    public static double[] getNormal(Triangle face){
        double[] v1 = subVector(face.p[1].getXYZ(), face.p[0].getXYZ());
        double[] v2 = subVector(face.p[2].getXYZ(), face.p[0].getXYZ());

        return crossProduct(v1,v2);
    }

    //dot Product + automatic normalization
    public static double normDotProduct(double[] v1, double[] v2){
        double[] normV1 = normalizeVector(v1);
        double[] normV2 = normalizeVector(v2);
        System.out.println(normV1[0]+","+normV1[1]+","+normV1[2]+"|"+normV2[0]+","+normV2[1]+","+normV2[2]);
        //System.out.println(dotProduct(normV1, normV2));
        return dotProduct(normV1, normV2);
    }



    public static double[] rotatePointOriginZ(double[] point, double angleInDeg){
        double[] returnPoint = new double[3];
        returnPoint[0] = point[0]*(Math.cos(Math.toRadians(angleInDeg))) + point[1]*(Math.sin(Math.toRadians(angleInDeg)));
        returnPoint[1] = point[0]*(-Math.sin(Math.toRadians(angleInDeg))) + point[1]*(Math.cos(Math.toRadians(angleInDeg)));
        returnPoint[2] = point[2];
        return returnPoint;
    }

    public static double[] rotatePointOriginX(double[] point, double angleInDeg){
        double[] returnPoint = new double[3];
        returnPoint[0] = point[0];
        returnPoint[1] = point[1]*(Math.cos(Math.toRadians(angleInDeg))) + point[2]*(Math.sin(Math.toRadians(angleInDeg)));
        returnPoint[2] = point[1]*(-Math.sin(Math.toRadians(angleInDeg))) + point[2]*(Math.cos(Math.toRadians(angleInDeg)));
        return returnPoint;
    }

    public static double[] rotatePointOriginY(double[] point, double angleInDeg){
        double[] returnPoint = new double[3];
        returnPoint[0] = point[0]*(Math.cos(Math.toRadians(angleInDeg))) + point[2]*(-Math.sin(angleInDeg));
        returnPoint[1] = point[1];
        returnPoint[2] = point[0]*(-Math.sin(Math.toRadians(angleInDeg))) + point[2]*(Math.cos(Math.toRadians(angleInDeg)));
        return returnPoint;
    }

    public static double[] rotateAroundPointZ(double[] point, double[] pivot, double angleInDeg){
        double[] originPoint = subVector(point,pivot);
        double[] returnPoint = new double[3];
        returnPoint[0] = originPoint[0]*(Math.cos(Math.toRadians(angleInDeg))) + originPoint[1]*(Math.sin(Math.toRadians(angleInDeg)));
        returnPoint[1] = originPoint[0]*(-Math.sin(Math.toRadians(angleInDeg))) + originPoint[1]*(Math.cos(Math.toRadians(angleInDeg)));
        returnPoint[2] = originPoint[2];
        returnPoint = addVector(returnPoint,pivot);
        return returnPoint;
    }

    public static double[] rotateAroundPointX(double[] point, double[] pivot, double angleInDeg){
        double[] originPoint = subVector(point,pivot);
        double[] returnPoint = new double[3];
        returnPoint[0] = originPoint[0];
        returnPoint[1] = originPoint[1]*(Math.cos(Math.toRadians(angleInDeg))) + originPoint[2]*(Math.sin(Math.toRadians(angleInDeg)));
        returnPoint[2] = originPoint[1]*(-Math.sin(Math.toRadians(angleInDeg))) + originPoint[2]*(Math.cos(Math.toRadians(angleInDeg)));
        returnPoint = addVector(returnPoint,pivot);
        return returnPoint;
    }

    public static double[] rotateAroundPointY(double[] point, double[] pivot, double angleInDeg){
        double[] originPoint = subVector(point,pivot);
        double[] returnPoint = new double[3];
        returnPoint[0] = originPoint[0]*(Math.cos(Math.toRadians(angleInDeg))) + originPoint[2]*(-Math.sin(angleInDeg));
        returnPoint[1] = originPoint[1];
        returnPoint[2] = originPoint[0]*(-Math.sin(Math.toRadians(angleInDeg))) + originPoint[2]*(Math.cos(Math.toRadians(angleInDeg)));
        returnPoint = addVector(returnPoint,pivot);
        return returnPoint;
    }
}
