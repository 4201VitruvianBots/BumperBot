// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.intake.RunIntake;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Intake m_intake = new Intake();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  static Joystick leftJoystick = new Joystick(Constants.USB.leftJoystick);

  static Joystick rightJoystick = new Joystick(Constants.USB.rightJoystick);
  public CommandXboxController xboxController = new CommandXboxController(Constants.USB.xBoxController);

  public Trigger[] leftJoystickTriggers = new Trigger[2]; // left joystick buttons
  public Trigger[] rightJoystickTriggers = new Trigger[2]; // right joystick buttons



  public Trigger xBoxLeftTrigger, xBoxRightTrigger;
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    initializeSubsystems();
  }

  public void initializeSubsystems() {
  }
  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() { // TODO: Replace Joystick Button?
    for (int i = 0; i < leftJoystickTriggers.length; i++)
    leftJoystickTriggers[i] = new JoystickButton(leftJoystick, (i + 1));
  for (int i = 0; i < rightJoystickTriggers.length; i++)
    rightJoystickTriggers[i] = new JoystickButton(rightJoystick, (i + 1));

    xboxController.a().whileTrue(new RunIntake(m_intake, 0.8)); 
    xboxController.b().whileTrue(new RunIntake(m_intake, -0.8)); 
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }

  public void disabledInit() {
  }

  public void disabledPeriodic() {
  }

  public void teleopInit() {
  }

  public void teleopPeriodic() {
  }

  public void autonomousInit() {}

  public void autonomousPeriodic() {
  }

  public void simulationInit() {
  }

  public void simulationPeriodic() {
  }
}
