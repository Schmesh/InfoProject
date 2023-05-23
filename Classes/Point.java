package Classes;

public class Point {
    //Coordinates X-Y Plane Z=height
    private double[] xyz;

    Point(double x, double y, double z){
        xyz = new double[3];
        xyz[0] = x;
        xyz[1] = y;
        xyz[2] = z;
    }

    Point(double[] xyz){
        this.xyz = xyz;
    }

    public double[] getXYZ(){
        return xyz;
    }

    public void setXyz(double[] xyz){
        this.xyz = xyz;
    }

    public void setXyz(double x, double y, double z){
        xyz[0] = x;
        xyz[1] = y;
        xyz[2] = z;
    }

    public void setX(double x){
        xyz[0] = x;
    }

    public void setY(double y){
        xyz[1] = y;
    }

    public void setZ(double z){
        xyz[2] = z;
    }

    public void move(double dx, double dy, double dz){
        xyz[0] += dx;
        xyz[1] += dy;
        xyz[2] += dz;
    }
    public void move(double[] distance){
        xyz[0] += distance[0];
        xyz[1] += distance[1];
        xyz[2] += distance[2];
    }
}