package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by ahegd on 1/26/2018.
 */


public class Calibration extends LinearOpMode {

    public static double fs1;
    public static double fs2;
    public static double fs3;
    public static double fs4;
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

                while (!(robot.fs1.getPosition() == fs1 && robot.fs2.getPosition() == fs2 && robot.fs3.getPosition() == fs3 && robot.fs4.getPosition() == fs4)) {
                    sleep(0);
                }
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

                }

                if (!close) {

                    robot.fs1.setPosition(fs1 + .35);
                    robot.fs2.setPosition(fs2 - .35);
                    robot.fs3.setPosition(fs3 + .35);
                    robot.fs4.setPosition(fs4 - .35);

                }
            }

            if (!test) {

                fs1 = robot.fs1.getPosition();
                fs2 = robot.fs1.getPosition();
                fs3 = robot.fs1.getPosition();
                fs4 = robot.fs1.getPosition();

            }
            /*robot.fs1.setPosition(fs1);
            robot.fs2.setPosition(fs2);
            robot.fs3.setPosition(fs3);
            robot.fs4.setPosition(fs4);

            if(type == 1){
               telemetry.addData("Type",fs1);
            }
            if(type == 2){
                telemetry.addData("Type",fs2);
            }
            if(type == 3){
                telemetry.addData("Type",fs3);
            }
            if(type == 4){
                telemetry.addData("Type",fs4);
            }
            telemetry.update();

            if (gamepad1.a){

            }

            if(type >= 5){
                type = 1;
            }*/

        }

    }
}
