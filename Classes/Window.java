package Classes;

import Classes.GraphicsPanel;

import javax.swing.*;
import java.awt.*;

public class Window {
    static JFrame window;

    public Window(){
        //Creates a new Classes.Window and makes it visible
        //creates a graphics panel and adds it to the window
        window = new JFrame("test");
        GraphicsPanel panel = new GraphicsPanel();
        window.add(panel);
        panel.setBackground(Color.BLACK);
        window.setVisible(true);
        window.pack();
        window.setLocationRelativeTo(null);
        //stops Program when the window is closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}