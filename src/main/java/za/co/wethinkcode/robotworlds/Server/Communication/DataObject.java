package za.co.wethinkcode.robotworlds.Server.Communication;

public class DataObject {
    private String direction;
    private String type;
    private int distance;

    public DataObject(String direction, String type, int distance){
        this.direction = direction;
        this.type = type;
        this.distance = distance;
    }

    public String getDirection() {
        return direction;
    }

    public String getType() {
        return type;
    }

    public int getDistance() {
        return distance;
    }

}
