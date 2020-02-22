/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.HashMap;
import java.util.Hashtable;

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
    // Begin motor control
    boolean isMet = false;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Kill the motors
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    /* 
    * Dictionary such that the key is the required color and the value is the color you must spin to.
    */
    HashMap<Character, Character> colorPattern = new HashMap<Character, Character>();
    colorPattern.put('R', 'B');
    colorPattern.put('Y', 'G');
    colorPattern.put('B', 'R');
    colorPattern.put('G', 'Y');

    var gameRequired = m_colorWheel.getRequired();
    

    if(m_colorWheel.getColor() == m_colorWheel.getRequired()) {
      SmartDashboard.putBoolean("Is met?", true);
      return true;
    }
    return false;
  }
}
