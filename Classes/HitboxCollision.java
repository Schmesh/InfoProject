package Classes;

public abstract class HitboxCollision {

    public static boolean checkCollision(Hitbox hitbox1, Hitbox hitbox2){
        Hitbox h1 = hitbox1;
        Hitbox h2 = hitbox2;

        //Check Z-collision
        if(Math.abs(h1.getZ()-h2.getZ())<h1.height/2+h2.height/2){
            return PolygonCollision.checkCollision(h1.base, h2.base);
        }
        else{
            return false;
        }
    }

    public static void applyCollision(Hitbox hitbox1, Hitbox hitbox2){
        Hitbox h1 = hitbox1;
        Hitbox h2 = hitbox2;
        double h1Top = h1.getZ()+h1.height/2; double h1Bottom = h1.getZ()-h1.height/2;
        double h2Top = h2.getZ()+h2.height/2; double h2Bottom = h2.getZ()-h2.height/2;

        if(h1Bottom<h2Top && h1Top>h2Bottom){   //Checks for collision on the z-axis
            if(h2Top-h1Bottom<=0.2){
                h1.move(0,0,h2Top-h1Bottom);
            }
            else if(h1Top-h2Bottom<= 0.2){
                h1.move(0,0,-h1Top-h2Bottom);
            }
            else {
                PolygonCollision.applyCollision(h2.base, h1.base);
                h1.setX(h1.base.x);
                h1.setY(h1.base.y);
            }
        }
    }

}