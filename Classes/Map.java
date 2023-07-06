package Classes;

import java.util.ArrayList;

public class Map {
    ArrayList<Hitbox> Cuboids= new ArrayList();
    Map(){
        Cuboids.add(new Hitbox(new double[]{1,1,1},new double[]{0/*x*/,0/*y*/,20/*z*/}));
        Cuboids.add(new Hitbox(new double[]{1,1,1},new double[]{0/*x*/,1/*y*/,20/*z*/}));
        Cuboids.add(new Hitbox(new double[]{1,1,1},new double[]{0/*x*/,2/*y*/,20/*z*/}));
        Cuboids.add(new Hitbox(new double[]{1,1,1},new double[]{0/*x*/,3/*y*/,20/*z*/}));
        Cuboids.add(new Hitbox(new double[]{1,1,1},new double[]{0/*x*/,4/*y*/,20/*z*/}));
        Cuboids.add(new Hitbox(new double[]{1,1,1},new double[]{0/*x*/,5/*y*/,20/*z*/}));
        Cuboids.add(new Hitbox(new double[]{1,1,1},new double[]{0/*x*/,6/*y*/,20/*z*/}));
        Cuboids.add(new Hitbox(new double[]{1,1,1},new double[]{0/*x*/,7 /*y*/,20/*z*/}));
        Cuboids.add(new Hitbox(new double[]{1,1,1},new double[]{0/*x*/,8/*y*/,20/*z*/}));
        Cuboids.add(new Hitbox(new double[]{1,1,1},new double[]{0/*x*/,9/*y*/,20/*z*/}));
        Cuboids.add(new Hitbox(new double[]{1,1,1},new double[]{0/*x*/,10/*y*/,20/*z*/}));





    }
}
