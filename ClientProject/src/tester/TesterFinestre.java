package tester;

import core.GUIcontroller;
import core.TokenColor;
import menuGUI.windows.SecondMenu;
import menuGUI.windows.ThirdMenu;

public class TesterFinestre {
    public static void main(String[] args) {

        GUIcontroller aaa = GUIcontroller.getGuiHandler();
        //aaa.displayDeclineFrame();
        //aaa.displayVictory();
        //LoserFrame loserFrame = new LoserFrame();
        //loserFrame.setVisible(true);
        //loserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ThirdMenu.choosenTheme = 3;
        aaa.startGameIO("3");
        aaa.addLabel(3,6, TokenColor.RED);
    }
}
