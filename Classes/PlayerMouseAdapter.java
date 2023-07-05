package Classes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PlayerMouseAdapter extends MouseAdapter implements MouseMotionListener {
    private Player pla;
    PlayerMouseAdapter(Player pla){
        this.pla = pla;

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 3){

            pla.rightMouseDown = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == 3){
            pla.rightMouseDown = false;
        }
    }



}
