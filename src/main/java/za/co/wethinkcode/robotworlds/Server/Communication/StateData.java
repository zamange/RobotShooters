package za.co.wethinkcode.robotworlds.Server.Communication;

import za.co.wethinkcode.robotworlds.Server.Robot.IRobot;

public class StateData {
    private int[] position;
    private  String direction;
    private int shields;
    private int shots;
    private String status;

    public StateData(IRobot robot) {
        this.position = new int[2];

        position[0] = robot.getPosition().getX();
        position[1] = robot.getPosition().getY();

        this.direction = robot.getCurrentDirection().toString();
        this.shields = robot.getCurrentShield();
        this.shots = robot.getAmmo();
        this.status = robot.getStatus();
        if (robot.getCurrentShield() < 0){
            this.status = "DEAD";
        }

    }
}
