// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkFlexConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

@SuppressWarnings("unused")
public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */

        private final SparkFlex FlywheelMotorA = new SparkFlex(ShooterConstants.MOTOR_A_ID, MotorType.kBrushless);
        private final SparkFlex FlywheelMotorB = new SparkFlex(ShooterConstants.MOTOR_B_ID, MotorType.kBrushless);
        // private final SparkFlex FlywheelMotorC = new SparkFlex(ShooterConstants.MOTOR_C_ID, MotorType.kBrushless);
        // private final SparkFlex FlywheelMotorD = new SparkFlex(ShooterConstants.MOTOR_D_ID, MotorType.kBrushless);
        private final RelativeEncoder flywheelRelativeEncoderA = FlywheelMotorA.getEncoder(); 
        // private final RelativeEncoder flywheelRelativeEncoderB = FlywheelMotorB.getEncoder();
        // private final RelativeEncoder flywheelRelativeEncoderC = FlywheelMotorC.getEncoder();
        // private final RelativeEncoder flywheelRelativeEncoderD = FlywheelMotorD.getEncoder();
        private final double GEAR_RATIO = 0; 
        private int RPM = 3; 

  public ShooterSubsystem() {
    SparkFlexConfig leaderConfig = new SparkFlexConfig();
    leaderConfig.idleMode(IdleMode.kCoast); 
    SparkFlexConfig followerConfig = new SparkFlexConfig(); 
    followerConfig.idleMode(IdleMode.kCoast);

// Paremeter configs 
    FlywheelMotorA.configure(
        leaderConfig,
        ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters);

    FlywheelMotorB.configure(
        followerConfig.follow(FlywheelMotorA),
        ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters);

    // FlywheelMotorC.configure(
    //     followerConfig.follow(FlywheelMotorA),
    //     ResetMode.kResetSafeParameters,
    //     PersistMode.kPersistParameters);

    // FlywheelMotorD.configure(
    //     followerConfig.follow(FlywheelMotorA),
    //     ResetMode.kResetSafeParameters,
    //     PersistMode.kPersistParameters);
  

  };

  public void rampFlywheel (double speedPercent) { 
    
    FlywheelMotorA.set(-speedPercent);
    FlywheelMotorB.set(speedPercent);
    // FlywheelMotorC.set(speedPercent);
    // FlywheelMotorD.set(-speedPercent);
    System.out.println("shooter running");

    
  }

  public void stopFlywheel() { 
    FlywheelMotorA.set(0);
    FlywheelMotorB.set(0);


    // FlywheelMotorC.set(0);
    // FlywheelMotorD.set(0);

  }

  public double getMotorRPM() {
    return flywheelRelativeEncoderA.getVelocity(); // RPM by default
  }
  public double getWheelRPM() {
    return getMotorRPM() / GEAR_RATIO;
  }



  public void initialize(){ 
    SmartDashboard.putString("Shooter Subsystem", "loaded");
  };

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Shooter Motor RPMs", getMotorRPM());
    SmartDashboard.putString("Shooter Subsystem", "active");
    SmartDashboard.putNumber("Shooter Wheel RPMs", getWheelRPM());

  }
}
