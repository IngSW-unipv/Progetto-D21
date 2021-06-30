package menuGUI.windows;

import core.GUI;

public class maintest {
    public static void main(String[] args) {

        GUI aaa = GUI.getGuiHandler();
        //aaa.displayDeclineFrame();
        //aaa.displayVictory();
        //LoserFrame loserFrame = new LoserFrame();
        //loserFrame.setVisible(true);
        //loserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aaa.startGameIO("5");



    }
}
