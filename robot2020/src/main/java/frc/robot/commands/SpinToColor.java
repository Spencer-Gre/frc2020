/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.io.Console;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheel;

public class SpinToColor extends CommandBase {
  private final ColorWheel m_colorWheel;
  /**
   * Creates a new SpinToColor.
   */
  public SpinToColor(ColorWheel colorWheel) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_colorWheel = colorWheel;
    addRequirements(m_colorWheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putBoolean("Is met?", false);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Boolean isMet = false;
    SmartDashboard.putBoolean("Is met?", isMet);
    
    if(m_colorWheel.getRequired().length() > 0) {
      while(isMet = false){
        var color = m_colorWheel.getColor();
        if (color == m_colorWheel.getRequired()) {
          isMet = true;
        }
    }

    SmartDashboard.putBoolean("Is met?", isMet);
    this.end(false);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
