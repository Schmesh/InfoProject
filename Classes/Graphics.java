package Classes;

import java.util.ArrayList;

public class Graphics {
    Window testWindow;
    Cuboid testCuboid;
    Cuboid testCuboid2;
    ArrayList<Cuboid> cuboidArray = new ArrayList();
    Graphics(){
        testWindow = new Window();
        testCuboid = new Cuboid(new double[]{1,1,2},new double[]{0,2,0});
        testCuboid2 = new Cuboid(new double[]{1,1,1},new double[]{1,3,0});
        for (int i = 0;i < 5;i++){
            cuboidArray.add(new Cuboid(new double[]{1,1,1},new double[]{0,0,i}));
        }
    }

    public void render(){
        testWindow.panel.clearLines();
        System.out.println("test");
        for (int i = 0; i < cuboidArray.size();i++){
            testWindow.renderObjectWireframe(cuboidArray.get(i));
        }
        testWindow.renderObjectWireframe(testCuboid);
        testWindow.renderObjectWireframe(testCuboid2);
    }


}
