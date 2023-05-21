package Classes;

public class Player extends Entity{

    Player(){
        super(new Hitbox(new Point(0,0,0), new double[]{0,0,0}),true);
    }
}
