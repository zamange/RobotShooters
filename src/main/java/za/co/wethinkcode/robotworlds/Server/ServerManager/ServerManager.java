package za.co.wethinkcode.robotworlds.Server.ServerManager;

import java.net.ServerSocket;
import java.util.Scanner;

public class ServerManager extends Thread {

    private final Scanner scanner = new Scanner(System.in);
    private final ServerSocket serverSocket;

    public ServerManager(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        while (!serverSocket.isClosed()){
            try{
                String command = getCommand();
                ServerCommands.create(command);

            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public String getCommand(){
        return scanner.nextLine();
    }
}
