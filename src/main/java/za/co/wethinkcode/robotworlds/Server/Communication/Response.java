package za.co.wethinkcode.robotworlds.Server.Communication;

import za.co.wethinkcode.robotworlds.Server.Robot.IRobot;

import com.google.gson.Gson;


public class Response {

    private String result;
    private Data data;
    private StateData state;

    public Response(IRobot target, String command) {
        if (!command.equalsIgnoreCase("state")){
            this.result = "OK";
            this.data = new Data(target,command);

        }
        this.state = new StateData(target);
    }

    public Response(String errorMsg){
        this.result = "ERROR";
        data = new Data(errorMsg);

    }

    public static String createResponse(Response response) {
        Gson gson = new Gson();
        return gson.toJson(response);
    }
}
