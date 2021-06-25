package menuGUI.windows;

import javax.swing.*;
import java.awt.*;

public class RandomFrame extends JFrame {

    private JLayeredPane layeredPane;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;

    public RandomFrame(){
        setSize(new Dimension(300,150));
        setResizable(false);
        this.getContentPane();
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,300,150);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/menuGUI/img/icon.png");
        setIconImage(img);

        label1 = new JLabel();
        label1.setIcon(new ImageIcon("src/menuGUI/img/blur300x150.jpg"));
        label1.setBounds(0,0,300,150);

        label2 = new JLabel();
        label2.setBounds(0,0, 300,150);
        label2.setIcon(new ImageIcon("src/menuGUI/img/hourglass.png"));

        label3 = new JLabel("WAITING...");
        label3.setBounds(110,10,200, 50);
        label3.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,15));
        label3.setForeground(Color.BLACK);

        layeredPane.add(label1, Integer.valueOf(0));
        layeredPane.add(label2, Integer.valueOf(1));
        layeredPane.add(label3, Integer.valueOf(1));
        this.add(layeredPane);
    }
}
