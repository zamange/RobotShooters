package za.co.wethinkcode.robotworlds.Server.World.IWorld;


import za.co.wethinkcode.robotworlds.Server.Communication.DataObject;
import za.co.wethinkcode.robotworlds.Server.Robot.IRobot;
import za.co.wethinkcode.robotworlds.Server.World.Position;
import java.util.*;

public abstract class AbstractWorld implements IWorld{

    public static Position TOP_LEFT;
    public static Position BOTTOM_RIGHT;
    public static int visibility;
    public static int reload ;
    public static int repair;


    public List<DataObject> getObjects(IRobot robot){
        List<DataObject> objects = new ArrayList<>();

        for (int i = robot.getPosition().getY(); i < robot.getPosition().getY()+visibility+1; i++){
            int distance = i-robot.getPosition().getY();
            String type = checkObjects(robot, distance, new Position(robot.getPosition().getX(),i));
            if (type != null){
                DataObject object = new DataObject("NORTH", type, distance);
                objects.add(object);
                if (type.equalsIgnoreCase("OBSTACLE") || type.equalsIgnoreCase("EDGE")){ break;}
            }
        }

        for (int i = robot.getPosition().getY(); i > robot.getPosition().getY()-visibility-1; i--){
            int distance = robot.getPosition().getY()-i;
            String type = checkObjects(robot, distance, new Position(robot.getPosition().getX(), i) {

            });
            if (type != null){
                DataObject object = new DataObject("SOUTH", type, distance);
                objects.add(object);
                if (type.equalsIgnoreCase("OBSTACLE") || type.equalsIgnoreCase("EDGE")){ break;}
            }
        }

        for (int i = robot.getPosition().getX(); i < robot.getPosition().getX()+visibility+1; i++){
            int distance = i-robot.getPosition().getX();
            String type = checkObjects(robot, distance, new Position(i, robot.getPosition().getY()));
            if (type != null){
                DataObject object = new DataObject("EAST", type, distance);
                objects.add(object);
                if (type.equalsIgnoreCase("OBSTACLE") || type.equalsIgnoreCase("EDGE")){ break;}
            }
        }

        for (int i = robot.getPosition().getX(); i > robot.getPosition().getX()-visibility-1; i--){
            int distance = robot.getPosition().getX()-i;
            String type = checkObjects(robot, distance, new Position(i, robot.getPosition().getY()));
            if (type != null){
                DataObject object = new DataObject("WEST", type, distance);
                objects.add(object);
                if (type.equalsIgnoreCase("OBSTACLE") || type.equalsIgnoreCase("EDGE")){ break;}
            }
        }

        return objects;
    }

    private String checkObjects(IRobot robot, int distance, Position position) {
        return null;
    }


    /**
     * Checks if the new position will be allowed, i.e. falls within the constraints of the world.
     * @param position the position to check
     * @return true if it is allowed, else false
     */
    public boolean isNewPositionAllowed(Position position) {
        return (position.isIn(TOP_LEFT,BOTTOM_RIGHT));
    }

    /**
     * Checks if the robot is at one of the edges of the world
     * @return true if the robot's current is on one of the 4 edges of the world
     */
    public boolean isAtEdge(IRobot robot) {
        return (robot.getPosition().getX() == TOP_LEFT.getX() ||
                robot.getPosition().getX() == BOTTOM_RIGHT.getX() ||
                robot.getPosition().getY() == TOP_LEFT.getY() ||
                robot.getPosition().getY() == BOTTOM_RIGHT.getY());
    }

    public AbstractWorld getWorld(){
        return this;
    }

}