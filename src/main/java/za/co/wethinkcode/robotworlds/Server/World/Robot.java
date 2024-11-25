package za.co.wethinkcode.robotworlds.Server.World;

import za.co.wethinkcode.robotworlds.Server.World.IWorld.IWorld;

import java.util.Random;


public class Robot {
    private final String name;
    private String type;
    private static final Position TOP_LEFT = new Position(-200, 100);
    private static final Position BOTTOM_RIGHT = new Position(100, -200);
    private Position position;
    private Direction currentDirection;
    private int shieldsRemaining;
    private int shots;
    private RobotStatus status;
    private int visibility;
    private int reloadDelay;
    private int repairDelay;
    private int shieldsStart;


    public Robot() {
        this.name = "HAL";
        this.type = "normal";
        this.position = new Position(1,1);
        this.currentDirection = Direction.NORTH;
        this.shieldsStart = 5;
        this.visibility = 5;
        this.reloadDelay = 5;
        this.repairDelay = 5;
        this.shots = 5;
        this.status = RobotStatus.NORMAL;
    }

    public Robot(String name, String type, World world, int maxShieldStrength, int maxShots) {
        this.name = name;
        this.type = type;
        // this.position is random
        int x = generateRandomX();
        int y = generateRandomY();
        this.position = new Position(x, y);
        this.currentDirection = Direction.NORTH;
        /*
        if (this.type == whatever) {
        this.shields = whatever shields;
        this.shots = whatever shots;
        } else {
        this.shields = WorldSetup.shieldStrength;
        this.shots = default nr of shots;
        }
         */

//        if (!this.type.equals("normal")) {
//            this.shieldsStart = maxShieldStrength;
//            this.shots = maxShots;
//        } else {
//            this.shieldsStart = world.getShieldStrength();
//            this.shots = 5;
//        }

        this.visibility = world.getVisibility();
        this.reloadDelay = world.getWeaponReloadDelay();
        this.repairDelay = world.getShieldRepairDelay();
        this.status = RobotStatus.NORMAL;
    }

    private int generateRandomX() {
        Random rand = new Random();
        return rand.nextInt((100 - (-100) + 1) + (-100));
    }

    private int generateRandomY() {
        Random rand = new Random();
        return rand.nextInt((200 - (-200) + 1) + (-200));
    }

    public Position getPosition() {
        return position;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction newDirection) {
        this.currentDirection = newDirection;
    }

    public int getShieldsRemaining() {
        return shieldsRemaining;
    }

    public int getShots() {
        return shots;
    }

    public RobotStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getVisibility() {
        return visibility;
    }

    public int getReloadDelay() {
        return reloadDelay;
    }

    public int getRepairDelay() {
        return repairDelay;
    }

    public int getShieldsStart() {
        return shieldsStart;
    }

    // Code from Alwaba below
    public IWorld.UpdateResponse updatePosition(int nrSteps) {
        int newX = this.position.getX();
        int newY = this.position.getY();

        if (Direction.NORTH.equals(this.currentDirection)) { //if up and command = forward then + else - (?)
            newY = newY + nrSteps;
        }
        if (Direction.SOUTH.equals(this.currentDirection)) {
            newY = newY - nrSteps;
        }
        if (Direction.EAST.equals(this.currentDirection)) {
            newX = newX + nrSteps;
        }
        if (Direction.WEST.equals(this.currentDirection)) {
            newX = newX - nrSteps;
        }

        Position newPosition = new Position(newX, newY);
        if (newPosition.isIn(TOP_LEFT, BOTTOM_RIGHT)) {
            this.position = newPosition;
//            new LaunchCommand();
            return IWorld.UpdateResponse.SUCCESS;
        }
        return IWorld.UpdateResponse.FAILED_OUTSIDE_WORLD;
    }
}
