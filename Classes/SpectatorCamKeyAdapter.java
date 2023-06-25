package Classes;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SpectatorCamKeyAdapter extends KeyAdapter{
    private SpectatorCam cam;
    SpectatorCamKeyAdapter(SpectatorCam cam){
        this.cam = cam;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W){
          cam.wDown = true;
      //    System.out.println("wpressw");
        }
        if (e.getKeyCode() == KeyEvent.VK_S){
            cam.sDown = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A){
            cam.aDown = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            cam.dDown = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_E){
            cam.eDown = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_Q){
            cam.qDown = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SHIFT){
            cam.speed = 0.02;
        }
        if (e.getKeyCode() == KeyEvent.VK_CONTROL){
            cam.speed = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W){
            cam.wDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S){
            cam.sDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A){
            cam.aDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            cam.dDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_E){
            cam.eDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_Q){
            cam.qDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SHIFT){
            cam.speed = 0.1;
        }
        if (e.getKeyCode() == KeyEvent.VK_CONTROL){
            cam.speed = 0.1;
        }
    }


}
