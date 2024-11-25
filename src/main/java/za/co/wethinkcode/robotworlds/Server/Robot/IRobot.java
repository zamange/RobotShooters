package za.co.wethinkcode.robotworlds.Server.Robot;

import za.co.wethinkcode.robotworlds.Server.Communication.StateData;
import za.co.wethinkcode.robotworlds.Server.Commands.Command;
import za.co.wethinkcode.robotworlds.Server.World.Direction;
import za.co.wethinkcode.robotworlds.Server.World.IWorld.AbstractWorld;
import za.co.wethinkcode.robotworlds.Server.World.IWorld.IWorld;
import za.co.wethinkcode.robotworlds.Server.World.Position;

/**
 * Interface to use for robot classes.
 */
public interface IRobot {

    String getStatus();

    void setStatus(String status);

    String getName();

    String getResult();

    void setResult(String result);

    boolean handleCommand(Command command);

    void repair();

    int getCurrentShield();

    int getAmmo();

    /**
     * Updates the position of your robot in the world by moving the nrSteps in the robots current direction.
     * @param nrSteps steps to move in current direction
     * @return true if this does not take the robot over the world's limits, or into an obstacle.
     */
    IWorld.UpdateResponse updatePosition(int nrSteps);

    /**
     * Updates the current direction your robot is facing in the world by cycling through the directions UP, RIGHT, BOTTOM, LEFT.
     * @param turnRight if true, then turn 90 degrees to the right, else turn left.
     */
    void updateDirection(boolean turnRight);

    /**
     * Retrieves the current position of the robot
     */
    Position getPosition();

    /**
     * Gets the current direction the robot is facing in relation to a world edge.
     * @return Direction.UP, RIGHT, DOWN, or LEFT
     */
    Direction getCurrentDirection();

    void setMessage(String message);

    void reload();

    void takeDamage(int damage);

    String getMessage();

    AbstractWorld getWorld();

    int getRange();

    void setDistanceofRobotHit(Integer distance);

    void setRobotHitName(String name);

    void setStateOfRobotHit(StateData stateOfRobotHit);

    void shoot();

    String getRobotHitName();

    StateData getStateOfRobotHit();

    Integer getDistanceofRobotHit();

    Position movePosition(int move);

    IWorld.UpdateResponse checkIfBlocked(Position position);

}

