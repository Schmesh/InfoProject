package Classes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//a panel that fits to the window and excludes the bar at the top


public class GraphicsPanel extends JPanel {
    public ArrayList<double[]> lineArray;
    public ArrayList<Triangle> renderedTris;
    public ArrayList<Triangle> wireframeTris;
    GraphicsPanel() {
        lineArray = new ArrayList();
        renderedTris = new ArrayList();
        wireframeTris = new ArrayList();
        this.setPreferredSize(new Dimension(600, 600));
       setBackground(Color.BLACK);
       //renderedTris.add(new Triangle(new Point[]{  new Point(100,100,100),  new Point(300,100,100),  new Point(100,100,300)  },new Color(30,80,30)) );
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

        g2d.setStroke(new BasicStroke(1));
        //AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5);
        //g2d.setComposite(alphaComposite);
        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);



        //sortTriangles
        Collections.sort(renderedTris, new Comparator<Triangle>() {
            @Override
            public int compare(Triangle o1, Triangle o2) {
                return Double.compare(o2.getCenter()[1],o1.getCenter()[1]);
            }
        });

        int triArraySize = renderedTris.size();
        for (int i = 0; i < triArraySize; i++){

            Triangle tri = renderedTris.get(i);
            System.out.println(tri.getCenter()[1]);
            int[] xCords = {  (int)Math.round(tri.p[0].getXYZ()[0]),  (int)Math.round(tri.p[1].getXYZ()[0]),  (int)Math.round(tri.p[2].getXYZ()[0])  };
            int[] zCords = { (int)Math.round(tri.p[0].getXYZ()[2]),  (int)Math.round(tri.p[1].getXYZ()[2]),  (int)Math.round(tri.p[2].getXYZ()[2])  };
            g2d.setColor(tri.color);
            g2d.fillPolygon( xCords ,zCords, 3);

        }

        int lineArraySize = lineArray.size();
        g2d.setColor(Color.white);
        for (int i = 0; i < lineArraySize;i++){
            g2d.drawLine((int)Math.round(lineArray.get(i)[0]),(int)Math.round(lineArray.get(i)[1]),(int)Math.round(lineArray.get(i)[2]),(int)Math.round(lineArray.get(i)[3]));
        }
    }


}






