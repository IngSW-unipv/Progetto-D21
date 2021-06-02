package core.gameLogic.guiB;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import core.Player;
import core.gameLogic.guiB.control.ButtonListener;
import core.gameLogic.model.partita.Game;

import core.gameLogic.model.partita.util.SoundPlayer;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;

public class Forza4 {

	private JFrame frame;
	public static final int buttonsize = 100;
	private Player p1;
	private Player p2;
	private Game test1;
	private SoundPlayer p;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forza4 window = new Forza4();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Forza4() {
		initialize();
		SoundPlayer.playSound(new File("resources/sounds/memories (online-audio-converter.com).wav"),0.2);

	}

	/**
	 * Initialize the contents of the frame.
	 */
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
				tempButt.addActionListener(new ButtonListener(tempButt,animationPanel,test1));
				System.out.println("bottone generato");
			}
		}
	}
	
	
	
}
