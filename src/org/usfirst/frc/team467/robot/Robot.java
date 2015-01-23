
package org.usfirst.frc.team467.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	private Joystick leftStick;  // set to ID 1 in DriverStation
    private Joystick rightStick; // set to ID 2 in DriverStation
    
	private CANTalon leftMotor;
	private CANTalon rightMotor;
	
	private DriveMode mode;
	
//	private CameraServer cam;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	leftStick = new Joystick(0);
        rightStick = new Joystick(1);
        
    	leftMotor = new CANTalon(2); //.changeControlMode(controlMode.<Mode Here>)
    	rightMotor = new CANTalon(1);
//    	leftMotor.disableControl();
//    	rightMotor.disableControl();
    	
    	mode = DriveMode.Straight;
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	if (mode == DriveMode.Straight)
    	{

        // Tank Drive
    	double left = leftStick.getY();
    	double right = rightStick.getY();
    	
//    	System.out.println(left + ", " + right);
    	
    	leftMotor.set(left);
    	rightMotor.set(right);
    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
