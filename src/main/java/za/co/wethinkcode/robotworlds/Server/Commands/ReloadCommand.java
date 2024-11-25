package za.co.wethinkcode.robotworlds.Server.Commands;

import za.co.wethinkcode.robotworlds.Server.World.Robot;

import java.util.List;

public class ReloadCommand extends Command {
    public ReloadCommand(List<String> arg) {
        super("reload", arg);
    }

    @Override
    public String execute(Robot target) {
        return "false";
    }
}
