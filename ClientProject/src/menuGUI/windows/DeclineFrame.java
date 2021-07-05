package menuGUI.windows;

import menuGUI.windows.util.FrameType;
import menuGUI.windows.util.WindowsType;

import javax.swing.*;
import java.awt.*;
/**
 * Simple class of a DeclineFrame (which pops when the invited player refuses a request)
 */

public class DeclineFrame extends InteractionFrame{

    private JLayeredPane layeredPane;
    private JLabel label1;
    private JLabel label2;

    public DeclineFrame(){
        super(FrameType.SMALLFRAME, WindowsType.DECLINE);
        setupFrameWithCostumElements();
    }

    /**
     * This method creates the DeclineFrame and adds it to the JLayerdPane
     */

    @Override
    protected void setupFrameWithCostumElements() {
        label1 = new JLabel();
        label1.setIcon(new ImageIcon("src/menuGUI/img/blur300x150.jpg"));
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