package menuGUI.windows;

import menuGUI.windows.util.FrameType;
import menuGUI.windows.util.WindowsType;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
/**
 * Simple class of a ErrorFrame (which pops whenever an error occurs anywhere in the program)
 */

public class ErrorFrame extends InteractionFrame {

    private JLabel errorLabel;
    private JTextArea errorInfo;
    private String errorMessage;

    public ErrorFrame(String errorMessage){
        super(FrameType.SMALLFRAME, WindowsType.ERROR);
        this.errorMessage = errorMessage;
        setupFrameWithCostumElements();
    }
    /**
     * This method creates the ErrorFrame and adds it to the JLayerdPane, revalidate() & repaint() make sure
     * that the old content is erased whenever is needed a new ErrorFrame
     */

    @Override
    protected void setupFrameWithCostumElements() {
        errorLabel = new JLabel("ERROR");
        errorLabel.setBounds(110,0,300,50);
        errorLabel.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,14));
        errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        errorLabel.setForeground(Color.BLACK);

        errorInfo = new JTextArea(errorMessage);
        errorInfo.setBounds(0,50,300, 100);
        errorInfo.setOpaque(false);
        errorInfo.setEditable(false);
        errorInfo.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,14));
        errorInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        errorInfo.setForeground(Color.BLACK);

        layeredPane.add(errorInfo, Integer.valueOf(1));
        layeredPane.add(errorLabel,Integer.valueOf(1));

        revalidate();
        repaint();
    }
}
