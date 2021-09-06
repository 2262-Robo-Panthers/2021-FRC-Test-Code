package frc.robot.parts;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.other.Utils;
import frc.robot.settings.HardwareSettings;

public class Hardware {
    HardwareSettings hardwareSettings;

    //contollers
    public XboxController XBoi;
    Joystick Logi;

    //Drive
    WPI_TalonFX driveMotor1;
    WPI_TalonFX driveMotor2;
    WPI_TalonFX driveMotor3;
    WPI_TalonFX driveMotor4;
    List<Object> driveMotors;

    //Conveyor
    DigitalInput frontPhotoGate;
    DigitalInput upperPhotoGate;
    DigitalInput otherPhotoGate;
    DigitalInput upperIntakeLimit;
    DigitalInput lowerIntakeLimit;
    WPI_VictorSPX roller;
    WPI_VictorSPX intake;
 
    //Launcher
    Encoder hoodEncoder;
    WPI_VictorSPX hood;
    CANSparkMax flywheel;

    //Climb
    DigitalInput climbLimit;
    CANSparkMax climb;

    //Other
    Compressor airCompressor;

    ////////////////
    //constructors//
    ////////////////
    Hardware() {
        hardwareSettings = new HardwareSettings();
    }

    Hardware(HardwareSettings hardwareSettings) {
        this.hardwareSettings = hardwareSettings;
    }

    ////////////////
    //init methods//
    ////////////////
    //Drive
    void constructDrive(){
        driveMotor1 = new WPI_TalonFX(hardwareSettings.driveMotor1Num);
        driveMotor2 = new WPI_TalonFX(hardwareSettings.driveMotor2Num);
        driveMotor3 = new WPI_TalonFX(hardwareSettings.driveMotor3Num);
        driveMotor4 = new WPI_TalonFX(hardwareSettings.driveMotor4Num);

        driveMotors = Arrays.asList(driveMotor1, driveMotor2, driveMotor3, driveMotor4);
    }

    void initDrive(){
        setMethodOnObjects(driveMotors, "setNeutralMode", hardwareSettings.driveNeutralMode);
        setMethodOnObjects(driveMotors, "configOpenloopRamp", hardwareSettings.driveOpenLoopRampTime);
        setMethodOnObjectsAdv(driveMotors, "setInverted", new Class[]{boolean.class}, hardwareSettings.flipDriveMotors);
    }

    //Conveyor
    void constructConveyor(){
        frontPhotoGate = new DigitalInput(hardwareSettings.frontPhotoGateChannel);
        upperPhotoGate = new DigitalInput(hardwareSettings.upperPhotoGateChannel);
        otherPhotoGate = new DigitalInput(hardwareSettings.otherPhotoGateChannel);
        upperIntakeLimit = new DigitalInput(hardwareSettings.upperIntakeLimitChannel);
        lowerIntakeLimit = new DigitalInput(hardwareSettings.lowerIntakeLimitChannel);
        roller = new WPI_VictorSPX(hardwareSettings.rollerID);
        intake = new WPI_VictorSPX(hardwareSettings.intakeID);
    }

    void initConveyor(){
        intake.setNeutralMode(hardwareSettings.intakeNeutralMode);
    }

    //Launcher
    void constructLauncher(){
        hoodEncoder = new Encoder(hardwareSettings.hoodEncoderNum1, hardwareSettings.hoodEncoderNum2);
        flywheel = new CANSparkMax(hardwareSettings.flywheelID, hardwareSettings.flywheelMotorType);
        hood = new WPI_VictorSPX(hardwareSettings.hoodID);
    }

    void initLauncher(){
        flywheel.setInverted(hardwareSettings.flipFlywheel);
        flywheel.getEncoder().setPosition(0);
        flywheel.setIdleMode(hardwareSettings.flywheelIdleMode);
    }

    //Climb
    void constructClimb(){
        climb = new CANSparkMax(hardwareSettings.climbId, hardwareSettings.climbMotorType);
        climbLimit = new DigitalInput(hardwareSettings.climbLimitChannel);
    }

    void initClimb(){

    }

    //Random
    void constructBaseHardware(){
        constructControllers();
        constructMiscellaneous();
    }

    void initBaseHardware(){
        initMiscellaneous();
    }

    void constructControllers(){
        XBoi = new XboxController(hardwareSettings.XBoiPort);
        Logi = new Joystick(hardwareSettings.LogiPort);
    }

    void constructMiscellaneous(){
        airCompressor = new Compressor(hardwareSettings.airCompressorModule);
    }

    void initMiscellaneous(){
        airCompressor.start();
    }

    /////////
    //other//
    /////////
    public void setMethodOnObjects(List<Object> objects, String method, Object... params) {
        Class[] paramsClass = Utils.getObjectClasses(params);
        for (Object mObj : objects) {
            try {
                Method setMethod = mObj.getClass().getMethod(method, paramsClass);
                if (setMethod != null) {
                    setMethod.invoke(mObj, params);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setMethodOnObjectsAdv(List<Object> objects, String method, Class[] paramClasses, Object... params) {
        for (int i = 0; i < objects.size(); i++) {
            try {
                Method setMethod = objects.get(i).getClass().getMethod(method, paramClasses);
                if (setMethod != null) {
                    setMethod.invoke(objects.get(i), params[i]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stopMotors(List<Object> motors){
        setMethodOnObjects(motors, "set", 0.0);
    }
}