package frc.robot.settings;

public class UsageSettings {
    public boolean useDrive;
    public boolean useClimb;
    public boolean useConveyor;

    UsageSettings() {
        setAllToValue(true);
    }

    UsageSettings(boolean value) {
        setAllToValue(value);
    }

    UsageSettings(boolean useDrive, boolean useClimb, boolean useConveyor) {
        this.useDrive = useDrive;
        this.useClimb = useClimb;
        this.useConveyor = useConveyor;
    }

    public void setAllToValue(boolean value) {
        useDrive = value;
        useClimb = value;
        useConveyor = value;
    }
}