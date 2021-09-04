package frc.robot.parts;

import java.util.Arrays;
import java.util.List;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.settings.HardwareSettings;
import jdk.nashorn.internal.objects.annotations.Function;

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

    void initBaseHardware(){
        initControllers();
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

    void runMethodOnMotors(List<Object> motors){
        motors.get(1).getClass().cast(motors.get(0)).set(1);
    }
}