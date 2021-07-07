package menuGUI.windows;

import menuGUI.listeners.OpenFrameListener;
import menuGUI.windows.util.WindowsType;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This class represents the main menu in which players can choose their gamemode or theme and invite other players
 */
public class SecondMenu extends JFrame {

    private JLayeredPane layeredPane;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button0;
    private JButton inviteButton;
    private JButton randoomQueueButton;
    private JButton button3;
    private JButton button4;
    private JMenuItem item1;
    private JPopupMenu popupMenu;
    private GameModeFrame gameModeFrame;
    private String gameLenght;
    private RandomFrame ranf;
    private OpenFrameListener openFrameListener;

    /**
     * Constructor where the frame parameters are set, it also creates instances of some ActionListeners that make possible
     * the opening of the frames related to each and every button
     */
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

        inviteButton = new JButton("Invite Player");
        inviteButton.setFont(new Font("ITC Avant Garde Gothic", Font.BOLD, 17));
        inviteButton.setForeground(Color.BLACK);
        inviteButton.setOpaque(true);
        inviteButton.setContentAreaFilled(false);
        inviteButton.setFocusPainted(false);
        inviteButton.setBorder(line);
        inviteButton.setBounds(260, 193, 170, 45);
        inviteButton.setBackground(Color.orange);
        inviteButton.setUI(new StyledButtonUI());

        randoomQueueButton = new JButton("Random Player");
        randoomQueueButton.setFont(new Font("ITC Avant Garde Gothic", Font.BOLD, 17));
        randoomQueueButton.setForeground(Color.BLACK);
        randoomQueueButton.setOpaque(true);
        randoomQueueButton.setContentAreaFilled(false);
        randoomQueueButton.setFocusPainted(false);
        randoomQueueButton.setBorder(line);
        randoomQueueButton.setBounds(260, 260, 170, 45);
        randoomQueueButton.setBackground(Color.orange);
        randoomQueueButton.setUI(new StyledButtonUI());

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

        ActionListener menubutton = e -> {
            popupMenu.show(button3, 320, -270);
        };

        button0.addActionListener(menubutton);


        OpenFrameListener openFrameListener3 = new OpenFrameListener(button3, WindowsType.GAMEMODE,this);
        button3.addActionListener(openFrameListener3);

        OpenFrameListener openFrameListener1 = new OpenFrameListener(inviteButton,WindowsType.INVITE);
        inviteButton.addActionListener(openFrameListener1);

        OpenFrameListener openFrameListenerItem1 = new OpenFrameListener(item1,WindowsType.RULES);
        item1.addActionListener(openFrameListenerItem1);

        OpenFrameListener openFrameListener4 = new OpenFrameListener(button4,WindowsType.THEME);
        button4.addActionListener(openFrameListener4);

        OpenFrameListener openRandomQueueList = new OpenFrameListener(randoomQueueButton,WindowsType.RANDOM,this);
        randoomQueueButton.addActionListener(openRandomQueueList);
        
        layeredPane.add(label1, Integer.valueOf(0));
        layeredPane.add(randoomQueueButton, Integer.valueOf(1));
        layeredPane.add(label2, Integer.valueOf(2));
        layeredPane.add(button3, Integer.valueOf(1));
        layeredPane.add(button4, Integer.valueOf(1));
        layeredPane.add(popupMenu, Integer.valueOf(1));
        layeredPane.add(button0, Integer.valueOf(1));
        layeredPane.add(label3, Integer.valueOf(2));
        layeredPane.add(inviteButton, Integer.valueOf(1));
        this.add(layeredPane);

        this.revalidate();
        this.repaint();
    }

    /**
     * This method returns the gameLength (the actual duration of the match). The return type is a String and it's
     * used to communicate to the OpenFrameListener class if players are ready for a game (it is derogatory
     * to set a preference on the timer for the game to start)
     * @return
     */

    public String getGameLenght() {
        if (gameLenght!=null) {
                return gameLenght;
            }
        return "nogamemodeSelected";
    }

    /**
     * The following methods are a simple getter and setter for the RandomFrame
     * @return
     */
    public RandomFrame getRanf() {
        return ranf;
    }

    public void setRanf(RandomFrame f){
        this.ranf = f;
    }

    public void setGameModeFrame(GameModeFrame gameModeFrame) {
        this.gameModeFrame = gameModeFrame;
    }

    public GameModeFrame getGameModeFrame() {
        return gameModeFrame;
    }

    public void setGameLenght(String gameLenght) {
        this.gameLenght = gameLenght;
    }


}
