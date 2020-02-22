/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
  private final DoubleSolenoid m_leftGrabber;
  private final DoubleSolenoid m_rightGrabber;
  private final DoubleSolenoid m_wheelFlipper;
  private final DoubleSolenoid m_leftClimber;
  private final DoubleSolenoid m_rightClimber;
  /**
   * Creates a new Pneumatics.
   */
  public Pneumatics() {
    m_leftGrabber = new DoubleSolenoid(0, 1);
    m_rightGrabber = new DoubleSolenoid(2, 3);
    m_wheelFlipper = new DoubleSolenoid(4, 5);
    m_leftClimber = new DoubleSolenoid(6, 7);
    m_rightClimber = new DoubleSolenoid(8, 9);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
