package org.firstinspires.ftc.teamcode;

/**
 * Created by ahegd on 12/7/2017.
 */


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Arm Test", group = "Pushbot")

public class PushbotArmTest extends LinearOpMode {

    public void moveTo (int Position, int arm, int delay){
        if(arm == 1){

            robot.arm1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.arm1.setTargetPosition(Position);
            robot.arm1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.arm1.setPower(0.05);
            sleep(delay);

        }

        if(arm == 2){
            robot.arm2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.arm2.setTargetPosition(Position);
            robot.arm2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.arm2.setPower(0.05);
            sleep(delay);
        }
    }

    TCHardwarePushbot robot = new TCHardwarePushbot();

    double power1 = 0;
    double pos1 = 0;


    public void runOpMode() throws InterruptedException {

        boolean toggle = false;

        int stage = 0;

        robot.init(hardwareMap);
        robot.arm1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.arm1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.arm2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.arm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        robot.arm1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.arm1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.arm1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.arm2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.arm2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.arm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();


        while (opModeIsActive()) {

        robot.arm2.setPower(-gamepad2.left_stick_y * 0.05);
        robot.arm1.setPower(-gamepad2.right_stick_y * 0.05);


            telemetry.addData("Encoder Test", robot.arm1.getCurrentPosition());
            telemetry.addData("Encoder Test", robot.arm2.getCurrentPosition());
            telemetry.addData("toggle",toggle);
            telemetry.addData("Stage", stage);
            telemetry.addData("RunMode",robot.arm1.getMode());
            telemetry.addData("DriveEncoder",robot.lDrive.getCurrentPosition());
            telemetry.update();

            robot.arm1.setPower(gamepad1.left_stick_y * 0.05);
            robot.arm2.setPower(gamepad1.right_stick_y * 0.05);


            /*moveTo(100,1,0);

            if (gamepad1.b) {
                while (gamepad1.b) {
                    sleep(0);
                }
                toggle = !toggle;
            }

            if (toggle) {

                if (gamepad1.a && stage < 2) {
                    while (gamepad1.a) {
                        sleep(0);
                    }
                    stage++;
                }*/

               /* if (stage == 1) ;
                moveTo(100,1);

                /*sleep(1000);

                moveTo(0,1);

                moveTo(-470,2);*/
            }


        }
    }



