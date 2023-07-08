package Classes;
//Axis aligned bounding box
public class Hitbox {
    public double[] size;
    public Punkt pos = new Punkt(0,0,0);
    public double diagonal;
    Hitbox(double[] size, double[] pos){
        this.size = size;
        this.pos.setXyz(pos);
        diagonal = Math.sqrt(size[0]*size[0] + size[1]*size[1] + size[2]*size[2]);
    }

    public void move(double[] distance){
        pos.move(distance);
    }

    public void moveTo(Punkt punkt){
        pos = punkt;
    }

    public void move(double dx, double dy, double dz){
        pos.move(dx,dy,dz);
    }

    public Punkt getPos() {
        return pos;
    }
}
