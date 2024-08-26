package jobsheet02;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author tb12as
 */
public class Percobaan4 extends JFrame {

    public Percobaan4() {
        setSize(400, 300);
        setTitle("Percobaan 4");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                //dispose();
            }
        });

        // setVisible(true);
    }

    public static void main(String[] args) {
        Percobaan4 obj = new Percobaan4();
        obj.setVisible(true);
    }

}
