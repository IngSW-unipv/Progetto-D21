package core;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VolumeControl implements ChangeListener { 

    public static double volume = 0.50;
    

    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        source.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                volume = ((double) (source.getValue())) / 100;
                System.out.println(volume);
            }
        });

    }

}