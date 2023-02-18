// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.Pigeon2;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveTrainConstants.DriveTrainNeutralMode;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  double m_leftOutput, m_rightOutput;
  boolean m_controllerDrive = false; 

  private final Pigeon2 pigeon = new Pigeon2(Constants.DriveTrainConstants.pigeonID, "rio");
  private double lastYaw = 0;
  private double yawPerSecond = 0;
  private DriveTrainNeutralMode neutralMode = DriveTrainNeutralMode.COAST;
  private double leftOutput = 0, rightOutput = 0, magnitude = 1.0;
  private Spark[] driveMotors = {
    new Spark(3), //Front Left
    new Spark(4), //Back Left
    new Spark(1), //Front Right
    new Spark(2), //Back Right
};

  public DriveTrain() {

  driveMotors[0].setInverted(true);
  driveMotors[1].setInverted(true);
  driveMotors[2].setInverted(false);
  driveMotors[3].setInverted(false);

  }

  public void setMotorPercentOutput(double leftOutput, double rightOutput) {
    driveMotors[0].set(leftOutput);
    driveMotors[1].set(leftOutput);
    driveMotors[2].set(rightOutput);
    driveMotors[3].set(rightOutput);
  }

  public void setMotorArcadeDrive(double throttle, double turn) {
  leftOutput = throttle + turn;
  rightOutput = throttle - turn;

  // Normalization
  magnitude = Math.max(Math.abs(leftOutput), Math.abs(rightOutput));
  if (magnitude > 1.0) {
    leftOutput /= magnitude;
    rightOutput /= magnitude;
  }

  setMotorPercentOutput(leftOutput, rightOutput);
  // setMotorTankDrive(leftOutput, rightOutput);
  }

  public boolean getControllerDrive(){
    return m_controllerDrive; 
  }

  public void ToggleControllerDrive(){
    m_controllerDrive = !m_controllerDrive; 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
