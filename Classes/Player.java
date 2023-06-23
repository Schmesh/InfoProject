package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Player extends Entity implements KeyListener, MouseMotionListener, MouseListener {
    double tilt = 0; //-90=down; 90 = up
    double movementDirection = 0; //0-360; -1 for no movement; 0 = forward; 90 = to the right
    public boolean wDown = false;
    public boolean aDown = false;
    public boolean dDown = false;
    public boolean sDown = false;
    public boolean rightMouseDown = false;
    private JPanel currentPanel;

    Player() {
        super(new Hitbox(4, Math.sqrt(2), 0, 0, 100, 2));
        speed = 1;
        movementDirection = -1;
    }

    @Override
    public void updateVelocityXY() {
        if (movementDirection == -1) {
            velocities[0] = 0;
            velocities[1] = 0;
        } else {
            velocities[0] = Math.sin(Math.toRadians(movementDirection)) * speed;
            velocities[1] = Math.cos(Math.toRadians(movementDirection)) * speed;
        }
    }


    //WASD-Steuerung für den Player
    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W)
            movementDirection = direction;
        if (key == KeyEvent.VK_S)
            movementDirection = -direction;
        if (key == KeyEvent.VK_A)
            movementDirection = -90;
        if (key == KeyEvent.VK_D)
            movementDirection = direction + 90;
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_S || key == KeyEvent.VK_A || key == KeyEvent.VK_D)
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

    public int[] mouseStart = new int[]{0, 0};

    public void processMouseMovement(MouseEvent mouseEvent) {
        int[] point = new int[]{mouseEvent.getPoint().x, mouseEvent.getPoint().y};
        int[] mouseMoveVector = new int[]{0, 0};
        mouseMoveVector[0] = point[0] - mouseStart[0];
        mouseMoveVector[1] = point[1] - mouseStart[1];
        try {
            Robot robot = new Robot();
            robot.mouseMove(mouseStart[0] + currentPanel.getLocationOnScreen().x, mouseStart[1] + currentPanel.getLocationOnScreen().y);
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
   /*     if (rot[0] >= 180) {
            rot[0] -= 360;
        }
        if (rot[0] <= -180) {
            rot[0] += 360;
        }
        if (rot[0] <= 90 && rot[0] >= -90) {
            rotate(new double[]{mouseMoveVector[1] * -0.1, 0, mouseMoveVector[0] * 0.1});
        } else {
            rotate(new double[]{mouseMoveVector[1] * -0.1, 0, mouseMoveVector[0] * -0.1});
        }

    */

    }
}