package menuGUI.listeners;

import core.NetworkThread;
import menuGUI.windows.*;
import menuGUI.windows.util.FrameType;
import menuGUI.windows.util.WindowsType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenFrameListener implements ActionListener {
    private JFrame frame1;
    private JButton button;
    private WindowsType type;
    private GameModeFrame gameModeFrame;
    private InviteFrame inviteFrame;
    private RulesFrame rulesFrame;
    private JMenuItem item;
    private PopupMenu popupMenu;
    private ThirdMenu thirdMenu;
    private RandomFrame ranf;
    private SecondMenu menu;

    public OpenFrameListener(JButton button,WindowsType type){
        this.type = type;
        this.button = button;
    }

    public OpenFrameListener(JMenuItem item,WindowsType type){
        this.type = type;
        this.item = item;
    }

    public OpenFrameListener(JButton button,WindowsType type, SecondMenu menu){
        this.type = type;
        this.button = button;
        this.menu = menu;
    }

    private void chooseType(WindowsType type){
        switch (type){
            case GAMEMODE:
                gameModeFrame = new GameModeFrame(menu);
                gameModeFrame.setVisible(true);
                break;
            case RULES:
                rulesFrame = new RulesFrame();
                rulesFrame.setVisible(true);
                break;
            case THEME:
                thirdMenu = new ThirdMenu();
                thirdMenu.setVisible(true);
                thirdMenu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                break;
            case RANDOM:
                //TODO aggiungi un metodo a parte
                    if (menu.getGameLenght().compareTo("nogamemodeSelected")!=0) {
                        NetworkThread.getNetworkThread().sendMessage("addmeToQueue," + menu.getGameLenght());
                        ranf = new RandomFrame();
                        ranf.setVisible(true);
                        break;
                    }
                ErrorFrame localErrorFrame = new ErrorFrame("Press Game Mode to set game duration");
                break;
            case INVITE:
                inviteFrame = new InviteFrame();
                inviteFrame.setVisible(true);
                break;
            default:
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        chooseType(type);
    }
}
