package menuGUI.windows;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import gameGui.guiB.util.AnimationTask;
import core.VolumeControl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VolumeFrame extends JFrame{

    private JSlider slider;
    private JButton button1;
    private JLayeredPane layeredPane;
    private JLabel label1;
    private boolean flag; //flag per bottone muto

    public VolumeFrame(){
        setSize(new Dimension(300,150));
        setResizable(false);
        this.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,300,150);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/menuGUI/img/icon.png");
        setIconImage(img);

        Border line = new LineBorder(new Color(0x0F142A, true));

<<<<<<< HEAD:ClientProject/src/menuGUI/windows/VolumeFrame.java
        slider = new JSlider(JSlider.HORIZONTAL,0,100,25);
        slider.setBounds(40,30,170,50);  
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing (50);
        slider.setPaintTicks (true);  
        slider.setPaintLabels (true);

        ImageIcon c0 = new ImageIcon("src/menuGUI/img/music.png");
        ImageIcon c1 = new ImageIcon("src/menuGUI/img/music-off.png");
=======
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,300,150);


        slider = new JSlider(JSlider.HORIZONTAL,0,90, (int)((VolumeControl.volume)*100)); //cambiamento
        slider.setBounds(40,30,170,50);
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing (10);
        slider.setPaintTicks (true);
        slider.setPaintLabels (true);
        slider.addChangeListener(new VolumeControl());
       
>>>>>>> e9f3400115813ae34cc1e3e582e08d9f868ee68b:ClientProject/src/menuGUI/mainmenu/VolumeFrame.java

        button1 = new JButton();
        if (AnimationTask.volumeOffset !=0) {
        	button1.setIcon(c0);
        }else if(AnimationTask.volumeOffset ==0){
        		button1.setIcon(c1);
        	}
        
        button1.setBounds(238,38,36,37);
        button1.setContentAreaFilled(false);
        button1.setFocusPainted(false);
        button1.setBorder(line);
        button1.setUI(new StyledButtonUI());
        button1.setBackground(Color.ORANGE);

        label1 = new JLabel();
        label1.setBounds(0,0,300,150);
        label1.setIcon(new ImageIcon("src/menuGUI/img/blur300x150.jpg"));

        button1.addActionListener(
<<<<<<< HEAD:ClientProject/src/menuGUI/windows/VolumeFrame.java
            new ActionListener(){
                private boolean flag = true;

                @Override
                public void actionPerformed(ActionEvent arg0){
                    button1.setIcon(flag ? c1 : c0);
                    flag = !flag;
                }
            });

        layeredPane.add(slider, Integer.valueOf(1));
        layeredPane.add(button1, Integer.valueOf(1));
        layeredPane.add(label1, Integer.valueOf(0));
        this.add(layeredPane);
=======
                new ActionListener(){
                	
                	boolean flag= setFlag();
                	double memVol;
                	
                	public boolean setFlag(){
                		
                		if (AnimationTask.volumeOffset !=0) {
                			return true;
                		}else if(AnimationTask.volumeOffset ==0){
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
                            AnimationTask.volumeOffset = 0;
                            slider.setVisible(false);
                            
                            //poi anche vittoria
                        }else {
                        	 slider.setVisible(true);
                            VolumeControl.volume = memVol;
                            AnimationTask.volumeOffset = 0.1;
                        }

                        System.out.println("nuovo flag � "+flag);
                    }
                });
>>>>>>> e9f3400115813ae34cc1e3e582e08d9f868ee68b:ClientProject/src/menuGUI/mainmenu/VolumeFrame.java
    }
}
