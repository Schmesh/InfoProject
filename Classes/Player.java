package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Player extends Entity  {
    double tilt = 0; //-90=down; 90 = up
    double movementDirection = 0; //0-360; -1 for no movement; 0 = forward; 90 = to the right
    public boolean wDown = false;
    public boolean aDown = false;
    public boolean dDown = false;
    public boolean sDown = false;
    public boolean altDown = false;
    public boolean rightMouseDown = false;
    public JPanel currentPanel;
    public PlayerMouseAdapter m1;
    public PlayerMouseListener ml1;
    public PlayerKeyAdapter k1;
    Player(double x, double y, double z) {
        super(new Hitbox(new double[]{1,1,2}, new double[]{x,y,z}));
        speed = 3;
        movementDirection = -1;
      //  direction = 90;
        k1 = new PlayerKeyAdapter(this);
        m1 = new PlayerMouseAdapter(this);
        ml1 = new PlayerMouseListener(this);

    }
    public void updateMovementDirection() {
        if(wDown&&aDown)
            movementDirection = 315+direction;
        else if(wDown&&dDown)
            movementDirection = 45+direction;
        else if(sDown&&aDown)
            movementDirection = 225+direction;
        else if(sDown&&dDown)
            movementDirection = 135+direction;
        else if(wDown)
            movementDirection = 0+direction;
        else if(aDown)
            movementDirection = 270+direction;
        else if (sDown)
            movementDirection = 180+direction;
        else if(dDown)
            movementDirection = 90+direction;
            else
            movementDirection = -1;

    }

    @Override
    public void updateVelocityXY() {
        updateMovementDirection();
        if (movementDirection == -1) {
            velocities[0] = 0;
            velocities[1] = 0;
        } else {
            velocities[0] = Math.sin(Math.toRadians(movementDirection)) * speed;
            velocities[1] = Math.cos(Math.toRadians(movementDirection)) * speed;
        }
    }


    public int[] mouseStart = new int[]{0, 0};

    public void processMouseMovement(MouseEvent mouseEvent) {


        int[] point = new int[]{mouseEvent.getPoint().x, mouseEvent.getPoint().y};
        int[] mouseMoveVector = new int[]{0, 0};
        mouseMoveVector[0] = point[0] - mouseStart[0];
        mouseMoveVector[1] = point[1] - mouseStart[1];
        mouseStart= new int[]{currentPanel.getWidth()/2, currentPanel.getHeight()/2};
        if (!altDown){

            direction+= mouseMoveVector[0]*0.13;

            if (tilt >= 180) {
                tilt -= 360;
            }
            if (tilt <= -180) {
                tilt += 360;
            }
            if (tilt <= 90 && tilt >= -90) {
                tilt += mouseMoveVector[1]*0.13;
            } else {
                tilt -= mouseMoveVector[1]*0.13;
            }



        }

            System.out.println(tilt);
            try {
                Robot robot = new Robot();
                robot.mouseMove(currentPanel.getWidth()/2+currentPanel.getLocationOnScreen().x, currentPanel.getHeight()/2+currentPanel.getLocationOnScreen().y);
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
        }


        //System.out.println(point[0]+"-"+mouseStart[0]);



}