package Classes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Entity implements KeyListener {

    Player(){
        super(new Hitbox(new Point(0,0,0), new double[]{0,0,0}),true);
    }

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
}
