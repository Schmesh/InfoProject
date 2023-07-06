package Classes;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OBJReader {

    OBJReader(){

    }
    public Triangle[] convertOBJToTris(String filename){
        Triangle[] tris = new Triangle[]{};

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tris;
    }

}
