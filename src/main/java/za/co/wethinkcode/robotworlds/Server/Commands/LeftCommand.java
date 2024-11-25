package za.co.wethinkcode.robotworlds.Server.Commands;

import org.json.JSONObject;
import za.co.wethinkcode.robotworlds.Server.World.Direction;
import za.co.wethinkcode.robotworlds.Server.World.Response;
import za.co.wethinkcode.robotworlds.Server.World.Robot;

import java.util.List;

public class LeftCommand extends Command {
    public Robot target;
    public LeftCommand(List<String> arg) {
        super("left", arg);
        Robot target = new Robot();
        execute(target);
    }

    @Override
    public String execute(Robot target) {
        String result = "OK";
        String message = "Done";
        JSONObject response;
        Direction newDirection = pickDirection(target);

        target.setCurrentDirection(newDirection);

        response = Response.createLeftResponse(target, result, message);
        System.out.println(response);
        return response.toString();
    }

    private Direction pickDirection(Robot target) {
        Direction newDirection;
        if (Direction.NORTH.equals(target.getCurrentDirection())) {
            newDirection = Direction.WEST;
        } else if (Direction.EAST.equals(target.getCurrentDirection())) {
            newDirection = Direction.NORTH;
        } else if (Direction.SOUTH.equals(target.getCurrentDirection())) {
            newDirection = Direction.EAST;
        } else {
            newDirection = Direction.SOUTH;
        }
        return newDirection;
    }
}
