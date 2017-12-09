package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file illustrates the concept of driving a path based on time.
 * It uses the common Pushbot hardware class to define the drive on the robot.
 * The code is structured as a LinearOpMode
 * <p>
 * The code assumes that you do NOT have encoders on the wheels,
 * otherwise you would use: PushbotAutoDriveByEncoder;
 * <p>
 * The desired path in this example is:
 * - Drive forward for 3 seconds
 * - Spin right for 1.3 seconds
 * - Drive Backwards for 1 Second
 * - Stop and close the claw.
 * <p>
 * The code is written in a simple form with no optimizations.
 * However, there are several ways that this type of sequence could be streamlined,
 * <p>
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name = "Pushbot: Auto Drive By Time Short", group = "Pushbot")

public class PushbotAutoDriveByTimeShort extends LinearOpMode {

    /* Declare OpMode members. */
    TCHardwarePushbot robot = new TCHardwarePushbot();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();
    private AutonomousConfiguration autoConfig;
    private AutonomousConfiguration.AllianceColor alliance = AutonomousConfiguration.AllianceColor.None;
    static final double BLUE_COLOR = 40;

    public enum jewelcolor {
        None,
        Red,
        Blue
    }

    private jewelcolor sensedjjewelcolor;
    private int startDelay = 0;


    static final double FORWARD_SPEED = 0.6;
    static final double TURN_SPEED = 0.5;

    @Override

    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        autoConfig = new AutonomousConfiguration(gamepad1, telemetry);

        autoConfig.ShowMenu();

        this.alliance = autoConfig.getAlliance();

        this.startDelay = autoConfig.getStartDelay();


        telemetry.addData("Waiting for Start", "");

        telemetry.update();


        // Wait for the game to start (driver presses PLAY)

        waitForStart();

        sleep(this.startDelay * 1000);

        // Wait for the game to start (driver presses PLAY)
        robot.lDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        robot.rDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way
        robot.jko.setPosition(.98);
        int accum_blue = 0;
        for (int I = 0; I < 20; I++) {
            accum_blue += robot.color_sensor.blue();
        }
        int accum_red = 0;
        for (int B = 0; B < 20; B++) {
            accum_red += robot.color_sensor.red();
        }
        accum_blue = accum_blue / 20;
        accum_red = accum_red / 20;
        telemetry.addData("accum", accum_blue);
        telemetry.addData("accum_red", accum_red);
        telemetry.update();
        sleep(5000);
        sensedjjewelcolor = (accum_blue > accum_red) ? jewelcolor.Blue : jewelcolor.Red;
        if ((this.alliance == AutonomousConfiguration.AllianceColor.Blue && sensedjjewelcolor == jewelcolor.Blue) ||
                (this.alliance == AutonomousConfiguration.AllianceColor.Red && sensedjjewelcolor == jewelcolor.Red)) {
            robot.lDrive.setPower(FORWARD_SPEED);
            robot.rDrive.setPower(-FORWARD_SPEED);
            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() < .20)) {
                telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                telemetry.update();
            }

        } else {
            robot.lDrive.setPower(-FORWARD_SPEED);
            robot.rDrive.setPower(FORWARD_SPEED);
            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() < .20)) {
                telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                telemetry.update();
            }
        }

        // Step 1:  Drive forward for 3 seconds

        robot.lDrive.setPower(-FORWARD_SPEED);
        robot.rDrive.setPower(FORWARD_SPEED);
        runtime.reset();
        while (

                opModeIsActive() && (runtime.seconds() < 1.25))

        {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }


        robot.lDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        robot.rDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        robot.lDrive.setPower(-.5);
        robot.rDrive.setPower(-.5);
        runtime.reset();
        while (

                opModeIsActive() && (runtime.seconds() < .3))

        {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        robot.lDrive.setPower(0);
        robot.rDrive.setPower(0);
    }
}

