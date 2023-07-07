package Classes;

import java.awt.*;
import java.util.ArrayList;



public class Map {

    public ArrayList<PhysicsObject>[] maps= new ArrayList[]{
            new ArrayList<>(),
            new ArrayList<>(),
            new ArrayList<>()
    };
    public Punkt[] spawns = new Punkt[]{
            new Punkt(0,0,21.5),
            new Punkt(0,0,21.5),
            new Punkt(0,0,21.5),
    };

    public double[] ends = new double[]{
            43,
            68,
            100

    };



    public Punkt spawn = new Punkt(0,0,21.5);;

    ArrayList<PhysicsObject> Cuboids= new ArrayList();

    public double end = 43;
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
        maps[0].add(new PhysicsObject(new Hitbox(new double[]{1,5,1},new double[]{2,43,27})));
        maps[0].get(11).color = new Color(128,0,255);

        maps[1].add(new PhysicsObject(new Hitbox(new double[]{10,10,1},new double[]{0/*x*/,0/*y*/,20/*z*/})));
        maps[1].add(new PhysicsObject(new Hitbox(new double[]{1,5,1},new double[]{1,11,20})));
        maps[1].add(new PhysicsObject(new Hitbox(new double[]{1,5,1},new double[]{-1,20,20})));
        maps[1].add(new PhysicsObject(new Hitbox(new double[]{1,5,1},new double[]{-4,30,20})));
        maps[1].add(new PhysicsObject(new Hitbox(new double[]{1,5,1},new double[]{-3,38,21})));
        maps[1].add(new PhysicsObject(new Hitbox(new double[]{1,3,1},new double[]{-3,46,22})));
        maps[1].add(new PhysicsObject(new Hitbox(new double[]{1,2,1},new double[]{-3,56,15})));
        maps[1].add(new PhysicsObject(new Hitbox(new double[]{1,2,1},new double[]{-3,60,15})));
        maps[1].add(new PhysicsObject(new Hitbox(new double[]{1,2,1},new double[]{-3,64,15})));
        maps[1].add(new PhysicsObject(new Hitbox(new double[]{6,2,1},new double[]{-3,68,15})));
        maps[1].get(9).color = new Color(128,0,255);

        maps[2].add(new PhysicsObject(new Hitbox(new double[]{10,10,1},new double[]{0/*x*/,0/*y*/,20/*z*/})));


        Cuboids = maps[0];
        spawn = spawns[0];
        end = ends[0];




    }
}
