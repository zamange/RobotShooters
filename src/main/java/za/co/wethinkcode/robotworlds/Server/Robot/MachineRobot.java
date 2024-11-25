//package za.co.wethinkcode.robotworlds.server.Robot;
//
//
//import za.co.wethinkcode.robotworlds.server.commands.Command;
//import za.co.wethinkcode.robotworlds.server.world.IWorld.AbstractWorld;
//import za.co.wethinkcode.robotworlds.server.world.IWorld.IWorld;
//import za.co.wethinkcode.robotworlds.server.world.Position;
//
//public class MachineRobot extends AbstractRobot {
//
//    private int range;
//    private int ammo;
//
//    /**
//     * GETTING THE ROBOT'S LIMITATIONS IF IT IS A MACHINE GUNNER CLASS
//     * @param name
//     * @param world
//     * @param maxShield
//     */
//    public MachineRobot(String name, AbstractWorld world, int maxShield) {
//        super(name, world, maxShield);
//        this.ammo = 6;
//        range = 3;
//    }
//
//    public void shoot() {
//        ammo--;
//    }
//
//    @Override
//    public IWorld.UpdateResponse checkIfBlocked(Position position) {
//        return null;
//    }
//
//    @Override
//    public IWorld.UpdateResponse checkIfBlocked(Position position) {
//        return null;
//    }
//
//    public void reload() {
//        this.ammo = 3;
//    }
//
//    public int getRange() {
//        return this.range;
//    }
//
//    @Override
//    public boolean handleCommand(Command command) {
//        return false;
//    }
//
//    public int getAmmo() {
//        return this.ammo;
//    }
//}
