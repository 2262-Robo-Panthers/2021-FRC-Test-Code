package frc.robot.parts;

import frc.robot.settings.RobotInterfaceSettings;
import frc.robot.settings.Settings;

public class RobotInterface {
    Settings settings;
    RobotInterfaceSettings robotInterfaceSettings;
    Hardware hardware;
    Drive drive;
    Climb climb;
    Conveyor conveyor;

    RobotInterface() {
        construct(new Settings());
    }

    RobotInterface(Settings settings) {
        construct(settings);
    }

    private void construct(Settings settings) {
        this.settings = settings;
        robotInterfaceSettings = settings.robotInterfaceSettings;
        hardware = new Hardware(settings.hardwareSettings);
        if(settings.usageSettings.useDrive) drive = new Drive(settings.driveSettings);
        if(settings.usageSettings.useClimb) climb = new Climb(settings.climbSettings);
        if(settings.usageSettings.useConveyor) conveyor = new Conveyor(settings.conveyorSettings);
    }

    public void init() {

    }
}