package Classes;

public class PhysicsObject {
    Hitbox hitbox;
    Point pos;

    boolean hasHP;

    PhysicsObject(Hitbox hitbox, Point pos, boolean hasHP){
        this.hitbox = hitbox;
        this.pos = pos;
        this.hasHP = hasHP;
    }

    public Point getPos(){
        return pos;
    }

    public Hitbox getHitbox(){
        return hitbox;
    }
}