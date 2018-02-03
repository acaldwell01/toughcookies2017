package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by ahegd on 1/26/2018.
 */

@TeleOp(name = "Calibration", group = "Pushbot")

public class Calibration extends LinearOpMode {

    public static double fs1;
    public static double fs2;
    public static double fs3;
    public static double fs4;
    public static double claw;
    TCHardwarePushbot robot = new TCHardwarePushbot();

    @Override


    public void runOpMode() throws InterruptedException {

        int type = 1;
        int A = 0;
        boolean test = false;
        boolean close = true;

        robot.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.b) {
                while (gamepad1.b) {
                    sleep(0);
                }
                test = !test;

                robot.fs1.setPosition(fs1);
                robot.fs2.setPosition(fs2);
                robot.fs3.setPosition(fs3);
                robot.fs4.setPosition(fs4);
                robot.claw.setPosition(claw);
                sleep(500);
            }

            if (test) {

                if (gamepad1.a) {

                    while (gamepad1.a) {
                        sleep(0);
                    }
                    close = !close;

                }

                if (close) {

                    robot.fs1.setPosition(fs1);
                    robot.fs2.setPosition(fs2);
                    robot.fs3.setPosition(fs3);
                    robot.fs4.setPosition(fs4);
                    robot.claw.setPosition(claw);


                }

                if (!close) {

                    robot.fs1.setPosition(fs1 + .35);
                    robot.fs2.setPosition(fs2 - .35);
                    robot.fs3.setPosition(fs3 + .35);
                    robot.fs4.setPosition(fs4 - .35);
                    robot.claw.setPosition(claw + .55);

                }
            }

            if (!test) {

                robot.fs1.setPosition(fs1);
                robot.fs2.setPosition(fs2);
                robot.fs3.setPosition(fs3);
                robot.fs4.setPosition(fs4);
                robot.claw.setPosition(claw);

                if (type == 1) {
                    telemetry.addData("Value", fs1);
                    if (gamepad1.dpad_up){
                        while(gamepad1.dpad_up) {
                         sleep(0);
                        }
                        fs1 += 0.01;
                    }
                    if (gamepad1.dpad_down){
                        while(gamepad1.dpad_down) {
                            sleep(0);
                        }
                        fs1 -= 0.01;
                    }
                }
                if (type == 2) {
                    telemetry.addData("Value", fs2);
                    if (gamepad1.dpad_up){
                        while(gamepad1.dpad_up) {
                            sleep(0);
                        }
                        fs2 += 0.01;
                    }
                    if (gamepad1.dpad_down){
                        while(gamepad1.dpad_down) {
                            sleep(0);
                        }
                        fs2 -= 0.01;
                    }
                }
                if (type == 3) {
                    telemetry.addData("Value", fs3);
                    if (gamepad1.dpad_up){
                        while(gamepad1.dpad_up) {
                            sleep(0);
                        }
                        fs3 += 0.01;
                    }
                    if (gamepad1.dpad_down){
                        while(gamepad1.dpad_down) {
                            sleep(0);
                        }
                        fs3 -= 0.01;
                    }
                }
                if (type == 4) {
                    telemetry.addData("Value", fs4);
                    if (gamepad1.dpad_up){
                        while(gamepad1.dpad_up) {
                            sleep(0);
                        }
                        fs4 += 0.01;
                    }
                    if (gamepad1.dpad_down){
                        while(gamepad1.dpad_down) {
                            sleep(0);
                        }
                        fs4 -= 0.01;
                    }
                }

                if (type == 5) {
                    telemetry.addData("Value", claw);
                    if (gamepad1.dpad_up){
                        while(gamepad1.dpad_up) {
                            sleep(0);
                        }
                        claw += 0.01;
                    }
                    if (gamepad1.dpad_down){
                        while(gamepad1.dpad_down) {
                            sleep(0);
                        }
                        claw -= 0.01;
                    }
                }
                telemetry.addData("Type",type);
                telemetry.update();

                if (gamepad1.a) {
                    while (gamepad1.a) {
                        sleep(0);
                    }
                    type++;
                }

                if (type >= 6) {
                    type = 1;
                }
            }


        }

    }
}
