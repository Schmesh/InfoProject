package Classes;

import java.util.ArrayList;

public class Graphics {
    Window testWindow;
    SpectatorCam c1;
    int testArrayLength = 50;
    ArrayList<Cuboid> cuboidArray = new ArrayList();
    Graphics(){
        testWindow = new Window();
        c1 = new SpectatorCam(new double[]{0,0,0},new double[]{0,0,0},90, testWindow.panel);
        testWindow.window.addKeyListener(c1.k1);
        testWindow.panel.addMouseListener(c1.m1);
        testWindow.panel.addMouseMotionListener(c1.ml1);

        cuboidArray.add(new Cuboid(new double[]{1,1,1},new double[]{-0.2,4,0}));
        cuboidArray.add(new Cuboid(new double[]{1,1,1},new double[]{-0.2,6,0}));
        cuboidArray.add(new Cuboid(new double[]{1,1,1},new double[]{-0.2,8,0}));
        cuboidArray.add(new Cuboid(new double[]{10,10,1},new double[]{0,6,-5}));
        for (int i = 0; i < 500;i++){
            cuboidArray.add(new Cuboid(new double[]{1,1,1},new double[]{-0.2,8+i*2,0}));
        }


    }

    public void render(){
        c1.updateCamMovement();
        testWindow.panel.clearLines();
        testWindow.renderedTris.clear();
        double cuboidArraySize = cuboidArray.size();
        for (int i = 0;i< cuboidArray.size();i++){
            //cuboidArray.get(i).move(new double[]{0.01,0,0});
            testWindow.renderObject(cuboidArray.get(i),c1);
        }
        //cuboidArray.get(3).rotateZ(2.5);
        //cuboidArray.get(3).rotateX(1);
        //c1.move(new double[]{0.005,0.6,0});
        //c1.move(new double[]{0.01,0.015,0.004});
        //c1.rotate(new double[]{0,0,-0.1});
        //c1.rotate(new double[]{-0.04,0,-0.15});
        testWindow.panel.lineArray = testWindow.lines;
        testWindow.panel.renderedTris = testWindow.renderedTris;
        testWindow.panel.drawLines(testWindow.lines);
    }


}
