package Classes;

import java.awt.event.*;

public class Player extends Entity implements KeyListener, MouseMotionListener, MouseListener {

    Player(){
        super(new Hitbox(4,1,0,0,1,2),true);
    }
//WASD-Steuerung für den Player
    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W)
            updateVelocityXY(speed, direction);
        if(key == KeyEvent.VK_S)
            updateVelocityXY(speed*(-1), direction);
        if(key == KeyEvent.VK_A)
            updateVelocityXY(speed*0.5, direction-90);
        if(key == KeyEvent.VK_D)
            updateVelocityXY(speed*0.5, direction+90);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W||key == KeyEvent.VK_S||key == KeyEvent.VK_A||key == KeyEvent.VK_D)
            updateVelocityXY(0, direction);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
