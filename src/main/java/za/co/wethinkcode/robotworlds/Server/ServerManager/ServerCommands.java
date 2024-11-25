package za.co.wethinkcode.robotworlds.Server.ServerManager;

public abstract class ServerCommands {


    public static void create(String instruction){

        switch (instruction) {
            case "quit":
                new QuitCommand();
                return;
            case "robot":
                new RobotsCommand();
                return;
            case "dump":
                new DumpCommand();
                return;
            default:
                throw new IllegalArgumentException("Not a valid command: " + instruction);
        }


    }
}