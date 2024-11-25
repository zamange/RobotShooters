package za.co.wethinkcode.robotworlds.Server.SaabirahServer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import za.co.wethinkcode.robotworlds.Client.jsonUtility.Json;
import za.co.wethinkcode.robotworlds.Server.Commands.Command;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class RobotServer implements Runnable {

    public static ArrayList<RobotServer>  clientRobots = new ArrayList<>();
    public static final int PORT = 1234;
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private PrintWriter out;
    public String robotName;

    public RobotServer(Socket socket){
        try {
            this.socket = socket;
            this.out = new PrintWriter(socket.getOutputStream());
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.robotName = bufferedReader.readLine();
            clientRobots.add(this);

            bufferedWriter.write("Successfully connected to the server " + robotName);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            displayOutput("Server: " + robotName.toUpperCase() + " joined the game!");

        } catch (IOException e) {
            closeProgram(socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run() {
        String commandFromRobot;

        while(socket.isConnected()) {
            try {
                while(true){
                    bufferedWriter.write(robotName.toUpperCase() + "> What must I do next? ");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    commandFromRobot = bufferedReader.readLine();

                    try {
                        JsonNode node = Json.parse(commandFromRobot);
                        System.out.println(Json.prettyPrint(node));

                        String command = node.get("command").asText();

                        if(node.get("arguments")!= null && node.get("arguments").isArray()){
                            ArrayNode arrayNode = (ArrayNode) node.get("arguments");
                            List<String> argList = new ArrayList<>();
                            for (JsonNode nodes : arrayNode){
                                argList.add(nodes.textValue());
                            }
//                            bufferedWriter.write(Command.create(command, argList).toString());
//                            bufferedWriter.newLine();
//                            bufferedWriter.flush();
                            // print execute
                            out.println(Command.create(command, argList).toString());
                        }

                    }
                    catch (IOException e) {
                        System.out.println(robotName.toUpperCase() + " has left the world...");
                        closeProgram(socket, bufferedReader, bufferedWriter);
                        break;
                    }
                }
            }catch (IOException e){
                break;
            }
        }
    }

    public void displayOutput(String commandsToServe){
        for(RobotServer robot: clientRobots){
            try {
                if (robot.robotName.equals(robotName)) {
                    robot.bufferedWriter.write(commandsToServe);
                    robot.bufferedWriter.newLine();
                    robot.bufferedWriter.flush();
                }
            }
            catch(IOException e){
                closeProgram(socket, bufferedReader,  bufferedWriter);
            }
        }
    }

    public void removeRobot(){
        clientRobots.remove(this);
        displayOutput("Server: "+ robotName.toUpperCase() + " has left the game.");

    }

    public void closeProgram(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        removeRobot();
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
            System.out.println("");
        }

    }

}

