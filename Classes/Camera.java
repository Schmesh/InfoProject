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

        light = new Lighting(new double[]{-1,-0.6,-0.3});

    }

    public double[] getLookVector() {
        double[] vectorPoint =  renderTools.addVector(pos, new double[]{0,1,0}) ;
        vectorPoint = renderTools.rotateAroundPointX(vectorPoint,pos, -rot[0]);
        vectorPoint = renderTools.rotateAroundPointZ(vectorPoint,pos, rot[2]);
        double[] vector = renderTools.subVector(vectorPoint,pos);

        return vector;

    }
    public double[] getRightVector() {
        double[] vectorPoint =  renderTools.addVector(pos, new double[]{1,0,0}) ;
        vectorPoint = renderTools.rotateAroundPointX(vectorPoint,pos, rot[0]);
        vectorPoint = renderTools.rotateAroundPointZ(vectorPoint,pos, rot[2]);
        double[] vector = renderTools.subVector(vectorPoint,pos);

        return vector;

    }
    public double[] getUpVector() {
        double[] vectorPoint =  renderTools.addVector(pos, new double[]{0,0,1}) ;
        vectorPoint = renderTools.rotateAroundPointX(vectorPoint,pos, -rot[0]);
        vectorPoint = renderTools.rotateAroundPointZ(vectorPoint,pos, rot[2]);
        double[] vector = renderTools.subVector(vectorPoint,pos);

        return vector;

    }

    public void move(double[] distance){
        pos = renderTools.addVector(pos,distance);
    }

    public void rotate(double[] rotation){
        rot = renderTools.addVector(rot,rotation);
    }
}
