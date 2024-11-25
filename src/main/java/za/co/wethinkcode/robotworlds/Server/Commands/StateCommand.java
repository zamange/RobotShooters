package za.co.wethinkcode.robotworlds.Server.Commands;

import org.json.JSONObject;
import za.co.wethinkcode.robotworlds.Server.World.Response;
import za.co.wethinkcode.robotworlds.Server.World.Robot;

import java.util.List;

public class StateCommand extends Command {
    public Robot target;
    public StateCommand(List<String> arg) {
        super("state", arg);
        Robot target = new Robot();
        execute(target);
    }


    @Override
    public String execute(Robot target) {
        JSONObject response;
        response = Response.createStateResponse(target);
        System.out.println(response);
        return response.toString();
    }
}
