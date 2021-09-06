package frc.robot.other;

public class Input {

    String methodName;
    Object[] params;
    Class[] paramClasses;
    Object controller;
    
    public Input(Object controller, String method){
        this.controller = controller;
        methodName = method;
    }

    public Input(String method){
        methodName = method;
    }

    public Input(Object controller, String method, Object... params){
        this.controller = controller;
        methodName = method;
        this.params = params;
        paramClasses = Utils.getObjectClasses(params);
    }

    public Input(String method, Object... params){
        methodName = method;
        this.params = params;
        paramClasses = Utils.getObjectClasses(params);
    }

    public Object getValue(Object controller){
        try{
            if(params == null)
                return controller.getClass().getMethod(methodName).invoke(controller);
            else
                return controller.getClass().getMethod(methodName, paramClasses).invoke(controller, params);

        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Object getValue(){
        return getValue(controller);
    }

    ///////////////
    //peset enums//
    ///////////////
    public enum ControllerButtons {
        A("getAButton"),
        B("getBButton"),
        X("getXButton"),
        Y("getYButton"),

        BACK("getBackButton"),
        START("getStartButton"),
        BUMPER("getBumper"),
        STICK_BUTTON("getStickButton");

        public String method;
        
        ControllerButtons(String name){
            method = name;
        }
    }

    public enum ControllerAxis {
        X("getX"),
        Y("getY"),
        TRIGGER("getTriggerAxis");

        public String method;
        
        ControllerAxis(String name){
            method = name;
        }
    }

    public enum ButtonModifier{
        PRESSED("Pressed"),
        RELEASED("Released"),
        NONE("");

        String modifier;

        ButtonModifier(String name){
            modifier = name;
        }
    }
}
