package menuGUI.windows;

import menuGUI.windows.util.FrameType;

import menuGUI.listeners.CloseRandomFrameListener;

import menuGUI.windows.util.FrameType;
import menuGUI.windows.util.WindowsType;


import javax.swing.*;
import java.awt.*;
/**
 * This class extends the Abstract class InteractionFrame, sets up the InviteFrame in order to make possible to look for another
 * random player with the same settings that match the ones that the first player has chosen
 */
public class RandomFrame extends InteractionFrame{

    private JLabel label2;
    private JLabel label3;

    public RandomFrame(){
        super(FrameType.SMALLFRAME, WindowsType.RANDOM);
        setupFrameWithCostumElements();
    }

    /**
     * overrided method inherited from the superclass that sets up the frame with custom parameters, implementes an instance
     * of a CloseRandomFrameListener
     */
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

        this.add(layeredPane);

        addWindowListener(new CloseRandomFrameListener(this));

        revalidate();
        repaint();

    }
}
