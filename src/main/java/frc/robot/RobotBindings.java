// will work on this later if we have time 


// package frc.robot;

// import edu.wpi.first.wpilibj.DriverStation;
// import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.Commands;
// import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
// import frc.robot.subsystems.swervedrive.SwerveSubsystem;
// import frc.robot.util.FeedbackEngine.FeedbackEngine;
// import swervelib.SwerveInputStream;

// public class RobotBindings {

//   private final CommandXboxController driverXbox;
//   private final SwerveSubsystem drivebase;
//   private final SwerveInputStream driveDirectAngleKeyboard;

//   public RobotBindings(
//       CommandXboxController driverXbox,
//       SwerveSubsystem drivebase,
//       SwerveInputStream driveDirectAngleKeyboard) {
//     this.driverXbox = driverXbox;
//     this.drivebase = drivebase;
//     this.driveDirectAngleKeyboard = driveDirectAngleKeyboard;
//   }

//   public void configureSimulationBindings() {
//     if (!Robot.isSimulation()) {
//       return;
//     }

//     driverXbox.start().onTrue(
//         Commands.runOnce(() -> drivebase.resetOdometry(
//             new edu.wpi.first.math.geometry.Pose2d(
//                 3, 3, new edu.wpi.first.math.geometry.Rotation2d()))));

//     driverXbox.button(1).whileTrue(drivebase.sysIdDriveMotorCommand());

//     driverXbox.button(2).whileTrue(
//         Commands.runEnd(
//             () -> driveDirectAngleKeyboard.driveToPoseEnabled(true),
//             () -> driveDirectAngleKeyboard.driveToPoseEnabled(false)));
//   }

//   public void configureTestBindings(Command driveFieldOrientedAngularVelocity) {
//     if (!DriverStation.isTest()) {
//       return;
//     }

//     drivebase.setDefaultCommand(driveFieldOrientedAngularVelocity);

//     driverXbox.x().whileTrue(Commands.runOnce(drivebase::lock, drivebase).repeatedly());
//     driverXbox.start().onTrue(Commands.runOnce(drivebase::zeroGyro));
//     driverXbox.back().whileTrue(drivebase.centerModulesCommand());
//     driverXbox.leftBumper().onTrue(Commands.none());
//     driverXbox.rightBumper().whileTrue(drivebase.centerModulesCommand());
//   }
// // Teleop 
//   public void configureTeleopBindings() {
//     if (DriverStation.isTest()) {
//       return;
//     }

//     driverXbox.x().onTrue(Commands.runOnce(drivebase::addFakeVisionReading));
//     driverXbox.start().whileTrue(Commands.none());
//     driverXbox.back().whileTrue(Commands.none());

//     driverXbox.leftBumper().whileTrue(
//         Commands.runOnce(drivebase::lock, drivebase).repeatedly());

//     driverXbox.a().onTrue(
//         Commands.sequence(
//             Commands.runOnce(drivebase::zeroGyro),
//             FeedbackEngine.success(driverXbox)));

//     driverXbox.rightBumper().whileTrue(
//         drivebase.centerModulesCommand()
//             .andThen(FeedbackEngine.doublePulse(driverXbox)));
//   }
// }