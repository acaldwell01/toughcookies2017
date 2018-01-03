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

    double power1 = 0;
    double pos1 = 0;


    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);
        robot.arm1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.arm1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.arm2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.arm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        while (opModeIsActive()) {

        robot.arm2.setPower(-gamepad2.left_stick_y * 0.05);
        robot.arm1.setPower(-gamepad2.right_stick_y * 0.05);

        }


    }
}


