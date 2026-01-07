package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp
public class EncoderTesting extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Find a motor in the hardware map named "Arm Motor"
        DcMotor FRM;
        DcMotor BRM;
        DcMotor BLM;
        DcMotor FLM;

        BRM = hardwareMap.get(DcMotor.class, ("BRM"));
        FRM = hardwareMap.get(DcMotor.class, ("FRM"));
        BLM = hardwareMap.get(DcMotor.class, ("BLM"));
        FLM = hardwareMap.get(DcMotor.class, ("FLM"));
        BRM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // Reset the motor encoder so that it reads zero ticks
        BRM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BLM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // Reset the motor encoder so that it reads zero ticks
        BLM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FRM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // Reset the motor encoder so that it reads zero ticks
        FRM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FLM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // Reset the motor encoder so that it reads zero ticks
        FLM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Turn the motor back on, required if you use STOP_AND_RESET_ENCODER
        BRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        waitForStart();

        while (opModeIsActive()) {
            double CPR = BLM.getMotorType().getTicksPerRev();

            // Get the current position of the motor
            int position = BLM.getCurrentPosition();
            double revolutions = position/CPR;

            double angle = revolutions * 360;
            double angleNormalized = angle % 360;
            double circumference  = Math.PI*96;
            double distance  = circumference* revolutions;


            if(gamepad1.a) {
                BLM.setPower(1);
            }
            else {
                BLM.setPower(0);
            }
            // Show the position of the motor on telemetry
            telemetry.addData("Encoder Position", position);
            telemetry.addData("CPR: ", BLM.getMotorType().getTicksPerRev());
            telemetry.addData("Encoder Revolutions", revolutions);
            telemetry.addData("Encoder Angle (Degrees)", angle);
            telemetry.addData("Encoder Angle - Normalized (Degrees)", angleNormalized);
            telemetry.update();
            //ian code kl;'lk;lk;nlmknmlkj;l

            if(distance<1000){
                BLM.setPower(0.5);
                FLM.setPower(0.5);
                BRM.setPower(-0.5);
                FRM.setPower(-0.5);

            } else {
                BLM.setPower(0.0);
                FLM.setPower(0.0);
                FRM.setPower(0.0);
                BRM.setPower(0.0);
            }
        }
    }
}