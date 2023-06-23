package Classes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class SpectatorCamMouseListener implements MouseMotionListener {
    private SpectatorCam cam;
    SpectatorCamMouseListener(SpectatorCam cam){
        this.cam = cam;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (cam.rightMouseDown){
            cam.processMouseMovement(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        cam.mouseStart = new int[]{e.getPoint().x,e.getPoint().y};
    }
}
