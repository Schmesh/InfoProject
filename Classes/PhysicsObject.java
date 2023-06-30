package Classes;

public class PhysicsObject{
    protected Hitbox hitbox;
    protected Point pos;

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