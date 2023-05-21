package Classes;

public class renderTools {

    //projects 3d to 2d coordinate (y is not used for rendering but for optimizations later on)
    public static double[] project3d2d(double[] inputCoordinate, double fov, double distanceToScreen, double viewDistance, double screenHeight, double screenWidth){
        double[] output = new double[3];

        output[0] = ((screenHeight/screenWidth)*( 1/ Math.tan( Math.toRadians(fov)/2 ) )*inputCoordinate[0]) / inputCoordinate[1];
        output[1] = 0;  //inputCoordinate[1]*(viewDistance/(viewDistance-distanceToScreen))-((viewDistance*distanceToScreen)/(viewDistance-distanceToScreen)); y calc disabled for now
        output[2] = ( ( 1/ Math.tan( Math.toRadians(fov)/2 ) ) * -inputCoordinate[2]) / inputCoordinate[1];

        output[0] += 1;
        output[2] += 1;

        output[0] *= 0.5*screenWidth;
        output[2] *= 0.5*screenHeight;

        return output;
    }

    //gets the normal of a triangle face (a vector that points in the direction the triangle is facing) used for deciding if triangles get rendered and shading
    public static double[] getNormal(Triangle face){
        double[] normal = new double[3];
        return normal;
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

    //says how similar 2 normalized vectors are for -1.0 beeing opposite directions to 1.0 beeing the same vector
    public static double dotProduct(double[] v1, double[] v2){
        return v1[0]*v2[0]+v1[1]*v2[1]+v1[2]*v2[2];
    }

}
