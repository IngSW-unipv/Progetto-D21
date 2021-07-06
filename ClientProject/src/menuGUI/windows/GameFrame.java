package menuGUI.windows;

import core.AnimationsTask;
import core.TokenColor;
import menuGUI.listeners.AddTokenListener;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;

/**
 * This class sets the actual graphic parameters (such as the grid style, the token style, the number of cells & so on)
 * of the game. That's what we actually see when we play the game.
 */

public class GameFrame extends JFrame {

    private JPanel animationPanel;
    private JPanel buttonsPanel;
    public static final int buttonsize = 100;
    private String duration;
    private Timer myTimer;
    private JLayeredPane layeredPane;
    private GameInfoPanel infoPanel;
    private JLabel lblNewLabel;
    private JLabel lbl;
    private Container c;
    private JButton[][] matrix = new JButton[6][7]; //matrice bottoni

    /**
     * The constructor creates an instance of the Timer (which is contained in the infoPanel), creates the actual grid using
     * a for cycle and creates an instance of the GameInfoPanel which is mentioned earlier
     * @param duration
     */
    public  GameFrame(String duration){
        this.duration=duration;
        myTimer = new Timer();

        c = new Container();
        c = getContentPane();
        c.setBackground(Color.WHITE);
        setBounds(100, 100, 1129, 737);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLayout(null);
        setResizable(false);

        layeredPane = new JLayeredPane();
        layeredPane.setBackground(Color.CYAN);
        layeredPane.setBounds(0, 0, 800, 700);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/menuGUI/img/icon.png");
        setIconImage(img);

        lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 800, 700);

        setGrid(ThirdMenu.choosenTheme);

        animationPanel = new JPanel();
        animationPanel.setOpaque(false);
        layeredPane.setLayer(animationPanel, 2);
        animationPanel.setBounds(0, 0, 800, 700);
        animationPanel.setLayout(null);

        buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        layeredPane.setLayer(buttonsPanel, 3);
        buttonsPanel.setBounds(50, 50, 700, 600);
        buttonsPanel.setLayout(null);


        for(int i=0;i<7;i++) {
            for(int j=0;j<6;j++) {
                JButton tempButt = new JButton();
                tempButt.setFocusPainted( false );
                tempButt.setContentAreaFilled( false );
                tempButt.setOpaque(false);
                tempButt.setBorderPainted(false);
                tempButt.setBounds(i*100, j*100, buttonsize, buttonsize);
                buttonsPanel.add(tempButt);
                tempButt.setActionCommand(""+i);
                tempButt.addActionListener(new AddTokenListener(tempButt));
                matrix[j][i] = tempButt; //riempio matrice dei bottoni
                //System.out.println("bottone generato");
            }
        }

        infoPanel = new GameInfoPanel(duration);
        c.add(infoPanel);
        infoPanel.setBounds(800,0,300,600);
        infoPanel.setVisible(true);

        layeredPane.add(lblNewLabel);
        layeredPane.add(animationPanel);
        layeredPane.add(buttonsPanel);
        c.add(layeredPane);
    }

    /**
     * this method uses the static parameter of the ThirdMenu. It sets the colour of the token related to the chosen theme.
     *
     * @param x
     * @param y
     * @param c
     */

    public void addLabel(int x, int y, TokenColor c) {
        lbl = new JLabel("");
        if(c==TokenColor.RED) {
            setTockenRed(ThirdMenu.choosenTheme);
        }
        if(c==TokenColor.YELLOW) {
            setTockenYellow(ThirdMenu.choosenTheme);
        }
        this.myTimer.schedule(new AnimationsTask(lbl, animationPanel, 0, 50+y*100, 50+x*100),1L );
    }

    public JPanel getAnimationPanel() {
        return animationPanel;
    }

    public JPanel getButtonsPanel() {
        return buttonsPanel;
    }

    public void addToLayeredPane(Component component,int level){
        layeredPane.add(component,Integer.valueOf(level));
    }

    public void resetTimer(){
        infoPanel.resetTimer();
    }

    public void setMyTurn(){
        infoPanel.setTurnOwnerME();
    }

    public void setOppositeTurn(){
        infoPanel.setTurnOwnerOPPOSITE();
    }

    /**
     * this method sets the grid to the preferred theme setting up an int variable that corresponds to each theme in
     * the following ThirdMenu
     * @param a
     */

    public void setGrid(int a) {

        switch (a){
            case 0:
                lblNewLabel.setIcon(new ImageIcon("src/menuGUI/img/themes/GrigliaBackgrond3.png"));
                break;
            case 1:
                lblNewLabel.setIcon(new ImageIcon("src/menuGUI/img/themes/stitchgrid.png"));
                break;
            case 2:
                lblNewLabel.setIcon(new ImageIcon("src/menuGUI/img/themes/ironmangrid.png"));
                break;
            case 3:
                lblNewLabel.setIcon(new ImageIcon("src/menuGUI/img/themes/firstmariogrid.png"));
                break;
            default:
                lblNewLabel.setIcon(new ImageIcon("src/menuGUI/img/themes/GrigliaBackgrond3.png"));
        }

        /*if (a == 1) {
            lblNewLabel.setIcon(new ImageIcon("src/menuGUI/img/themes/stitchgrid.png"));
        } else if (a == 2) {
            lblNewLabel.setIcon(new ImageIcon("src/menuGUI/img/themes/ironmangrid.png"));
        } else if (a == 3) {
            lblNewLabel.setIcon(new ImageIcon("src/menuGUI/img/themes/firstmariogrid.png"));
        } else if (a == 0) {
            lblNewLabel.setIcon(new ImageIcon("src/menuGUI/img/themes/GrigliaBackgrond3.png"));
        } else {
            lblNewLabel.setIcon(new ImageIcon("src/menuGUI/img/themes/GrigliaBackgrond3.png"));
        }*/
    }

    /**
     *This method sets the token's label image depeding by the theme selected
     *
     * @param a
     */

    public void setTockenRed(int a){
        switch (a){
            case 0:
                lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/RedToken2.png"));
                break;
            case 1:
                lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/stitchtoken.png"));
                break;
            case 2:
                lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/capamericatoken.png"));
                break;
            case 3:
                lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/poweruptokenred.png"));
                break;
            default:
                lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/RedToken2.png"));
        }
    }

    /**
     *This method sets the token's label depending on the theme selected
     * @param a
     */

    public void setTockenYellow(int a){
        switch (a){
            case 1:
                lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/angeltoken.png"));
                break;
            case 2:
                lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/ironmantoken.png"));
                break;
            case 3:
                lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/poweruptoken.png"));
                break;
            case 0:
                lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/YellowToken2.png"));
                break;
            default:
                lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/YellowToken2.png"));
        }

    }

    /**
     * This method disable the column when it's full of tokens
     * @param column
     */

    public void disableColumn(int column) {
        for(int i = column,j=0;j<6;j++) {
            matrix[j][i].setVisible(false);
        }

    }
}

