package menuGUI.mainmenu;

import menuGUI.gui3.StyledButtonUI;
import menuGUI.mainmenu.control.ButtonAndTextAreaListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class First_Menu extends JFrame {

    private JLayeredPane layeredPane;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton button1;
    private JTextField textField;

    public First_Menu(){
        setSize(new Dimension(626,481));
        setResizable(false);
        this.getContentPane().setBackground(Color.RED);
        this.setLayout(null);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/menuGUI/mainmenu/img/icon.png");
        setIconImage(img);

        label1 = new JLabel();
        label1.setOpaque(true);
        label1.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/red-yellow-retro.jpg"));
        label1.setBounds(0,0,626,481);

        label2 = new JLabel();
        label2.setOpaque(false);
        label2.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/logo.png"));
        label2.setBounds(100,80,500,120);

        label3 = new JLabel();
        label3.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/ENTER YOUR NICKNAME.png"));
        label3.setBounds(180,200,220,47);


        Border line = new LineBorder(new Color(0x0F142A, true));

        button1 = new JButton();
        button1.setBounds(260,285,100,35);
       // button1.setIcon(new ImageIcon("src/mainmenu/img/button200x117.png"));
        button1.setBorder(line);
        button1.setContentAreaFilled(false);
        button1.setBackground(Color.ORANGE);
        button1.setUI(new StyledButtonUI());

        label4 = new JLabel();
        label4.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/PLAY.png"));
        label4.setBounds(267,242,200,117);

        /*button1 = new JButton("Play");
        button1.setBounds(220,290,150,40);
        button1.setForeground(Color.white);
        button1.setBackground(new Color(0x00040A));
        button1.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,25));
        Border line = new LineBorder(new Color(0x0F142A));
        button1.setBorder(line);
        button1.setFocusPainted(false);*/

        //invisible button
        //button1.setContentAreaFilled(false);

        textField = new JTextField();
        textField.setBackground(Color.white);
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("ITC Avant Garde Gothic",Font.PLAIN,15));
        textField.setBounds(235,240,150,25);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,800,700);

        ButtonAndTextAreaListener textlistener = new ButtonAndTextAreaListener(button1,textField);
        button1.setActionCommand("newNick");
        button1.addActionListener(textlistener);

        layeredPane.add(label1,Integer.valueOf(0));
        layeredPane.add(label2,Integer.valueOf(1));
        layeredPane.add(label3, Integer.valueOf(1));
        layeredPane.add(textField,Integer.valueOf(1));
        layeredPane.add(button1,Integer.valueOf(1));
        layeredPane.add(label4,Integer.valueOf(2));
        this.add(layeredPane);
        this.setLocationRelativeTo(null);

    }
}
