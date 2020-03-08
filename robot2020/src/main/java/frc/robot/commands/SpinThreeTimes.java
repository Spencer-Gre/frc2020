/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheel;

public class SpinThreeTimes extends CommandBase {
  private final ColorWheel m_colorWheel;
  /**
   * Creates a new SpinThreeTimes.
   */
  public SpinThreeTimes(ColorWheel colorWheel) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_colorWheel = colorWheel;
    addRequirements(m_colorWheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_colorWheel.resetWheelPos();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_colorWheel.spinThreeTimes();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_colorWheel.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_colorWheel.getWheelPos() >= 3000 & m_colorWheel.getWheelPos() <= 8010){
      return true;
    }
    return false;
  }
}
