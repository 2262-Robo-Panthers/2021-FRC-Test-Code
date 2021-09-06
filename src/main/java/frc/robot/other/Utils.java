package frc.robot.other;

public class Utils {
    public static Class[] getObjectClasses(Object[] objects){
        Class[] classes = new Class[objects.length];
        for (int i=0; i<objects.length; i++) {
            classes[i] = objects[i].getClass();
        }
        return classes;
    }
}
