package za.co.wethinkcode.robotworlds.Server.World;

import org.json.JSONObject;
import za.co.wethinkcode.robotworlds.Server.Obstacles.Obstacle;
import za.co.wethinkcode.robotworlds.Server.World.IWorld.AbstractWorld;

import java.util.ArrayList;
import java.util.List;

public class World extends AbstractWorld {
    private List<Obstacle> obstaclesInWorld;
    private static List<Robot> robotsInWorld;

    // needs to generate random square obstacles
    // needs to know what robots are in it
        // add to this list in launch command
        // remove from this list in client quit command
    private static int worldWidth;
    private static int worldHeight;
    private static int visibility;
    private int shieldStrength;
    private int shieldRepairDelay;
    private int weaponReloadDelay;

    public World() {
        JSONObject data = WorldConfig.extractDataFromConfigFile();
        this.obstaclesInWorld = new ArrayList<>();
        this.robotsInWorld = new ArrayList<>();
        if (data != null) {
            this.worldWidth = Integer.parseInt(data.get("world_width").toString());
            this.worldHeight = Integer.parseInt(data.get("world_height").toString());
            this.visibility = Integer.parseInt(data.get("visibility").toString());
            this.shieldStrength = Integer.parseInt(data.get("shield_strength").toString());
            this.shieldRepairDelay = Integer.parseInt(data.get("repair_delay").toString());
            this.weaponReloadDelay = Integer.parseInt(data.get("reload_delay").toString());
        } else {
            System.out.println("World unable to be constructed.");
        }
    }

    public List<Obstacle> getObstaclesInWorld() {
        return obstaclesInWorld;
    }

    public void setObstaclesInWorld(List<Obstacle> obstaclesInWorld) {
        this.obstaclesInWorld = obstaclesInWorld;
    }

    public List<Robot> getRobotsInWorld() {
        return robotsInWorld;
    }

    public void setRobotsInWorld(List<Robot> robotsInWorld) {
        this.robotsInWorld = robotsInWorld;
    }

    public static int getWorldWidth() {
        return worldWidth;
    }


    public void setWorldHeight() {
        worldHeight = worldHeight;
    }


    public static int getWorldHeight() {
        return worldHeight;
    }


    public static int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        World.visibility = visibility;
    }
    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    public int getShieldRepairDelay() {
        return shieldRepairDelay;
    }

    public void setShieldRepairDelay(int shieldRepairDelay) {
        this.shieldRepairDelay = shieldRepairDelay;
    }

    public int getWeaponReloadDelay() {
        return weaponReloadDelay;
    }

    public void setWeaponReloadDelay(int weaponReloadDelay) {
        this.weaponReloadDelay = weaponReloadDelay;
    }

//    public static void main(String[] args) {
//        World world = new World();
//
//        System.out.println("World width: "+ world.worldWidth + " steps");
//        System.out.println("World height: " + world.worldHeight + " steps");
//        System.out.println("Area visible to robot: " + world.visibility + " steps");
//        System.out.println("Shield strength: " + world.shieldStrength + " hits");
//        System.out.println("Shield repair delay: " + world.shieldRepairDelay + " seconds");
//        System.out.println("Weapon reload delay: " + world.weaponReloadDelay + " seconds");
//}
}
