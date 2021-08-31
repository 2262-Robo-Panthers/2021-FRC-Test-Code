package frc.robot.parts;

import java.util.List;

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
    WPI_TalonFX frontLeftMotor;
    WPI_TalonFX frontRightMotor;
    WPI_TalonFX backLeftMotor;
    WPI_TalonFX backRightMotor;
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
        frontLeftMotor = new WPI_TalonFX(hardwareSettings.frontLeftMotorNum);
        frontRightMotor = new WPI_TalonFX(hardwareSettings.frontRightMotorNum);
        backLeftMotor = new WPI_TalonFX(hardwareSettings.backLeftMotorNum);
        backRightMotor = new WPI_TalonFX(hardwareSettings.frontRightMotorNum);
    }

    void setMotorList(){

    }
}