/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
//import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Conveyor extends SubsystemBase { 
  private WPI_TalonSRX tal;
  private AnalogInput ultrasound;
  private DigitalInput photosensor;
  private int count;
  //private Counter counter = new Counter();

  /**
   * Creates a new Conveyor.
   */
  public Conveyor() {
    tal = new WPI_TalonSRX(Constants.SRX_CONVEYOR);
    tal.configFactoryDefault();
    tal.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 30);
    tal.setSensorPhase(false);
    tal.setInverted(false);
    tal.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 30);
    tal.setStatusFramePeriod(StatusFrameEnhanced.Status_10_Targets, 30);
    tal.configNominalOutputForward(0);
    tal.configNominalOutputReverse(0);
    tal.configPeakOutputForward(0.25);
    tal.configPeakOutputReverse(0.25);

    tal.selectProfileSlot(0, 1);
    tal.config_kF(0, Constants.kGains.kF, 30);
    tal.config_kP(0, Constants.kGains.kP, 30);
    tal.config_kI(0, Constants.kGains.kI, 30);
    tal.config_kD(0, Constants.kGains.kD, 30);


    tal.configMotionCruiseVelocity(15000, 30);
    tal.configMotionAcceleration(6000, 30);

    tal.setSelectedSensorPosition(0, 0, 30);

    //tal.setNeutralMode(NeutralMode.Brake);


    ultrasound = new AnalogInput(Constants.AI_CONVEYOR_SONAR);
    photosensor = new DigitalInput(Constants.DIO_CONVEYOR_PHOTO);

    //counter.setUpSource(Constants.DIO_CONVEYOR_PHOTO);
    //counter.setUpSourceEdge(false, true);

  }

  public double getUltrasound() {
    return ultrasound.getValue();
  }

  public boolean getPhotosensor() {
    return photosensor.get();
  }

  public int getCount() {
    return count;
  }

  public void incCount() {
    count++;
  }
  
  public void decCount() {
    count--;
  }

  public void resetCount() {
    count = 0;
  }

  public void incrementConveyor() {
    tal.set(ControlMode.MotionMagic, 8000);
  }
  
  public void pushConveyor() {
    tal.set(ControlMode.MotionMagic, 400);
  }

  public void startConveyor() {
    tal.set(ControlMode.PercentOutput, 0.6);
  }

  public void stopConveyor() {
    tal.set(ControlMode.PercentOutput, 0.0);
  }

  public int getConveyorPos() {
    return tal.getSelectedSensorPosition();
  }

  public void resetConveyorPos() {
    tal.setSelectedSensorPosition(0, 0, 10);
  }

  @Override
  public void periodic() {
    
    
    SmartDashboard.putNumber("Conveyor USound", getUltrasound());
    SmartDashboard.putNumber("Conveyor Count", getCount());

    SmartDashboard.putNumber("Conveyor Pos", tal.getSelectedSensorPosition());
  }
}
