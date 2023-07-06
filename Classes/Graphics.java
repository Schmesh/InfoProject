package Classes;

import java.awt.*;
import java.util.ArrayList;

public class Graphics {

    Window testWindow;
    //SpectatorCam c1;

    Camera playerCam;

    ArrayList<Cuboid> cuboidArray = new ArrayList();

    ArrayList<TestLine> testLineArray = new ArrayList();
    Graphics(Gamestate gamestate){
        testWindow = new Window();


        //c1 = new SpectatorCam(new double[]{0,0,0},new double[]{0,0,0},90, testWindow.panel);
        //testWindow.window.addKeyListener(c1.k1);
        //testWindow.panel.addMouseListener(c1.m1);
        //testWindow.panel.addMouseMotionListener(c1.ml1);
        playerCam = new Camera(new double[]{0,0,0},new double[]{0,0,0},110);
        testWindow.window.addKeyListener(gamestate.returnPlayer().k1);
        testWindow.panel.addMouseListener(gamestate.returnPlayer().m1);
        testWindow.panel.addMouseMotionListener(gamestate.returnPlayer().ml1);
        gamestate.player.currentPanel = testWindow.panel;

        cuboidArray.add(new Cuboid(new double[]{1,1,1},new double[]{0,6.2,0}));



        //cuboidArray.get(0).rotateZ(30);
        //cuboidArray.get(0).rotateX(70);
        cuboidArray.get(0).setColor(0,200,200);
        testLineArray.add(new TestLine(new double[][]{{0,0},{100,100}}));

        OBJReader.convertOBJToTris("./Classes/rock.obj");

    }

    public void render(Gamestate gamestate){

        //c1.updateCamMovement();
        playerCam.pos= renderTools.addVector(gamestate.player.pos.getXYZ(), new double[]{0,0,0.3}) ;
        playerCam.rot= new double[]{gamestate.player.tilt,0,gamestate.player.direction};
        testWindow.panel.clearLines();
        testWindow.renderedTris.clear();
        double cuboidArraySize = cuboidArray.size();
        for (int i = 0;i< cuboidArray.size();i++){
            testWindow.renderObjectWireframe(cuboidArray.get(i),playerCam);
        }
        for (int i = 0;i< gamestate.physicsObjects.size();i++){
            Cuboid temporaryCuboid = new Cuboid(gamestate.physicsObjects.get(i).hitbox.size, gamestate.physicsObjects.get(i).pos.getXYZ() );
            testWindow.renderObjectWireframe(temporaryCuboid,playerCam);
        }
        //for (TestLine line : testLineArray){
        //    testWindow.renderLine(line);
        //}

        testWindow.panel.lineArray = testWindow.lines;
        testWindow.panel.renderedTris = testWindow.renderedTris;
        testWindow.panel.drawLines(testWindow.lines);
        if (gamestate.player.altDown){
            // Create a transparent image
            //Image image = Toolkit.getDefaultToolkit().createImage(new byte[] { 0 });

            // Create a custom cursor using the transparent image
            //Cursor invisibleCursor = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0, 0), "invisibleCursor");

        }
    }


}
