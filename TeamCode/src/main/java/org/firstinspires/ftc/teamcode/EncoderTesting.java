package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp
public class EncoderTesting extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Find a motor in the hardware map named "Arm Motor"
        DcMotor motor;

        motor = hardwareMap.dcMotor.get("BLM");
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // Reset the motor encoder so that it reads zero ticks
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Turn the motor back on, required if you use STOP_AND_RESET_ENCODER
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        waitForStart();

        while (opModeIsActive()) {
            double CPR = motor.getMotorType().getTicksPerRev();

            // Get the current position of the motor
            int position = motor.getCurrentPosition();
            double revolutions = position/CPR;

            double angle = revolutions * 360;
            double angleNormalized = angle % 360;
            if(gamepad1.a) {
                motor.setPower(1);
            }
            else {
                motor.setPower(0);
            }
            // Show the position of the motor on telemetry
            telemetry.addData("Encoder Position", position);
            telemetry.addData("CPR: ", motor.getMotorType().getTicksPerRev());
            telemetry.addData("Encoder Revolutions", revolutions);
            telemetry.addData("Encoder Angle (Degrees)", angle);
            telemetry.addData("Encoder Angle - Normalized (Degrees)", angleNormalized);
            telemetry.addData("CPR: ", motor.getMotorType().getTicksPerRev());
            telemetry.update();
            //ian code kl;'lk;lk;nlmknmlkj;l
        }
    }
}