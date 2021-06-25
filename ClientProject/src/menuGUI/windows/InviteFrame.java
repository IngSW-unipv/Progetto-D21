package menuGUI.windows;

import core.NetworkThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InviteFrame extends JFrame {

    private JLayeredPane layeredPane;
    private JTextField textField;
    private JLabel label1;
    private JLabel label2;
    private JButton jb1;
    private Second_Menu second_menu;

    public InviteFrame(Second_Menu second_menu){

        setSize(new Dimension(300,100));
        setResizable(false);
        this.getContentPane().setBackground(new Color(0xFFE57510, true));
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.second_menu = second_menu;

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,300,100);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/menuGUI/img/icon.png");
        setIconImage(img);

        textField = new JTextField();
        textField.setBounds(0,20, 150, 25);

        label1 = new JLabel("Enter the nickname:");
        label1.setBounds(0,4,150,10);
        label1.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,12));
        label1.setForeground(Color.BLACK);

        ActionListener sendInvite = e ->{
            if((this.second_menu!=null)&&(second_menu.getGameLenght().compareTo("a")!=0)){
                NetworkThread.getNetworkThread().sendMessage("sendInvite,"+textField.getText()+","+second_menu.getGameLenght());
                return;
            }ErrorFrame localErrorFrame = new ErrorFrame("Press Game Mode to set game duration");
        };

        jb1 = new JButton("INVITE");
        jb1.setBounds(180, 20, 100, 25);
        jb1.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,12));
        jb1.setBackground(Color.ORANGE.brighter());
        jb1.setForeground(Color.BLACK);
        jb1.addActionListener(sendInvite);
        jb1.setUI(new StyledButtonUI());

        ActionListener closeFrame = e -> {
            this.dispose();
        };

        jb1.addActionListener(closeFrame);

        label2 = new JLabel();
        label2.setBounds(0,0,300,100);
        label2.setIcon(new ImageIcon("src/menuGUI/img/blur300x100.jpg"));

        layeredPane.add(textField, Integer.valueOf(1));
        layeredPane.add(label1, Integer.valueOf(1));
        layeredPane.add(jb1, Integer.valueOf(1));
        layeredPane.add(label2, Integer.valueOf(0));
        this.add(layeredPane);
    }
}
