package jobsheet02;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author tb12as
 */
public class Percobaan1 extends JFrame {

    public Percobaan1() {
        setSize(400, 300);
        setTitle("Percobaan 1 - Contoh Objek Frame");
        // getContentPane().setBackground(Color.RED);
        getContentPane().setBackground(new Color(225, 100, 140));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // setVisible(true);
    }

    public static void main(String[] args) {
        Percobaan1 percobaan1 = new Percobaan1();
        percobaan1.setVisible(true);
    }
}
