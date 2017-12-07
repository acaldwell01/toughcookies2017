package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by night on 12/5/2017.
 */
@TeleOp(name = "Test Color", group = "Pushbot")
public class TestColor extends LinearOpMode {
        TCHardwarePushbot robot = new TCHardwarePushbot();   // Use a Pushbot's hardware


        static final double FORWARD_SPEED = 0.6;
        static final double TURN_SPEED = 0.5;
    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        telemetry.addData("Waiting for Start", "");

        telemetry.update();
        waitForStart();
        int accum;
        while (true) {
            accum = robot.color_sensor.blue();
            telemetry.addData("accum", accum);
            telemetry.update();
            sleep(500);
        }


    }
}

