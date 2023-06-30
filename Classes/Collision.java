package Classes;

public abstract class Collision {

    public static double distance(Hitbox h1, Hitbox h2){
        double dx = h1.pos.getX() - h2.pos.getX();
        double dy = h1.pos.getY() - h2.pos.getY();
        double dz = h1.pos.getZ() - h2.pos.getZ();
        return Math.sqrt(dx*dx+dy*dy+dz*dz);
    }

    public static boolean checkCollision(Hitbox h1, Hitbox h2){
        double xMax1 = h1.pos.getX()+h1.size[0];    double xMin1 = h1.pos.getX()-h1.size[0];
        double yMax1 = h1.pos.getY()+h1.size[1];    double yMin1 = h1.pos.getY()-h1.size[1];
        double zMax1 = h1.pos.getZ()+h1.size[2];    double zMin1 = h1.pos.getZ()-h1.size[2];

        double xMax2 = h2.pos.getX()+h2.size[0];    double xMin2 = h2.pos.getX()-h2.size[0];
        double yMax2 = h2.pos.getY()+h2.size[1];    double yMin2 = h2.pos.getY()-h2.size[1];
        double zMax2 = h2.pos.getZ()+h2.size[2];    double zMin2 = h2.pos.getZ()-h2.size[2];

            if(
                xMax1 > xMin2 && xMin1 < xMax2  &&
                yMax1 > yMin2 && yMin1 < yMax2  &&
                zMax1 > zMin2 && zMin1 < zMax2
            ){
                return true;
            }
            else {return false;}
    }




//Applies Collision between two hitboxes, h1 gets moved
    public static boolean applyCollision(Hitbox h1, Hitbox h2){
        double xMax1 = h1.pos.getX()+h1.size[0]/2;    double xMin1 = h1.pos.getX()-h1.size[0]/2;
        double yMax1 = h1.pos.getY()+h1.size[1]/2;    double yMin1 = h1.pos.getY()-h1.size[1]/2;
        double zMax1 = h1.pos.getZ()+h1.size[2]/2;    double zMin1 = h1.pos.getZ()-h1.size[2]/2;

        double xMax2 = h2.pos.getX()+h2.size[0]/2;    double xMin2 = h2.pos.getX()-h2.size[0]/2;
        double yMax2 = h2.pos.getY()+h2.size[1]/2;    double yMin2 = h2.pos.getY()-h2.size[1]/2;
        double zMax2 = h2.pos.getZ()+h2.size[2]/2;    double zMin2 = h2.pos.getZ()-h2.size[2]/2;
        if(
                xMax1 > xMin2 && xMin1 < xMax2  && yMax1 > yMin2 && yMin1 < yMax2  && zMax1 > zMin2 && zMin1 < zMax2
        ){
            double overlapX;
            double overlapY;
            double overlapZ;
            //Compute xOverlap
            if(xMin1 <= xMin2){
                overlapX = Math.min(xMax1-xMin2, h2.size[0]);
            }
            else{
                overlapX = Math.min(xMax2-xMin1, h1.size[0]);
            }

            //Compute YOverlap
            if(yMin1 <= yMin2){
                overlapY = Math.min(yMax1-yMin2, h2.size[1]);
            }
            else{
                overlapY = Math.min(yMax2-yMin1, h1.size[1]);
            }

            //Compute ZOverlap
            if(zMin1 <= zMin2){
                overlapZ = Math.min(zMax1-zMin2, h2.size[2]);
            }
            else{
                overlapZ = Math.min(zMax2-zMin1, h1.size[2]);
            }

            //Resolve Collision
            if(overlapX < overlapY && overlapX < overlapZ){
                if(h1.pos.getX()<h2.pos.getX()){
                    h1.move(-overlapX,0,0);
                }
                else {
                    h1.move(overlapX,0,0);
                }
                return true;
            }

            else if (overlapY < overlapX && overlapY < overlapZ) {
                if(h1.pos.getY()<h2.pos.getY()){
                    h1.move(0,-overlapY,0);
                }
                else {
                    h1.move(0,overlapY,0);
                }
                return true;
            }
            else if (overlapZ < overlapX && overlapZ < overlapY) {
                if(h1.pos.getZ()<h2.pos.getZ()){
                    h1.move(0,0,-overlapZ);
                }
                else {
                    h1.move(0,0,overlapZ);
                }
                return true;
            }
        }
        return false;
    }



    public static void applyCollision(Entity entity, PhysicsObject object){
        applyCollision(entity.hitbox, object.hitbox);
        entity.moveTo(entity.hitbox.getPos());
    }

}
