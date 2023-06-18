package Classes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class SpectatorCamMouseAdapter extends MouseAdapter implements MouseMotionListener{
    private SpectatorCam cam;
    SpectatorCamMouseAdapter(SpectatorCam cam){
        this.cam = cam;

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 3){

            cam.rightMouseDown = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == 3){
            cam.rightMouseDown = false;
        }
    }



}
