package za.co.wethinkcode.robotworlds.Server.Commands;

import za.co.wethinkcode.robotworlds.Server.World.Robot;

import java.util.List;

public class RepairCommand extends Command {
    public Robot target;
    public RepairCommand(List<String> arg) {
        super("repair", arg);
    }

    @Override
    public String execute(Robot target) {
        return "false";
    }
}
