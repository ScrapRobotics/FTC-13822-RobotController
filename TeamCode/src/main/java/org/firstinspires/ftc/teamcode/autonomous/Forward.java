package org.firstinspires.ftc.teamcode.autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class Forward extends LinearOpMode{
    public DcMotor BLM;
    public DcMotor FRM;
    public DcMotor FLM;
    public DcMotor BRM;


    public Forward() {

    }
    @Override
    public void runOpMode(){

    }
    public void moveF(int distance){
        BRM = hardwareMap.get(DcMotor.class, ("BRM"));
        BLM = hardwareMap.get(DcMotor.class, ("BLM"));
        FRM = hardwareMap.get(DcMotor.class, ("FRM"));
        FLM = hardwareMap.get(DcMotor.class, ("FLM"));
        BRM.setTargetPosition(distance);
        FRM.setTargetPosition(distance);
        BLM.setTargetPosition(-distance);
        FLM.setTargetPosition(-distance);
        FRM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FRM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BRM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BRM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BLM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BLM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FLM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FLM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        double CPR  = 384.5;
        double diameter = 96;
        double circumference = Math.PI*diameter;
        double position = FRM.getCurrentPosition();
        double revolutions = position/CPR;
        double distanceMoved = revolutions *circumference;
        double power = FRM.getPower();
        //acceleration
        boolean end = true;
        while (distanceMoved < distance && power < 0.75 && end) {
            power +=0.05;
            FRM.setPower(power);
            FLM.setPower(-power);
            BRM.setPower(power);
            BLM.setPower(-power);
            //deceleration
            if(distance - FRM.getCurrentPosition()/CPR * circumference < 100){
                end = false;
            }
        }
        while (power > .25){
            power -= .05;
        }
    }


}