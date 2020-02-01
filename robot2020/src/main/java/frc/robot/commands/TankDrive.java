/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import java.util.function.DoubleSupplier;

public class TankDrive extends CommandBase {
  private final DriveTrain m_driveTrain;
  private final DoubleSupplier m_left;
  private final DoubleSupplier m_right;
  /**
   * Creates a new TankDrive.
   */
  public TankDrive(DriveTrain driveTrain, DoubleSupplier left, DoubleSupplier right) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_driveTrain = driveTrain;
    m_left = left;
    m_right = right;
    addRequirements(m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveTrain.telopDrive(m_left.getAsDouble(), m_right.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
    m_driveTrain.telopDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
