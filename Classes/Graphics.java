package Classes;

import java.util.ArrayList;

public class Graphics {
    Window testWindow;
    Camera c1;
    int testArrayLength = 50;
    ArrayList<Cuboid> cuboidArray = new ArrayList();
    Graphics(){
        c1 = new Camera(new double[]{0.4,0,0.4},new double[]{-20,0,0},90);
        testWindow = new Window();

        cuboidArray.add(new Cuboid(new double[]{1,1,1},new double[]{0.7,4,-1}));
        cuboidArray.add(new Cuboid(new double[]{1,1,1},new double[]{-0.3,3,0}));
        cuboidArray.add(new Cuboid(new double[]{1,1,1},new double[]{-0.3,4,0}));
        cuboidArray.add(new Cuboid(new double[]{1,1,1},new double[]{-0.3,6,0}));
    }

    public void render(){
        testWindow.panel.clearLines();
        double cuboidArraySize = cuboidArray.size();
        for (int i = 0;i< cuboidArray.size();i++){
            //cuboidArray.get(i).move(new double[]{0.01,0,0});
            testWindow.renderObjectWireframe(cuboidArray.get(i),c1);
        }
        cuboidArray.get(3).rotateZ(2.5);
        c1.move(new double[]{0,0.006,0});//0.01,0.015,0.004
        System.out.println(c1.pos[0]+","+c1.pos[1]+","+c1.pos[2]);
        //c1.rotate(new double[]{-0.04,0,-0.15});//-0.04,0,-0.15
    }


}
