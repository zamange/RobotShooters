package za.co.wethinkcode.robotworlds.Server.ServerManager;

import za.co.wethinkcode.robotworlds.Server.Obstacles.Obstacle;
import za.co.wethinkcode.robotworlds.Server.Obstacles.SquareObstacle;
import za.co.wethinkcode.robotworlds.Server.SaabirahServer.RobotServer;
import za.co.wethinkcode.robotworlds.Server.World.Robot;
import za.co.wethinkcode.robotworlds.Server.World.World;

public class DumpCommand extends ServerCommands{

    private int height;
    private int width;
    private int visibility;
    private SquareObstacle obstacles;


    public DumpCommand() {
        this.height = World.getWorldHeight();
        this.width = World.getWorldWidth();
        visibility = World.getVisibility();
        dump();
    }

    public boolean execute(Robot target) {
        return true;
    }

    public String dump(){

        System.out.println("Server Details..\n");

        String dump = "";

        dump += "\nWorld height: "+ height;
        dump += "\nWorld width: "+ width;
        dump += "\nWorld area: "+ height * width;
        dump += "\nArea visible to robot: " + visibility;
        dump += "\n";

        if (RobotServer.getClientRobots().isEmpty()){
            System.out.println("No robots connected!\n");
        } else {
            for (RobotServer robot : RobotServer.getClientRobots())
            dump += "\nConnect clients..\nRobot username: " + robot.robotName;

        }

        System.out.println(String.valueOf(dump));
        return dump;
    }

}
