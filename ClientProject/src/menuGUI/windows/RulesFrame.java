package menuGUI.windows;

import menuGUI.windows.util.FrameType;
import menuGUI.windows.util.WindowsType;

import javax.swing.*;
import java.awt.*;
/**
 * This class extends the Abstract class InteractionFrame, it shows the rules of the game
 */
public class RulesFrame extends InteractionFrame{

    private JTextArea textArea;

    public RulesFrame(){
        super(FrameType.RULES, WindowsType.RULES);
        setupFrameWithCostumElements();
    }
    /**
     * This overrided method (inherited from the superlclass) makes possible the customization of the simple RulesFrame
     */
    @Override
    protected void setupFrameWithCostumElements() {
        textArea = new JTextArea("Before you can start playing \nConnect Four or planning a \nstrategy, you must make sure \nthat you understand the object of \nthe game. \nIn order to win, a player must get \nfour checkers in their color in a\nrow.\nWhoever does it first is the\nwinner.\n" +
                "There are three ways to get four\ntokens in a row in Connect Four:\nhorizontally, vertically, and\ndiagonally.");
        textArea.setBounds(0,0, 234, 280);
        textArea.setFont(new Font("ITC Avant Garde Gothic",Font.ITALIC,12));
        textArea.setEditable(false);
        textArea.setBackground(Color.ORANGE);
        textArea.setForeground(Color.BLACK);
        layeredPane.add(textArea, Integer.valueOf(0));
        revalidate();
        repaint();
    }
}
