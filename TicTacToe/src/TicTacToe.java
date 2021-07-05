import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TicTacToe implements Runnable{
    private String ip = "localhost";
    private int port = 22222;
    private JFrame frame;
    private final int WIDTH = 506;
    private final int HEIGHT = 527;
    private Thread thread;
    private Socket socket; //connects to server
    private DataOutputStream dos;
    private DataInputStream dis;
    private ServerSocket serverSocket; //for the server
    private BufferedImage board;
    private BufferedImage redX;
    private BufferedImage blueX;
    private BufferedImage redCircle;
    private BufferedImage blueCircle;
    private String [] spaces = new String[9];
    private String unableToCommunicateWithOpponentString = "Unable to communicate with opponent.";
    private boolean yourTurn = false;
    private boolean circle = true;
    private boolean accepted = false;
    private boolean unableToCommunicateWithOpponent = false;
    private boolean won = false;
    private boolean enemywon = false;

    private int lenghtOfSpace = 160; //squares
    private int errors = 0;
    private int firstSpot = -1; //firstspot
    private int secondSpot = -1; //thirdsport

    private Font font = new Font("Verdana",Font.BOLD,32);
    private Font smallerfont = new Font("Verdana",Font.BOLD,20);
    private Font largerfont = new Font("Verdana",Font.BOLD,50);

    private String waitingString = "Waiting for another player";
    private String unabletoComm = "Unable to communicate with opponent";
    private String wonString = "You won!";
    private String enemyWonString = "Opponent Won!";

    private Scanner scanner = new Scanner(System.in);
    private Painter painter = new Painter();

    public TicTacToe(){
        System.out.println("Input IP: ");
        ip = scanner.nextLine();
        System.out.printf("Input port: ");
        port = scanner.nextInt();

        while(port<1||port>65535){
            System.out.println("Port invalid");
        }

        loadImages();
    }

    private void loadImages(){
        try{
            board = ImageIO.read(getClass().getResourceAsStream("res/board.png"));
            redX = ImageIO.read(getClass().getResourceAsStream("res/redX.png"));
            redCircle = ImageIO.read(getClass().getResourceAsStream("res/redCircle.png"));
            blueX = ImageIO.read(getClass().getResourceAsStream("res/blueX.png"));
            blueCircle = ImageIO.read(getClass().getResourceAsStream("res/blueCircle.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void listenerForServerRequest(){
        Socket socket = null;
        try{
            socket = serverSocket.accept();
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            accepted = true;
            System.out.println("Client has requested to join & we have accepted");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            tick();
            painter.repaint();

            if(!circle&&!accepted){
                listenerForServerRequest();
            }
        }
    }

    private void tick() {
        if(!yourTurn && !unableToCommunicateWithOpponent){
            try{
                int space = dis.readInt();
                if(circle){
                    spaces[space] = "X";
                }else{
                    spaces[space] = "O";
                }
                checkForEnemyWin();
                yourTurn = true;
            }catch (IOException e){
                
            }
        }
    }
    //can do better in gui, do it
    private void render(Graphics g){
        g.drawImage(board,0,0,null);
        if(unableToCommunicateWithOpponent){
            g.setColor(Color.RED);
            g.setFont(smallerfont);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            //how logn the string is cuz we can center the string in the center of the screen
            int stringWidth = g2.getFontMetrics().stringWidth(unableToCommunicateWithOpponentString);
            g.drawString(unableToCommunicateWithOpponentString,WIDTH/2-stringWidth/2, HEIGHT/2);
            return;
        }
        if(accepted){
            for(int i = 0; i < spaces.length; i++){
                if(spaces[i].equals("X")){
                    if(circle){
                        //rendering in the correct box on the screen
                        g.drawImage(redX,(i%3)*lenghtOfSpace+10*(i%3),(int)(i/3)*lenghtOfSpace+10*(int)(i/3),null);
                    }else{
                        g.drawImage(blueX,(i%3)*lenghtOfSpace+10*(i%3),(int)(i/3)*lenghtOfSpace+10*(int)(i/3),null);
                    }
                }else if(spaces[i].equals("O")){
                    if(circle){
                        g.drawImage(redCircle,(i%3)*lenghtOfSpace+10*(i%3),(int)(i/3)*lenghtOfSpace+10*(int)(i/3),null);
                    }else{
                        g.drawImage(blueCircle,(i%3)*lenghtOfSpace+10*(i%3),(int)(i/3)*lenghtOfSpace+10*(int)(i/3),null);
                    }
                }
            }
            if(won||enemywon){
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(10));
                g.setColor(Color.BLACK);
                g.drawLine(firstSpot % 3*lenghtOfSpace+10*firstSpot%3+lenghtOfSpace/2,(int)(firstSpot/3)*lenghtOfSpace+10*(int)(firstSpot/3)+lenghtOfSpace/2,secondSpot%3*lenghtOfSpace+10*secondSpot%3+lenghtOfSpace/2, (int)(secondSpot/3)*lenghtOfSpace+10*(int)(secondSpot/3)+lenghtOfSpace/2);
                g.setColor(Color.red);
                g.setFont(largerfont);

                if(won){
                    int string
                }
            }
        }
    }

    private void checkForEnemyWin() {
    }

}
