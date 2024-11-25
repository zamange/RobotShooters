package za.co.wethinkcode.robotworlds.Server.Commands;

import org.json.JSONObject;
import za.co.wethinkcode.robotworlds.Server.World.Response;
import za.co.wethinkcode.robotworlds.Server.World.Robot;
import za.co.wethinkcode.robotworlds.Server.World.World;

import java.util.List;

public class LaunchCommand extends Command {
    public Robot target;

    public LaunchCommand(List<String> arg) {
        super("launch", arg);
        Robot target = new Robot();
        execute(target);
    }

    @Override
    public String execute(Robot target) {
        String typeOfRobot;
        int maxShieldStrength;
        int maxShots;
        World world = new World();
        JSONObject response;
        List<String> args = getArg();

        typeOfRobot = args.get(0);

        if (args.size() > 1) {
            maxShieldStrength = Integer.parseInt(args.get(1));
            maxShots = Integer.parseInt(args.get(2));
        } else {
            maxShieldStrength = world.getShieldStrength();
            maxShots = target.getShots();
        }


        Robot robot = new Robot("name of robot", typeOfRobot, world, maxShieldStrength, maxShots);
        response = Response.createLaunchResponse(target);
        System.out.println(response);
        return response.toString();
    }

}
