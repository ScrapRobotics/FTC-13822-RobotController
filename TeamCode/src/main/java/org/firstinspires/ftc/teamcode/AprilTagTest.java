package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

@Autonomous
public class AprilTagTest  extends OpMode{
    AprilTag aprilTag = new AprilTag();
    @Override
    public void init(){
        aprilTag.init(hardwareMap, telemetry);
    }
    @Override
    public void loop(){
        aprilTag.update();
        AprilTagDetection id24 = aprilTag.getTagBySpecificId(24);
        aprilTag.displayDetectionTelemetry(id24);
    }
}
