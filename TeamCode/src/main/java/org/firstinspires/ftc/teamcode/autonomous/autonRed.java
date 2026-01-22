package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class autonRed extends OpMode {
    //left back 1 front -1
    //out ~2ft then strafe left - red
    DcMotor BRM;
    DcMotor FRM;
    DcMotor BLM;
    DcMotor FLM;
    DcMotor ShooterPrecision;
    DcMotor ShooterPower;
    ElapsedTime runtime = new ElapsedTime();
    public void init(){

        BRM = hardwareMap.get(DcMotor.class, ("BRM"));
        FRM = hardwareMap.get(DcMotor.class, ("FRM"));
        BLM = hardwareMap.get(DcMotor.class, ("BLM"));
        FLM = hardwareMap.get(DcMotor.class, ("FLM"));
        //initialize both motors
        ShooterPrecision = hardwareMap.get(DcMotor.class, ("Shooter1"));
        ShooterPower = hardwareMap.get(DcMotor.class, ("Shooter2"));
    }
    public void loop(){
        moveForward.forward(1.5);
        FRM.setPower(-.5);
        FLM.setPower(-.5);
        BRM.setPower(.5);
        BLM.setPower(.5);
        while(runtime.seconds() < 1.5) {
            telemetry.update();
        }
        requestOpModeStop();
    }
}
