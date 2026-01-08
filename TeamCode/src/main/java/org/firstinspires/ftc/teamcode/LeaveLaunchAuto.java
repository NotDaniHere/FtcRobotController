package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Retarded Auto R", group="Robot")
public class LeaveLaunchAuto extends LinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("backRightMotor");
        ElapsedTime runtime = new ElapsedTime();
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        while(opModeIsActive()) {
            if(runtime.seconds() > 29) {
                frontRightMotor.setPower(-0.5);
                backRightMotor.setPower(-0.5);
                frontLeftMotor.setPower(0.5);
                backLeftMotor.setPower(0.5);
            } else {
                frontRightMotor.setPower(0);
                backRightMotor.setPower(0);
                frontLeftMotor.setPower(0);
                backLeftMotor.setPower(0);
            }
        }



    }
}
