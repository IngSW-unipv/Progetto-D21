package gameGui.guiB.gameScreen;

import menuGUI.gui3.StyledButtonUI;
import menuGUI.mainmenu.control.BackToMenuLIstener;

import javax.swing.*;
import java.awt.*;

public class VictoryPanel extends JPanel {

    private JLabel displayLabel;
    private JButton backButton;

    //TODO sistemare il colore di backgorund sitemare il font mettere un immagine di sfondo e rendere trasp?
    public VictoryPanel(boolean victory){

        setBounds(0,0,800,700);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(Color.cyan);
        setupLabel(victory);
        setupButton();
        setVisible(true);

        //mi assicuro che il pannello venga stampato per bene
        revalidate();
        repaint();
    }

    private void setupLabel(boolean victory){

        //tutto per la label la dimensione dipende dal font
        displayLabel = new JLabel();
        displayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        displayLabel.setAlignmentX(CENTER_ALIGNMENT);
        displayLabel.setAlignmentY(CENTER_ALIGNMENT);
        displayLabel.setPreferredSize(new Dimension(200,100));
        displayLabel.setFont(new Font("myfont",Font.PLAIN,80));
        //displayLabel.setBounds(0,0,800,200);
        if(victory)
            displayLabel.setText("VICTORY ARCHIVED");
        else
            displayLabel.setText("DEFEAT ENDURED");
       // displayLabel.setAlignmentX(CENTER_ALIGNMENT);

        this.add(displayLabel);

    }

    private void setupButton(){

        // tutto il necessario per impostare il bottone, la dimensione dipende dal font size
        backButton = new JButton();
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setAlignmentX(CENTER_ALIGNMENT);
        backButton.setAlignmentY(CENTER_ALIGNMENT);
        backButton.setPreferredSize(new Dimension(200,100));
        backButton.setFont(new Font("myfont",Font.PLAIN,80));
        backButton.setUI(new StyledButtonUI());
        backButton.setText("Back to menu");
        backButton.addActionListener(new BackToMenuLIstener());

        this.add(backButton);

    }

}
