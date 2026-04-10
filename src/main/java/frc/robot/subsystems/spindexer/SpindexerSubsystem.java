// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.spindexer;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CombodexerConstants;



public class SpindexerSubsystem extends SubsystemBase {
  /** Creates a new SpindexerSubsystem. */

  private final SparkFlex spindexerMotor = new SparkFlex(CombodexerConstants.MOTOR_A_ID, MotorType.kBrushless);
  private final SparkFlex spindexerMotorInverse = new SparkFlex(CombodexerConstants.MOTOR_B_ID, MotorType.kBrushless);


  private final SparkMax IndexerMotorA = new SparkMax(CombodexerConstants.SMOTOR_A_ID, MotorType.kBrushless);
  private final SparkMax IndexerMotorB = new SparkMax(CombodexerConstants.SMOTOR_B_ID, MotorType.kBrushless);



   public SpindexerSubsystem() {

   SparkFlexConfig leaderConfig = new SparkFlexConfig();
    leaderConfig.idleMode(IdleMode.kCoast); 
        leaderConfig.inverted(true);

    SparkFlexConfig followerConfig = new SparkFlexConfig(); 
    followerConfig.idleMode(IdleMode.kCoast);
    followerConfig.inverted(false);


    SparkMaxConfig indexerAConfig = new SparkMaxConfig(); 
    SparkMaxConfig indexerBConfig = new SparkMaxConfig(); 
    indexerAConfig.inverted(CombodexerConstants.INVERTED_INDEXER_STATE);
    indexerBConfig.inverted(CombodexerConstants.INVERTED_INDEXER_STATE);

// Paremeter configs 
    spindexerMotor.configure(
        leaderConfig,
        ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters);

           spindexerMotorInverse.configure(
        followerConfig,
        ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters);

// ---- 

        IndexerMotorA.configure(
        indexerAConfig,
        ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters);

           IndexerMotorB.configure(
        indexerBConfig,
        ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters);

  };
  

  


  public void runCombodexer(){
    spindexerMotor.set(CombodexerConstants.SPINDEXER_SPEED);
    spindexerMotorInverse.set(CombodexerConstants.SPINDEXER_SPEED);

    // IndexerMotorA.set(CombodexerConstants.INDEXER_SPEED);
    // IndexerMotorB.set(CombodexerConstants.INDEXER_SPEED);
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
