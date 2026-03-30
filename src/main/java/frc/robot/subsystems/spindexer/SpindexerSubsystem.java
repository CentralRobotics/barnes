// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.spindexer;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SpindexerConstants;

public class SpindexerSubsystem extends SubsystemBase {
  /** Creates a new SpindexerSubsystem. */

  private final SparkMax spindexerMotor = new SparkMax(SpindexerConstants.MOTOR_A_ID, MotorType.kBrushless);

  public void runSpindexer() {
    spindexerMotor.set(100);
  }

  public void stopSpindexer() {
    spindexerMotor.set(0);
  }

  public SpindexerSubsystem() {

    SparkMaxConfig motorConfigsDefault = new SparkMaxConfig();
    motorConfigsDefault.idleMode(IdleMode.kCoast);
    spindexerMotor.configure(
        motorConfigsDefault,
        ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
