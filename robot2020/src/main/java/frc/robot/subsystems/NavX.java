/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NavX extends SubsystemBase {
  private final AHRS ahrs;
  /**
   * Creates a new NavX.
   */
  public NavX() {
    ahrs = new AHRS(SPI.Port.kMXP);
  }

  public float getYaw() {
    return ahrs.getYaw();
  }

  public float getRoll() {
    return ahrs.getRoll();
  }

  public float getPitch() {
    return ahrs.getPitch();
  }

  public float getDisplacementX() {
    return ahrs.getDisplacementX();
  }

  public float getDisplacementY() {
    return ahrs.getDisplacementY();
  }

  public float getDisplacementZ() {
    return ahrs.getDisplacementZ();
  }

  public float getCompass() {
    return ahrs.getCompassHeading();
  }

  public void resetYaw() {
    ahrs.reset();
  }

  public void resetDisplacement() {
    ahrs.resetDisplacement();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
