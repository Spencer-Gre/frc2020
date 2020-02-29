/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Conveyor extends SubsystemBase {
  private WPI_TalonSRX tal;
  private AnalogInput ultrasound;
  private Counter counter = new Counter();

  /**
   * Creates a new Conveyor.
   */
  public Conveyor() {
    tal = new WPI_TalonSRX(Constants.SRX_CONVEYOR);
    tal.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);

    ultrasound = new AnalogInput(Constants.AI_CONVEYOR_SONAR);
    //photosensor = new DigitalInput(Constants.DIO_CONVEYOR_PHOTO);

    counter.setUpSource(Constants.DIO_CONVEYOR_PHOTO);
    counter.setUpSourceEdge(false, true);
  }

  public double getUltrasound() {
    return ultrasound.getValue();
  }

  public void startConveyor() {
    tal.set(ControlMode.PercentOutput, 0.6);
  }

  public void stopConveyor() {
    tal.set(ControlMode.PercentOutput, 0.0);
  }

  public int getCount() {
    return counter.get();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Conveyor USound", getUltrasound());
    SmartDashboard.putNumber("Conveyor Count", getCount());

    SmartDashboard.putNumber("Conveyor Talon Count", tal.getSelectedSensorVelocity());
  }
}
