package core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static tester.Tester1.serverLogger;

/**[ENG]
 * This class listens on the assigned serverSocket to detect incoming connections from new clients
 * once one of these is detected a new socket is created and the handling of the connection is given to
 * a new WorkerThread.
 *
 * [IT]
 * Questa classe si occupa di stare in ascolto sul socket assegnato al server
 * per nuove connessioni, quando una di queste viene rilevata viene creato un socket
 * dedicato e la sua gestione passata ad un altro thread
 *
 * @author Flavio Bobba
 */
public class ListenerThread extends Thread{

    private ServerSocket serverSocket;

    /**
     * Class construcuror
     * Accepts a socket which is created before and then given to an attribute
     *
     * Costruttore della classe, accetta un serversocket che viene istanziato a priori
     * assegnato poi all'attributo della classe
     *
     * @param serverSocket
     */
    public ListenerThread(ServerSocket serverSocket){

        this.serverSocket = serverSocket;

    }

    /**Thread's run implementation
     * This method listens on the socket for incoming connections
     * once a new connection is detected, a WorkerThread instance is
     * created and the socket relative to the new connection is given to
     * it.
     *
     * Metodo run che si occupa di stare in ascolto sul serversocket,
     * una volta che una nuova connessione viene creata, crea un istanza
     * della classe WorkerThread passandogli il socket della nuova connessione
     * in modo tale che essa si occupi di gestire l'utente connesso.
     *
     * @see WorkerThread
     */
    @Override
    public void run() {
        //TODO implementare logica decente es controllo stato socket e che non si a chiuso
        while (true){

            try {

                Socket newConnectedSocket = this.serverSocket.accept();
                serverLogger.info("Inbound Connnection detected on address:"+newConnectedSocket.getInetAddress());
                WorkerThread workerThread = new WorkerThread(newConnectedSocket);
                serverLogger.info("Handling of the connection given to a new thread");
                workerThread.start();

            } catch (IOException e) {
                serverLogger.info("Failure in establishing connection");
            }


        }

    }
}
