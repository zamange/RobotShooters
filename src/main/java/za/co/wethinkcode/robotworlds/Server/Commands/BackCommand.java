package za.co.wethinkcode.robotworlds.Server.Commands;

import org.json.JSONObject;
import za.co.wethinkcode.robotworlds.Server.World.IWorld.IWorld;
import za.co.wethinkcode.robotworlds.Server.World.Response;
import za.co.wethinkcode.robotworlds.Server.World.Robot;

import java.util.List;

public class BackCommand extends Command {
    public Robot target;

    public BackCommand(List<String> arg) {
        super("back", arg);
        Robot target = new Robot();
        execute(target);
    }

    @Override
    public String execute(Robot target) {
        List<String> args = getArg();
        String message;
        String result;
        JSONObject response;
        int distance = Integer.parseInt(args.get(0));
        IWorld.UpdateResponse updateResult = target.updatePosition(-distance);

        if (updateResult == IWorld.UpdateResponse.SUCCESS) {
            message = "Done";
        } else if (updateResult == IWorld.UpdateResponse.FAILED_OUTSIDE_WORLD) {
            message = "Obstructed";
        } else {
            message = "Obstructed";
        }
        result = "OK";
        response = Response.createBackResponse(target, result, message);
        System.out.println(response);
        return response.toString();
    }
}
