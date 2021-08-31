package frc.robot.parts;

import frc.robot.settings.DriveSettings;

class Drive {
    DriveSettings driveSettings;

    Drive() {
        driveSettings = new DriveSettings();
    }

    Drive(DriveSettings driveSettings) {
        this.driveSettings = driveSettings;
    }

    void moveRobot(double X, double Y, double R) {
        if (driveSettings.driveMode == DriveSettings.DriveMode.TANK) {
            
        } else if (driveSettings.driveMode == DriveSettings.DriveMode.MECANUM) {

        } else if (driveSettings.driveMode == DriveSettings.DriveMode.OMNI) {
            // omni is not currentlly supported!!
            // support comming soon!
        }
    }
}