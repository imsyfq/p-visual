/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jobsheet02;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author tb12as
 */
public class Percobaan6 extends JFrame {

    public Percobaan6() {
        setSize(400, 300);
        setTitle("Percobaan6");
        addWindowListener(new Peristiwa(this));
        setVisible(true);
    }

    public static void main(String[] args) {
        new Percobaan6();
    }

    class Peristiwa extends WindowAdapter {

        Percobaan6 percobaan;

        Peristiwa(Percobaan6 percobaan) {
            this.percobaan = percobaan;
        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
            //dispose();
        }

    }
}
