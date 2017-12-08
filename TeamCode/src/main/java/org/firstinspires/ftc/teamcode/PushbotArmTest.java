package org.firstinspires.ftc.teamcode;

/**
 * Created by ahegd on 12/7/2017.
 */


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Arm Test", group = "Pushbot")

public class PushbotArmTest {

    TCHardwarePushbot robot = new TCHardwarePushbot();

    public void runOpMode() throws InterruptedException{

        double arm1Int;

        robot.init(hardwareMap);
    }

}
