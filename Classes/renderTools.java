package Classes;

public class renderTools {

    //projects 3d to 2d coordinate (y is not used for rendering but for optimizations later on)
    public static double[] project3d2d(double[] inputCoordinate, double fov, double distanceToScreen, double viewDistance, double screenHeight, double screenWidth){
        double[] output = new double[3];
        //width: x
        //height: z
        //depth: y

        output[0] = ((screenHeight/screenWidth)*( 1/ Math.tan( Math.toRadians(fov)/2 ) )*inputCoordinate[0]) / inputCoordinate[1];
        output[1] = inputCoordinate[1]*(viewDistance/(viewDistance-distanceToScreen))-((viewDistance*distanceToScreen)/(viewDistance-distanceToScreen));
        output[2] = ( ( 1/ Math.tan( Math.toRadians(fov)/2 ) ) * inputCoordinate[2]) / inputCoordinate[1];

        return output;
    }

}
