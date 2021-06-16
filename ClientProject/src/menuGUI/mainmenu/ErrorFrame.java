package menuGUI.mainmenu;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ErrorFrame extends JFrame {

    private JLabel errorLabel;
    private JLayeredPane layeredPane;
    private JTextArea errorInfo;
    private JLabel backGround;

    public ErrorFrame(String errorMessage){

        setSize(new Dimension(300,150));
        setResizable(false);


        this.getContentPane();
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/mainmenu/img/icon.png");
        setIconImage(img);

        Border line = new LineBorder(new Color(0x0F142A, true));

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,300,150);

        backGround = new JLabel();
        backGround.setIcon(new ImageIcon("src/menuGUI/mainmenu/img/blur300x150.jpg"));
        backGround.setBounds(0,0,300,150);

        errorLabel = new JLabel("ERROR");
        errorLabel.setBounds(110,0,300,50);
        errorLabel.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,15));
        errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        errorLabel.setForeground(Color.BLACK);

        errorInfo = new JTextArea(errorMessage);
        errorInfo.setBounds(0,50,300, 100);
        errorInfo.setOpaque(false);
        errorInfo.setEditable(false);
        errorInfo.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,15));
        errorInfo.setForeground(Color.BLACK);




        layeredPane.add(backGround, Integer.valueOf(0));
        layeredPane.add(errorInfo, Integer.valueOf(1));
        layeredPane.add(errorLabel,Integer.valueOf(1));

        this.add(layeredPane);

    }

}
