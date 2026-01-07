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
        ShooterPrecision = hardwareMap.get(DcMotor.class, ("Shooter_Precision"));
        ShooterPower = hardwareMap.get(DcMotor.class, ("Shooter_Power"));
        ShooterPower.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ShooterPrecision.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ShooterPrecision.setDirection(DcMotorSimple.Direction.REVERSE);


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
       /* boolean brakel = true;
        boolean braker = true;

        if(braker) {
            if (gamepad1.right_stick_y == 0) {
                BRM.setPower(-BRM.getPower() / 2);
                FRM.setPower(-FRM.getPower() / 2);
                BRM.setPower(0);
                FRM.setPower(0);
                braker = false;

            }
        }
        else if (gamepad1.right_stick_y!=0) {
            braker=true;
        }
        if(brakel) {
            if (gamepad1.left_stick_y == 0) {
                BLM.setPower(-BLM.getPower() / 2);
                FLM.setPower(-FLM.getPower() / 2);
                BLM.setPower(0);
                FLM.setPower(0);
                brakel = false;

            }
        }
        else if (gamepad1.left_stick_y!=0) {
            brakel=true;
        }*/
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
        if (gamepad1.cross){
            ShooterPrecision.setPower(1.0);
            ShooterPower.setPower(1.0);
        } else {
            ShooterPrecision.setPower(0.0);
            ShooterPower.setPower(0.0);
        }
    }
}

