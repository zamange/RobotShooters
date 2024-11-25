package za.co.wethinkcode.robotworlds.Server.Commands;

import za.co.wethinkcode.robotworlds.Server.World.Robot;

import java.util.List;

public class FireCommand extends Command {
    public FireCommand(List<String> arg) {
        super("fire", arg);
    }

    @Override
    public String execute(Robot target) {
        return "false";
    }
}
