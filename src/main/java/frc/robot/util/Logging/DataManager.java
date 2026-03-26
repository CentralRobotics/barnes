// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.util.Logging;

    /* Logs to FRC Console locally on roborio  */
public class DataManager {

    public static void LogToConsole(String message){ 
        
        edu.wpi.first.wpilibj.DataLogManager.log(message);
        System.out.println(message);

    }
}
