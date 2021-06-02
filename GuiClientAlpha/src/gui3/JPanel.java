package gui3;

import javax.swing.*;
import java.awt.*;

public class JPanel extends javax.swing.JPanel {
    //custom jpanel

    private Image img;

    public JPanel(String path) {
        img = Toolkit.getDefaultToolkit().createImage(path);
        loadImage(img);
    }

    /*not sure about MediaTracker ma dovrebbe esserci utile quando usiamo i Thread dato che è
    una classe che monitora il caricamento delle img, si può fare sicuramente in un altro modo ma
    ho letto che appunto è utile coi Thread
    sono stanca
     */
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