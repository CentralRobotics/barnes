// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;


public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsysterm. */

      private final SparkMax IntakeRoller = new SparkMax(IntakeConstants.MOTOR_ID, MotorType.kBrushless);

  public IntakeSubsystem() {}

  public void setIntakeSpeedManual(double motorSpeed) {
  IntakeRoller.set(motorSpeed);
  };

  public void runIntake() {
        IntakeRoller.set(-100);
    }

    // Run intake reverse (optional)
    public void reverseIntake() {
        IntakeRoller.set(IntakeConstants.INTAKE_SPEED);
    }

    public void stopIntake() {
        IntakeRoller.set(0.0);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void init(){

  }
}
