/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveTrain extends SubsystemBase {
  private AHRS gyro = RobotContainer.gyro;
  
  private WPI_TalonSRX leftMaster = new WPI_TalonSRX(Constants.LEFT_MASTER);
  private WPI_TalonSRX leftSlave = new WPI_TalonSRX(Constants.LEFT_SLAVE);
  private WPI_TalonSRX rightMaster = new WPI_TalonSRX(Constants.RIGHT_MASTER);
  private WPI_VictorSPX rightSlave = new WPI_VictorSPX(Constants.RIGHT_SLAVE);


  private DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

  // TODO: FIX FRAME LENGTH
  DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Units.inchesToMeters(Constants.K_TRACKWIDTH));
  DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(getHeading());


  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);

    leftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    rightMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
  }

  public void telopDrive(double y, double x) {
    drive.arcadeDrive(y, x);
  }

  public double getAngle() {
    return -gyro.getAngle();
  }

  public Rotation2d getHeading() {
    return Rotation2d.fromDegrees(getAngle());
  }

  public DifferentialDriveWheelSpeeds getSpeeds() {
    return new DifferentialDriveWheelSpeeds(
      leftMaster.getSelectedSensorVelocity(),
      rightMaster.getSelectedSensorVelocity()
    );
  }
  
  public void setPower() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
