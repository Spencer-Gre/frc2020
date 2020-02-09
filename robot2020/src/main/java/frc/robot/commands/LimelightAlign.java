/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.DriveTrain;;

public class LimelightAlign extends CommandBase {
  private final Vision m_vision;
  private final DriveTrain m_driveTrain;

  private double m_steeringKP = 0.055;
  private double m_targetArea = 2.1;
  private double m_driveKP = 0.80;
  /**
   * Creates a new LimelightAlign.
   */
  public LimelightAlign(Vision vision, DriveTrain driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_vision = vision;
    m_driveTrain = driveTrain;

    addRequirements(m_vision, m_driveTrain);
    
    SmartDashboard.putNumber("Steering KP", 0.04);  // TODO -- Tune KPs on carpet
    SmartDashboard.putNumber("min TA", 10);
    SmartDashboard.putNumber("Driving KP", 0.093);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_steeringKP = SmartDashboard.getNumber("Steering KP", 0.0);
    m_targetArea = SmartDashboard.getNumber("min TA", 0.0);
    m_driveKP = SmartDashboard.getNumber("Driving KP", 0.0);

    SmartDashboard.putNumber("Left", 10000);
    SmartDashboard.putNumber("Right", 10000);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double right = m_vision.getTX()*m_steeringKP; // Right Y
    double left  = (m_targetArea-m_vision.getTA())*m_driveKP; // Left X
    SmartDashboard.putNumber("target area", m_vision.getTA());

    // m_DriveTrain.teleop_drive(left, right); // Drive until the target is at desired distance
    SmartDashboard.putNumber("Left", left);
    SmartDashboard.putNumber("Right", right);
    if (m_vision.isTargetValid()) {
      if (m_vision.getTA() >= m_targetArea) {
        left = 0;
        right = 0;
      }
    } else {
     left = 0;
     right = 0;
    }

    m_driveTrain.telopDrive(-left, right);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrain.telopDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
