package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous
public class autonRed extends OpMode {
    //left back 1 front -1
    //out ~2ft then strafe left - red
    DcMotor BRM;
    DcMotor FRM;
    DcMotor BLM;
    DcMotor FLM;
    DcMotor ShooterPrecision;
    DcMotor ShooterPower;
    Forward moveF;
    boolean t = true;
    ElapsedTime runtime = new ElapsedTime();
    public void init(){

        BRM = hardwareMap.get(DcMotor.class, ("BRM"));
        FRM = hardwareMap.get(DcMotor.class, ("FRM"));
        BLM = hardwareMap.get(DcMotor.class, ("BLM"));
        FLM = hardwareMap.get(DcMotor.class, ("FLM"));
        //initialize both motors
        //moveF = new Forward();
        int distance = 610;
        FRM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BRM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BLM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FLM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BRM.setTargetPosition(distance);
        FRM.setTargetPosition(distance);
        BLM.setTargetPosition(-distance);
        FLM.setTargetPosition(-distance);

        FRM.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        BRM.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        BLM.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        FLM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        double CPR = 384.5;
        double diameter = 96;
        double circumference = Math.PI * diameter;
        double position = FRM.getCurrentPosition();
        double revolutions = position / CPR;
        double distanceMoved = revolutions * circumference;
        double power = FRM.getPower();
    }
    public void loop() {



            //acceleration
            BLM.setPower(.25);
            BRM.setPower(.25);
            FLM.setPower(.25);
            FRM.setPower(.25);
        }
    }


