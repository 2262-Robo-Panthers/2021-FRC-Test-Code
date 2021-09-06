package frc.robot.settings;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class HardwareSettings {
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
    public short rollerID = 6;
    public short intakeID = 7;
    public NeutralMode intakeNeutralMode = NeutralMode.Brake;

    //Launcher
    public short hoodEncoderNum1 = 2;
    public short hoodEncoderNum2 = 3;
    public short flywheelID = 8;
    public boolean flipFlywheel = true;
    public IdleMode flywheelIdleMode = IdleMode.kCoast;
    public MotorType flywheelMotorType = MotorType.kBrushless;
    public short hoodID = 5;

    //Climb
    public short climbId = 4;
    public MotorType climbMotorType = MotorType.kBrushed;
    public short climbLimitChannel = 6;

    //Other
    public short airCompressorModule = 9;
    
    //Controllers
    public short XBoiPort = 0;
    public short LogiPort = 1;
}
