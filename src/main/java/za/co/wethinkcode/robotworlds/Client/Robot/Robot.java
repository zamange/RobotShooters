package za.co.wethinkcode.robotworlds.Client.Robot;

import com.fasterxml.jackson.databind.JsonNode;
import za.co.wethinkcode.robotworlds.Client.jsonUtility.Json;
import za.co.wethinkcode.robotworlds.Client.WriteToSocket;
import za.co.wethinkcode.robotworlds.Server.Commands.Command;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Robot {

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String robotName;
    private WriteToSocket writeToSocket;

    public Robot(Socket socket, String robot){
        try{
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.robotName = robot;
            this.writeToSocket = new WriteToSocket();
            this.writeToSocket.setRobot(robot);
        }
        catch(IOException e){
            closeProgram(socket, bufferedReader, bufferedWriter);
        }
    }
    public void sendMessage(){
        try{
            bufferedWriter.write(robotName);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scan = new Scanner(System.in);

            while(socket.isConnected()){
                String command = scan.nextLine();
                String[] commands = command.split(" ",2);
                if(command.contains("quit")){
                    bufferedWriter.write(robotName + " has left the game.");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    System.exit(1);
                    break;
                }
                writeToSocket.setCommand(commands[0]);

                if(command != null){
                    if(command.contains("launch")) {
                        if (command.contains("sniper")) {
                            ArrayList<String> ar = new ArrayList<String>();
                            String arg = commands[1];
                            int maxStrength = 5;
                            int maxShots = 5;
                            ar.add(arg);
                            ar.add(String.valueOf(maxStrength));
                            ar.add(String.valueOf(maxShots));
                            for (String argValues : ar) {
                                writeToSocket.setArguments(argValues);
                            }
                        }
                        else{
                            ArrayList<String> ar = new ArrayList<String>();
                            String arg = "normal";
                            int maxStrength = 5;
                            int maxShots = 5;
                            ar.add(arg);
                            ar.add(String.valueOf(maxStrength));
                            ar.add(String.valueOf(maxShots));
                            for (String argValues : ar) {
                                writeToSocket.setArguments(argValues);
                            }

                        }
                    }
                    else if(command.contains("state")){
                        writeToSocket.setArguments(" ");



                    }
                    else {
                        String arg = commands[1];
                        String[] splitArg = arg.split(" ");
                        for (String arguments : splitArg) {
                            writeToSocket.setArguments(arguments);
                        }
                    }

                }

                JsonNode node = Json.toJson(writeToSocket);

                String com = node.get("command").asText();
                List<String> argList = new ArrayList<>();
                for (JsonNode nodes : node.get("arguments")){
                    argList.add(nodes.textValue());

                }
                Command.create(com,argList).toString();

                bufferedWriter.write(Json.stringify(node));
                bufferedWriter.newLine();
                bufferedWriter.flush();

                writeToSocket.clearArgument();

            }

        }
        catch(IOException e){
            closeProgram(socket, bufferedReader, bufferedWriter);

        }
    }
    public void listeningForMessage(){
        new Thread ( new Runnable() {
            @Override
            public void run() {
                String msgRunGame;
                while(socket.isConnected()){
                    try{
                        msgRunGame = bufferedReader.readLine();
                        if (msgRunGame == null){
                            closeProgram(socket, bufferedReader, bufferedWriter);
                            System.out.println("\nGame Ended\nShutting down...");
                            System.exit(1);
                            break;
                        }
                        else{
                        System.out.println(msgRunGame);
                        }
                    }
                    catch (IOException e){
                        closeProgram(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
    }

    public void closeProgram(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try{
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null){
                socket.close();
            }
        }
        catch(IOException e){
            System.out.println(" ");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to za.co.wethinkcode.robotworlds.server.Robot World!\nWhat would you like to name your robot?");
        String userInput = scanner.nextLine();
        Socket socket = new Socket("localhost", 1234);
        Robot robot = new Robot(socket,userInput);
        robot.listeningForMessage();
        robot.sendMessage();
    }
}
