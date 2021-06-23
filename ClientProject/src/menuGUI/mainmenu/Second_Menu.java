package menuGUI.mainmenu;

import core.NetworkThread;
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
    private JPopupMenu popupMenu;
    private GameModeFrame gameModeFrame;
    private String gameLenght;


    public Second_Menu() {
        setSize(new Dimension(700, 500));
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
        layeredPane.setBounds(0, 0, 700, 500);

        label0 = new JLabel();
        label0.setBounds(0, 0, 700, 500);
        label0.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/blur.jpg"));

        label3 = new JLabel();
        label3.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/CHOOSE YOUR.png"));
        label3.setOpaque(false);
        label3.setBounds(110, 0, 450, 180);

        label7 = new JLabel();
        label7.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/OPPONENT.png"));
        label7.setOpaque(false);
        label7.setBounds(160, 60, 400, 180);

        Border line = new LineBorder(new Color(0x0F142A, true));

        button5 = new JButton();
        button5.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/white-gear.png"));
        button5.setBounds(640, 20, 35, 35);
        button5.setFocusPainted(false);
        button5.setBorder(line);
        button5.setContentAreaFilled(false);

        button1 = new JButton("Invite Player");
        button1.setFont(new Font("ITC Avant Garde Gothic", Font.BOLD, 17));
        button1.setForeground(Color.BLACK);
        button1.setOpaque(true);
        button1.setContentAreaFilled(false);
        button1.setFocusPainted(false);
        button1.setBorder(line);
        button1.setBounds(260, 193, 170, 45);
        button1.setBackground(Color.orange);
        button1.setUI(new StyledButtonUI());


        button2 = new JButton("Random Player");
        button2.setFont(new Font("ITC Avant Garde Gothic", Font.BOLD, 17));
        button2.setForeground(Color.BLACK);
        button2.setOpaque(true);
        button2.setContentAreaFilled(false);
        button2.setFocusPainted(false);
        button2.setBorder(line);
        button2.setBounds(260, 260, 170, 45);
        button2.setBackground(Color.orange);
        button2.setUI(new StyledButtonUI());

        button3 = new JButton("Game Mode");
        button3.setFont(new Font("ITC Avant Garde Gothic", Font.BOLD, 17));
        button3.setForeground(Color.BLACK);
        button3.setOpaque(true);
        button3.setContentAreaFilled(false);
        button3.setFocusPainted(false);
        button3.setBorder(line);
        button3.setBounds(260, 325, 170, 45);
        button3.setBackground(Color.orange);
        button3.setUI(new StyledButtonUI());

        button4 = new JButton("Themes");
        button4.setFont(new Font("ITC Avant Garde Gothic", Font.BOLD, 17));
        button4.setForeground(Color.BLACK);
        button4.setOpaque(true);
        button4.setContentAreaFilled(false);
        button4.setFocusPainted(false);
        button4.setBorder(line);
        button4.setBounds(260, 390, 170, 45);
        button4.setBackground(Color.orange);
        button4.setUI(new StyledButtonUI());

        popupMenu = new JPopupMenu();

        item1 = new JMenuItem("Volume");
        item2 = new JMenuItem("How to play");

        popupMenu.add(item1);
        popupMenu.add(item2);
        popupMenu.setBackground(new Color(0xDE8B0E));
        popupMenu.setBorder(line);

        item1.setBackground(new Color(0xDE8B0E));
        item2.setBackground(new Color(0xDE8B0E));
        item1.setForeground(Color.white);
        item2.setForeground(Color.white);


        ActionListener menubutton = e -> {
            popupMenu.show(button3, -55, 30);
        };

        ActionListener volume = e -> {
            VolumeFrame volumeFrame = new VolumeFrame();
            volumeFrame.setVisible(true);
        };

        ActionListener gameMode = e -> {
            this.gameModeFrame = new GameModeFrame();
            gameModeFrame.setVisible(true);
        };

        ActionListener invite = e -> {
            InviteFrame inF = new InviteFrame(this);
            inF.setVisible(true);
        };

        ActionListener rules = e -> {
            RulesFrame rf = new RulesFrame();
            rf.setVisible(true);
        };

        ActionListener tema = e -> {
            Third_Menu third_menu = new Third_Menu();
            third_menu.setVisible(true);
            third_menu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        };

        ActionListener random = e -> {

            if (gameModeFrame != null) {
                if (gameModeFrame.getGameSpeed() != null) {
                    NetworkThread.getNetworkThread().sendMessage("addmeToQueue," + gameModeFrame.getGameSpeed());
                    RandomFrame ranf = new RandomFrame();
                    ranf.setVisible(true);
                    return;
                }
            }
            ErrorFrame localErrorFrame = new ErrorFrame("Press Game Mode to set game duration");

        };

        item1.addActionListener(volume);
        button1.addActionListener(tema);
        button3.addActionListener(menubutton);
        button5.addActionListener(gameMode);
        item2.addActionListener(rules);
        button4.addActionListener(invite);
        button2.addActionListener(random);

        layeredPane.add(label0, Integer.valueOf(0));
        layeredPane.add(button2, Integer.valueOf(1));
        layeredPane.add(label3, Integer.valueOf(2));
        layeredPane.add(button3, Integer.valueOf(1));
        layeredPane.add(button4, Integer.valueOf(1));

        layeredPane.add(popupMenu, Integer.valueOf(1));
        layeredPane.add(button5, Integer.valueOf(1));
        //layeredPane.add(label6, Integer.valueOf(2));
        layeredPane.add(label7, Integer.valueOf(2));
        layeredPane.add(button1, Integer.valueOf(1));
        this.add(layeredPane);
        // il pannello per qualche motivo non completa la sua generazione fino a che non viene aggiornato
        this.revalidate();
        this.repaint();

    }

    public String getGameLenght() {
        if (gameModeFrame != null) {
            if (gameModeFrame.getGameSpeed() != null) {
                return gameModeFrame.getGameSpeed();
            }
        }return "a";
    }
}
