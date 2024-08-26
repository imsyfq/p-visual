package jobsheet02;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author tb12as
 */
public class Percobaan2 {

    public Percobaan2() {
        JFrame fr = new JFrame("Percobaan 2 - Contoh Objek Frame");
        fr.setSize(400, 300);
        fr.getContentPane().setBackground(Color.BLUE);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }

    public static void main(String[] args) {
        new Percobaan2();
    }
}
