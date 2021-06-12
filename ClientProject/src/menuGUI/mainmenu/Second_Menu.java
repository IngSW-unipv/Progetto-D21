package menuGUI.mainmenu;

import menuGUI.gui3.StyledButtonUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Second_Menu extends JFrame {

    private JLayeredPane layeredPane;
    private JLabel label0;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JTextField textField;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JMenu menu;
    private JMenuItem item1;
    private JMenuItem item2;
    private JMenuItem item3;
    private JPopupMenu popupMenu;

    public Second_Menu(){
        setSize(new Dimension(700,500));
        setResizable(false);

        this.getContentPane().setBackground(Color.yellow);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/menuGUI/mainmenu/img/icon.png");
        setIconImage(img);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,700,500);

        label0 = new JLabel();
        label0.setBounds(0,0,700,500);
        label0.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/blur.jpg"));

        label3 = new JLabel();
        label3.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/CHOOSE YOUR.png"));
        label3.setOpaque(false);
        label3.setBounds(110,0,450,180);

        label7 = new JLabel();
        label7.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/OPPONENT.png"));
        label7.setOpaque(false);
        label7.setBounds(160,60,400,180);



        label4 = new JLabel("Invite Player");
        label4.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,17));
        label4.setForeground(Color.black);
        label4.setBounds(290,155,200,117);

        label5 = new JLabel("Random Player");
        label5.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,17));
        label5.setForeground(Color.black);
        label5.setBounds(280,220,200,117);


        Border line = new LineBorder(new Color(0x0F142A, true));

        button2 = new JButton();
        button2.setBounds(275,260,140,45);
        button2.setUI(new StyledButtonUI());
        button2.setBackground(Color.orange);

        button3 = new JButton();
        button3.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/white-gear.png"));
        button3.setBounds(640,20,35,35);
        button3.setFocusPainted(false);
        button3.setBorder(line);
        button3.setContentAreaFilled(false);

        button4 = new JButton();
        button4.setBounds(275,193,140,45);
        button4.setUI(new StyledButtonUI());
        button4.setBackground(Color.ORANGE);


        button5 = new JButton();
        button5.setBounds(275,325,140,45);
        button5.setUI(new StyledButtonUI());
        button5.setBackground(Color.ORANGE);

        label6 = new JLabel("Game Mode");
        label6.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,17));
        label6.setForeground(Color.black);
        label6.setBounds(290,285,200,117);

        popupMenu = new JPopupMenu();

        item1 = new JMenuItem("Volume");
        item2 = new JMenuItem("How to play");
        item3 = new JMenuItem("Themes");

        popupMenu.add(item1);
        popupMenu.add(item2);
        popupMenu.add(item3);
        popupMenu.setBackground(new Color(0xDE8B0E));
        popupMenu.setBorder(line);

        item1.setBackground(new Color(0xDE8B0E));
        item2.setBackground(new Color(0xDE8B0E));
        item3.setBackground(new Color(0xDE8B0E));
        item1.setForeground(Color.white);
        item2.setForeground(Color.white);
        item3.setForeground(Color.white);


        ActionListener menubutton = e->{
            popupMenu.show(button3,-55,30);
        };

        ActionListener volume = e->{
            VolumeFrame volumeFrame = new VolumeFrame();
            volumeFrame.setVisible(true);
        };

        ActionListener gameMode = e->{
            GameModeFrame gm = new GameModeFrame();
            gm.setVisible(true);
        };

        ActionListener invite = e->{
            InviteFrame inF = new InviteFrame();
            inF.setVisible(true);
        };

        ActionListener rules = e->{
            RulesFrame rf = new RulesFrame();
            rf.setVisible(true);
        };

        ActionListener tema = e ->{
            Third_Menu third_menu = new Third_Menu();
            third_menu.setVisible(true);
            third_menu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        };

        ActionListener random = e->{
            RandomFrame ranf = new RandomFrame();
            ranf.setVisible(true);
        };

        item1.addActionListener(volume);
        item3.addActionListener(tema);
        button3.addActionListener(menubutton);
        button5.addActionListener(gameMode);
        item2.addActionListener(rules);
        button4.addActionListener(invite);
        button2.addActionListener(random);

        layeredPane.add(label0,Integer.valueOf(0));
        layeredPane.add(button2,Integer.valueOf(1));
        layeredPane.add(label3,Integer.valueOf(2));
        layeredPane.add(button3,Integer.valueOf(1));
        layeredPane.add(button4,Integer.valueOf(1));
        layeredPane.add(label4,Integer.valueOf(2));
        layeredPane.add(label5,Integer.valueOf(2));
        layeredPane.add(popupMenu,Integer.valueOf(1));
        layeredPane.add(button5, Integer.valueOf(1));
        layeredPane.add(label6, Integer.valueOf(2));
        layeredPane.add(label7, Integer.valueOf(2));
        this.add(layeredPane);
        // il pannello per qualche motivo non completa la sua generazione fino a che non viene aggiornato
        this.revalidate();
        this.repaint();

    }
}
