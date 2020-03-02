/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  private CANSparkMax maxUn = new CANSparkMax(40, MotorType.kBrushless);
  private CANSparkMax maxDeux = new CANSparkMax(41, MotorType.kBrushless);
  /**
   * Creates a new Arm.
   */
  public Arm() {
    maxDeux.follow(maxUn);
    maxUn.getEncoder().setPosition(0);
    maxDeux.getEncoder().setPosition(0);
  }

  public void startArm() {
    maxUn.set(1.0);
  }

  public void stopArm() {
    maxUn.set(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("MaxUn", maxUn.getEncoder().getVelocity());
    SmartDashboard.putNumber("MaxUnPos", maxUn.getEncoder().getPosition());
    SmartDashboard.putNumber("MaxDeux", maxDeux.getEncoder().getVelocity());
    SmartDashboard.putNumber("MaxDeuxPos", maxDeux.getEncoder().getPosition());
  }
}
