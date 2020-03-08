/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Grabber;

public class RunGrabber extends CommandBase {
  private final Grabber m_grabber;
  private final Conveyor m_conveyor;
  /**
   * Creates a new RunGrabber.
   */
  public RunGrabber(Grabber grabber, Conveyor conveyor) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_grabber = grabber;
    m_conveyor = conveyor;
    addRequirements(m_grabber, m_conveyor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_grabber.startGrab();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_grabber.stopGrab();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_grabber.getSwitch()) {
      return true;
    }
    return false;
  }
}
