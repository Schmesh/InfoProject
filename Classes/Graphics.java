package Classes;

import java.util.ArrayList;

public class Graphics {
    Window testWindow;
    int testArrayLength = 50;
    ArrayList<Cuboid> cuboidArray = new ArrayList();
    Graphics(){
        testWindow = new Window();

        cuboidArray.add(new Cuboid(new double[]{1,1,1},new double[]{0.7,4,-1}));
        cuboidArray.add(new Cuboid(new double[]{1,1,1},new double[]{-0.3,3,0}));


    }

    public void render(){
        testWindow.panel.clearLines();
        double cuboidArraySize = cuboidArray.size();
        for (int i = 0;i< cuboidArray.size();i++){
            testWindow.renderObjectWireframe(cuboidArray.get(i));
        }
    }


}
