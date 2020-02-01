/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  
  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(Constants.LEFT_MASTER);
  public WPI_TalonSRX leftSlave = new WPI_TalonSRX(Constants.LEFT_SLAVE);
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(Constants.RIGHT_MASTER);
  public WPI_TalonSRX rightSlave = new WPI_TalonSRX(Constants.RIGHT_SLAVE);


  public DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
  }

public void telopDrive(double left, double right) {
  drive.tankDrive(left, right);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
