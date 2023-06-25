package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//a panel that fits to the window and excludes the bar at the top


public class GraphicsPanel extends JPanel {
    public ArrayList<double[]> lineArray;
    public ArrayList<Triangle> renderedTris;
    public ArrayList<Triangle> wireframeTris;
    public double[][] depthBuffer;
    BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);

    Window currentWindow;

    GraphicsPanel(Window window) {
       clearDepthBuffer();
        lineArray = new ArrayList();
        renderedTris = new ArrayList();
        wireframeTris = new ArrayList();
        this.setPreferredSize(new Dimension(600, 600));
       setBackground(Color.BLACK);
       //renderedTris.add(new Triangle(new Point[]{  new Point(100,100,100),  new Point(300,100,100),  new Point(100,100,300)  },new Color(30,80,30)) );
        currentWindow = window;
    }
    private void clearDepthBuffer(){
        depthBuffer = new double[getWidth()][getHeight()];
        double height = getHeight();
        double width = getWidth();
        for (int x = 0; x < width; x+=1){
            for (int z = 0; z < height; z+=1){
                depthBuffer[x][z] = Double.MAX_VALUE;
            }
        }
    }
    public void drawLines(ArrayList<double[]> lineArray){
        this.lineArray = lineArray;
        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        repaint();

        //currentWindow.window.getContentPane().add(new JLabel(new ImageIcon(image)));
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


        clearDepthBuffer();

        //sortTriangles

        //Collections.sort(renderedTris, new Comparator<Triangle>() {
        //    @Override
        //    public int compare(Triangle o1, Triangle o2) {
        //        return Double.compare(o1.getCenter()[1],o2.getCenter()[1]);
        //    }
        //});

        int triArraySize = renderedTris.size();
        for (int i = 0; i < triArraySize; i++){

            Triangle tri = renderedTris.get(i);

            //int[] xCords = {  (int)Math.round(tri.p[0].getXYZ()[0]),  (int)Math.round(tri.p[1].getXYZ()[0]),  (int)Math.round(tri.p[2].getXYZ()[0])  };
            //int[] zCords = { (int)Math.round(tri.p[0].getXYZ()[2]),  (int)Math.round(tri.p[1].getXYZ()[2]),  (int)Math.round(tri.p[2].getXYZ()[2])  };
            g2d.setColor(tri.color);
            //g2d.fillPolygon( xCords ,zCords, 3);

            double[][] projectedPoints = new double[3][2];
            for (int i2 = 0; i2 < 3; i2++) {
                projectedPoints[i2] = new double[]{tri.p[i2].getX(),tri.p[i2].getZ()};
            }

            int minX = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int minZ = Integer.MAX_VALUE;
            int maxZ = Integer.MIN_VALUE;
            for (int i2 = 0; i2 < 3; i2++) {
                int x = (int) Math.round(tri.p[i2].getX());
                int z = (int) Math.round(tri.p[i2].getZ());
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minZ = Math.min(minZ, z);
                maxZ = Math.max(maxZ, z);
            }
            double size = (maxX-minX)*(maxZ-minZ);
            System.out.println(size);

            int red = tri.color.getRed();   // Red component value
            int green = tri.color.getGreen();   // Green component value
            int blue = tri.color.getBlue();    // Blue component value
            int rgb = (red << 16) | (green << 8) | blue;

            if (size < 3000000 && size > 0){
                for (int x = minX; x <= maxX; x++) {
                    for (int z = minZ; z <= maxZ; z++) {
                        if (x >= 0 && x < getWidth() && z >= 0 && z < getHeight()){
                            double[] barycentricCoords = renderTools.calculateBarycentricCoordinates(projectedPoints, x, z);
                            if(renderTools.isInsideTriangle(barycentricCoords)){
                                double depth = renderTools.calculateDepth(tri, barycentricCoords);
                                if (depth < depthBuffer[x][z] && depth > 0) {

                                    depthBuffer[x][z] = depth;


                                    image.setRGB(x,z,rgb);


                                }
                            }
                        }
                    }
                }

            }


        }
//================
        int lineArraySize = lineArray.size();
        g2d.setColor(Color.white);
        for (int i = 0; i < lineArraySize;i++){
            g2d.drawLine((int)Math.round(lineArray.get(i)[0]),(int)Math.round(lineArray.get(i)[1]),(int)Math.round(lineArray.get(i)[2]),(int)Math.round(lineArray.get(i)[3]));
        }
    }


}






