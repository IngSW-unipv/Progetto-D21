package menuGUI.windows;

import javax.swing.*;
import java.awt.*;

public class RulesFrame extends JFrame {

    private JLayeredPane layeredPane;
    private JTextArea textArea;

    public RulesFrame(){
        setSize(new Dimension(234,280));
        setResizable(false);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,234,280);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/menuGUI/img/icon.png");
        setIconImage(img);

        textArea = new JTextArea("Before you can start playing \nConnect Four or planning a \nstrategy, you must make sure \nthat you understand the object of \nthe game. \nIn order to win, a player must get \nfour checkers in their color in a\nrow.\nWhoever does it first is the\nwinner.\n" +
                "There are three ways to get four\ntokens in a row in Connect Four:\nhorizontally, vertically, and\ndiagonally.");
        textArea.setBounds(0,0, 234, 280);
        textArea.setFont(new Font("ITC Avant Garde Gothic",Font.ITALIC,12));
        textArea.setEditable(false);
        textArea.setBackground(Color.ORANGE);
        textArea.setForeground(Color.BLACK);
        layeredPane.add(textArea, Integer.valueOf(0));
        this.add(layeredPane);
    }
}
