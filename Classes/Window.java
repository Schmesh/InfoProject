package Classes;

import Classes.GraphicsPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Window {
    JFrame window;
    public GraphicsPanel panel;
    private double fov = 90;
    //private double distanceToScreen = 0.1;
    //private double viewDistance = 1000;

    public ArrayList<double[]> lines;

    public ArrayList<Triangle> renderedTris;


    public Window() {
        //Creates a new Classes.Window and makes it visible
        //creates a graphics panel and adds it to the window
        window = new JFrame("test");
        panel = new GraphicsPanel(this);
        window.add(panel);
        window.setVisible(true);
        window.pack();
        window.setLocationRelativeTo(null);
        //stops Program when the window is closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lines = new ArrayList();
        renderedTris = new ArrayList();
        //maximizes the window
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);




    }




    public void renderObjectWireframe(Object object, Camera cam) {

        int trianglesLength = object.getTriangles().length;

        for (int i = 0; i < trianglesLength; i++) {
            if (object.getTriangles()[i] != null){ // && renderTools.normDotProduct(renderTools.getNormal(object.getTriangles()[i]),renderTools.subVector(object.getTriangles()[i].p[0].getXYZ(),new double[]{0,0,0})) < 0 ){
                //===rotate Points around 0,0,0 then add camera pos
                Triangle translatedTri = new Triangle(new Point[]{new Point(object.getTriangles()[i].p[0].getXYZ()),new Point(object.getTriangles()[i].p[1].getXYZ()),new Point(object.getTriangles()[i].p[2].getXYZ())});

                //-> move to cam pos
                translatedTri.p[0].setXyz(renderTools.subVector(translatedTri.p[0].getXYZ(),cam.pos));
                translatedTri.p[1].setXyz(renderTools.subVector(translatedTri.p[1].getXYZ(),cam.pos));
                translatedTri.p[2].setXyz(renderTools.subVector(translatedTri.p[2].getXYZ(),cam.pos));

                //-> rotate
                //Z
                translatedTri.p[0].setXyz(renderTools.rotatePointOriginZ(translatedTri.p[0].getXYZ(),-cam.rot[2]));
                translatedTri.p[1].setXyz(renderTools.rotatePointOriginZ(translatedTri.p[1].getXYZ(),-cam.rot[2]));
                translatedTri.p[2].setXyz(renderTools.rotatePointOriginZ(translatedTri.p[2].getXYZ(),-cam.rot[2]));
                //X
                translatedTri.p[0].setXyz(renderTools.rotatePointOriginX(translatedTri.p[0].getXYZ(),cam.rot[0]));
                translatedTri.p[1].setXyz(renderTools.rotatePointOriginX(translatedTri.p[1].getXYZ(),cam.rot[0]));
                translatedTri.p[2].setXyz(renderTools.rotatePointOriginX(translatedTri.p[2].getXYZ(),cam.rot[0]));



                    Triangle renderedTri = new Triangle(new Point[3]);
                    renderedTri.p[0] = new Point(renderTools.project3d2d(translatedTri.p[0].getXYZ() ,cam.fov,panel.getHeight(),panel.getWidth()));
                    renderedTri.p[1] = new Point(renderTools.project3d2d(translatedTri.p[1].getXYZ() ,cam.fov,panel.getHeight(),panel.getWidth()));
                    renderedTri.p[2] = new Point(renderTools.project3d2d(translatedTri.p[2].getXYZ() ,cam.fov,panel.getHeight(),panel.getWidth()));

                    //if y > 0 only temporary approach until clipping is implemented

                    if (translatedTri.p[0].getXYZ()[1] > 0&&translatedTri.p[1].getXYZ()[1] > 0&&translatedTri.p[2].getXYZ()[1] > 0){ //&&renderTools.normDotProduct(renderTools.getNormal(object.getTriangles()[i]), translatedTri.p[0].getXYZ()) < 0
                    lines.add(new double[]{renderedTri.p[0].getXYZ()[0],renderedTri.p[0].getXYZ()[2], renderedTri.p[1].getXYZ()[0], renderedTri.p[1].getXYZ()[2]});
                    lines.add(new double[]{renderedTri.p[1].getXYZ()[0],renderedTri.p[1].getXYZ()[2], renderedTri.p[2].getXYZ()[0], renderedTri.p[2].getXYZ()[2]});
                    lines.add(new double[]{renderedTri.p[2].getXYZ()[0],renderedTri.p[2].getXYZ()[2], renderedTri.p[0].getXYZ()[0], renderedTri.p[0].getXYZ()[2]});
                    //double[] normalEnd = renderTools.project3d2d(    renderTools.addVector(object.getTriangles()[i].p[0].getXYZ() , renderTools.getNormal(object.getTriangles()[i])),fov,distanceToScreen,viewDistance,panel.getHeight(),panel.getWidth());
                    //lines.add(new double[]{renderedTri.p[0].getXYZ()[0],renderedTri.p[0].getXYZ()[2],normalEnd[0],normalEnd[2]});

                    }


                translatedTri = null;
                renderedTri = null;
            }
        }

    }

    public void renderObject(Object object, Camera cam){
        int trianglesLength = object.getTriangles().length;

        for (int i = 0; i < trianglesLength; i++) {
            if (object.getTriangles()[i] != null){ // && renderTools.normDotProduct(renderTools.getNormal(object.getTriangles()[i]),renderTools.subVector(object.getTriangles()[i].p[0].getXYZ(),new double[]{0,0,0})) < 0 ){
                //===rotate Points around 0,0,0 then add camera pos
                Triangle translatedTri = new Triangle(new Point[]{new Point(object.getTriangles()[i].p[0].getXYZ()),new Point(object.getTriangles()[i].p[1].getXYZ()),new Point(object.getTriangles()[i].p[2].getXYZ())});

                //-> move to cam pos
                translatedTri.p[0].setXyz(renderTools.subVector(translatedTri.p[0].getXYZ(),cam.pos));
                translatedTri.p[1].setXyz(renderTools.subVector(translatedTri.p[1].getXYZ(),cam.pos));
                translatedTri.p[2].setXyz(renderTools.subVector(translatedTri.p[2].getXYZ(),cam.pos));

                //-> rotate
                //Z
                translatedTri.p[0].setXyz(renderTools.rotatePointOriginZ(translatedTri.p[0].getXYZ(),-cam.rot[2]));
                translatedTri.p[1].setXyz(renderTools.rotatePointOriginZ(translatedTri.p[1].getXYZ(),-cam.rot[2]));
                translatedTri.p[2].setXyz(renderTools.rotatePointOriginZ(translatedTri.p[2].getXYZ(),-cam.rot[2]));
                //X
                translatedTri.p[0].setXyz(renderTools.rotatePointOriginX(translatedTri.p[0].getXYZ(),cam.rot[0]));
                translatedTri.p[1].setXyz(renderTools.rotatePointOriginX(translatedTri.p[1].getXYZ(),cam.rot[0]));
                translatedTri.p[2].setXyz(renderTools.rotatePointOriginX(translatedTri.p[2].getXYZ(),cam.rot[0]));



                Triangle renderedTri = new Triangle(new Point[3]);
                renderedTri.p[0] = new Point(renderTools.project3d2d(translatedTri.p[0].getXYZ() ,cam.fov,panel.getHeight(),panel.getWidth()));
                renderedTri.p[1] = new Point(renderTools.project3d2d(translatedTri.p[1].getXYZ() ,cam.fov,panel.getHeight(),panel.getWidth()));
                renderedTri.p[2] = new Point(renderTools.project3d2d(translatedTri.p[2].getXYZ() ,cam.fov,panel.getHeight(),panel.getWidth()));

                //if y > 0 only temporary approach until clipping is implemented

                if (translatedTri.p[0].getXYZ()[1] > 0&&translatedTri.p[1].getXYZ()[1] > 0&&translatedTri.p[2].getXYZ()[1] > -0){ //&&renderTools.normDotProduct(renderTools.getNormal(object.getTriangles()[i]), translatedTri.p[0].getXYZ()) < 0
                    double lightDotProduct = renderTools.normDotProduct(renderTools.getNormal(object.getTriangles()[i]),  cam.light.lightVector);
                    double lightFactor = (renderTools.normDotProduct(renderTools.getNormal(object.getTriangles()[i]),  cam.light.lightVector)+1)*0.5;


                    //renderedTri.color = new Color((int)Math.round(object.getTriangles()[i].color.getRed()+lightDotProduct*255), (int) (object.getTriangles()[i].color.getGreen()+lightDotProduct*255), (int) (object.getTriangles()[i].color.getBlue()+lightDotProduct*255));
                    renderedTri.color = new Color((int) Math.floor(lightFactor*255), (int) Math.floor(lightFactor*255), (int) Math.floor(lightFactor*255));

                    renderedTris.add(renderedTri);
                }


                translatedTri = null;
                renderedTri = null;
            }
        }
    }

    public void setFov(double fov){
        this.fov = fov;
    }

    public double getFov(){
        return fov;
    }

}