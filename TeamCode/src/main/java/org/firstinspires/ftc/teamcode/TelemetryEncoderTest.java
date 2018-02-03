package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Nightmaze on 2/3/18.
 */
@Autonomous(name = "Telemetry Test", group = "Pushbot")
public class TelemetryEncoderTest extends LinearOpMode {

    TCHardwarePushbot robot = new TCHardwarePushbot();

    @Override

    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        robot.lDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.rDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.lDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        int test = 0;
        int positionright = 0;
        int positionleft = 0;


        waitForStart();

        while (opModeIsActive()) {

            positionleft = robot.lDrive.getCurrentPosition();
            positionright = robot.rDrive.getCurrentPosition();
            test = robot.arm1.getCurrentPosition();

            robot.rDrive.setPower(.1);
            robot.lDrive.setPower(.1);

            telemetry.addData("rdrive", positionright);
            telemetry.addData("ldrive", positionleft);
            telemetry.addData("test", test);
            telemetry.update();
        }
    }
}
