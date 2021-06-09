import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelsiusiGUI extends JFrame{
    private JPanel panel1;
    private JTextField celsiusTextField;
    private JButton convertButton;

    public CelsiusiGUI(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        CelsiusiGUI cs = new CelsiusiGUI();
        cs.setVisible(true);
    }
}
