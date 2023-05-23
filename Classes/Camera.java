package Classes;

public class Camera {
    double[] pos;
    double[] rot; // y is not used
    double fov;
    Camera(double[] pos, double[] rot, double fov){
        this.pos = pos;
        this.rot = rot;
        this.fov = fov;
    }

    public void move(double[] distance){
        pos = renderTools.addVector(pos,distance);
    }
}
