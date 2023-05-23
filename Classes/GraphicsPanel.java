package Classes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//a panel that fits to the window and excludes the bar at the top


public class GraphicsPanel extends JPanel {
    private ArrayList<double[]> lineArray;
    GraphicsPanel() {
        lineArray = new ArrayList();
        this.setPreferredSize(new Dimension(600, 600));
       setBackground(Color.BLACK);
    }
    public void drawLines(ArrayList<double[]> lineArray){
        this.lineArray = lineArray;
        repaint();
    }

    public void clearLines(){
        lineArray.clear();
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.setStroke(new BasicStroke(1));
        //AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5);
        //g2d.setComposite(alphaComposite);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int lineArraySize = lineArray.size();
        for (int i = 0; i < lineArraySize;i++){
            g2d.drawLine((int)Math.round(lineArray.get(i)[0]),(int)Math.round(lineArray.get(i)[1]),(int)Math.round(lineArray.get(i)[2]),(int)Math.round(lineArray.get(i)[3]));
        }
    }


}






