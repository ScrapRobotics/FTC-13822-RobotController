package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

//todo-when theres a ball the power will reduce a bit, detect when that happens and slow down the power
@TeleOp
public class RobovikesOpMode extends OpMode {
    private DcMotor BRM;
    private DcMotor FRM;
    private DcMotor BLM;
    private DcMotor FLM;
    private DcMotor ShooterPrecision;
    private DcMotor ShooterPower;


    @Override
    public void init() {

        BRM = hardwareMap.get(DcMotor.class, ("BRM"));
        FRM = hardwareMap.get(DcMotor.class, ("FRM"));
        BLM = hardwareMap.get(DcMotor.class, ("BLM"));
        FLM = hardwareMap.get(DcMotor.class, ("FLM"));
        //initialize both motors
        ShooterPrecision = hardwareMap.get(DcMotor.class, ("Shooter1"));
        ShooterPower = hardwareMap.get(DcMotor.class, ("Shooter2"));
        //set both zero power behavior to instantly brake
        ShooterPower.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ShooterPrecision.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //and all the driving motors
        BRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    @Override
    public void loop() {
        //boolean brake = false;
        double leftPower = gamepad1.left_stick_y;
        double rightPower = gamepad1.right_stick_y;
        float lTrig = gamepad1.left_trigger;
        float rTrig = gamepad1.right_trigger;
        leftPower  = Math.max(-1, Math.min(1, leftPower));
        rightPower = -Math.max(-1, Math.min(1, rightPower));

        //strafing
        if(lTrig > .5){
            BRM.setPower(1);
            FRM.setPower(-1);
            FLM.setPower(-1);
            BLM.setPower(1);
        }
        else if(rTrig > .5){
            BRM.setPower(-1);
            FRM.setPower(1);
            FLM.setPower(1);
            BLM.setPower(-1);
        }
        else {
            BLM.setPower(leftPower);
            FLM.setPower(leftPower);
            FRM.setPower(rightPower);
            BRM.setPower(rightPower);
        }
        telemetry.addData("Left Power: ", leftPower);
        //telemetry.addData("Left Brake: ", brakel);
        telemetry.addData("FLM", FLM.getPower());
        telemetry.addData("BLM", BLM.getPower());
        telemetry.addData("Right Power: ", rightPower);
        //telemetry.addData("Right Brake: ", braker);
        telemetry.addData("FRM", FRM.getPower());
        telemetry.addData("BRM", BRM.getPower());
        telemetry.update();
        // simple program logic for motor and button
        if (gamepad1.cross){
            ShooterPrecision.setPower(1.0);
            ShooterPower.setPower(1.0);
        } else {
            ShooterPrecision.setPower(0.0);
            ShooterPower.setPower(0.0);
        }
    }
}

