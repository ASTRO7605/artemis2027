package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp(name="CRServo_TeleOp", group="Servo")
public class t2 extends LinearOpMode {

    private CRServo crServo;

    @Override
    public void runOpMode() {

        // Nom du servo dans la configuration FTC
        crServo = hardwareMap.get(CRServo.class, "crServo");

        telemetry.addLine("CRServo prêt");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // Vitesse variable avec le trigger droit (0 à 1)
            double variableSpeed = gamepad1.right_trigger;

            // Vitesse max avant
            if (gamepad1.a) {
                crServo.setPower(1.0);
            }
            // Vitesse max arrière
            else if (gamepad1.b) {
                crServo.setPower(-1.0);
            }
            // Vitesse variable
            else if (variableSpeed > 0.05) {
                crServo.setPower(variableSpeed);
            }
            // Stop
            else {
                crServo.setPower(0.0);
            }

            telemetry.addData("Power", crServo.getPower());
            telemetry.update();
        }
    }
}