package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

import java.util.List;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

public class getObeliskTag {
    public static AprilTagDetection obeliskTag;
    public static AprilTagDetection getTag() {
        AprilTag aprilTag = new AprilTag();
        List<AprilTagDetection> tags  = aprilTag.getDetectedTags();
        for (int i = 0; i < tags.size(); i++) {
            if (tags.get(i).id == 21 || tags.get(i).id == 22 || tags.get(i).id == 23) {
                obeliskTag = tags.get(i);
                return tags.get(i);
            }
        }
        return null;
    }
}
