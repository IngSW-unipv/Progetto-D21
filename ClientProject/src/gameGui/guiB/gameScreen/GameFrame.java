package gameGui.guiB.gameScreen;

import gameGui.guiB.control.ButtonListener;
import gameGui.guiB.util.AnimationTask;
import gameGui.guiB.util.TokenColor;
import menuGUI.mainmenu.Third_Menu;

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

    public  GameFrame(String duration){

        this.duration=duration;
        myTimer = new Timer();

        Container c = new Container();
        c = getContentPane();
        c.setBackground(Color.WHITE);
        setBounds(100, 100, 1129, 737);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLayout(null);

        layeredPane = new JLayeredPane();
        layeredPane.setBackground(Color.CYAN);
        layeredPane.setBounds(0, 0, 800, 700);
        c.add(layeredPane);

        lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 800, 700);
        layeredPane.add(lblNewLabel);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/menuGUI/mainmenu/img/icon.png");
        setIconImage(img);

        setGriglia(Third_Menu.choosenTheme);

        this.animationPanel = new JPanel();
        animationPanel.setOpaque(false);
        layeredPane.setLayer(animationPanel, 2);
        animationPanel.setBounds(0, 0, 800, 700);
        layeredPane.add(animationPanel);
        animationPanel.setLayout(null);

        this.buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        //buttonsPanel.setVisible(false);
        layeredPane.setLayer(buttonsPanel, 3);
        buttonsPanel.setBounds(50, 50, 700, 600);
        layeredPane.add(buttonsPanel);
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
                //System.out.println("bottone generato");
            }
        }

        infoPanel = new GameInfoPanel(duration);

        c.add(infoPanel);
        infoPanel.setBounds(800,0,300,600);
        infoPanel.setVisible(true);



    }

    public void addLabel(int x, int y, TokenColor c) {
        lbl = new JLabel("");
        if(c==TokenColor.RED) {
            setTockenRosso(Third_Menu.choosenTheme);
        }
        if(c==TokenColor.YELLOW) {
            setTockenGiallo(Third_Menu.choosenTheme);
        }
        this.myTimer.schedule(new AnimationTask(lbl, animationPanel, 0, 50+y*100, 50+x*100),1L );
        System.out.println("aa");
    }

    public JPanel getAnimationPanel() {
        return animationPanel;
    }

    public JPanel getButtonsPanel() {
        return buttonsPanel;
    }

    //questo metodo si occupa di aggiungere i componenti specificati al livello dato
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
            lblNewLabel.setIcon(new ImageIcon("src/menuGUI/gui3/themes/GrigliaBackgrond3.png"));
        } else if (a == 2) {
            lblNewLabel.setIcon(new ImageIcon("src/menuGUI/gui3/themes/ironmangrid.png"));
        } else if (a == 3) {
            lblNewLabel.setIcon(new ImageIcon("src/menuGUI/gui3/themes/firstmariogrid.png"));
        } else if (a == 0) {
            lblNewLabel.setIcon(new ImageIcon("src/menuGUI/gui3/themes/GrigliaBackgrond3.png"));
        } else {
            lblNewLabel.setIcon(new ImageIcon("src/menuGUI/gui3/themes/GrigliaBackgrond3.png"));
        }
    }

        public void setTockenRosso(int a){
            if (a == 1) {
                lbl.setIcon(new ImageIcon("src/menuGUI/gui3/themes/stitch90px.png"));
            } else if (a == 2) {
                lbl.setIcon(new ImageIcon("src/menuGUI/gui3/themes/capamericatoken.png"));
            } else if (a == 3) {
                lbl.setIcon(new ImageIcon("src/menuGUI/gui3/themes/powerup.png"));
            } else if (a == 0) {
                lbl.setIcon(new ImageIcon("resources/textures/RedToken2.png"));
            } else {
                lbl.setIcon(new ImageIcon("resources/textures/RedToken2.png"));
            }
        }

    public void setTockenGiallo(int a){
        if (a == 1) {
            lbl.setIcon(new ImageIcon("src/menuGUI/gui3/themes/angelog90px.png"));
        } else if (a == 2) {
            lbl.setIcon(new ImageIcon("src/menuGUI/gui3/themes/ironmantoken.png"));
        } else if (a == 3) {
            lbl.setIcon(new ImageIcon("src/menuGUI/gui3/themes/1uppng.png"));
        } else if (a == 0) {
            lbl.setIcon(new ImageIcon("resources/textures/YellowToken2.png"));
        } else {
            lbl.setIcon(new ImageIcon("resources/textures/YellowToken2.png"));
        }
    }
    }
