package Classes;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PlayerKeyAdapter extends KeyAdapter {

    private final Player pla;

    PlayerKeyAdapter(Player pla) {
        this.pla = pla;

    }


    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("test");
        if (e.getKeyCode() == KeyEvent.VK_W) {
            pla.wDown = true;
      //      System.out.println(pla.wDown);
            System.out.println("wpressw");
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
            pla.speed = 0.02;
        }
        if (e.getKeyCode() == KeyEvent.VK_CONTROL)
            pla.speed = 1;
    }
//jump noch hinzufügen brauche vincent
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            pla.wDown = false;
            System.out.println("keyreleased");
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
            pla.speed = 0.1;
        }
        if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
            pla.speed = 0.1;
        }
    }
}