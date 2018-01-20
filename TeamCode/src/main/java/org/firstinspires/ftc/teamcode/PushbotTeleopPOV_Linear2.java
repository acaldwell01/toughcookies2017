/*
Copyright (c) 2016 Robert Atkinson
All rights reserved.
Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:
Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.
Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.
Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.
NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;


/**
 * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
 * <p>
 * All device access is managed through the HardwarePushbot class.
 * <p>
 * The code is structured as a LinearOpMode
 * <p>
 * <p>
 * <p>
 * This particular OpMode executes a POV Game style Teleop for a PushBot
 * <p>
 * In this mode the left stick moves the robot FWD and back, the Right stick turns left and right.
 * <p>
 * It raises and lowers the claw using (change to center motor)the Gampad Y and A buttons respectively.
 * <p>
 * It also opens and closes the claws slowly (change to swiffer) using the left and right Bumper buttons.
 * <p>
 * <p>
 * <p>
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * <p>
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name = "Pushbot: Teleop POV TC42", group = "Pushbot")

//@Disabled
public class PushbotTeleopPOV_Linear2 extends LinearOpMode {


    // Declare OpMode members.

    TCHardwarePushbot robot = new TCHardwarePushbot();   // Use a Pushbot's hardware

    // could also use HardwarePushbotMatrix class.

    //  double          clawOffset      = 0;                       // Servo mid position

    //  final double    CLAW_SPEED      = 0.02 ;                   // sets rate to move servo


    @Override

    public void runOpMode() throws InterruptedException {

        double fDrive = 0;

        double rDrive = 0;

        double sDrive;

        double fLift;

        boolean fGrab = false;

        boolean claw = false;

        // Initialize the hardware variables.

        // The init() method of the hardware class does all the work here

        robot.init(hardwareMap);

        // Set all the modes of the motors to prepare for Start

        robot.arm1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.arm2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.lDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.lDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.rDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.rDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.cDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.fLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Wait for the game to start (driver presses PLAY)

        waitForStart();

        robot.fs1.setPosition(.5);
        robot.fs3.setPosition(.8);
        robot.fs2.setPosition(.25);
        robot.fs4.setPosition(.35);
        robot.claw.setPosition(.5);


        // run until the end of the match (driver presses STOP)

        while (opModeIsActive()) {

            robot.jko.setPosition(0.45);

            // Telemetry statements to give info about the robot

            telemetry.addData("lDrive Speed", fDrive + rDrive);
            telemetry.addData("rDrive Speed", fDrive - rDrive);
            telemetry.addData("rDrive", rDrive);
            telemetry.addData("Arm Mode",robot.arm1.getMode());
            System.out.println("Hi yalls");
            telemetry.update();

            // Assign all power values

            fDrive = gamepad1.left_stick_y;
            rDrive = -gamepad1.right_stick_x;
            sDrive = -gamepad1.left_trigger + gamepad1.right_trigger;

            // If statements to assign the controller something to do

            if (gamepad1.a) {
                while (gamepad1.a) {
                    sleep(0);

                }
                fGrab = !fGrab;
            }
            if (fGrab) {
                robot.fs1.setPosition(.15);
                robot.fs2.setPosition(.6);
                robot.fs3.setPosition(.35);
                robot.fs4.setPosition(.7);
            }
            if (!fGrab) {
                robot.fs1.setPosition(.5);
                robot.fs3.setPosition(.8);
                robot.fs2.setPosition(.25);
                robot.fs4.setPosition(.35);
            }


            if (gamepad2.y) {
                while (gamepad2.y) {
                    sleep(0);
                }
                claw = !claw;
            }

            if (claw) {
                robot.claw.setPosition(.2);
            }

            if (!claw) {
                robot.claw.setPosition(.75);
            }

            if (gamepad1.right_bumper) {
                robot.fLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                fLift = 0.5;
            } else if (gamepad1.left_bumper) {
                robot.fLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
                fLift = -0.5;
            } else {
                fLift = 0;
            }

            // The actual power setting of the motors

            robot.lDrive.setPower(fDrive + rDrive);
            robot.rDrive.setPower(fDrive - rDrive);
            robot.cDrive.setPower(sDrive);

            robot.arm1.setPower(-gamepad2.left_stick_y * 0.25);
            robot.arm2.setPower(gamepad2.right_stick_y * 0.25);
            robot.fLift.setPower(fLift);


        }

    }

}