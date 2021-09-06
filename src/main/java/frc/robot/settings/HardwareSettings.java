package frc.robot.settings;

import com.ctre.phoenix.motorcontrol.NeutralMode;

public class HardwareSettings {
    //Controllers
    public short XBoiPort = 0;
    public short LogiPort = 1;

    //Drive
    public short driveMotor1Num = 3;
    public short driveMotor2Num = 1;
    public short driveMotor3Num = 2;
    public short driveMotor4Num = 0;
    public boolean[] flipDriveMotors = {false, false, false, false};
    public NeutralMode driveNeutralMode = NeutralMode.Coast;
    public double driveOpenLoopRampTime = 0.5;

    //Conveyor
    public short frontPhotoGateChannel = 0;
    public short upperPhotoGateChannel = 1;
    public short otherPhotoGateChannel = 7;
    public short upperIntakeLimitChannel = 4;
    public short lowerIntakeLimitChannel = 5;

    //Launcher
    public short hoodEncoderNum1 = 2;
    public short hoodEncoderNum2 = 3;

    //Climb
    public short climbLimitChannel = 6;

    //Other
    public short airCompressorModule = 9;
}
