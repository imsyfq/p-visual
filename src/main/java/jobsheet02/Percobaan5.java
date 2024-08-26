package jobsheet02;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author tb12as
 */
public class Percobaan5 extends JFrame implements WindowListener {

    public Percobaan5() {
        setSize(400, 300);
        setTitle("Percobaan 5");
        addWindowListener(this); // what?
        setVisible(true);
    }

    public static void main(String[] args) {
        new Percobaan5();
    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

}
