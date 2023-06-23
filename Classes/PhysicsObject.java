package Classes;

public class PhysicsObject {
    protected Hitbox hitbox;
    protected Point pos;

    protected double direction = 0;

    boolean hasHP;

    PhysicsObject(Hitbox hitbox){
        this.hitbox = hitbox;
        this.pos = hitbox.getPos();
    }

    public Point getPos(){
        return pos;
    }

    public void setDirection(double direction){
        this.direction = direction;
        hitbox.setDirection(direction);
    }

    public void rotate(double angle){
        this.direction += angle;
        this.hitbox.rotate(angle);
    }

    public Hitbox getHitbox(){
        return hitbox;
    }
}