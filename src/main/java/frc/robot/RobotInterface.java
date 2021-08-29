package frc.robot;

public class RobotInterface {
    Drive drive;
    Settings settings;

    RobotInterface(Settings settings){
        this.settings = settings;
        this.drive = new Drive(this, settings.driveSettings);
    }
}

class RobotInterfaceSettings {
}