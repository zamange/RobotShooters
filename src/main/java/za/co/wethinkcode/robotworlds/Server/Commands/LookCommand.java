package za.co.wethinkcode.robotworlds.Server.Commands;

import org.json.JSONObject;
import za.co.wethinkcode.robotworlds.Server.World.Robot;

import java.util.List;

public class LookCommand extends Command {
    public Robot target;
    public LookCommand(List<String> arg) {
        super("look", arg);
        Robot target = new Robot();
        execute(target);
    }

    @Override
    public String execute(Robot target) {
        String result = "OK";
        JSONObject response = new JSONObject();
        List<JSONObject> objects;
//        World world = new World(); // this shouldn't be a new world, it should be the current world?
//        objects = world.getObjects(target); // TODO: need list of objects in world
//        response = Response.createLookResponse(target, result, objects);
        System.out.println(response);
        return response.toString();
    }
}
