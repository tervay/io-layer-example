package frc.robot.subsystems.drive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotController;

public class DriveIOSparkMax implements DriveIO {

    CANSparkMax left1, left2, right1, right2;

    ADXRS450_Gyro gyro;

    public DriveIOSparkMax() {
        left1 = new CANSparkMax(0, MotorType.kBrushless);
        left2 = new CANSparkMax(1, MotorType.kBrushless);
        right1 = new CANSparkMax(2, MotorType.kBrushless);
        right2 = new CANSparkMax(3, MotorType.kBrushless);
        gyro = new ADXRS450_Gyro();

        left2.follow(left1);
        right2.follow(right1);
    }

    @Override
    public void updateInputs(DriveIOInputs inputs) {
        inputs.left1PositionMeters = left1.getEncoder().getPosition();
        inputs.left1VelocityMetersPerSec = left1.getEncoder().getVelocity();
        inputs.left1CurrentAmps = left1.getOutputCurrent();
        inputs.left1AppliedVolts = left1.getAppliedOutput() * RobotController.getBatteryVoltage();

        inputs.left2PositionMeters = left2.getEncoder().getPosition();
        inputs.left2VelocityMetersPerSec = left2.getEncoder().getVelocity();
        inputs.left2CurrentAmps = left2.getOutputCurrent();
        inputs.left2AppliedVolts = left2.getAppliedOutput() * RobotController.getBatteryVoltage();

        inputs.right1PositionMeters = right1.getEncoder().getPosition();
        inputs.right1VelocityMetersPerSec = right1.getEncoder().getVelocity();
        inputs.right1CurrentAmps = right1.getOutputCurrent();
        inputs.right1AppliedVolts = right1.getAppliedOutput() * RobotController.getBatteryVoltage();

        inputs.right2PositionMeters = right2.getEncoder().getPosition();
        inputs.right2VelocityMetersPerSec = right2.getEncoder().getVelocity();
        inputs.right2CurrentAmps = right2.getOutputCurrent();
        inputs.right2AppliedVolts = right2.getAppliedOutput() * RobotController.getBatteryVoltage();

        inputs.gyroYawDegrees = gyro.getAngle();
    }

    @Override
    public void setVoltage(double leftVolts, double rightVolts) {
        left1.setVoltage(leftVolts);
        right1.setVoltage(rightVolts);
    }

}
