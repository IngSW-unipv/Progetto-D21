package menuGUI.windows;

import core.GUIcontroller;
import core.NetworkThread;
import menuGUI.windows.util.FrameType;
import menuGUI.windows.util.WindowsType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 * This class extends the Abstract class InteractionFrame, sets up the InviteFrame in order to make possible to invite
 * another player.
 */
public class InviteFrame extends InteractionFrame{

    private JTextField textField;
    private JLabel label1;
    private JLabel label2;
    private JButton jb1;
    private SecondMenu second_menu;
    private ErrorFrame localErrorFrame;

    public InviteFrame(){
        super(FrameType.SMALLFRAME, WindowsType.INVITE);
        setupFrameWithCostumElements();
    }

    /**
     * This overrided method (inherited from the superlclass) implements an inner ActionListener that make possible to communicate
     * to the NetworkThread the message the intention to invite another known player. If necessary, it creates an instance of
     * an ErrorFrame if the game mode has not been set
     */
    @Override
    protected void setupFrameWithCostumElements() {
        second_menu = GUIcontroller.getGuiHandler().getSecondMenu();
        textField = new JTextField();
        textField.setBounds(0,20, 150, 25);

        label1 = new JLabel("Enter the nickname:");
        label1.setBounds(0,4,150,10);
        label1.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,12));
        label1.setForeground(Color.BLACK);

        ActionListener sendInvite = e ->{
            second_menu = new SecondMenu();
            second_menu.setVisible(false);
            if((this.second_menu!=null)&&(second_menu.getGameLenght().compareTo("a")!=0)){
                NetworkThread.getNetworkThread().sendMessage("sendInvite,"+textField.getText()+","+second_menu.getGameLenght());
                return;
            } localErrorFrame = new ErrorFrame("Press Game Mode to set game duration");
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

        revalidate();
        repaint();
    }
}
