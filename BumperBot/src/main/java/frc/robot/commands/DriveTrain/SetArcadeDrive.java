/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.DriveTrain;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import java.util.function.DoubleSupplier;

/** Sets the drivetrain based on joystick inputs for forward and turning */
public class SetArcadeDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrain m_driveTrain;

  private final DoubleSupplier m_throttle, m_turn;
  private double joystickX, joystickY, throttle, turn;

  /**
   * Sets the drivetrain based on joystick inputs for forward and turning
   *
   * @param driveTrain drivetrain to set
   * @param throttle Percent output to drive forward.
   * @param turn Percent output to turn (positive = turn right, negative = turn left)
   */
  public SetArcadeDrive(DriveTrain driveTrain, DoubleSupplier throttle, DoubleSupplier turn) {
    m_driveTrain = driveTrain;
    m_throttle = throttle;
    m_turn = turn;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    joystickY = m_throttle.getAsDouble(); 
    // joystickY = MathUtil.applyDeadband(m_throttle.getAsDouble(), 0.05);
    joystickX = MathUtil.applyDeadband(m_turn.getAsDouble(), 0.05);

    throttle = joystickY;

    turn = -0.60 * joystickX;

    m_driveTrain.setMotorArcadeDrive(throttle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
