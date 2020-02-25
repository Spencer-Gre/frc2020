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
    public static final int LEFT_MASTER = 0;
    public static final int LEFT_SLAVE = 1;
    public static final int RIGHT_MASTER = 2;
    public static final int RIGHT_SLAVE = 3;

    // * Functional
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
    public static final int DIO_WHEELARM_LIMIT = 0;
    public static final int DIO_CONVEYOR_PHOTO = 1;
    public static final int AI_CONVEYOR_SONAR = 0;

    // ! Pneumatics
    

    // ! Constants
    // * Limelight
    public static final double Kp = .02;
    public static final double min_command = .05;
    public static final double distance_adjust = .05;

    // ! Ports
    public static final I2C.Port i2c = I2C.Port.kOnboard;

}
