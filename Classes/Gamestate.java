package Classes;

import java.util.ArrayList;

public class Gamestate {
    public int FPS = 60;
    //Attribute sind alle Spielelemente
    protected ArrayList<Entity> entities = new ArrayList<>();
    protected ArrayList<PhysicsObject> physicsObjects = new ArrayList<>();
    protected Player player = new Player();

    Gamestate(){
        physicsObjects.add(new PhysicsObject(new Hitbox(new double []{1,1,1}, new double[]{0,5,0})));
    }

    public ArrayList<Entity> returnEntities(){
      return entities;
    }

    public ArrayList<PhysicsObject> returnPhysicsObjects(){
        return  physicsObjects;
    }

    public Player returnPlayer(){
        return player;
    }

    public int getFPS(){
        return FPS;
    }

    public void updateGame(){
        System.out.println(player.velocities[0] + "  " + player.velocities[1] + "  " + player.velocities[2] + "    " +player.getPos().getX() + "  " + player.getPos().getY() + "  " + player.getPos().getZ());
        int numberEntities = entities.size();
        int numberObjects = physicsObjects.size();
        //System.out.println(player.movementDirection);
        //System.out.println(player.wDown);

        //update entities
        player.updateEntity(FPS);
        for (int i = 0; i<numberEntities; i++){
            entities.get(i).updateEntity(FPS);
        }

        //Collision
        //entities with objects
        for (int i = 0; i<numberEntities; i++){
            for (int z = 0; z<numberObjects; z++){
                Collision.applyCollision(entities.get(i), physicsObjects.get(z));
            }
        }
        //Player with objects
        for (int i = 0; i<numberObjects; i++){
            Collision.applyCollision(player, physicsObjects.get(i));
        }

        //Player with entities
        for (int i = 0; i<numberEntities; i++){
            Collision.applyCollision(player, entities.get(i));
        }

        //entities with entities
        for (int i = 0; i<numberEntities-1; i++){
            for (int z = i+1; z<numberEntities; z++){
                    Collision.applyCollision(entities.get(i), entities.get(z));
                }
            }
        }


}
