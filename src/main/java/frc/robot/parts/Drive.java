package frc.robot.parts;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.settings.DriveSettings;

public class Drive {
    RobotInterface robotInterface;
    DriveSettings driveSettings;

    Drive(RobotInterface robotInterface) {
        this.robotInterface = robotInterface;
        driveSettings = new DriveSettings();
    }

    Drive(RobotInterface robotInterface, DriveSettings driveSettings) {
        this.robotInterface = robotInterface;
        this.driveSettings = driveSettings;
    }

    public void init(){}

    public void moveForTeleOp(boolean telemetry){
        moveRobot(driveSettings.driveXSupplier.apply(robotInterface.hardware.XBoi), driveSettings.driveYSupplier.apply(robotInterface.hardware.XBoi), driveSettings.driveRSupplier.apply(robotInterface.hardware.XBoi));
        if(telemetry)
            addTelemetry();
    }

    void addTelemetry(){
        SmartDashboard.putNumber("xSupplier", driveSettings.driveXSupplier.apply(robotInterface.hardware.XBoi));
        SmartDashboard.putNumber("ySupplier", driveSettings.driveYSupplier.apply(robotInterface.hardware.XBoi));
        SmartDashboard.putNumber("rSupplier", driveSettings.driveRSupplier.apply(robotInterface.hardware.XBoi));
    }

    double[] getRobotMovePowers(double X, double Y, double R, DriveSettings.DriveMode driveMode, boolean cap) {
        //get motor powers
        double[] arr = new double[4];
        if (driveMode == DriveSettings.DriveMode.TANK) {
            arr[0] = X + R;
            arr[1] = X - R;
            arr[2] = X + R;
            arr[3] = X - R;
        } else if (driveMode == DriveSettings.DriveMode.MECANUM) {
            arr[0] = X + Y + R;
            arr[1] = -X + Y - R;
            arr[2] = -X + Y + R;
            arr[3] = X + Y - R;
        } else if (driveMode == DriveSettings.DriveMode.OMNI) {
            //expiremental
            arr[0] = Y + R;
            arr[1] = X + R;
            arr[2] = Y - R;
            arr[3] = X - R;
        }

        if(cap){
            //get highest power
            double high = 0;
            for(double val:arr){
                if(Math.abs(val) > high) high = Math.abs(val);
            }
            //range to -1 to 1
            if(high > 1){
                for(int i = 0; i < 4; i++){
                    arr[i] /= high;
                }
            }
        }

        return arr;
    }

    double[] getRobotMovePowers(double X, double Y, double R){
        return getRobotMovePowers(X, Y, R, driveSettings.driveMode, true);
    }

    void moveRobot(double X, double Y, double R, DriveSettings.DriveMode driveMode, boolean cap){
        robotInterface.hardware.setMethodOnObjectsAdv(robotInterface.hardware.driveMotors, "set", new Class[]{Double.class}, getRobotMovePowers(X, Y, R, driveMode, cap));
    }

    void moveRobot(double X, double Y, double R){
        moveRobot(X, Y, R, driveSettings.driveMode, true);
    }
}