package Classes;

public abstract class Collision {

    public static void applyCollision(PhysicsObject object, Entity entity){
        HitboxCollision.applyCollision(entity.hitbox, object.hitbox);
        entity.moveTo(entity.hitbox.getPos());
    }
}