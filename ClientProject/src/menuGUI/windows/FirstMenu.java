package menuGUI.windows;

import menuGUI.listeners.ButtonAndTextAreaListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * This is one of the main frames of the Client: this class creates the menu in which the player can add their nickname.
 * There are 3 labels used for images and backgrounds. The only JButton sends a message to the server triggering the
 * setActionCommand that sends the String newNick. Simple class with only a constructor.
 */

public class FirstMenu extends JFrame {

    private JLayeredPane layeredPane;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton button1;
    private JTextField textField;
    private ButtonAndTextAreaListener textlistener;

    public FirstMenu(){
        setSize(new Dimension(626,481));
        setResizable(false);
        this.getContentPane().setBackground(Color.RED);
        this.setLayout(null);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/menuGUI/img/icon.png");
        setIconImage(img);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,626,481);

        label1 = new JLabel();
        label1.setOpaque(true);
        label1.setIcon(new ImageIcon("src/menuGUI/img/red-yellow-retro.jpg"));
        label1.setBounds(0,0,626,481);

        label2 = new JLabel();
        label2.setOpaque(false);
        label2.setIcon(new ImageIcon("src/menuGUI/img/logo.png"));
        label2.setBounds(100,80,500,120);

        label3 = new JLabel();
        label3.setIcon(new ImageIcon("src/menuGUI/img/ENTER YOUR NICKNAME.png"));
        label3.setBounds(180,200,220,47);

        Border line = new LineBorder(new Color(0x0F142A, true));

        button1 = new JButton();
        button1.setBounds(260,285,100,35);
        button1.setBorder(line);
        button1.setContentAreaFilled(false);
        button1.setBackground(Color.ORANGE);
        button1.setUI(new StyledButtonUI());

        label4 = new JLabel();
        label4.setIcon(new ImageIcon("src/menuGUI/img/PLAY.png"));
        label4.setBounds(267,242,200,117);

        textField = new JTextField();
        textField.setBackground(Color.white);
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("ITC Avant Garde Gothic",Font.PLAIN,15));
        textField.setBounds(235,240,150,25);

        textlistener = new ButtonAndTextAreaListener(button1,textField);
        button1.setActionCommand("newNick");
        button1.addActionListener(textlistener);

        layeredPane.add(label1,Integer.valueOf(0));
        layeredPane.add(label2,Integer.valueOf(1));
        layeredPane.add(label3, Integer.valueOf(1));
        layeredPane.add(textField,Integer.valueOf(1));
        layeredPane.add(button1,Integer.valueOf(1));
        layeredPane.add(label4,Integer.valueOf(2));
        this.add(layeredPane);
        this.setLocationRelativeTo(null);

        //TODO wtf

        revalidate();
        repaint();
    }
}
