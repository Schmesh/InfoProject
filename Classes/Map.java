package Classes;

import java.util.ArrayList;

public class Map {
    public Point spawn = new Point(0,0,21);;
    ArrayList<PhysicsObject> Cuboids= new ArrayList();
    Map(){
        Cuboids.add(new PhysicsObject(new Hitbox(new double[]{10,10,1},new double[]{0/*x*/,0/*y*/,20/*z*/})));
        Cuboids.add(new PhysicsObject(new Hitbox(new double[]{8,8,1},new double[]{1/*x*/,10/*y*/,20/*z*/})));
        Cuboids.add(new PhysicsObject(new Hitbox(new double[]{6,6,1},new double[]{2/*x*/,18/*y*/,20/*z*/})));
        Cuboids.add(new PhysicsObject(new Hitbox(new double[]{2,2,1},new double[]{3/*x*/,22/*y*/,20/*z*/})));










    }
}
