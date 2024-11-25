package za.co.wethinkcode.robotworlds.Server.World.IWorld;

import za.co.wethinkcode.robotworlds.Server.Communication.DataObject;

import za.co.wethinkcode.robotworlds.Server.Robot.IRobot;
//import za.co.wethinkcode.robotworlds.server.ServerConfig;
import za.co.wethinkcode.robotworlds.Server.World.Position;


import java.util.List;

public interface IWorld {
    List<DataObject> getObjects(IRobot robot);

    /**
     * Enum used to track direction
     */
//    enum Direction {
//        NORTH, EAST, SOUTH, WEST;
//
//        static
//        public final Direction[] values = values();
//
//        /**
//         * Return the previous direction as on a 4-point compass.
//         * @return the previous direction
//         */
//        public Direction prev() {
//            return values[Math.floorMod(ordinal() - 1, values.length)];
//        }
//
//        /**
//         * Return the next direction as on a 4-point compass.
//         * @return the next direction
//         */
//        public Direction next() {
//            return values[Math.floorMod(ordinal() + 1, values.length)];
//        }
//    }

    /**
     * Enum that indicates response for updatePosition request
     */
    enum UpdateResponse {
        SUCCESS, //position was updated successfully
        FAILED_MINE, //robot hit mine
        FAILED_OUTSIDE_WORLD,
        FAILED_OBSTRUCTED
    }

    Position CENTRE = new Position(0,0);



    /**
     * Checks if the new position will be allowed, i.e. falls within the constraints of the world, and does not overlap an obstacle.
     * @param position the position to check
     * @return true if it is allowed, else false
     */
    boolean isNewPositionAllowed(Position position);

    /**
     * Checks if the robot is at one of the edges of the world
     * @return true if the robot's current is on one of the 4 edges of the world
     */
    boolean isAtEdge(IRobot robot);



//    ServerConfig getConfig();

}
