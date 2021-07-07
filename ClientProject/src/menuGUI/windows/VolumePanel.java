package menuGUI.windows;

import core.AnimationsTask;
import core.SoundPlayer;
import core.VolumeControl;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is a simple extension of the JPanel class, it creates a mechanism for the volume settings.
 * It implements ad inner ActionListener for the mute option
 */
public class VolumePanel extends JPanel {
    private JSlider slider;
    private JButton button1;
    private boolean isMute = false;
    private ImageIcon c0;
    private ImageIcon c1;


    public VolumePanel(){
        setSize(new Dimension(300,200));
        setBackground(Color.WHITE);

        c0 = new ImageIcon("src/menuGUI/img/music.png");
        c1 = new ImageIcon("src/menuGUI/img/music-off.png");

        Border line = new LineBorder(new Color(0x0F142A, true));

        slider = new JSlider(JSlider.HORIZONTAL,0,100, (int)((VolumeControl.volume)*100)); //cambiamento
        slider.setBounds(30,30,170,50);
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing (10);
        slider.setPaintTicks (true);
        slider.setPaintLabels (true);
        slider.addChangeListener(new VolumeControl());
        slider.setBackground(Color.WHITE);

        button1 = new JButton();
        if (AnimationsTask.volumeOffset !=0) {
            button1.setIcon(c0);
        }else if(AnimationsTask.volumeOffset ==0){
            button1.setIcon(c1);
        }

        button1.setBounds(250,38,36,37);
        button1.setContentAreaFilled(false);
        button1.setFocusPainted(false);
        button1.setBorder(line);
        button1.setUI(new StyledButtonUI());
        button1.setBackground(Color.GRAY.brighter());


        ActionListener volumeListener = e -> {
            isMute = !isMute;
            if(isMute){
                button1.setIcon(c1);
                SoundPlayer.setGlobalVol(0);
                slider.setVisible(false);
            }
            if(!isMute){
                button1.setIcon(c0);
                SoundPlayer.setGlobalVol(VolumeControl.volume);
                slider.setVisible(true);
            }
        };

        button1.addActionListener(volumeListener);
        this.add(button1);
        this.add(slider);
    }
}
