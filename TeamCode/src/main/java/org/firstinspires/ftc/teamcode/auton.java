package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@Autonomous
public class Auton extends LinearOpMode {
    DcMotor BRM;
    DcMotor FRM;
    DcMotor BLM;
    DcMotor FLM;

    DcMotor Shooter;

    @Override
    public void runOpMode(){
        BRM = hardwareMap.get(DcMotor.class, ("BRM"));
        FRM = hardwareMap.get(DcMotor.class, ("FRM"));
        BLM = hardwareMap.get(DcMotor.class, ("BLM"));
        FLM = hardwareMap.get(DcMotor.class, ("FLM"));
        Shooter = hardwareMap.get(DcMotor.class, ("Shooter"));


    }
}
