package Classes;

import java.awt.event.*;

public class PlayerKeyAdapter extends KeyAdapter {

    private final Player pla;

    PlayerKeyAdapter(Player pla) {
        this.pla = pla;

    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            pla.wDown = true;
            //      System.out.println(pla.wDown);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            pla.sDown = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            pla.aDown = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            pla.dDown = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            pla.speed = 7;
        }
        if (e.getKeyCode() == KeyEvent.VK_CONTROL){
            pla.speed = 3;
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            pla.jumping = true;
        }

        if (e.getKeyCode()== KeyEvent.VK_ALT){
            pla.altDown = true;

        }


        if (e.getKeyCode() == KeyEvent.VK_Z){
            pla.moveTo(new Punkt(pla.currentSpawn.getX(),pla.currentSpawn.getY(),pla.currentSpawn.getZ()));
            pla.direction = 0;
            pla.tilt = 0;
            pla.mouseLocked = true;
        }

    }


    //jump noch hinzufügen brauche vincent
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            pla.wDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            pla.sDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            pla.aDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            pla.dDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            pla.speed = 3;
        }
        if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
            pla.speed = 3 ;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            pla.jumping = false;
        }
        if (e.getKeyCode()== KeyEvent.VK_ALT){
            pla.altDown = false;
        }
    }


}
