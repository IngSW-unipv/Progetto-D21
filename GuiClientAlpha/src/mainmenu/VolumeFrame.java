package mainmenu;

import gui3.StyledButtonUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class VolumeFrame extends JFrame {

    private JSlider slider;
    private JButton button1;
    private JLayeredPane layeredPane;
    private JLabel label1;

    public VolumeFrame(){

        setSize(new Dimension(300,150));
        setResizable(false);
        this.setLocationRelativeTo(null);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/mainmenu/img/icon.png");
        setIconImage(img);

        Border line = new LineBorder(new Color(0x0F142A, true));

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,300,150);


        slider = new JSlider(JSlider.HORIZONTAL,0,50,25);
        slider.setBounds(40,30,170,50);  
        slider.setMinorTickSpacing(2);  
        slider.setMajorTickSpacing (10);  
        slider.setPaintTicks (true);  
        slider.setPaintLabels (true);



        button1 = new JButton();
        button1.setIcon(new ImageIcon("src/mainmenu/img/music.png"));
        button1.setBounds(238,38,36,37);
        button1.setContentAreaFilled(false);
        button1.setFocusPainted(false);
        button1.setBorder(line);
        button1.setUI(new StyledButtonUI());
        button1.setBackground(Color.ORANGE);
        
        ActionListener musicOff = e->{
            button1.setIcon(new ImageIcon("src/mainmenu/img/music-off.png"));
        };

        label1 = new JLabel();
        label1.setBounds(0,0,300,150);
        label1.setIcon(new ImageIcon("src/mainmenu/img/blur300x150.jpg"));


        layeredPane.add(slider, Integer.valueOf(1));
        layeredPane.add(button1, Integer.valueOf(1));
        layeredPane.add(label1, Integer.valueOf(0));
        this.add(layeredPane);
        
        button1.addActionListener(musicOff);
        
    }
}
