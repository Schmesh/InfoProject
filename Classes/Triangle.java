package Classes;

import java.awt.*;

public class Triangle {
    public Color color = new Color(255,255,255);

    public Punkt[] p = new Punkt[3];;



    Triangle(Punkt[] pInput){
        //Points
        p[0] = pInput[0];
        p[1] = pInput[1];
        p[2] = pInput[2];
    }
    Triangle(Punkt[] pInput, Color color){
        //Points
        p[0] = pInput[0];
        p[1] = pInput[1];
        p[2] = pInput[2];
        this.color = color;

    }
    public double[] getCenter(){

        return renderTools.divVector(renderTools.addVector(renderTools.addVector(p[0].getXYZ(),p[1].getXYZ()),p[2].getXYZ()),3);

    }
    public void setColor(Color color){
        this.color = color;
    }
}