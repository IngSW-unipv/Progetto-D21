package menuGUI.windows;

import core.GUIcontroller;

public class TesterFinestre {
    public static void main(String[] args) {

        GUIcontroller aaa = GUIcontroller.getGuiHandler();
        //aaa.displayDeclineFrame();
        //aaa.displayVictory();
        //LoserFrame loserFrame = new LoserFrame();
        //loserFrame.setVisible(true);
        //loserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aaa.startGameIO("5");



    }
}
