/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.I2C;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // ! Motor Controllers
    // * Drive
    public static final int LEFT_MASTER = 2;
    public static final int LEFT_SLAVE = 3; // ! Currently using an SRX as slave.
    public static final int RIGHT_MASTER = 0;
    public static final int RIGHT_SLAVE = 1;

    // * Functional
    public static final int SRX_COLORWHEEL = 4;
    public static final int SRX_SHOOTER_MASTER = 5;
    public static final int SPX_SHOOTER_FOLLOWER = 6;
    public static final int SRX_CONVEYOR = 7;
    public static final int SRX_ARM_MASTER = 8;
    public static final int SPX_ARM_FOLLOWER = 9;

    public static final int PWM_GRABBER_SR = 0;
    public static final int PWM_WHEELARM_SR = 1;

    // ! Trajectory Following
    public static final double K_TRACKWIDTH = 28;
    public static final double K_SVOLTS = 0.22;
    public static final double K_VELOCITYPERMETER = 1.98;
    public static final double K_ACCELPERMETER = 0.2;
    public static final double K_PDrive = 8.5;
    public static final double K_MAXSPEED = 3;
    public static final double K_MAXACCEL = 3;
    public static final double K_RAMSETEB = 2;
    public static final double K_RAMSETEZETA = 0.7;

    // ! Switches & Sensors
    public static final int ENCODER_LEFTDRIVE = 11;
    public static final int ENCODER_RIGHTDRIVE = 12;
    public static final int DIO_WHEELARM_LIMIT = 0;
    public static final int DIO_CONVEYOR_PHOTO = 1;
    public static final int DIO_GRABBER_SWITCH = 4;
    public static final int AI_CONVEYOR_SONAR = 0;

    // ! Pneumatics
    

    // ! Constants
    // * DRIVE
    public static final double K_GEAR_RATIO = 7.29;
    public static final double K_WHEEL_RADIUS_INCHES = 3.0;

    // * Limelight
    public static final double Kp = .02;
    public static final double min_command = .05;
    public static final double distance_adjust = .05;

    public static final Gains kGains = new Gains(2.27, 0.0, 0.0, 0.2, 0, 1.0);

    // ! Ports
    public static final I2C.Port i2c = I2C.Port.kOnboard;

}
