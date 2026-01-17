package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class moveForward extends OpMode {
    public DcMotor BRM;
    public DcMotor BLM;
    public DcMotor FRM;
    public DcMotor FLM;

    @Override
    public void init(){
        BRM = hardwareMap.get(DcMotor.class, "BRM");
        BLM = hardwareMap.get(DcMotor.class, "BLM");
        FRM = hardwareMap.get(DcMotor.class, "FRM");
        FLM = hardwareMap.get(DcMotor.class, "FLM");


        BRM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // Reset the motor encoder so that it reads zero ticks
        BLM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // Reset the motor encoder so that it reads zero ticks
        FRM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // Reset the motor encoder so that it reads zero ticks
        FLM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // Reset the motor encoder so that it reads zero ticks
        //motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Turn the motor back on, required if you use STOP_AND_RESET_ENCODER
        BRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }
    @Override
    public void loop(){

    }

    public void encoderDrive(double speed, double distance){
        int position = BRM.getCurrentPosition();
         double CPR = 384.5;
        double revolutions = position/CPR;

        double angle = revolutions * 360;
        double angleNormalized = angle % 360;
        double circumference  = Math.PI*96;
        BLM.setTargetPosition(-(int)((distance/circumference)*CPR));
        FLM.setTargetPosition(-(int)((distance/circumference)*CPR));
        BRM.setTargetPosition((int)((distance/circumference)*CPR));
        FRM.setTargetPosition((int)((distance/circumference)*CPR));
        BLM.setPower(Math.abs(speed));
        BRM.setPower(Math.abs(speed));
        FLM.setPower(Math.abs(speed));
        FRM.setPower(Math.abs(speed));
        BLM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FLM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FRM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BRM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}
