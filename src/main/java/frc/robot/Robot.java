// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.littletonrobotics.junction.LoggedRobot;
import org.littletonrobotics.junction.Logger;
import org.littletonrobotics.junction.inputs.LoggedNetworkTables;
import org.littletonrobotics.junction.io.ByteLogReceiver;
import org.littletonrobotics.junction.io.ByteLogReplay;
import org.littletonrobotics.junction.io.LogSocketServer;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.drive.Drive;
import frc.robot.subsystems.drive.DriveIOSim;
import frc.robot.subsystems.drive.DriveIOSparkMax;

public class Robot extends LoggedRobot {
  public static final Drive drive = new Drive(
      isReal() ? new DriveIOSparkMax() : new DriveIOSim());

  public static final XboxController driver = new XboxController(0);

  @Override
  public void robotInit() {
    // Run as fast as possible during replay
    setUseTiming(isReal());

    // Log & replay "SmartDashboard" values (no tables are logged by default).
    LoggedNetworkTables.getInstance().addTable("/SmartDashboard");

    if (isReal()) {
      // Log to USB stick (name will be selected automatically)
      Logger.getInstance().addDataReceiver(new ByteLogReceiver("/media/sda1/"));
      // Provide log data over the network, viewable in Advantage Scope.
      Logger.getInstance().addDataReceiver(new LogSocketServer(5800));
    }

    // Start logging! No more data receivers, replay sources, or metadata values may
    // be added.
    Logger.getInstance().start();

    drive.setDefaultCommand(new RunCommand(() -> {
      drive.drive(driver.getLeftTriggerAxis(), driver.getRightTriggerAxis(), driver.getRightX());
    }, drive));
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void simulationInit() {
  }

  @Override
  public void simulationPeriodic() {
  }
}
