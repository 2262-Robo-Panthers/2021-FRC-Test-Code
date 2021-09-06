package frc.robot.parts;

import frc.robot.settings.RobotInterfaceSettings;
import frc.robot.settings.Settings;

public class RobotInterface {
    Settings settings;
    RobotInterfaceSettings robotInterfaceSettings;
    Hardware hardware;
    public Drive drive;
    public Climb climb;
    public Conveyor conveyor;
    public Launcher launcher;

    RobotInterface() {
        construct(new Settings());
    }

    public RobotInterface(Settings settings) {
        construct(settings);
    }

    private void construct(Settings settings) {
        this.settings = settings;
        robotInterfaceSettings = settings.robotInterfaceSettings;
        hardware = new Hardware(settings.hardwareSettings);
        hardware.constructBaseHardware();

        if(settings.usageSettings.useDrive){
            hardware.constructDrive();
            drive = new Drive(this, settings.driveSettings);
        }
        if(settings.usageSettings.useClimb) climb = new Climb(settings.climbSettings);
        if(settings.usageSettings.useConveyor) conveyor = new Conveyor(settings.conveyorSettings);
    }

    public void init() {
        hardware.initBaseHardware();
        if(settings.usageSettings.useDrive){
            hardware.initDrive();
            drive.init();
        }
    }
}