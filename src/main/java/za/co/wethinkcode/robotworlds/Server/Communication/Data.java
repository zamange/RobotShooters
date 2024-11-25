package za.co.wethinkcode.robotworlds.Server.Communication;

import za.co.wethinkcode.robotworlds.Server.Robot.IRobot;

import java.util.List;

public class Data {
    private String message = null;
    private Integer[] position;
    private Integer visibility;
    private Integer reload;
    private Integer repair;
    private Integer mine;
    private Integer shields;
    private List<DataObject> objects;
    private Integer distance;
    private String robot;
    private StateData state;

    /**
     * PROCESSING THE ROBOTS DATA IN THE WORLD
     * @param robot
     * @param command
     */
    public Data(IRobot robot, String command){

        if (command.equalsIgnoreCase("launch")) {
            this.position = new Integer[2];
            position[0] = robot.getPosition().getX();
            position[1] = robot.getPosition().getY();

//            this.visibility = robot.getWorld().getConfig().getVisibility();
//            this.reload = robot.getWorld().getConfig().getReload();
//            this.repair = robot.getWorld().getConfig().getRepair();
//            this.mine =robot.getWorld().getConfig().getMine();
//            this.shields =robot.getWorld().getConfig().getShields();

        }
        else if (command.equalsIgnoreCase("look")) {
            objects = robot.getWorld().getObjects(robot);
        }
        else if (command.equalsIgnoreCase("fire") && robot.getMessage().equalsIgnoreCase("Hit")) {
            this.message = robot.getMessage();
            this.robot = robot.getRobotHitName();
            this.distance = robot.getDistanceofRobotHit();
            this.state = robot.getStateOfRobotHit();
        }
        else{
            this.message = robot.getMessage();
        }
    }

    public Data(String msg) {
        this.message = msg;
    }

}