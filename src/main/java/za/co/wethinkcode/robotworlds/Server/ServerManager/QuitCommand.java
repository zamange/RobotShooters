package za.co.wethinkcode.robotworlds.Server.ServerManager;


public class QuitCommand extends ServerCommands{

    public QuitCommand() {
        execute();
    }


    public void execute() {
        System.out.println("Shutting Down The Server...");
        System.exit(0);
    }
}
