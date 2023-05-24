package Classes;

import java.util.ArrayList;

public class Gamestate {
    private int FPS = 60;
    //Attribute sind alle Spielelemente
    ArrayList<Entity> entities = new ArrayList<>();
    ArrayList<PhysicsObject> PhysicsObject = new ArrayList<>();
    Player player = new Player();

    Gamestate(){
    }

    public void updateGamestate(){
        int numberEntities = entities.size();
        //Player
        player.updateEntity(FPS);

        //Entities
        for (int i = 0; i < numberEntities; i++){
            entities.get(i).updateEntity(FPS);
        }
    }

    public ArrayList<Entity> returnEntities(){
      return entities;
    }

    public ArrayList<PhysicsObject> returnPhysicsObjects(){
        return  PhysicsObject;
    }

    public int getFPS(){
        return FPS;
    }
}