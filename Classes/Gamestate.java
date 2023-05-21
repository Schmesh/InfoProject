package Classes;

public class Gamestate {
    private int FPS = 60;
    //Attribute sind alle Spielelemente
    Player player;

    Gamestate(){
        player=new Player();
    }

    public void updateGamestate(){

        //Player
        player.updatePos(FPS);
        player.addVelocityX(player.getAccelerations()[0]/FPS);
        player.addVelocityX(player.getAccelerations()[0]/FPS);
        player.addVelocityX(player.getAccelerations()[0]/FPS);
    }

    public int getFPS(){
        return FPS;
    }
}