package Classes;

import java.util.ArrayList;

public class Gamestate {
    private int FPS = 60;
    //Attribute sind alle Spielelemente
    ArrayList<Entity> entities = new ArrayList<>();
    ArrayList<PhysicsObject> physicsObjects = new ArrayList<>();
    Player player = new Player();

    Gamestate(){
    }

    public ArrayList<Entity> returnEntities(){
      return entities;
    }

    public ArrayList<PhysicsObject> returnPhysicsObjects(){
        return  physicsObjects;
    }

    public int getFPS(){
        return FPS;
    }

    public void updateGame(){
        int numberEntities = entities.size();
        int numberObjects = physicsObjects.size();

        //update entities
        player.updateEntity(FPS);
        for (int i = 0; i<numberEntities; i++){
            entities.get(i).updateEntity(FPS);
        }

        //Collision
        //entities with static objects
        for (int i = 0; i<numberEntities; i++){
            for (int z = 0; z<numberObjects; z++){
                Collision.applyCollision(physicsObjects.get(z), entities.get(i));
            }
        }
        //Player with objects
        for (int i = 0; i<numberObjects; i++){
            Collision.applyCollision(physicsObjects.get(i), player);
        }

        //Player with entities
        for (int i = 0; i<numberEntities; i++){
            Collision.applyCollision(entities.get(i), player);
        }

        //entities with entities
        for (int i = 0; i<numberEntities; i++){
            for (int z = 0; z<numberEntities; z++){
                if(i != z){
                    Collision.applyCollision(entities.get(i), entities.get(z));
                }
            }
        }

    }


}