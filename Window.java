import javax.swing.*;

public class Window {
    JFrame window;

    Window(){
        //Creates a new Window and makes it visible
        window = new JFrame("test");
        window.setVisible(true);
        window.pack();
        window.setLocationRelativeTo(null);
        //stops Program when the window is closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
