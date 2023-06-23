package Classes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PlayerMouseListener implements MouseMotionListener {
    private Player pla;
    PlayerMouseListener(SpectatorCam cam){
        this.pla= pla;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (pla.rightMouseDown){
            pla.processMouseMovement(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        pla.mouseStart = new int[]{e.getPoint().x,e.getPoint().y};
    }
}
