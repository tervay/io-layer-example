package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;

public class DriveIOSim implements DriveIO {

    private DifferentialDrivetrainSim drivetrainSim = DifferentialDrivetrainSim
            .createKitbotSim(KitbotMotor.kDoubleNEOPerSide, KitbotGearing.k10p71, KitbotWheelSize.kSixInch, null);

    // Extra state that the sim doesn't have
    private double leftAppliedVolts, rightAppliedVolts;

    // This function runs every robot cycle
    @Override
    public void updateInputs(DriveIOInputs inputs) {
        // Update the diff drive sim model by 0.02 sec
        drivetrainSim.update(0.02);

        inputs.left1PositionMeters = drivetrainSim.getLeftPositionMeters();
        inputs.left2PositionMeters = drivetrainSim.getLeftPositionMeters();
        inputs.left1VelocityMetersPerSec = drivetrainSim.getLeftVelocityMetersPerSecond();
        inputs.left2VelocityMetersPerSec = drivetrainSim.getLeftVelocityMetersPerSecond();
        inputs.left1CurrentAmps = drivetrainSim.getLeftCurrentDrawAmps();
        inputs.left2CurrentAmps = drivetrainSim.getLeftCurrentDrawAmps();
        inputs.left1AppliedVolts = leftAppliedVolts;
        inputs.left2AppliedVolts = leftAppliedVolts;

        inputs.right1PositionMeters = drivetrainSim.getRightPositionMeters();
        inputs.right2PositionMeters = drivetrainSim.getRightPositionMeters();
        inputs.right1VelocityMetersPerSec = drivetrainSim.getRightVelocityMetersPerSecond();
        inputs.right2VelocityMetersPerSec = drivetrainSim.getRightVelocityMetersPerSecond();
        inputs.right1CurrentAmps = drivetrainSim.getRightCurrentDrawAmps();
        inputs.right2CurrentAmps = drivetrainSim.getRightCurrentDrawAmps();
        inputs.right1AppliedVolts = rightAppliedVolts;
        inputs.right2AppliedVolts = rightAppliedVolts;

        inputs.gyroYawDegrees = drivetrainSim.getHeading().getDegrees();
    }

    @Override
    public void setVoltage(double leftVolts, double rightVolts) {
        leftAppliedVolts = leftVolts;
        rightAppliedVolts = rightVolts;
        drivetrainSim.setInputs(leftAppliedVolts, rightAppliedVolts);
    }
}
