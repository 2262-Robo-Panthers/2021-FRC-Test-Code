package frc.robot.parts;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.settings.HardwareSettings;

class Hardware {
    HardwareSettings hardwareSettings;
    //contollers
    XboxController XBoi;
    Joystick Logi;
    //drive
    WPI_TalonFX driveMotor1;
    WPI_TalonFX driveMotor2;
    WPI_TalonFX driveMotor3;
    WPI_TalonFX driveMotor4;
    List<WPI_TalonFX> driveMotors;

    Hardware() {
        hardwareSettings = new HardwareSettings();
    }

    Hardware(HardwareSettings hardwareSettings) {
        this.hardwareSettings = hardwareSettings;
    }

    void initControllers(){
        XBoi = new XboxController(hardwareSettings.XBoiPort);
        Logi = new Joystick(hardwareSettings.LogiPort);
    }

    void initDrive(){
        driveMotor1 = new WPI_TalonFX(hardwareSettings.driveMotor1Num);
        driveMotor2 = new WPI_TalonFX(hardwareSettings.driveMotor2Num);
        driveMotor3 = new WPI_TalonFX(hardwareSettings.driveMotor3Num);
        driveMotor4 = new WPI_TalonFX(hardwareSettings.driveMotor4Num);

        driveMotors = Arrays.asList(driveMotor1, driveMotor2, driveMotor3, driveMotor4);

        setMotorDir(driveMotors, hardwareSettings.flipDriveMotors);
        setMotorNeutralMode(driveMotors, hardwareSettings.driveNeutralMode);
        setMotorOpenLoopRampTime(driveMotors, hardwareSettings.driveOpenLoopRampTime);
    }

    void setMotorNeutralMode(List<WPI_TalonFX> motors, NeutralMode neutralMode){
        for(int i = 0; i < motors.size(); i++){
            motors.get(i).setNeutralMode(neutralMode);
        }
    }

    void setMotorOpenLoopRampTime(List<WPI_TalonFX> motors, double time){
        for(int i = 0; i < motors.size(); i++){
            motors.get(i).configOpenloopRamp(time);
        }
    }

    void setMotorDir(List<WPI_TalonFX> motors, boolean[] dir){
        for(int i = 0; i < motors.size(); i++){
            motors.get(i).setInverted(dir[i]);
        }
    }

    void setMotorPowers(List<WPI_TalonFX> motors, double power){
        for(int i = 0; i < motors.size(); i++){
            motors.get(i).set(power);
        }
    }

    void setMotorPowers(List<WPI_TalonFX> motors, double[] powers){
        for(int i = 0; i < motors.size(); i++){
            motors.get(i).set(powers[i]);
        }
    }
}