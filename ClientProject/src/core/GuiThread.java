package core;

import gameGui.guiB.control.ButtonListener;
import gameGui.guiB.util.AnimationTask;
import gameGui.guiB.util.TokenColor;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;

public class GuiThread extends Thread{

    private JFrame frame;
    private static final int buttonsize=100;
    private java.util.Timer myTimer;
    private JPanel animationPanel;
    private JPanel buttonsPanel;
    private static final long refreshRate = 1l;

    public GuiThread(Timer timer){

        startGui();
        myTimer = timer;

    }

    @Override
    public void run() {

    }

    private void startGui(){

        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.getContentPane().setBackground(Color.MAGENTA);
        frame.setBounds(100, 100, 1129, 841);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBackground(Color.CYAN);
        layeredPane.setBounds(0, 0, 800, 700);
        frame.getContentPane().add(layeredPane);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("resources/textures/GrigliaBackgrond3.png"));
        lblNewLabel.setBounds(0, 0, 800, 700);
        layeredPane.add(lblNewLabel);


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
                System.out.println("bottone generato");
            }
        }

    }

    public void addLabel(int x, int y, TokenColor c) {

        JLabel lbl = new JLabel("");
        if(c==TokenColor.RED) {
            lbl.setIcon(new ImageIcon("resources/textures/RedToken2.png"));
        }
        if(c==TokenColor.YELLOW) {
            lbl.setIcon(new ImageIcon("resources/textures/YellowToken2.png"));
        }
        this.myTimer.schedule(new AnimationTask(lbl, animationPanel, 0, 50+y*100, 50+x*100),this.refreshRate );
        System.out.println("aa");
    }

    public JPanel getButtonsPanel() {
        return buttonsPanel;
    }
}
