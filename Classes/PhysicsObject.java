package Classes;

public class PhysicsObject{
    protected Hitbox hitbox;
    protected Punkt pos;

    PhysicsObject(Hitbox hitbox){
        this.hitbox = hitbox;
        this.pos = hitbox.getPos();
    }

    public Punkt getPos(){
        return pos;
    }

    public Hitbox getHitbox(){
        return hitbox;
    }
}