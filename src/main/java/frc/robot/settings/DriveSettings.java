package frc.robot.settings;

public class DriveSettings {
    public DriveMode driveMode = DriveMode.TANK;

    public enum DriveMode {
        MECANUM, TANK, OMNI
    }
}