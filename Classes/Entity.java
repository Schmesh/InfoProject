package Classes;

public class Entity extends PhysicsObject{
    private double[] velocities;

    private double[] accelerations;

    Entity(Hitbox hitbox, boolean hasHP){
        super(hitbox, hasHP);
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

    public void setAccelerationX(double accelerationX){accelerations[0] = accelerationX;}
    public void setAccelerationY(double accelerationY){accelerations[1] = accelerationY;}
    public void setAccelerationZ(double accelerationZ){accelerations[2] = accelerationZ;}
    public void addAccelerationX(double accelerationX){accelerations[0] +=accelerationX;}
    public void addAccelerationY(double accelerationY){accelerations[1] +=accelerationY;}
    public void addAccelerationZ(double accelerationZ){accelerations[2] +=accelerationZ;}
    public double[] getAccelerations(){
        return accelerations;
    }

    public void updatePos(double time){
        pos.setX(pos.getXYZ()[0]+velocities[0]/time);
        pos.setX(pos.getXYZ()[1]+velocities[1]/time);
        pos.setX(pos.getXYZ()[2]+velocities[2]/time);
    }

    public void updateVelocities(){
        velocities[0] += accelerations[0];
        velocities[1] += accelerations[1];
        velocities[2] += accelerations[2];
    }
}