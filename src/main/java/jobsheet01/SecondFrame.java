package jobsheet01;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author tb12as
 */
public class SecondFrame {

    public SecondFrame() {
        Frame fr = new Frame("Second Frame");
        fr.setSize(300, 400);
        fr.setVisible(true);

        fr.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new SecondFrame();
    }
}
