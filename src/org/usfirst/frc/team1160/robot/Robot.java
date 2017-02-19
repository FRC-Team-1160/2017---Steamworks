
package org.usfirst.frc.team1160.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1160.robot.subsystems.Climber;
import org.usfirst.frc.team1160.robot.subsystems.DriveTrain;

import org.usfirst.frc.team1160.robot.subsystems.FuelIntake;
import org.usfirst.frc.team1160.robot.subsystems.ServoSystem;
import org.usfirst.frc.team1160.robot.subsystems.Shooter;
import org.usfirst.frc.team1160.robot.subsystems.ShooterTurntable;
import org.usfirst.frc.team1160.robot.subsystems.USBCamera;
import org.usfirst.frc.team1160.robot.subsystems.VisionProcessing;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveTrain dt;
	public static ServoSystem servo;
	public static FuelIntake intake;
	public static Climber climber;
	public static Shooter shooter;
	public static ShooterTurntable turntable;
	public static VisionProcessing vision;
	public static USBCamera gearCam;

	Command autonomousCommand;
	SendableChooser chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override //This is where Robot.java starts
	public void robotInit() {
		intake = FuelIntake.getInstance();
		servo = ServoSystem.getInstance();
		climber = Climber.getInstance();
		turntable = ShooterTurntable.getInstance();
		shooter = Shooter.getInstance();
		//vision = VisionProcessing.getInstance();
		//gearCam = USBCamera.getInstance();
		dt = DriveTrain.getInstance();
		
		oi = OI.getInstance();

		// chooser.addObject("My Auto", new MyAutoCommand());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = (Command) chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		dt.resetPos();
		dt.setManual();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
