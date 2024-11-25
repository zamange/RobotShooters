//package za.co.wethinkcode.robotworlds.server.Robot;
//
//
//
//import za.co.wethinkcode.robotworlds.server.Communication.StateData;
//import za.co.wethinkcode.robotworlds.server.world.Direction;
//import za.co.wethinkcode.robotworlds.server.world.IWorld.AbstractWorld;
//import za.co.wethinkcode.robotworlds.server.world.IWorld.IWorld;
//import za.co.wethinkcode.robotworlds.server.world.Position;
//
//import java.util.Random;
//
//public abstract class AbstractRobot implements IRobot {
//    private String status;
//    private String message;
//    private final String name;
//    private final AbstractWorld world;
//    private String result;
//    private final int maxShield;
//    private int currentShield;
//    private Position position;
//    private Direction currentDirection;
//
//    private Integer distanceofRobotHit;
//    private String robotHitName;
//    private StateData stateOfRobotHit;
//
//    public static final Position TOP_LEFT = new Position(-100,200);
//    public static final Position BOTTOM_RIGHT = new Position(100,-200);
//    private final Random random = new Random();
//
//    public AbstractRobot(String name, AbstractWorld world, int maxShield) {
//        this.status = "NORMAL";
//        this.name = name;
//        this.world = world;
//        this.maxShield = maxShield;
//        currentShield = maxShield;
//        this.position = setStart();
//        this.currentDirection = setDirection();
//    }
//
//    /**
//     * Updates the position of your robot in the world by moving the nrSteps in the robots current direction.
//     * @param nrSteps steps to move in current direction
//     * @return true if this does not take the robot over the world's limits, or into an obstacle.
//     */
//    public IWorld.UpdateResponse updatePosition(int nrSteps) {
//
//        int move = 1;
//
//        if (nrSteps < 0){
//            move = -1;
//        }
//
//        for (int i = 0; i < Math.abs(nrSteps); i++){
//
//            Position newPosition = movePosition(move);
//
//            IWorld.UpdateResponse isAllowed = checkIfBlocked(newPosition);
//
//            if (!isAllowed.equals(IWorld.UpdateResponse.SUCCESS)){
//                if (isAllowed.equals(IWorld.UpdateResponse.FAILED_MINE)){
//                    position = newPosition;
//                }
//                return isAllowed;
//            }
//            position = newPosition;
//        }
//
//        return IWorld.UpdateResponse.SUCCESS;
//
//    }
//
//    public Position movePosition(int move){
//        int newX = position.getX();
//        int newY = position.getY();
//
//        if (IWorld.Direction.NORTH.equals(getCurrentDirection())) {
//            newY = newY + move;
//        } else if (IWorld.Direction.SOUTH.equals(getCurrentDirection())) {
//            newY = newY - move;
//        } else if (IWorld.Direction.EAST.equals(getCurrentDirection())) {
//            newX = newX + move;
//        } else if (IWorld.Direction.WEST.equals(getCurrentDirection())) {
//            newX = newX - move;
//        }
//        return new Position(newX, newY);
//    }
//
//
//
//    /**
//     * Updates the current direction your robot is facing in the world by cycling
//     * through the directions UP, RIGHT, BOTTOM, LEFT.
//     * @param turnRight if true, then turn 90 degrees to the right, else turn left.
//     */
//    public void updateDirection(boolean turnRight) {
//        if (turnRight) {
//            this.currentDirection = getCurrentDirection().next();
//        } else {
//            this.currentDirection = getCurrentDirection().prev();
//        }
//    }
//
//    private Position setStart(){
//
//        int x = random.nextInt(BOTTOM_RIGHT.getX()-TOP_LEFT.getX()) - BOTTOM_RIGHT.getX();
//        int y = random.nextInt(TOP_LEFT.getY()-BOTTOM_RIGHT.getY()) - TOP_LEFT.getY();
//
//        if (!checkIfBlocked(new Position(x,y)).equals(IWorld.UpdateResponse.SUCCESS)) {
//            return setStart();
//        }
//        return new Position(x,y);
//    }
//
//    private IWorld.Direction setDirection(){
//        IWorld.Direction[] directions = IWorld.Direction.values();
//        return directions[random.nextInt(directions.length)];
//    }
//
//    public Position getPosition() {
//        return position;
//    }
//
//    public IWorld.Direction getCurrentDirection() {
//        return currentDirection;
//    }
//
//    public void repair() {
//        this.currentShield = maxShield;
//    }
//
//    public void takeDamage(int damage){
//        currentShield = currentShield - damage;
//        if (currentShield < 0){
//            setStatus("DEAD");
//        }
//    }
//
//    public int getCurrentShield() {
//        return this.currentShield;
//    }
//
//    public AbstractWorld getWorld() {
//        return world;
//    }
//
//    public void setMessage(String message) { this.message = message; }
//
//    public String getMessage() {
//        return this.message;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getStatus() {
//        return this.status;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setResult(String result) {
//        this.result = result;
//    }
//
//    public String getResult() {
//        return result;
//    }
//
//    public void setDistanceofRobotHit(Integer distanceofRobotHit) {
//        this.distanceofRobotHit = distanceofRobotHit;
//    }
//
//    public void setRobotHitName(String robotHitName) {
//        this.robotHitName = robotHitName;
//    }
//
//    public void setStateOfRobotHit(StateData stateOfRobotHit) {
//        this.stateOfRobotHit = stateOfRobotHit;
//    }
//
//    public Integer getDistanceofRobotHit() {
//        return distanceofRobotHit;
//    }
//
//    public String getRobotHitName() {
//        return robotHitName;
//    }
//
//    public StateData getStateOfRobotHit() {
//        return stateOfRobotHit;
//    }
//
//    /**
//     * Run the command given.
//     * @param command the given command
//     * @return true if the command was executed
//     */
//    public boolean handleCommand(Command command) {
//        return command.execute(this);
//    }
//
//    /**
//     * Create a dump of the robot's position and status.
//     * @return a string of the robot's information
//     */
//    @Override
//    public String toString() {
//        if (this.status.contains("[")){  //previous command has already output necessary data
//            return this.status;
//        } else {
//            return "[" + getPosition().getX() + "," + getPosition().getY() + "] "
//                    + this.name + "> " + this.status;
//        }
//    }
//
//    public abstract void reload();
//
//    public abstract void shoot();
//
//    public abstract int getAmmo();
//
//    public abstract int getRange();
//
//}
//
