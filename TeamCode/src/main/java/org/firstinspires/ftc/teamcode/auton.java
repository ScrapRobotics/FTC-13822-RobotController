package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

public class auton extends OpMode {
    AprilTag aprilTag = new AprilTag();

    @Override
    public void init() {
        DcMotor BRM = hardwareMap.get(DcMotor.class, "BRM");
        DcMotor BLM = hardwareMap.get(DcMotor.class, "BLM");
        DcMotor FRM = hardwareMap.get(DcMotor.class, "FRM");
        DcMotor FLM = hardwareMap.get(DcMotor.class, "FLM");

        //gets obelisk tag data? Pray ts works
        aprilTag.displayDetectionTelemetry(getObeliskTag.getTag());
/*
        if(getObeliskTag.obeliskTag.id == 21){
            //gpp
        }
        if(getObeliskTag.obeliskTag.id == 22){
            //pgp
        }
        if(getObeliskTag.obeliskTag.id == 23){
            //ppg
        }
*/
    }


    public void loop() {

    }
}
