package Classes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PlayerMouseListener implements MouseMotionListener {
    private Player pla;
    PlayerMouseListener(Player pla){
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
   //     pla.processMouseMovement(e);
    }
}
