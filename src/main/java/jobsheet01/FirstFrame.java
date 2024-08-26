package jobsheet01;

import java.awt.Frame;

/**
 *
 * @author tb12as
 */
public class FirstFrame extends Frame {

    public FirstFrame() {
        setSize(300, 400);
        setTitle("Frame Pertama");
        setVisible(true);
    }

    public static void main(String[] args) {
        FirstFrame firstFrame = new FirstFrame();
    }
}
