package gui3;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BoxLayoutDemo {
    /*did everything in main, should separate but works
    missing actionlistener
    */
        public static void main(String[] args) {

            //create jframe & its style
            JFrame.setDefaultLookAndFeelDecorated(true);
            JFrame frame = new JFrame("FIRST DEMO MENU");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //set customizable panel with bg
            DemoBackgroundSwing panel = new DemoBackgroundSwing();

            // vertical layout
            BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

            panel.setLayout(boxlayout);

            //borders for panel (not sure but works)
            panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
            //panel.setBorder(new EmptyBorder(new Insets(50, 80, 50, 80)));

            //defining styled button (see styledbuttonsui class for custom)
            final JButton jb1 = new JButton("");
            jb1.setFont(new Font("Calibri", Font.PLAIN, 14));
            jb1.setBackground(new Color(0xA32DCE));
            jb1.setIcon(new ImageIcon("C:\\Users\\greta\\IdeaProjects\\MenuGUI\\src\\gui3\\capamericatoken.png"));
            jb1.setForeground(Color.white);

            final JButton jb2 = new JButton("");
            jb2.setFont(new Font("Calibri", Font.PLAIN, 14));
            jb2.setBackground(new Color(0x2D9BCE));
            jb2.setIcon(new ImageIcon("C:\\Users\\greta\\IdeaProjects\\MenuGUI\\src\\gui3\\stitch90px.png"));
            jb2.setForeground(Color.white);

            final JButton jb3 = new JButton("");
            jb3.setFont(new Font("Calibri", Font.PLAIN, 14));
            jb3.setBackground(new Color(0xCE782D));
            jb3.setIcon(new ImageIcon("C:\\Users\\greta\\IdeaProjects\\MenuGUI\\src\\gui3\\powerup.png"));
            jb3.setForeground(Color.white);

            jb1.setUI(new StyledButtonUI());
            panel.add(jb1);

            jb2.setUI(new StyledButtonUI());
            panel.add(jb2);

            jb3.setUI(new StyledButtonUI());
            panel.add(jb3);

            //adding buttons & blanks spaces between them
            panel.add(jb1);
            panel.add(Box.createRigidArea(new Dimension(0, 60)));
            panel.add(jb2);
            panel.add(Box.createRigidArea(new Dimension(0, 60)));
            panel.add(jb3);

            // Set size for the frame
            //frame.setSize(300, 300);

            //add panel to frame (should use container ma sono stata pigra)
            frame.add(panel);
            frame.pack();
            frame.setVisible(true);

        }

}

