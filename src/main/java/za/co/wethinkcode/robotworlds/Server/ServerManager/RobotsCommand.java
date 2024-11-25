package za.co.wethinkcode.robotworlds.Server.ServerManager;

import za.co.wethinkcode.robotworlds.Server.SaabirahServer.RobotServer;

import java.util.List;

public class RobotsCommand extends ServerCommands {

    protected RobotsCommand() {
        execute();
    }


    public void execute() {

        List<RobotServer> robotList = RobotServer.getClientRobots();
        String output = "List of robots.. \n";


        if (robotList.size() == 0) {
            System.out.println("No robots connected!");
        } else if (robotList.size() >= 1) {
            for (int i = 0; i < robotList.size(); i++) {

                if (!robotList.get(i).robotName.equals("")) {
                    output += "Client name: " + robotList.get(i).robotName + "\n";
                }
            }
            System.out.println(output);


        }
    }
}
