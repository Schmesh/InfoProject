package Classes;

public class PhysicsCuboid extends PhysicsObject{

    private double sideLength;

    PhysicsCuboid(double sideLength, double height, double posX, double posY, double posZ){
        super(new Hitbox(4,Math.sqrt(2)*sideLength/2, posX, posY, posZ, height));
        this.sideLength = sideLength;
    }

    public double getSideLength(){
        return sideLength;
    }
}