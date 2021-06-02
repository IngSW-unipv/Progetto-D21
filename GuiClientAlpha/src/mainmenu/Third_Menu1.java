package mainmenu;

import gui3.StyledButtonUI;

import javax.swing.*;
import java.awt.*;

public class Third_Menu1 extends JFrame {
    private BoxLayout boxLayout;
    private Container container;
    private JPanel jPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton jb1;
    private JButton jb2;
    private JButton jb3;
    private JButton jb4;
    private JButton jb5;
    private JLayeredPane layeredPane;

    public Third_Menu1(){
        setSize(new Dimension(500,900));
        setResizable(false);
        container = getContentPane();

        this.setLayout(null);
        this.setLocationRelativeTo(null);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/mainmenu/img/icon.png");
        setIconImage(img);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,500,700);

        jPanel = new JPanel();
        jPanel.setBackground(new Color(0xDE8B0E, true));
        jPanel.setBounds(175,180,200,580);
        boxLayout = new BoxLayout(jPanel, BoxLayout.Y_AXIS);
        jPanel.setLayout(boxLayout);

        jb1 = new JButton();
        jb1.setBackground(Color.ORANGE);
        jb1.setIcon(new ImageIcon("src/gui3/themes/stitch.png"));


        jb2 = new JButton();
        jb2.setBackground(Color.ORANGE);
        jb2.setIcon(new ImageIcon("src/gui3/themes/avengers.png"));


        jb3 = new JButton();
        jb3.setBackground(Color.orange);
        jb3.setIcon(new ImageIcon("src/gui3/themes/mario.png"));


        jb4 = new JButton("Default Theme      ");
        jb4.setFont(new Font("Calibri", Font.BOLD, 14));
        jb4.setBackground(new Color(0xC61F29));
        jb4.setIcon(new ImageIcon(""));
        jb4.setForeground(Color.BLACK);

        jb5 = new JButton();
        jb5.setBackground(new Color(0xC61F29));
        jb5.setBounds(30,625,50,50);
        jb5.setIcon(new ImageIcon("src/mainmenu/img/double-arrow-left-1.png"));


        jb1.setUI(new StyledButtonUI());
        jb2.setUI(new StyledButtonUI());
        jb3.setUI(new StyledButtonUI());
        jb4.setUI(new StyledButtonUI());
        jb5.setUI(new StyledButtonUI());

        label1 = new JLabel();
        label1.setIcon(new ImageIcon("src/mainmenu/img/blur500x700.jpg"));
        label1.setBounds(0,0,500,700);

        label2 = new JLabel();
        label2.setIcon(new ImageIcon("src/mainmenu/img/CHOOSE YOUR (3).png"));
        label2.setBounds(10,30,700,80);

        label4 = new JLabel();
        label4.setIcon(new ImageIcon("src/mainmenu/img/THEME (2).png"));
        label4.setBounds(120,90,700,80);

        label3 = new JLabel();
        label3.setBackground(Color.green);
        label3.setForeground(Color.WHITE);
        label3.setBounds(170,50,300,50);
        label3.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,35));

        jPanel.add(jb1);
        jPanel.add(Box.createRigidArea(new Dimension(0,50)));
        jPanel.add(jb2);
        jPanel.add(Box.createRigidArea(new Dimension(0,50)));
        jPanel.add(jb3);
        jPanel.add(Box.createRigidArea(new Dimension(0,50)));
        jPanel.add(jb4);

        layeredPane.add(jPanel,Integer.valueOf(1));
        layeredPane.add(label2,Integer.valueOf(2));
        layeredPane.add(label3,Integer.valueOf(1));
        layeredPane.add(label1,Integer.valueOf(0));
        layeredPane.add(label4, Integer.valueOf(1));
        layeredPane.add(jb5, Integer.valueOf(2));

        container.add(layeredPane);

    }

}
