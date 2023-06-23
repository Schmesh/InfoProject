package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SpectatorCam extends Camera{
    public SpectatorCamKeyAdapter k1;
    public SpectatorCamMouseAdapter m1;
    public SpectatorCamMouseListener ml1;
    private JPanel currentPanel;
    public boolean wDown = false;
    public boolean aDown = false;
    public boolean dDown = false;
    public boolean sDown = false;
    public boolean eDown = false;
    public boolean qDown = false;
    public boolean rightMouseDown = false;

    public double speed = 0.1;
    SpectatorCam(double[] pos, double[] rot, double fov, JPanel panel) {
        super(pos, rot, fov);
        currentPanel = panel;
        k1 = new SpectatorCamKeyAdapter(this);
        m1 = new SpectatorCamMouseAdapter(this);
        ml1 = new SpectatorCamMouseListener(this);
    }




    public int[] mouseStart = new int[]{0,0};
    public void processMouseMovement(MouseEvent mouseEvent){
        int[] point = new int[]{mouseEvent.getPoint().x,mouseEvent.getPoint().y};
        int[] mouseMoveVector = new int[]{0,0};
        mouseMoveVector[0] = point[0] - mouseStart[0];
        mouseMoveVector[1] = point[1] - mouseStart[1];
        try {
            Robot robot = new Robot();
            robot.mouseMove(mouseStart[0]+currentPanel.getLocationOnScreen().x, mouseStart[1]+currentPanel.getLocationOnScreen().y);
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
        if (rot[0]>=180){
            rot[0]-= 360;
        }
        if (rot[0]<=-180){
            rot[0]+= 360;
        }
        if (rot[0]<=90&&rot[0]>=-90){
            rotate(new double[]{mouseMoveVector[1]*-0.1,0,mouseMoveVector[0]*0.1});
        }else {
            rotate(new double[]{mouseMoveVector[1]*-0.1,0,mouseMoveVector[0]*-0.1});
        }

    }
    public void updateCamMovement(){
        if (wDown){
            move(renderTools.multVector(getLookVector(), speed));
        }
        if (sDown){
            move(renderTools.multVector(getLookVector(), -speed));
        }
        if (aDown){
            move(renderTools.multVector(getRightVector(), -speed));
        }
        if (dDown){
            move(renderTools.multVector(getRightVector(), speed));
        }
        if (eDown){
            move(renderTools.multVector(getUpVector(), speed));
        }
        if (qDown){
            move(renderTools.multVector(getUpVector(), -speed));
        }
    }
}
