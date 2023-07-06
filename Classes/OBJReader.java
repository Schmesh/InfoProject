package Classes;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class OBJReader {

    OBJReader(){

    }
    static public Triangle[] convertOBJToTris(String filename){
        Triangle[] tris = new Triangle[]{};

        final String fileName = "./Classes/rock.obj";



        try {
           var file = new FileInputStream(fileName);

           //System.out.println(file.read().);
        } catch (Exception e) {
            System.out.println("ouchie when loading obj file");
            e.printStackTrace();
        }

        return tris;
    }

}
