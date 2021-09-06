package frc.robot.settings;

public class Settings {
    public RobotInterfaceSettings robotInterfaceSettings;
    public UsageSettings usageSettings;
    public HardwareSettings hardwareSettings;
    public DriveSettings driveSettings;
    public ClimbSettings climbSettings;
    public ConveyorSettings conveyorSettings;
    public LauncherSettings launcherSettings;

    public Settings() {
        robotInterfaceSettings = new RobotInterfaceSettings();
        usageSettings = new UsageSettings();
        hardwareSettings = new HardwareSettings();
        driveSettings = new DriveSettings();
        climbSettings = new ClimbSettings();
        conveyorSettings = new ConveyorSettings();
    }

    public Settings(RobotInterfaceSettings robotInterfaceSettings, UsageSettings usageSettings, HardwareSettings hardwareSettings, DriveSettings driveSettings, ClimbSettings climbSettings, ConveyorSettings conveyorSettings) {
        this.robotInterfaceSettings = robotInterfaceSettings;
        this.usageSettings = usageSettings;
        this.hardwareSettings = hardwareSettings;
        this.driveSettings = driveSettings;
        this.climbSettings = climbSettings;
        this.conveyorSettings = conveyorSettings;
    }
}
