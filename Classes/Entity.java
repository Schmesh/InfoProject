package Classes;

public class Entity extends PhysicsObject{
    private double[] velocities = new double[]{0,0,0};
    protected double direction; //0 = positive X, rotation clockwise in degrees (90 ist positive y)
    protected double speed;

    protected double accelerationZ;

    Entity(Hitbox hitbox){
        super(hitbox);
        accelerationZ = -9.81;
    }

    public void setSpeed(double speed){this.speed = speed;}
    public void addSpeed(double speed){this.speed +=speed;}
    public double getSpeed(){return speed;}
    public void setDirection(double direction){this.direction = direction;}
    public void addDirection(double direction){this.direction += direction;}
    public double getDirection(double direction){return direction;}

    public void move(double dx, double dy, double dz){
        pos.move(dx,dy,dz);
        hitbox.move(dx,dy,dz);
    }

    public void moveTo(Point pos){
        this.pos.setXyz(pos.xyz);
        hitbox.moveTo(pos);
    }

    public void setVelocityX(double velocityX){velocities[0] = velocityX;}
    public void setVelocityY(double velocityY){velocities[1] = velocityY;}
    public void setVelocityZ(double velocityZ){velocities[2] = velocityZ;}
    public void addVelocityX(double velocityX){velocities[0] += velocityX;}
    public void addVelocityY(double velocityY){velocities[1] += velocityY;}
    public void addVelocityZ(double velocityZ){velocities[2] += velocityZ;}
    public double[] getVelocities(){
        return velocities;
    }

    public void updatePos(double time){
        pos.setX(pos.getXYZ()[0]+velocities[0]*time);
        pos.setX(pos.getXYZ()[1]+velocities[1]*time);
        pos.setX(pos.getXYZ()[2]+velocities[2]*time);
    }

    public void updateVelocityXY(double speed, double direction){
        velocities[0]=Math.cos(Math.toRadians(direction))*speed;
        velocities[1]=Math.sin(Math.toRadians(direction))*speed;
    }

    public void updateVelocityXY(){
        velocities[0]=Math.cos(Math.toRadians(direction))*speed;
        velocities[1]=Math.sin(Math.toRadians(direction))*speed;
    }

    public void updateEntity(int time){
        updatePos(time);
        //Gravity
        if (pos.getZ()>hitbox.height/2){
            this.addVelocityZ(accelerationZ);
        }
        else if (pos.getZ()<hitbox.height/2){
            move(0,0,-(pos.getZ()-hitbox.height/2));
            velocities[3] = 0;
        }
        else {
            velocities[3] = 0;
        }
    }
}