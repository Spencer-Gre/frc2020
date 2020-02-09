/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/*
 // ! DEPRECATED
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Limelight extends SubsystemBase {

    // * INTITIATE VARIABLES FOR THE LIMELIGHT API
    double x; // * Horizontal Offset
    double y; // * Vertical Offset
    double a; // * Target Area
    double s; // * Robot Skew
    double v; // * Target Visible
    double d; // * Actual Distance
    double led;
    
    // * IDEAL AND PREDETERMINED VARIABLES
    double heightL; // * HEIGHT OF LIMELIGHT
    double heightG; // * HEIGHT OF GOAL
    double idealDistance; // * IDEAL DISTANCE FROM GOAL
    double limelightAngle; // * ANGLE OF LIMELIGHT

    // * MOTOR CONTROLLERS AND VARIABLES
    WPI_TalonSRX leftMaster = new WPI_TalonSRX(Constants.LEFT_MASTER);
    WPI_VictorSPX leftSlave = new WPI_VictorSPX(Constants.LEFT_SLAVE); 
    WPI_TalonSRX rightMaster = new WPI_TalonSRX(Constants.RIGHT_MASTER);
    WPI_VictorSPX rightSlave = new WPI_VictorSPX(Constants.RIGHT_SLAVE);
    double left_command; // * PERCENT OUTPUT OF LEFT MOTORS
    double right_command; // * PERCENT OUTPUT OF RIGHT MOTORS

  // * CREATE NEW LIMELIGHT VARIABLE
  public Limelight() {
    heightL = 0;
    heightG = 0;
    idealDistance = 1;
    limelightAngle = 0;

    SmartDashboard.putNumber("Limelight TY", x);
    SmartDashboard.putNumber("Limelight TX", y);
  }

  public void setX(NetworkTableEntry tx) {
    x = tx.getDouble(0.0);
  }

  public void setY(NetworkTableEntry ty) {
    y = ty.getDouble(0.0);
  }  
  
  public void setArea(NetworkTableEntry ta) {
    a = ta.getDouble(0.0);
  }

  public void setV(NetworkTableEntry tv) {
    v = tv.getDouble(0.0);
  }

  public double getV() {
    return v;
  }

  public void autoAlign() {
    Double Kp = -Constants.Kp;
    Double KpDistance = -.01;
    //Double area_error = 3 - area;
    Double distance_adjust = Constants.distance_adjust;
    Double min_command = Constants.min_command;
    left_command = 0;
    right_command = 0;

    Double heading_error = -x;
    Double distance_error = -y;
    Double steering_adjust = 0.075;

    if (x > 1.0)
    {
            steering_adjust = Kp*heading_error - min_command;
    }
    else if (x < -1.0)
    {
            steering_adjust = Kp*heading_error + min_command;
    }
    
    distance_adjust = KpDistance * distance_error;

    left_command += -steering_adjust + distance_adjust;
    right_command += distance_adjust + steering_adjust;

    if (v == 1){

      leftMaster.set(ControlMode.PercentOutput, left_command);
      rightMaster.set(ControlMode.PercentOutput, -right_command);
      leftSlave.set(ControlMode.PercentOutput, left_command);
      rightSlave.set(ControlMode.PercentOutput, -right_command);

    }
    else
    {
      leftMaster.set(ControlMode.PercentOutput, 0);
      rightMaster.set(ControlMode.PercentOutput, 0);
      leftSlave.set(ControlMode.PercentOutput, 0);
      rightSlave.set(ControlMode.PercentOutput, 0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
*/