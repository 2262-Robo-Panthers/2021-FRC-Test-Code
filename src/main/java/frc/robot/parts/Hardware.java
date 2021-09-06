package frc.robot.parts;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

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
 
    //Launcher
    Encoder hoodEncoder;

    //Climb
    DigitalInput climbLimit;

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
    //random
    void constructBaseHardware(){

    }

    void initBaseHardware(){
        initMiscellaneous();
    }

    void constructControllers(){
        XBoi = new XboxController(hardwareSettings.XBoiPort);
        Logi = new Joystick(hardwareSettings.LogiPort);
    }

    void constructMiscellaneous(){
        airCompressor = new Compressor(9);
    }

    void initMiscellaneous(){
        airCompressor.start();
    }

    //drive
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