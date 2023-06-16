package Classes;

public class Camera {
    double[] pos;
    double[] rot; // y is not used
    double fov;

    public Lighting light;
    Camera(double[] pos, double[] rot, double fov){
        this.pos = pos;
        this.rot = rot;
        this.fov = fov;

        light = new Lighting(new double[]{-1,-1,-0.3});

    }

    public void move(double[] distance){
        pos = renderTools.addVector(pos,distance);
    }

    public void rotate(double[] rotation){
        rot = renderTools.addVector(rot,rotation);
    }
}
