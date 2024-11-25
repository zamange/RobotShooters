package za.co.wethinkcode.robotworlds.Server.SaabirahServer;

import za.co.wethinkcode.robotworlds.Server.ServerManager.ServerManager;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class MultiServer {

    private final ServerSocket serverSocket;

    public MultiServer (ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServers() {

        try {
            while (!serverSocket.isClosed()) {

                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected!");

                Runnable robot = new RobotServer(socket);
                Thread task = new Thread(robot);
                task.start();

            }
        } catch(IOException e){
            closeServeSocket();
        }

    }

    public void closeServeSocket () {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println(" ");

        }
    }

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(RobotServer.PORT);
        System.out.println("Server running & waiting for robots to connect...");
        MultiServer servers = new MultiServer(serverSocket);
        ServerManager serverManager = new ServerManager(serverSocket);

        serverManager.start();
        servers.startServers();
    }
}
