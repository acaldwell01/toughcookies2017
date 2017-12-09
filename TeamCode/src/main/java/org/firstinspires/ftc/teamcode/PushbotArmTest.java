package org.firstinspires.ftc.teamcode;

/**
 * Created by ahegd on 12/7/2017.
 */


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Arm Test", group = "Pushbot")

public class PushbotArmTest extends LinearOpMode {

    TCHardwarePushbot robot = new TCHardwarePushbot();

    public void runOpMode() throws InterruptedException {

        double arm1Int = 0;

        robot.init(hardwareMap);

        robot.arm1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        while (opModeIsActive()) {

            arm1Int += -gamepad1.left_stick_y / 100;

            robot.arm1.setPower(-gamepad1.left_stick_y);

        }


    }
}


