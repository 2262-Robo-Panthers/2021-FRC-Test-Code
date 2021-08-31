package frc.robot.parts;

import frc.robot.settings.ConveyorSettings;

class Conveyor {
    ConveyorSettings conveyorSettings;

    Conveyor() {
        conveyorSettings = new ConveyorSettings();
    }

    Conveyor(ConveyorSettings conveyorSettings) {
        this.conveyorSettings = conveyorSettings;
    }
}
