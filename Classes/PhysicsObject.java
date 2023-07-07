package Classes;

import java.awt.*;

public class PhysicsObject{
    protected Hitbox hitbox;
    protected Punkt pos;
    Color color = new Color(255,255,255);
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