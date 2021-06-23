package menuGUI.mainmenu;


import gameGui.guiB.util.ButtonsListener;
import menuGUI.gui3.StyledButtonUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionListener;

public class RequestFrame extends JFrame {

    private JLayeredPane layeredPane;
    private JLabel label1;
    private JLabel label2;
    private JButton jb1;
    private JButton jb2;

    public RequestFrame(String playerName){
        setSize(new Dimension(300,150));
        setResizable(false);


        this.getContentPane();
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/menuGUI/mainmenu/img/icon.png");
        setIconImage(img);

        Border line = new LineBorder(new Color(0x0F142A, true));

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,300,150);


        label1 = new JLabel();
        label1.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/blur300x150.jpg"));
        label1.setBounds(0,0,300,150);

        label2 = new JLabel("Invite recived from "+playerName);
        label2.setBounds(0,10,300, 50);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,15));
        label2.setForeground(Color.BLACK);

        jb1 = new JButton("ACCEPT");
        jb1.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,12));
        jb1.setForeground(Color.BLACK);
        jb1.setOpaque(true);
        jb1.setContentAreaFilled(false);
        jb1.setFocusPainted(false);
        jb1.setBorder(line);
        jb1.setBounds(35,70,100,20);
        jb1.setBackground(Color.orange.brighter());
        jb1.setUI(new StyledButtonUI());
        jb1.setActionCommand("accept");
        jb1.addActionListener(new ButtonsListener(jb1,this));

        jb2 = new JButton("DECLINE");
        jb2.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,12));
        jb2.setForeground(Color.BLACK);
        jb2.setOpaque(true);
        jb2.setContentAreaFilled(false);
        jb2.setFocusPainted(false);
        jb2.setBorder(line);
        jb2.setBounds(155,70,100,20);
        jb2.setBackground(Color.orange.brighter());
        jb2.setUI(new StyledButtonUI());
        jb2.setActionCommand("decline");
        jb2.addActionListener(new ButtonsListener(jb2,this));

        layeredPane.add(label1, Integer.valueOf(0));
        layeredPane.add(label2, Integer.valueOf(1));
        layeredPane.add(jb1, Integer.valueOf(1));
        layeredPane.add(jb2, Integer.valueOf(1));

        this.add(layeredPane);

        revalidate();
        repaint();
    }
}
