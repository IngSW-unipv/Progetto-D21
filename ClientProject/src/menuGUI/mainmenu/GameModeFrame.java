package menuGUI.mainmenu;

import menuGUI.gui3.StyledButtonUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GameModeFrame extends JFrame {

    private JButton jb1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLayeredPane layeredPane;
    private JLabel label1;

    public GameModeFrame(){
        setSize(new Dimension(300,150));
        setResizable(false);


        this.getContentPane().setBackground(Color.ORANGE);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/mainmenu/img/icon.png");
        setIconImage(img);

        Border line = new LineBorder(new Color(0x0F142A, true));

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,300,150);

        label1 = new JLabel();
        label1.setBounds(0, 0, 300, 150);
        label1.setIcon(new ImageIcon("src/mainmenu/img/blur300x150.jpg"));

        radioButton1 = new JRadioButton("Fast Game");
        radioButton2 = new JRadioButton("Slow Game");
        radioButton1.setBounds(10,20,150,30);
        radioButton2.setBounds(160,20,150,30);
        radioButton1.setOpaque(false);
        radioButton2.setOpaque(false);
        radioButton1.setForeground(Color.black);
        radioButton2.setForeground(Color.black);
        radioButton2.setBackground(new Color(0x0FFFFFF, true));
        radioButton1.setBackground(new Color(0x0FFFFFF, true));
        radioButton1.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,18));
        radioButton2.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,18));
        radioButton1.setBorder(line);
        radioButton2.setBorder(line);
        radioButton2.setFocusPainted(false);
        radioButton1.setFocusPainted(false);

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



        layeredPane.add(radioButton1, Integer.valueOf(1));
        layeredPane.add(radioButton2, Integer.valueOf(1));
        layeredPane.add(jb1, Integer.valueOf(1));
        layeredPane.add(label1, Integer.valueOf(0));
        this.add(layeredPane);
    }


}
