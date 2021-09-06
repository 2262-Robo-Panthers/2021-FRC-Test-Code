package frc.robot.settings;

import java.util.function.Function;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.other.Input;

public class DriveSettings {
    public DriveMode driveMode = DriveMode.TANK;
    private Input yInput1 = new Input(Input.ControllerAxis.TRIGGER.method, Hand.kRight);
    private Input yInput2 = new Input(Input.ControllerAxis.TRIGGER.method, Hand.kLeft);
    private Input rInput = new Input(Input.ControllerAxis.X.method, Hand.kLeft);
    public Function<XboxController, Double> driveXSupplier = (c) -> (0.0);
    public Function<XboxController, Double> driveYSupplier = (c) -> ((Double)yInput1.getValue(c) - (Double)yInput2.getValue(c));
    public Function<XboxController, Double> driveRSupplier = (c) -> ((Double)rInput.getValue(c));

    public enum DriveMode {
        MECANUM, TANK, OMNI
    }
}