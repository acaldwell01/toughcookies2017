package org.firstinspires.ftc.teamcode;

/**
 * Created by ahegd on 12/7/2017.
 */


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "ArmAssist", group = "Pushbot")

public class ArmDriveAssist extends LinearOpMode {


    TCHardwarePushbot robot = new TCHardwarePushbot();


    public void runOpMode() throws InterruptedException {

        double pos1 = 0;
        double currPos1 = 0;
        double power1 = 0;
        double pos2 = 0;
        double currPos2 = 0;
        double power2 = 0;

        robot.init(hardwareMap);

        robot.arm1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.arm1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.arm1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.arm2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.arm2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.arm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();


        while (opModeIsActive()) {


            telemetry.addData("Pos", (currPos1) + ",   " + "Encoder: " + robot.arm1.getCurrentPosition());
            telemetry.addData("Target Position", pos1 + ",   " + "Power: " + power1);
            telemetry.addLine("Hello " + 1 + " this is a magical number");
            telemetry.update();

            pos1 += -gamepad1.left_stick_y * 0.01;
            currPos1 = (robot.arm1.getCurrentPosition() / 1440);
            power1 = (currPos1 - pos1);
            pos2 += -gamepad1.right_stick_y * 0.01;
            currPos2 = robot.arm2.getCurrentPosition() / 1440;
            power2 = (currPos2 - pos2);

            robot.arm1.setPower(power1);
            robot.arm2.setPower(power2);
        }
    }
}



