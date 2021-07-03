package menuGUI.windows;
import menuGUI.listeners.BackToMenuLIstener;
import menuGUI.windows.util.FrameType;
import menuGUI.windows.util.WindowsType;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;


public class VictoryFrame extends InteractionFrame{

    private JLabel label0, label1;
    private JLabel label2;
    private JButton jb1;

    public VictoryFrame(){
        super(FrameType.ENDGAME, WindowsType.VICTORY);
        setupFrameWithCostumElements();
    }

    @Override
    protected void setupFrameWithCostumElements() {

        jb1 = new JButton("BACK TO MENU");
        jb1.setBounds(255, 350, 180, 40);
        jb1.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,16));
        jb1.setBackground(Color.ORANGE.brighter());
        jb1.setForeground(Color.BLACK);
        jb1.setUI(new StyledButtonUI());

        ActionListener backToMenu = e -> {
            this.dispose();
            SecondMenu menu = new SecondMenu();
        };
        jb1.addActionListener(backToMenu);

        label2 = new JLabel();
        label2.setBounds(0,0,700,500);
        label2.setIcon(new ImageIcon("src/menuGUI/img/blur.jpg"));

        label0 = new JLabel();
        label0.setBounds(70,50,600,200);
        label0.setIcon(new ImageIcon("src/menuGUI/img/CONGRATULATIONS.png"));

        label1 = new JLabel();
        label1.setBounds(200,120,600,200);
        label1.setIcon(new ImageIcon("src/menuGUI/img/YOU WON!.png"));

        layeredPane.add(label0, Integer.valueOf(1));
        layeredPane.add(label1, Integer.valueOf(1));
        layeredPane.add(jb1, Integer.valueOf(1));
        layeredPane.add(label2, Integer.valueOf(0));

        revalidate();
        repaint();
    }
}
