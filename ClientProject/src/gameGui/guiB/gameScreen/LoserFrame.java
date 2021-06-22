package gameGui.guiB.gameScreen;
import menuGUI.gui3.StyledButtonUI;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;


public class LoserFrame extends JFrame {

    private JLayeredPane layeredPane;
    private JLabel label0, label1;
    private JLabel label2;
    private JButton jb1;

    public LoserFrame(){

        setSize(new Dimension(700,500));
        setResizable(false);


        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/menuGUI/mainmenu/img/icon.png");
        setIconImage(img);

        Border line = new LineBorder(new Color(0x0F142A, true));

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,700,500);



        label0 = new JLabel();
        label0.setBounds(160,50,600,200);
        label0.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/I'M SORRY . . ..png"));

        label1 = new JLabel();
        label1.setBounds(200,120,600,200);
        label1.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/YOU LOST!.png"));


        jb1 = new JButton("BACK TO MENU");
        jb1.setBounds(255, 350, 180, 40);
        jb1.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,16));
        jb1.setBackground(Color.ORANGE.brighter());
        jb1.setForeground(Color.BLACK);
        jb1.setUI(new StyledButtonUI());

        label2 = new JLabel();
        label2.setBounds(0,0,700,500);
        label2.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/blur.jpg"));


        layeredPane.add(label0, Integer.valueOf(1));
        layeredPane.add(label1, Integer.valueOf(1));
        layeredPane.add(jb1, Integer.valueOf(1));
        layeredPane.add(label2, Integer.valueOf(0));
        this.add(layeredPane);
    }
}
