package Classes;

import java.awt.event.*;

public class Player extends Entity implements KeyListener, MouseMotionListener, MouseListener {
    double tilt=0; //-90=down; 90 = up
    double movementDirection=0; //0-360; -1 for no movement; 0 = forward; 90 = to the right

    Player(){
        super(new Hitbox(4,Math.sqrt(2),0,0,1,2));
        speed = 1;
        movementDirection=0;
    }

    @Override public void updateVelocityXY(){
        velocities[0]=Math.sin(Math.toRadians(movementDirection))*speed;
        velocities[1]=Math.cos(Math.toRadians(movementDirection))*speed;
    }





//WASD-Steuerung für den Player
    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W)
            movementDirection=direction;
        if(key == KeyEvent.VK_S)
            movementDirection=-direction;
        if(key == KeyEvent.VK_A)
           movementDirection=-90;
        if(key == KeyEvent.VK_D)
            movementDirection=direction+90;
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W||key == KeyEvent.VK_S||key == KeyEvent.VK_A||key == KeyEvent.VK_D)
            movementDirection = -1;
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
