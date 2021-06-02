package core;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameGui.guiB.util.AnimationTask;
import gameGui.guiB.util.TokenColor;

import static tester.ClientMainProva1.clientLogger;

public class NetworkThread extends Thread {

    private Socket socket;
    private static int port=25565;
    private PrintWriter socketOutput = null;
    private BufferedReader socketInput = null;
    private static NetworkThread myThread=null;
    private JPanel animPanel;

    private NetworkThread(int port) {
        this.port = port;
    }
    
    public static NetworkThread getNetworkThread() {
    	if(myThread==null)
    		myThread = new NetworkThread(port);
    	return myThread;
    }

    @Override
    public void run() {

        try {
            this.socket = new Socket("2.36.254.212", port);
            clientLogger.info("Connection established");
        } catch (IOException e) {
            clientLogger.info("Impossible to establish connection to:" + socket.getInetAddress());
        }

        try {
            socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketOutput = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        } catch (IOException e) {
            clientLogger.info("I/O Error");
        }

        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;

        while (true) {

            try {
                msg = tastiera.readLine();
                System.out.println(msg);
                socketOutput.println(msg);
                System.out.println(msg+"inviato");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void parseString(String message){
        String[] parts = message.split(",");

        switch (parts[0]){
        	case "abilitaInterfaccia":
        		//todo abilita buttonpanel;
        		break;
        	case "disabilitaInterfaccia":
        		//todo diabilita buttonpanel;
        		break;
        	case "addToken": //addToken,x,y	
        		addLabel(x, y, c);
        		break;
        	case "begin":
        		// apri cose
        	case "victory":
        		// vittoira
        	case "defeat":
        		//sconfitta
        }
    }
    
    
    
    public void setAnimPanel(JPanel animPanel) {
		this.animPanel = animPanel;
	}

	public void sendMessage(String message) {
    	socketOutput.println(message);
    }
    
    private void addLabel(int x,int y,TokenColor c) {
		
		JLabel lbl = new JLabel("");
		if(c==TokenColor.RED) {
			lbl.setIcon(new ImageIcon("resources/textures/RedToken2.png"));
		}
		if(c==TokenColor.YELLOW) {
			lbl.setIcon(new ImageIcon("resources/textures/YellowToken2.png"));
		}
		this.gameTimer.schedule(new AnimationTask(lbl, animPanel, 0, 50+tokenY*100, 50+tokenX*100),this.refreshRate );
		System.out.println("aa");
	}
    
    
}