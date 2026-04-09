// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.spindexer;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SpindexerConstants;
import frc.robot.Constants.IndexerConstants;



public class SpindexerSubsystem extends SubsystemBase {
  /** Creates a new SpindexerSubsystem. */

  private final SparkFlex spindexerMotor = new SparkFlex(SpindexerConstants.MOTOR_A_ID, MotorType.kBrushless);
  private final SparkFlex spindexerMotorInverse = new SparkFlex(SpindexerConstants.MOTOR_B_ID, MotorType.kBrushless);
  // private final SparkMax IndexerMotorA = new SparkMax(IndexerConstants.MOTOR_A_ID, MotorType.kBrushless);
  // private final SparkMax IndexerMotorB = new SparkMax(IndexerConstants.MOTOR_B_ID, MotorType.kBrushless);
  private final RelativeEncoder spindexerMotorRelativeEncoder = spindexerMotor.getEncoder();

   public SpindexerSubsystem() {

   SparkFlexConfig leaderConfig = new SparkFlexConfig();
    leaderConfig.idleMode(IdleMode.kCoast); 
        leaderConfig.inverted(true);

    SparkFlexConfig followerConfig = new SparkFlexConfig(); 
    followerConfig.idleMode(IdleMode.kCoast);
    followerConfig.inverted(false);


// Paremeter configs 
    spindexerMotor.configure(
        leaderConfig,
        ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters);

           spindexerMotorInverse.configure(
        followerConfig,
        ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters);


  };


  public void runCombodexer(){
    spindexerMotor.set(.5);
    spindexerMotorInverse.set(.5);

    // IndexerMotorA.set(IndexerConstants.MOTOR_SPEED);
    // IndexerMotorB.set(IndexerConstants.MOTOR_SPEED_NEGATIVE);
  }

  public void stopCombodexer(){ 
    spindexerMotor.stopMotor();
    spindexerMotorInverse.stopMotor();
    // IndexerMotorA.set(0);
    // IndexerMotorB.set(0);

  }
 

  
 

  @Override
  public void periodic() {

    // SmartDashboard.putNumber("Spindexer Motor RPMs", spindexerMotorRelativeEncoder.getVelocity());
  }
}
