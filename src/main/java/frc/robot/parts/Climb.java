package frc.robot.parts;

import frc.robot.settings.ClimbSettings;

class Climb {
    ClimbSettings climbSettings;

    Climb() {
        climbSettings = new ClimbSettings();
    }

    Climb(ClimbSettings climbSettings) {
        this.climbSettings = climbSettings;
    }
}