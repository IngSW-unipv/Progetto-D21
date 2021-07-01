package menuGUI.windows;

import menuGUI.windows.util.FrameType;

import javax.swing.*;
import java.awt.*;

public class RandomFrame extends InteractionFrame{

    private JLabel label2;
    private JLabel label3;

    public RandomFrame(){
        super(FrameType.SMALLFRAME);
        setupFrameWithCostumElements();
    }

    @Override
    protected void setupFrameWithCostumElements() {
        label2 = new JLabel();
        label2.setBounds(0,0, 300,150);
        label2.setIcon(new ImageIcon("src/menuGUI/img/hourglass.png"));

        label3 = new JLabel("WAITING...");
        label3.setBounds(110,10,200, 50);
        label3.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,15));
        label3.setForeground(Color.BLACK);

        layeredPane.add(label2, Integer.valueOf(1));
        layeredPane.add(label3, Integer.valueOf(1));

        revalidate();
        repaint();
    }
}
