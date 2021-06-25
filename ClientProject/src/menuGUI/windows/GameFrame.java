package menuGUI.windows;

import core.AnimationsTask;
import core.TokenColor;
import menuGUI.listeners.ButtonListener;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;

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

        setGriglia(Third_Menu.choosenTheme);

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
                tempButt.addActionListener(new ButtonListener(tempButt));
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

    public void addLabel(int x, int y, TokenColor c) {
        lbl = new JLabel("");
        if(c==TokenColor.RED) {
            setTockenRosso(Third_Menu.choosenTheme);
        }
        if(c==TokenColor.YELLOW) {
            setTockenGiallo(Third_Menu.choosenTheme);
        }
        this.myTimer.schedule(new AnimationsTask(lbl, animationPanel, 0, 50+y*100, 50+x*100),1L );
        System.out.println("aa");
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

    public void setGriglia(int a) {
        if (a == 1) {
            lblNewLabel.setIcon(new ImageIcon("src/menuGUI/img/themes/stitchgrid.png"));
        } else if (a == 2) {
            lblNewLabel.setIcon(new ImageIcon("src/menuGUI/img/themes/ironmangrid.png"));
        } else if (a == 3) {
            lblNewLabel.setIcon(new ImageIcon("src/menuGUI/img/themes/firstmariogrid.png"));
        } else if (a == 0) {
            lblNewLabel.setIcon(new ImageIcon("src/menuGUI/img/themes/GrigliaBackgrond3.png"));
        } else {
            lblNewLabel.setIcon(new ImageIcon("src/menuGUI/img/themes/GrigliaBackgrond3.png"));
        }
    }

    public void setTockenRosso(int a){
        if (a == 1) {
            lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/stitchtoken.png"));
        } else if (a == 2) {
            lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/capamericatoken.png"));
        } else if (a == 3) {
            lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/poweruptokenred.png"));
        } else if (a == 0) {
            lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/RedToken2.png"));
        } else {
            lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/RedToken2.png"));
        }
    }

    public void setTockenGiallo(int a){
        if (a == 1) {
            lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/angeltoken.png"));
        } else if (a == 2) {
            lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/ironmantoken.png"));
        } else if (a == 3) {
            lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/poweruptoken.png"));
        } else if (a == 0) {
            lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/YellowToken2.png"));
        } else {
            lbl.setIcon(new ImageIcon("src/menuGUI/img/themes/YellowToken2.png"));
        }
    }

    public void disableColumn(int column) {//disabilita la colonna, viene richiamato quando la colonna � piena
        for(int i = column,j=0;j<6;j++) {
            matrix[j][i].setVisible(false);
        }

    }
}

