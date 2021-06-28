package menuGUI.windows;

import core.AnimationsTask;
import core.VolumeControl;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VolumePanel extends JPanel {
    private JSlider slider;
    private JButton button1;


    public VolumePanel(){
        setSize(new Dimension(300,200));
        setBackground(Color.WHITE);

        ImageIcon c0 = new ImageIcon("src/menuGUI/img/music.png");
        ImageIcon c1 = new ImageIcon("src/menuGUI/img/music-off.png");

        Border line = new LineBorder(new Color(0x0F142A, true));

        slider = new JSlider(JSlider.HORIZONTAL,0,90, (int)((VolumeControl.volume)*100)); //cambiamento
        slider.setBounds(30,30,170,50);
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing (10);
        slider.setPaintTicks (true);
        slider.setPaintLabels (true);
        slider.addChangeListener(new VolumeControl());

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

       /* button1.addActionListener(
            new ActionListener(){
                boolean flag= setFlag();
                double memVol;

                public boolean setFlag(){
                    if (AnimationsTask.volumeOffset !=0) {
                        return true;
                    }else if(AnimationsTask.volumeOffset ==0){
                        return false;
                    }
                    return false;
                }

                @Override
                public void actionPerformed(ActionEvent arg0){

                    button1.setIcon(flag ? c1 : c0);
                    flag = !flag;
                    if(!flag) {
                        memVol= VolumeControl.volume;
                        VolumeControl.volume = 0;
                        AnimationsTask.volumeOffset = 0;
                        slider.setVisible(false);

                        //poi anche vittoria
                    }else {
                        slider.setVisible(true);
                        VolumeControl.volume = memVol;
                        AnimationsTask.volumeOffset = 0.1;
                    }

                    System.out.println("nuovo flag è "+flag);
                }
            });
        */


        //abbiamo fatto tutti gli actionListener così, inserire qui il codice dell'azione da effettuare
        ActionListener volumeListener = e -> {

        };

        this.add(button1);
        this.add(slider);
    }
}
