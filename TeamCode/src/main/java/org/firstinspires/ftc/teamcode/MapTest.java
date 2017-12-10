package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Ian on 12/9/2017.
 * Map test for mapping field - by far the most advanced code
 */
@TeleOp(name = "ArmTest", group = "Pushbot")

public class MapTest extends LinearOpMode {
    TCHardwarePushbot robot = new TCHardwarePushbot();

    public enum glyph {
        LOADED,
        UNLOADED
    }
    private glyph glyphposition;

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        while(opModeIsActive()) {
            if (robot.glyphsensor.isPressed()) {
                glyphposition = glyph.LOADED;
            } else {
                glyphposition = glyph.UNLOADED;
            }
        if (glyphposition == glyph.LOADED) {
                telemetry.addData("Glyph Loaded", true);
                telemetry.update();
        } else {
                telemetry.addData("Glyph Loaded", false);
                telemetry.update();
        }
        }
    }
}