package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drive {
    DriveSettings driveSettings;
    RobotInterface robotInterface;

    WPI_TalonFX frontLeftMotor;
    WPI_TalonFX frontRightMotor;
    WPI_TalonFX backLeftMotor;
    WPI_TalonFX backRightMotor;
    DifferentialDrive differentialDrive;

    private final XboxController XBoi = new XboxController(0);


    Drive(RobotInterface robotInterface, DriveSettings driveSettings){
        this.robotInterface = robotInterface;
        this.driveSettings = driveSettings;
    }

    void init(){
        initMotors();
        configMotors();

        differentialDrive = new DifferentialDrive(frontLeftMotor, frontRightMotor);
    }

    void run(){
        differentialDrive.arcadeDrive(XBoi.getTriggerAxis(Hand.kLeft) - XBoi.getTriggerAxis(Hand.kRight), -XBoi.getX(Hand.kLeft));
    }

    private void initMotors(){
        frontLeftMotor = new WPI_TalonFX(driveSettings.frontLeftMotorID);
        frontRightMotor = new WPI_TalonFX(driveSettings.frontRightMotorID);
        backLeftMotor = new WPI_TalonFX(driveSettings.backLeftMotorID);
        backRightMotor = new WPI_TalonFX(driveSettings.backRightMotorID);
    }

    private void tetherMotors(){
        backLeftMotor.follow(frontLeftMotor);
        backRightMotor.follow(frontRightMotor);
    }

    private void setNutralMode(NeutralMode neutralMode){
        frontLeftMotor.setNeutralMode(neutralMode);
        frontRightMotor.setNeutralMode(neutralMode);
        backLeftMotor.setNeutralMode(neutralMode);
        backRightMotor.setNeutralMode(neutralMode);
    }

    private void configOpenloopRamp(double time){
        frontLeftMotor.configOpenloopRamp(time);
        frontRightMotor.configOpenloopRamp(time);
    }

    private void configMotors(){
        setNutralMode(driveSettings.neutralMode);
        tetherMotors();
        configOpenloopRamp(driveSettings.openLoopRampTime);
    }

}

class DriveSettings{
    short frontLeftMotorID = 3;
    short frontRightMotorID = 1;
    short backLeftMotorID = 2;
    short backRightMotorID = 0;
    NeutralMode neutralMode = NeutralMode.Coast;
    double openLoopRampTime = 0.5;
}