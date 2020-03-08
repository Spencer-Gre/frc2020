/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Grabber extends SubsystemBase {
  private Talon tal;
  private DigitalInput ballSwitch;
  /**
   * Creates a new Grabber.
   */
  public Grabber() {
    tal = new Talon(Constants.PWM_GRABBER_SR);
    ballSwitch = new DigitalInput(Constants.DIO_GRABBER_SWITCH);
  }

  public void startGrab() {
    tal.set(0.5);
  }

  public void stopGrab() {
    tal.set(0.0);
  }

  public boolean getSwitch() {
    return ballSwitch.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Grabber Switch", ballSwitch.get());
  }
}
