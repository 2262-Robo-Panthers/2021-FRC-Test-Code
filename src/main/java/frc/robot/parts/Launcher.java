package frc.robot.parts;

import frc.robot.settings.LauncherSettings;

public class Launcher {
    LauncherSettings launcherSettings;

    Launcher(){
        launcherSettings = new LauncherSettings();
    }

    Launcher(LauncherSettings launcherSettings){
        this.launcherSettings = launcherSettings;
    }

    void init(){}
}
