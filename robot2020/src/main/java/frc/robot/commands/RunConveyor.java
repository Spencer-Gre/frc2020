/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Conveyor;

public class RunConveyor extends CommandBase {
  private final Conveyor m_conveyor;
  /**
   * Creates a new RunConveyor.
   */
  public RunConveyor(Conveyor conveyor) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_conveyor = conveyor;
    addRequirements(m_conveyor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
     m_conveyor.resetConveyorPos();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_conveyor.getUltrasound() > 50) {
      m_conveyor.incrementConveyor();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_conveyor.stopConveyor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_conveyor.getUltrasound() < 15) {
      return true;
    }
    else if(m_conveyor.getPhotosensor()) {
      return true;
    } 
    else if(m_conveyor.getConveyorPos() >= 8000 & m_conveyor.getConveyorPos() <= 8010){
      return true;
    }
    return false;
  }
}
