package frc.robot.other;

import java.util.Hashtable;

public class Utils {
    public static class Misc{
        /**
         * tells you how many tasks there are with the same name in allTasks
         * @param name the name you want to check
         * @return how many tasks there are with the same name
         */
        public static  <E> int getNumOfSameName(Hashtable<String, E> table, String name){
            String nameOg = name;
            int count = 0;
            while(table.get(name) != null){
                count++;
                name = nameOg + "(" + count + ")";
            }
            return count;
        }

        public static <E> String getAvailableName(Hashtable<String,E> table, String name){
            int c = getNumOfSameName(table, name);
            if(c != 0) name = name + "(" + c + ")";
            return name;
        }
    }

    public static class Math {
        public static double findAngleError(double currentAngle, double targetAngle)
        {
            targetAngle = scaleAngle(targetAngle);
            double angleError = currentAngle - targetAngle;
            if (angleError > 180) {
                angleError -= 360;
            } else if (angleError < -180) {
                angleError += 360;
            }
            return angleError;  //LK -
        }

        public static double scaleAngle(double angle)// scales an angle to fit in -180 to 180
        {
            if (angle > 180) { return angle - 360; }
            if (angle < -180) { return angle + 360; }
            return angle;
        }

        public static double getAngleFromXY(double X, double Y)
        {
            return java.lang.Math.atan2(X, Y)*(180 / java.lang.Math.PI);
        }

        public static double[] getXYFromAngle(double angle)
        {
            // deg to rad
            angle /= (180 / java.lang.Math.PI);

            //rad to X,Y
            double[] XY = new double[2];
            XY[0] = java.lang.Math.sin(angle);
            XY[1] = java.lang.Math.cos(angle);
            double total = java.lang.Math.abs(XY[0]) + java.lang.Math.abs(XY[1]);
            XY[0] /= total;
            XY[1] /= total;

            return XY;
        }

        public static int capInt(int val, int min, int max){
            return (val < min) ? min : (val > max) ? max : val;
        }

        public static double capDouble(double val, double min, double max){
            return (val < min) ? min : (val > max) ? max : val;
        }

        public static int getSign(double val){
            return val < 0 ? -1 : 1;
        }

        public static int getSign(float val){
            return val < 0 ? -1 : 1;
        }

        public static int getSign(int val){
            return val < 0 ? -1 : 1;
        }
    }
}
