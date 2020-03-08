/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.function.DoubleSupplier;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Grabber;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.ColorWheel;
import frc.robot.subsystems.Conveyor;
import frc.robot.commands.TankDrive;
import frc.robot.commands.LimelightAlign;
import frc.robot.commands.RunConveyor;
import frc.robot.commands.RunGrabber;
import frc.robot.commands.ShootSingle;
import frc.robot.commands.SpinThreeTimes;
import frc.robot.commands.SpinToColor;
import frc.robot.subsystems.Vision;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static AHRS gyro = new AHRS(SPI.Port.kMXP);
  public static boolean isCountIncrease = false;

  private final DriveTrain m_driveTrain = new DriveTrain();
  private final Vision m_vision = new Vision();
  private final ColorWheel m_colorWheel = new ColorWheel();
  private final Conveyor m_conveyor = new Conveyor();
  private final Shooter m_shooter = new Shooter();
  private final Grabber m_grabber = new Grabber();

  // ! Joystick
  private final Joystick controller = new Joystick(0);
  final DoubleSupplier leftsupply = () -> controller.getRawAxis(1);
  final DoubleSupplier rightsupply = () -> controller.getRawAxis(0);
  public JoystickButton trigger;
  public JoystickButton thumbDown;
  public JoystickButton buttonThree;
  public JoystickButton buttonEight;
  public JoystickButton buttonSeven;
  public JoystickButton buttonTen;

  public double getJoystickThrottle() {
    double throttle = controller.getThrottle();
    return throttle;
  }



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    m_driveTrain.setDefaultCommand(new TankDrive(m_driveTrain, this, leftsupply, rightsupply));
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    trigger = new JoystickButton(controller, 1);
    trigger.whenHeld(new LimelightAlign(m_vision, m_driveTrain));

    thumbDown = new JoystickButton(controller, 2);
    thumbDown.whenPressed(new SpinToColor(m_colorWheel));

    buttonThree = new JoystickButton(controller, 3);
    buttonThree.whenPressed(new SpinThreeTimes(m_colorWheel));

    buttonEight = new JoystickButton(controller, 8);
    buttonEight.whenPressed(new RunConveyor(m_conveyor));

    buttonSeven = new JoystickButton(controller, 7);
    buttonSeven.whileHeld(new ShootSingle(m_shooter, m_conveyor));

    buttonTen = new JoystickButton(controller, 10);
    buttonTen.whenPressed(new RunGrabber(m_grabber, m_conveyor).andThen(new RunConveyor(m_conveyor)));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  /*public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }*/
}
