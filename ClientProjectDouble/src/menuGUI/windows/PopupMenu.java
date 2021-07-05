package menuGUI.windows;

import menuGUI.windows.util.WindowsType;

import javax.swing.*;
import java.awt.*;

public class PopupMenu extends JFrame{
    private JPopupMenu popupMenu;
    private JMenuItem item;
    private WindowsType windowsType;

    public PopupMenu(JMenuItem item){
        windowsType = WindowsType.POPUP;
        this.item = item;
        setPopupMenu();
    }

    private void setPopupMenu(){
        item = new JMenuItem("How to Play");
        popupMenu.add(item);
        popupMenu.setBackground(new Color(0xDE8B0E));
        //popupMenu.setBorder(line);
        item.setBackground(new Color(0xDE8B0E));
        item.setForeground(Color.white);
    }

}
