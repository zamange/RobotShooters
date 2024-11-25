package za.co.wethinkcode.robotworlds.Server.Commands;

import org.json.JSONObject;
import za.co.wethinkcode.robotworlds.Server.World.Direction;
import za.co.wethinkcode.robotworlds.Server.World.Response;
import za.co.wethinkcode.robotworlds.Server.World.Robot;

import java.util.List;

public class RightCommand extends Command {
    public Robot target;
    public RightCommand(List<String> arg) {

        super("right", arg);
        Robot target = new Robot();
        execute(target);
    }

    @Override
    public String execute(Robot target) {
        JSONObject response;
        String result = "OK";
        String message = "Done";
        Direction newDirection = pickDirection(target);

        target.setCurrentDirection(newDirection);

        response = Response.createRightResponse(target, result, message);
        System.out.println(response);
        return response.toString();
    }

    private Direction pickDirection(Robot target) {
        Direction newDirection;
        if (Direction.NORTH.equals(target.getCurrentDirection())) {
            newDirection = Direction.EAST;
        } else if (Direction.EAST.equals(target.getCurrentDirection())) {
            newDirection = Direction.SOUTH;
        } else if (Direction.SOUTH.equals(target.getCurrentDirection())) {
            newDirection = Direction.WEST;
        } else {
            newDirection = Direction.NORTH;
        }
        return newDirection;
    }
}
