// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  Drivetrain drive;
  Climb climb;
  Intake intake;
  Shooter shooter;
  
  XboxController controller = new XboxController(0);
  XboxController controller2 = new XboxController(1);

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    drive = new Drivetrain();
    shooter = new Shooter();
    climb = new Climb();
    intake = new Intake();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    /**
     * universal controls
     */

    double left, right;
    if( controller.getBButton())  {
      left = controller.getLeftY();
      right = controller.getRightY(); 
    }
    else {
      left = controller.getLeftY() / 2;
      right = controller.getRightY() / 2; 
    }
    if (controller.getRightBumper()) {
      left = -left;
      right = -right;
    }

    //drive.tank(left, right);
    drive.arcade(-controller.getRightX(), -controller.getLeftY());
    shooter.shoot(controller.getRightTriggerAxis() * 1.5);
    if(controller2.getRightTriggerAxis() > 0.1) shooter.shoot(controller2.getRightTriggerAxis() * .36);
    if(controller.getYButtonPressed()) {
      intake.setspeed(intake.speed + 0.1);
      System.out.println("intake speed: " + intake.speed);
    } else if (controller.getXButtonPressed()) {
      intake.setspeed(intake.speed - 0.1);
      System.out.println("intake speed: " + intake.speed);    
    } 


    if(controller2.getStartButton()) {
      climb.up();
    } else if(controller2.getBackButton()) {
      climb.down();     
    } else {
      climb.off();
    }

    /**
     * shifted controls
     */

    if(controller.getLeftBumper()) {

      if(controller.getAButton()) {
        intake.out();
      } else if (controller2.getBButton()){
        intake.out();
      } else {
        intake.off();
      }


      shooter.feed(controller.getLeftTriggerAxis());
      if(controller.getLeftTriggerAxis() > 0.1) intake.in();

      return;
    }

    /** 
     * unshifted controls
     */

    shooter.feed(-controller.getLeftTriggerAxis());
    if(controller.getLeftTriggerAxis() > 0.1) intake.in();
    if(controller.getBButton()) {
      intake.in();
      } else if (controller2.getBButton()){
        intake.in();
      } else {
        intake.off();
      }
  }
}
