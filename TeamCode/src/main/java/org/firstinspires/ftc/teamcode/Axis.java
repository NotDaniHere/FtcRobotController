package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp(name = "axis_dani")
public class Axis extends OpMode {
    DcMotor frontLeftMotor;
    DcMotor frontRightMotor;
    DcMotor backLeftMotor;
    DcMotor backRightMotor;
    DcMotor shooter;

    @Override
    public void init() {
        frontLeftMotor = hardwareMap.get(DcMotor.class, "frontLeftMotor");
        frontRightMotor = hardwareMap.get(DcMotor.class, "frontRightMotor");
        backLeftMotor = hardwareMap.get(DcMotor.class, "backLeftMotor");
        backRightMotor = hardwareMap.get(DcMotor.class, "backRightMotor");
        shooter = hardwareMap.get(DcMotor.class, "shooter");
        frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
        backRightMotor.setDirection(DcMotor.Direction.REVERSE);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }


    @Override
    public void loop() {
        float x = gamepad1.right_stick_x;
        float y = -gamepad1.left_stick_y;
        double slidePower = gamepad1.left_stick_x;
        slide(slidePower);
        deplasare(x,y);
        if(gamepad1.a) shooter.setPower(-1);
        else shooter.setPower(0);

        telemetry.update();
    }

    private void deplasare(float x, float y) {
        double frontRightPower = y + x;
        double frontLeftPower = y - x;
        double backRightPower = y + x;
        double backLeftPower = y - x;

        setMotorPowers(frontLeftPower, frontRightPower, backLeftPower, backRightPower);
    }

    private void setMotorPowers(double fl, double fr, double bl, double br) {
        frontLeftMotor.setPower(fl);
        frontRightMotor.setPower(fr);
        backLeftMotor.setPower(bl);
        backRightMotor.setPower(br);
    }
    private void slide(double slidePower) {
        double frontLeftPower = -slidePower;
        double frontRightPower = slidePower;
        double backLeftPower = slidePower;
        double backRightPower = -slidePower;

        setMotorPowers(frontLeftPower, frontRightPower, backLeftPower, backRightPower);
    }
}