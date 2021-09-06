package frc.robot.settings;

public class UsageSettings {
    public boolean useDrive;
    public boolean useClimb;
    public boolean useConveyor;
    public boolean useLauncher;

    UsageSettings() {
        setAllToValue(true);
    }

    UsageSettings(boolean value) {
        setAllToValue(value);
    }

    UsageSettings(boolean useDrive, boolean useClimb, boolean useConveyor, boolean useLauncher) {
        this.useDrive = useDrive;
        this.useClimb = useClimb;
        this.useConveyor = useConveyor;
        this.useLauncher = useLauncher;
    }

    public void setAllToValue(boolean value) {
        useDrive = value;
        useClimb = value;
        useConveyor = value;
        useLauncher = value;
    }
}