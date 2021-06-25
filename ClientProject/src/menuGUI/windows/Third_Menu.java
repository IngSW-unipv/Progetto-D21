package menuGUI.windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Third_Menu extends JFrame {
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
    public static int choosenTheme; //TODO rendere questo attributo PROTECTED quando la GUI verrà messa TUTTA nello stesso package

    public Third_Menu(){
        setSize(new Dimension(500,700));
        setResizable(false);
        container = getContentPane();
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,500,700);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/menuGUI/img/icon.png");
        setIconImage(img);

        jPanel = new JPanel();
        jPanel.setBackground(new Color(0xDE8B0E, true));
        jPanel.setBounds(175,145,200,580);
        boxLayout = new BoxLayout(jPanel, BoxLayout.Y_AXIS);
        jPanel.setLayout(boxLayout);

        jb1 = new JButton();
        jb1.setBackground(Color.ORANGE);
        jb1.setIcon(new ImageIcon("src/menuGUI/img/themes/stitch.png"));
        jb1.setUI(new StyledButtonUI());

        jb2 = new JButton();
        jb2.setBackground(Color.ORANGE);
        jb2.setIcon(new ImageIcon("src/menuGUI/img/themes/avengers.png"));
        jb2.setUI(new StyledButtonUI());

        jb3 = new JButton();
        jb3.setBackground(Color.orange);
        jb3.setIcon(new ImageIcon("src/menuGUI/img/themes/mario.png"));
        jb3.setUI(new StyledButtonUI());

        jb4 = new JButton("Default theme");
        jb4.setBounds(170, 610, 140, 30);
        jb4.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,14));
        jb4.setBackground(new Color(0xC61F29));
        jb4.setForeground(Color.BLACK);
        jb4.setUI(new StyledButtonUI());

        ActionListener Theme1 = e -> {
            choosenTheme = 1;
        };
        ActionListener Theme2 = e -> {
            choosenTheme = 2;
        };
        ActionListener Theme3 = e -> {
            choosenTheme = 3;
        };
        ActionListener Theme4 = e -> {
            choosenTheme = 0;
        };

        jb1.addActionListener(Theme1);
        jb2.addActionListener(Theme2);
        jb3.addActionListener(Theme3);
        jb4.addActionListener(Theme4);

        jb5 = new JButton();
        jb5.setBackground(new Color(0xC61F29));
        jb5.setBounds(30,621,35,35);
        jb5.setIcon(new ImageIcon("src/menuGUI/img/double-arrow-left.png"));
        jb5.setUI(new StyledButtonUI());

        ActionListener BackToMenu = e -> {
            this.dispose();
        };

        jb5.addActionListener(BackToMenu);

        label1 = new JLabel();
        label1.setIcon(new ImageIcon("src/menuGUI/img/blur500x700.jpg"));
        label1.setBounds(0,0,500,700);

        label2 = new JLabel();
        label2.setIcon(new ImageIcon("src/menuGUI/img/CHOOSE YOUR.png"));
        label2.setBounds(10,10,700,80);

        label3 = new JLabel();
        label3.setBackground(Color.green);
        label3.setForeground(Color.WHITE);
        label3.setBounds(170,50,300,50);
        label3.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,35));

        label4 = new JLabel();
        label4.setIcon(new ImageIcon("src/menuGUI/img/THEME.png"));
        label4.setBounds(120,70,700,80);

        jPanel.add(jb1);
        jPanel.add(Box.createRigidArea(new Dimension(0,50)));
        jPanel.add(jb2);
        jPanel.add(Box.createRigidArea(new Dimension(0,50)));
        jPanel.add(jb3);
        jPanel.add(Box.createRigidArea(new Dimension(0,50)));

        layeredPane.add(jPanel,Integer.valueOf(1));
        layeredPane.add(label2,Integer.valueOf(2));
        layeredPane.add(label3,Integer.valueOf(1));
        layeredPane.add(label1,Integer.valueOf(0));
        layeredPane.add(label4, Integer.valueOf(1));
        layeredPane.add(jb4, Integer.valueOf(2));
        layeredPane.add(jb5, Integer.valueOf(2));
        container.add(layeredPane);
    }

}
