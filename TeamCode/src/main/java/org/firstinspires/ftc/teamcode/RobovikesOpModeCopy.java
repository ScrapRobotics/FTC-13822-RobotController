package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class RobovikesOpModeCopy extends OpMode {
    private DcMotor BRM;
    private DcMotor FRM;
    private DcMotor BLM;
    private DcMotor FLM;

    private DcMotor Shooter;


    @Override
    public void init() {

        BRM = hardwareMap.get(DcMotor.class, ("BRM"));
        FRM = hardwareMap.get(DcMotor.class, ("FRM"));
        BLM = hardwareMap.get(DcMotor.class, ("BLM"));
        FLM = hardwareMap.get(DcMotor.class, ("FLM"));
        Shooter = hardwareMap.get(DcMotor.class, ("Shooter"));

    }
//todo-after input stops, reverse motor a bit
    @Override
    public void loop() {
        boolean brake = false;

        double rightPower = gamepad1.right_stick_y;
        double leftPower = gamepad1.left_stick_y;
        float lTrig = gamepad1.left_trigger;
        float rTrig = gamepad1.right_trigger;
        boolean x = gamepad1.x;
        leftPower  = Math.max(-1, Math.min(1, leftPower));
        rightPower = -Math.max(-1, Math.min(1, rightPower));

        BLM.setPower(leftPower);
        FLM.setPower(leftPower);
        FRM.setPower(rightPower);
        BRM.setPower(rightPower);
        if(x) {
            Shooter.setPower(1);
        }
        else {
            Shooter.setPower(0);
        }
        //braking - still need to figure out how to make brake true/false based on input?
       /*while(brake){
           if(gamepad1.right_stick_x == 0 && gamepad1.right_stick_y==0){
               BRM.setPower(-BRM.getPower()/2);
               FRM.setPower(-FRM.getPower()/2);
               BRM.setPower(0);
               FRM.setPower(0);
               brake = false;

           }
           if(gamepad1.left_stick_x == 0 && gamepad1.left_stick_y==0){
               BLM.setPower(-BLM.getPower()/2);
               FLM.setPower(-FLM.getPower()/2);
               BLM.setPower(0);
               FLM.setPower(0);
               brake = false;
           }
       }

        //strafing
        if(lTrig > .5){
            BRM.setPower(1);
            FRM.setPower(-0.5);
            FLM.setPower(0.5);
            BLM.setPower(-1);
        }
        else {
            BRM.setPower(0);
            FRM.setPower(0);
            FLM.setPower(0);
            BLM.setPower(0);
        }
        if(rTrig > .5){
            BRM.setPower(-1);
            FRM.setPower(0.5);
            FLM.setPower(-0.5);
            BLM.setPower(1);
        }
        else {
            BRM.setPower(0);
            FRM.setPower(0);
            FLM.setPower(0);
            BLM.setPower(0);
        }
        */

    }
}

