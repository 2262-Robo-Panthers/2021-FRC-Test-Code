package frc.robot.settings;

import com.ctre.phoenix.motorcontrol.NeutralMode;

public class HardwareSettings {
    //controllers
    public short XBoiPort = 0;
    public short LogiPort = 1;

    //drive
    public short driveMotor1Num = 3;
    public short driveMotor2Num = 1;
    public short driveMotor3Num = 2;
    public short driveMotor4Num = 0;
    public boolean[] flipDriveMotors = {false, false, false, false};
    public NeutralMode driveNeutralMode = NeutralMode.Coast;
    public double driveOpenLoopRampTime = 0.5;
}
