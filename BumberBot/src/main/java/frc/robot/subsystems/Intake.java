// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
// import com.ctre.phoenix.motorcontrol.can.talonSRX;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */

  // Intake motor setup

  private TalonFX intakeMotor = new TalonFX(Constants.Intake.intakeMotor); 
  // Intake piston setup
 
  public Intake() {
    //default motor configurations
      intakeMotor.configFactoryDefault();
      intakeMotor.setNeutralMode(NeutralMode.Brake);
      intakeMotor.configOpenloopRamp(0.5);
      intakeMotor.setStatusFramePeriod(1, 100);
      intakeMotor.setStatusFramePeriod(2, 100);
      intakeMotor.configVoltageCompSaturation(10);
      intakeMotor.enableVoltageCompensation(true);
    SmartDashboard.putData("Intake Subsystem", this);
      intakeMotor.setInverted(TalonFXInvertType.Clockwise); // change this to TalonFXInvertType.CounterClokwise if motor is running backwards
  }
  /** sets the amount of power going to the intake */
  public void setIntakePercentOutput(double value) {
    intakeMotor.set(ControlMode.PercentOutput, value);
  }

  /** updates intake data on to the dashboard */
  public void updateSmartDashboard() {
    SmartDashboard.putNumber("Falcon Current PercentOutput", intakeMotor.getMotorOutputPercent()); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    updateSmartDashboard();
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

public void setIntakeRollerPercentOutput(double d) {
}
}
