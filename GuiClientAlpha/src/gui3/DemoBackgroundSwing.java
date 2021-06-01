package gui3;

import javax.swing.*;
import java.awt.*;

public class DemoBackgroundSwing extends JPanel {

    private Image img;

    public DemoBackgroundSwing() {
        img = Toolkit.getDefaultToolkit().createImage("C:\\Users\\greta\\IdeaProjects\\MenuGUI\\src\\gui3\\qWPdo.jpg");
        loadImage(img);
    }

    private void loadImage(Image img) {
        try {
            MediaTracker track = new MediaTracker(this);
            track.addImage(img, 0);
            track.waitForID(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void paintComponent(Graphics g) {
        setOpaque(false);
        g.drawImage(img, 0, 0, null);
        super.paintComponent(g);
    }
}