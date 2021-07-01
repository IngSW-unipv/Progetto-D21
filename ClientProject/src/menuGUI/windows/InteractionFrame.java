package menuGUI.windows;

import menuGUI.windows.util.FrameType;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class InteractionFrame extends JFrame {

    protected JLayeredPane layeredPane;
    protected Border line;
    protected JLabel backGround;


    public InteractionFrame(FrameType type){
        layeredPane = new JLayeredPane();
        chooseType(type);
       // setupFrameWithCostumElements();
    }

    private void chooseType(FrameType type){
        switch (type){
            case RULES:
                //TODO
                break;
            case ENDGAME:
                setupEndgameFrame();
                break;
            case SMALLFRAME:
                setUpNormalFrame();
                break;
            default:
                setUpNormalFrame();
        }
    }

    protected void setUpNormalFrame(){
        setSize(new Dimension(300,150));
        setResizable(false);

        this.getContentPane();
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/menuGUI/img/icon.png");
        setIconImage(img);

        line = new LineBorder(new Color(0x0F142A, true));

        layeredPane.setBounds(0,0,300,150);

        backGround = new JLabel();
        backGround.setIcon(new ImageIcon("src/menuGUI/img/blur300x150.jpg"));
        backGround.setBounds(0,0,300,150);

        layeredPane.add(backGround, Integer.valueOf(0));

        this.add(layeredPane);

        revalidate();
        repaint();
    }

    protected abstract void setupFrameWithCostumElements();

    protected void setupEndgameFrame(){

        setSize(new Dimension(700,500));
        setResizable(false);

        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/menuGUI/img/icon.png");
        setIconImage(img);

        Border line = new LineBorder(new Color(0x0F142A, true));

        layeredPane.setBounds(0,0,700,500);

        backGround = new JLabel();
        backGround.setBounds(0,0,700,500);
        backGround.setIcon(new ImageIcon("src/menuGUI/img/blur.jpg"));

        layeredPane.add(backGround, Integer.valueOf(0));
        this.add(layeredPane);
        revalidate();
        repaint();
    }

    private void setupRulesFrame(){
        setSize(new Dimension(234,280));
        setResizable(false);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        layeredPane.setBounds(0,0,234,280);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("src/menuGUI/img/icon.png");
        setIconImage(img);
        this.add(layeredPane);
    }
}
