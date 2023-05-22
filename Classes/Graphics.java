package Classes;

import java.util.ArrayList;

public class Graphics {
    Window testWindow;
    Cuboid testCuboid;
    Cuboid testCuboid2;
    int testArrayLength = 50;
    Cuboid[] test = new Cuboid[testArrayLength];
    ArrayList<Cuboid> cuboidArray = new ArrayList();
    Graphics(){
        testWindow = new Window();
        //testCuboid = new Cuboid(new double[]{1,1,2},new double[]{0,2,0});
        //testCuboid2 = new Cuboid(new double[]{1,1,1},new double[]{1,3,0});

        for (int i=0;i<testArrayLength;i++){
            test[i]=new Cuboid(new double[]{1,1,1}, new double[]{-5+i,2+i,i/3.0});
        }
    }

    public void render(){
        testWindow.panel.clearLines();
        //testWindow.renderObjectWireframe(testCuboid);
        //testWindow.renderObjectWireframe(testCuboid2);

        for (int i=0;i<testArrayLength;i++){
            testWindow.renderObjectWireframe(test[i]);
        }
    }


}
