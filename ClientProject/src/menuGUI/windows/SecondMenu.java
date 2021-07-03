package menuGUI.windows;

import core.NetworkThread;
import menuGUI.listeners.OpenFrameListener;
import menuGUI.windows.util.WindowsType;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;


public class SecondMenu extends JFrame {

    private JLayeredPane layeredPane;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JMenuItem item1;
    private JPopupMenu popupMenu;
    private GameModeFrame gameModeFrame;
    private String gameLenght;
    private RandomFrame ranf;
    private OpenFrameListener openFrameListener;

    public SecondMenu() {
        setSize(new Dimension(700, 500));
        setResizable(false);
        this.getContentPane().setBackground(Color.yellow);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 700, 500);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/menuGUI/img/icon.png");
        setIconImage(img);

        label1 = new JLabel();
        label1.setBounds(0, 0, 700, 500);
        label1.setIcon(new ImageIcon("src/menuGUI/img/blur.jpg"));

        label2 = new JLabel();
        label2.setIcon(new ImageIcon("src/menuGUI/img/CHOOSE YOUR.png"));
        label2.setOpaque(false);
        label2.setBounds(110, 0, 450, 180);

        label3 = new JLabel();
        label3.setIcon(new ImageIcon("src/menuGUI/img/OPPONENT.png"));
        label3.setOpaque(false);
        label3.setBounds(160, 60, 400, 180);

        Border line = new LineBorder(new Color(0x0F142A, true));

        button0 = new JButton();
        button0.setIcon(new ImageIcon("src/menuGUI/img/white-gear.png"));
        button0.setBounds(640, 20, 35, 35);
        button0.setFocusPainted(false);
        button0.setBorder(line);
        button0.setContentAreaFilled(false);

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

        item1 = new JMenuItem("How to play");
        popupMenu = new JPopupMenu();
        popupMenu.add(item1);
        popupMenu.setBackground(new Color(0xDE8B0E));
        popupMenu.setBorder(line);
        item1.setBackground(new Color(0xDE8B0E));
        item1.setForeground(Color.white);

        //!!!!
        ActionListener menubutton = e -> {
            popupMenu.show(button3, 320, -270);
        };

        /*ActionListener gameMode = e -> {
            this.gameModeFrame = new GameModeFrame();
            gameModeFrame.setVisible(true);
        };*/

       /* ActionListener invite = e -> {
            InviteFrame inF = new InviteFrame();
            inF.setVisible(true);
        };*/

        /*ActionListener rules = e -> {
            RulesFrame rf = new RulesFrame();
            rf.setVisible(true);
        };*/

        /*ActionListener tema = e -> {
            ThirdMenu third_menu = new ThirdMenu();
            third_menu.setVisible(true);
            third_menu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        };*/

        /*ActionListener random = e -> {

            if (gameModeFrame != null) {
                if (gameModeFrame.getGameSpeed() != null) {
                    NetworkThread.getNetworkThread().sendMessage("addmeToQueue," + gameModeFrame.getGameSpeed());
                    ranf = new RandomFrame();
                    ranf.setVisible(true);
                    return;
                }
            }
            ErrorFrame localErrorFrame = new ErrorFrame("Press Game Mode to set game duration");

        };*/


        //button4.addActionListener(tema);
        button0.addActionListener(menubutton);
        //button3.addActionListener(gameMode);
        //item1.addActionListener(rules);
        //button1.addActionListener(invite);
        //button2.addActionListener(random);

        openFrameListener = new OpenFrameListener(button3, WindowsType.GAMEMODE);
        button3.addActionListener(openFrameListener);

        openFrameListener = new OpenFrameListener(button1,WindowsType.INVITE);
        button1.addActionListener(openFrameListener);

        openFrameListener = new OpenFrameListener(item1,WindowsType.RULES);
        item1.addActionListener(openFrameListener);

        openFrameListener = new OpenFrameListener(button4,WindowsType.THEME);
        button4.addActionListener(openFrameListener);

        openFrameListener = new OpenFrameListener(button2,WindowsType.RANDOM);
        button2.addActionListener(openFrameListener);

        openFrameListener = new OpenFrameListener(button1,WindowsType.INVITE);
        button1.addActionListener(openFrameListener);


        layeredPane.add(label1, Integer.valueOf(0));
        layeredPane.add(button2, Integer.valueOf(1));
        layeredPane.add(label2, Integer.valueOf(2));
        layeredPane.add(button3, Integer.valueOf(1));
        layeredPane.add(button4, Integer.valueOf(1));
        layeredPane.add(popupMenu, Integer.valueOf(1));
        layeredPane.add(button0, Integer.valueOf(1));
        layeredPane.add(label3, Integer.valueOf(2));
        layeredPane.add(button1, Integer.valueOf(1));
        this.add(layeredPane);

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

    public RandomFrame getRanf() {
        return ranf;
    }

}
