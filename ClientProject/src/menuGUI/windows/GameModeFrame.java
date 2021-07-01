package menuGUI.windows;

import menuGUI.windows.util.FrameType;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class GameModeFrame extends InteractionFrame{

    private JButton jb1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private String gameSpeed;
    private Border line;

    public GameModeFrame(){
        super(FrameType.SMALLFRAME);
        setupFrameWithCostumElements();
    }

    public String getGameSpeed(){
        return gameSpeed;
    }


    @Override
    protected void setupFrameWithCostumElements() {
        radioButton1 = new JRadioButton("Fast Game");
        radioButton1.setBounds(10,20,150,30);
        radioButton1.setOpaque(false);
        radioButton1.setForeground(Color.black);
        radioButton1.setBackground(new Color(0x0FFFFFF, true));
        radioButton1.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,18));
        radioButton1.setBorder(line);
        radioButton1.setFocusPainted(false);

        radioButton2 = new JRadioButton("Slow Game");
        radioButton2.setBounds(160,20,150,30);
        radioButton2.setOpaque(false);
        radioButton2.setForeground(Color.black);
        radioButton2.setBackground(new Color(0x0FFFFFF, true));
        radioButton2.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,18));
        radioButton2.setBorder(line);
        radioButton2.setFocusPainted(false);


        // action listener che chiude con enter solo se una delle modalità è stata selezionata altrimenti enter non fa nulla
        ActionListener radio = e ->{
            if(radioButton1.isSelected())
                gameSpeed = "s";
            if(radioButton2.isSelected())
                gameSpeed = "l";
            if(radioButton1.isSelected()||radioButton2.isSelected()){
                WindowEvent closeFrame = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeFrame);
            }
        };

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        jb1 = new JButton("ENTER");
        jb1.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,12));
        jb1.setForeground(Color.BLACK);
        jb1.setOpaque(true);
        jb1.setContentAreaFilled(false);
        jb1.setFocusPainted(false);
        jb1.setBorder(line);
        jb1.setBounds(90,70,100,20);
        jb1.setBackground(Color.orange.brighter());
        jb1.setUI(new StyledButtonUI());
        jb1.addActionListener(radio);

        layeredPane.add(radioButton1, Integer.valueOf(1));
        layeredPane.add(radioButton2, Integer.valueOf(1));
        layeredPane.add(jb1, Integer.valueOf(1));

        revalidate();
        repaint();
    }
}
