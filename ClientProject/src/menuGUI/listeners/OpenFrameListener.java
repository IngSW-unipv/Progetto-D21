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

    public OpenFrameListener(JButton button,WindowsType type){
        this.type = type;
        this.button = button;
    }

    public OpenFrameListener(JMenuItem item,WindowsType type){
        this.type = type;
        this.item = item;
    }
    private void chooseType(WindowsType type){
        switch (type){
            case GAMEMODE:
                gameModeFrame = new GameModeFrame();
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
                if (gameModeFrame != null) {
                    if (gameModeFrame.getGameSpeed() != null) {
                        NetworkThread.getNetworkThread().sendMessage("addmeToQueue," + gameModeFrame.getGameSpeed());
                        ranf = new RandomFrame();
                        ranf.setVisible(true);
                        return;
                    }
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
