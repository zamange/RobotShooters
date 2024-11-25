package za.co.wethinkcode.robotworlds.Server.Commands;

import za.co.wethinkcode.robotworlds.Server.World.Robot;

import java.util.ArrayList;
import java.util.List;
//
public abstract class Command {
    private final String name;
    private List<String> arg;

    public abstract String execute(Robot target);

    public Command(String name) {
        this(name, new ArrayList<>());
    }

    public Command(String name, List<String> arg) {
        this.name = name.trim().toLowerCase();
        this.arg = arg;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getArg() {
        return this.arg;
    }

    public static Command create(String command, List<String> arg) {
        switch (command.toLowerCase()) {
            case "launch":
                return new LaunchCommand(arg);
            case "state":
                return new StateCommand(arg);
            case "look":
                return new LookCommand(arg);
            case "forward":
                return new ForwardCommand(arg);
            case "back":
                return new BackCommand(arg);
            case "turn":
                if(arg.contains("left")){
                    return new LeftCommand(arg);
                }
                else {
                    return new RightCommand(arg);
                }
            case "repair":
                return new RepairCommand(arg);
            case "reload":
                return new ReloadCommand(arg);
            case "fire":
                return new FireCommand(arg);
            default:
                return null;
        }
    }
}
