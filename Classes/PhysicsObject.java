package Classes;

public class PhysicsObject {
    protected Hitbox hitbox;
    protected Point pos;

    boolean hasHP;

    PhysicsObject(Hitbox hitbox){
        this.hitbox = hitbox;
        this.pos = hitbox.getPos();
    }

    public Point getPos(){
        return pos;
    }

    public Hitbox getHitbox(){
        return hitbox;
    }
}