package za.co.wethinkcode.robotworlds.Server.Commands;

import org.json.JSONObject;
import za.co.wethinkcode.robotworlds.Server.World.IWorld.IWorld;
import za.co.wethinkcode.robotworlds.Server.World.Response;
import za.co.wethinkcode.robotworlds.Server.World.Robot;

import java.util.List;

public class ForwardCommand extends Command {
    public Robot target;

    public ForwardCommand(List<String> arg) {
        super("forward", arg);
        Robot target = new Robot();
        execute(target);
    }

    @Override
    public String execute(Robot target) {
        List<String> args = getArg();
        String message;
        String result;
        JSONObject response;
        // turn string into array and then use for each loop to go through each arg
        // switch case to determine what happens for that arg - maybe not necessary
        // for forward command because there aren't many args, but for other
        // commands this will be necessary
        int distance = Integer.parseInt(args.get(0));
        IWorld.UpdateResponse updateResult = target.updatePosition(distance);

        if (updateResult == IWorld.UpdateResponse.SUCCESS) {
            message = "Done";
        } else if (updateResult == IWorld.UpdateResponse.FAILED_OUTSIDE_WORLD) {
            message = "Obstructed";
        } else {
            message = "Obstructed";
        }
        result = "OK";
        response = Response.createForwardResponse(target, result, message);
        System.out.println(response);
        return response.toString();
    }
}
