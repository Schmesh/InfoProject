package Classes;

import java.util.ArrayList;

public class Map {
    public Point spawn = new Point(0,0,21.5);
    public double end = 43;
    ArrayList<PhysicsObject>[] maps = new ArrayList[]{
            new ArrayList(),
            new ArrayList()
    };
    Point[] spawns = {
            new Point(0,0,21.5),
            new Point(0,0,21.5)
    };

    double[] ends = new double[]{
            43,
            43
    };
    ArrayList<PhysicsObject> Cuboids= new ArrayList();
    Map(){

        maps[0].add(new PhysicsObject(new Hitbox(new double[]{10,10,1},new double[]{0/*x*/,0/*y*/,20/*z*/})));
        maps[0].add(new PhysicsObject(new Hitbox(new double[]{8,8,1},new double[]{1/*x*/,11/*y*/,21/*z*/})));
        maps[0].add(new PhysicsObject(new Hitbox(new double[]{6,6,1},new double[]{2/*x*/,22/*y*/,19/*z*/})));
        maps[0].add(new PhysicsObject(new Hitbox(new double[]{2,2,1},new double[]{3/*x*/,29/*y*/,20/*z*/})));
        maps[0].add(new PhysicsObject(new Hitbox(new double[]{1,1,1},new double[]{3/*x*/,33/*y*/,21/*z*/})));
        maps[0].add(new PhysicsObject(new Hitbox(new double[]{1,1,1},new double[]{1/*x*/,34/*y*/,22/*z*/})));
        maps[0].add(new PhysicsObject(new Hitbox(new double[]{1,1,1},new double[]{1/*x*/,36/*y*/,23/*z*/})));
        maps[0].add(new PhysicsObject(new Hitbox(new double[]{1,1,1},new double[]{1/*x*/,37/*y*/,24/*z*/})));
        maps[0].add(new PhysicsObject(new Hitbox(new double[]{1,1,1},new double[]{2/*x*/,36/*y*/,25/*z*/})));
        maps[0].add(new PhysicsObject(new Hitbox(new double[]{1,1,1},new double[]{-1/*x*/,36/*y*/,26/*z*/})));
        maps[0].add(new PhysicsObject(new Hitbox(new double[]{1,1,1},new double[]{2/*x*/,37/*y*/,27/*z*/})));
        maps[0].add(new PhysicsObject(new Hitbox(new double[]{5,3,1},new double[]{2,43,27})));
        maps[0].get(11).setColor(130,0,255);

        maps[1].add(new PhysicsObject(new Hitbox(new double[]{10,10,1},new double[]{0/*x*/,0/*y*/,20/*z*/})));
        maps[1].add(new PhysicsObject(new Hitbox(new double[]{1,3,1},new double[]{1,10,20})));
        maps[1].add(new PhysicsObject(new Hitbox(new double[]{1,3,1},new double[]{3,10,20})));






        Cuboids = maps[0];
        spawn = spawns[0];
        end = ends[0];

    }
}
