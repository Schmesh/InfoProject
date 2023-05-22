package Classes;

import Classes.GraphicsPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window {
    JFrame window;
    public GraphicsPanel panel;
    private double fov = 90;
    private double distanceToScreen = 0.1;
    private double viewDistance = 1000;

    private ArrayList<double[]> lines;

    public Window() {
        //Creates a new Classes.Window and makes it visible
        //creates a graphics panel and adds it to the window
        window = new JFrame("test");
        panel = new GraphicsPanel();
        window.add(panel);
        window.setVisible(true);
        window.pack();
        window.setLocationRelativeTo(null);
        //stops Program when the window is closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lines = new ArrayList();
        //maximizes the window
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }




    public void renderObjectWireframe(Object object) {

        int trianglesLength = object.getTriangles().length;

        for (int i = 0; i < trianglesLength; i++) {
            if (object.getTriangles()[i] != null){
                Triangle renderedTri = new Triangle(new Point[3]);
                renderedTri.p[0] = new Point(renderTools.project3d2d(object.getTriangles()[i].p[0].getXYZ(),fov,distanceToScreen,viewDistance,panel.getHeight(),panel.getWidth()));
                renderedTri.p[1] = new Point(renderTools.project3d2d(object.getTriangles()[i].p[1].getXYZ(),fov,distanceToScreen,viewDistance,panel.getHeight(),panel.getWidth()));
                renderedTri.p[2] = new Point(renderTools.project3d2d(object.getTriangles()[i].p[2].getXYZ(),fov,distanceToScreen,viewDistance,panel.getHeight(),panel.getWidth()));

                lines.add(new double[]{renderedTri.p[0].getXYZ()[0],renderedTri.p[0].getXYZ()[2], renderedTri.p[1].getXYZ()[0], renderedTri.p[1].getXYZ()[2]});
                lines.add(new double[]{renderedTri.p[1].getXYZ()[0],renderedTri.p[1].getXYZ()[2], renderedTri.p[2].getXYZ()[0], renderedTri.p[2].getXYZ()[2]});
                lines.add(new double[]{renderedTri.p[2].getXYZ()[0],renderedTri.p[2].getXYZ()[2], renderedTri.p[0].getXYZ()[0], renderedTri.p[0].getXYZ()[2]});

                renderedTri = null;
            }
        }
        panel.drawLines(lines);
    }

    public void setFov(double fov){
        this.fov = fov;
    }

    public double getFov(){
        return fov;
    }

}