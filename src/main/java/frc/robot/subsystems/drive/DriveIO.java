package frc.robot.subsystems.drive;

import org.littletonrobotics.junction.AutoLog;

public interface DriveIO {

    @AutoLog
    public static class DriveIOInputs {
        public double left1PositionMeters = 0.0;
        public double left1VelocityMetersPerSec = 0.0;
        public double left1AppliedVolts = 0.0;
        public double left1CurrentAmps = 0.0;

        public double left2PositionMeters = 0.0;
        public double left2VelocityMetersPerSec = 0.0;
        public double left2AppliedVolts = 0.0;
        public double left2CurrentAmps = 0.0;

        public double right1PositionMeters = 0.0;
        public double right1VelocityMetersPerSec = 0.0;
        public double right1AppliedVolts = 0.0;
        public double right1CurrentAmps = 0.0;

        public double right2PositionMeters = 0.0;
        public double right2VelocityMetersPerSec = 0.0;
        public double right2AppliedVolts = 0.0;
        public double right2CurrentAmps = 0.0;

        public double gyroYawDegrees = 0.0;
    }

    public void updateInputs(DriveIOInputs inputs);

    public void setVoltage(double leftVolts, double rightVolts);
}
