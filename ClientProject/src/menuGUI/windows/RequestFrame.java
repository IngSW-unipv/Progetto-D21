package menuGUI.windows;


import menuGUI.listeners.RequestListener;
import menuGUI.windows.util.FrameType;
import menuGUI.windows.util.WindowsType;

import javax.swing.*;

import java.awt.*;
/**
 * This class extends the Abstract class InteractionFrame, sets up the RequestFrame that shows a simple JFrame where the invited
 * player receives from another player. It shows some simple messages (such as "Invite received from...) and it implements two
 * JButtons in order to accept or decline the request received
 */
public class RequestFrame extends InteractionFrame{

    private JLabel label2;
    private JButton jb1;
    private JButton jb2;
    private String playerName;

    public RequestFrame(String playerName){
        super(FrameType.SMALLFRAME, WindowsType.REQUEST);
        this.playerName = playerName;
        setupFrameWithCostumElements();
    }
    /**
     * overrided method inherited from the superclass that sets up the frame with custom parameters
     */
    @Override
    protected void setupFrameWithCostumElements() {
        label2 = new JLabel("Invite recived from "+playerName);
        label2.setBounds(0,10,300, 50);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,15));
        label2.setForeground(Color.BLACK);

        jb1 = new JButton("ACCEPT");
        jb1.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,12));
        jb1.setForeground(Color.BLACK);
        jb1.setOpaque(true);
        jb1.setContentAreaFilled(false);
        jb1.setFocusPainted(false);
        jb1.setBorder(line);
        jb1.setBounds(35,70,100,20);
        jb1.setBackground(Color.orange.brighter());
        jb1.setUI(new StyledButtonUI());
        jb1.setActionCommand("accept");
        jb1.addActionListener(new RequestListener(jb1,this));

        jb2 = new JButton("DECLINE");
        jb2.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,12));
        jb2.setForeground(Color.BLACK);
        jb2.setOpaque(true);
        jb2.setContentAreaFilled(false);
        jb2.setFocusPainted(false);
        jb2.setBorder(line);
        jb2.setBounds(155,70,100,20);
        jb2.setBackground(Color.orange.brighter());
        jb2.setUI(new StyledButtonUI());
        jb2.setActionCommand("decline");
        jb2.addActionListener(new RequestListener(jb2,this));

        layeredPane.add(label2, Integer.valueOf(1));
        layeredPane.add(jb1, Integer.valueOf(1));
        layeredPane.add(jb2, Integer.valueOf(1));

        revalidate();
        repaint();
    }
}
