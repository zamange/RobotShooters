package za.co.wethinkcode.robotworlds.Server.Communication;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Request {
    String name;
    String command;
    List<String> arguments;

    public Request(String name, String command) {
        String[] args = command.toLowerCase().trim().split(" ");
        this.name = name;
        this.command = args[0];
        arguments = new ArrayList<>();
        for (String arg : args)
        {
            if(!arg.equals(this.command))
                arguments.add(arg);
        }
    }

    public String getName() {
        return name;
    }
    public String getCommand() { return command;}
    public String getArgument() { return String.join(" ", arguments);}
    public String getCommand(String args) {return command +" "+getArgument();}

    /**
     * GETS STRING JSON, CONVERTS TO REQUEST OBJECT
     * @return Request object
     */
    public static Request handleRequest(String request) {
        Gson gson = new Gson();

        Request name = gson.fromJson(request, Request.class);
        return name;
    }
}