package menuGUI.mainmenu;

import javax.swing.*;
import java.awt.*;

public class DeclineFrame extends JFrame {

    private JLayeredPane layeredPane;
    private JLabel label1;
    private JLabel label2;

    public DeclineFrame(){
        setSize(new Dimension(300,150));
        setResizable(false);


        this.getContentPane();
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/menuGUI/mainmenu/img/icon.png");
        setIconImage(img);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,300,150);

        label1 = new JLabel();
        label1.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/blur300x150.jpg"));
        label1.setBounds(0,0,300,150);

        label2 = new JLabel("Invite declined");
        label2.setBounds(0,10,300, 50);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,15));
        label2.setForeground(Color.BLACK);

        layeredPane.add(label1, Integer.valueOf(0));
        layeredPane.add(label2, Integer.valueOf(1));

        this.add(layeredPane);
    }
}