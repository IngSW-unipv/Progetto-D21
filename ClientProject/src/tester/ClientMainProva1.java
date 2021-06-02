package tester;

import core.NetworkThread;
import gameGui.guiB.ButtonListener;

import java.awt.Color;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class ClientMainProva1 {

    private static int port = 25565;
    public static Logger clientLogger = Logger.getLogger("ClientLogger");
    private JFrame frame;
    private int buttonsize = 100;


    public static void main(String[] args) {

        clientLogger.info("Client starting");
        startGui();
        startConnection(port);
        clientLogger.info("Startup Successful");

    }

    private static void startGui(){
        //TODO ISTANZIA CLASSE
    }

    private static void startConnection(int port){

        NetworkThread networkThread = NetworkThread.getNetworkThread();
        networkThread.start();

    }
    
    private void initialize() {
		frame = new JFrame();
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
		
		
		JPanel animationPanel = new JPanel();
		animationPanel.setOpaque(false);
		layeredPane.setLayer(animationPanel, 2);
		animationPanel.setBounds(0, 0, 800, 700);
		layeredPane.add(animationPanel);
		animationPanel.setLayout(null);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setOpaque(false);
		//buttonsPanel.setVisible(false);
		layeredPane.setLayer(buttonsPanel, 3);
		buttonsPanel.setBounds(50, 50, 700, 600);
		layeredPane.add(buttonsPanel);
		buttonsPanel.setLayout(null);
		
		/*JButton unouno = new JButton("aa");
		unouno.setContentAreaFilled(false);
		unouno.setBounds(0, 0, 100, 100);
		buttonsPanel.add(unouno);
		unouno.addActionListener(new ButtonListener(unouno));*/
		
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

}
