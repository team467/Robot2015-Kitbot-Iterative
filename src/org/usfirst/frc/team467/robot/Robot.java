
package org.usfirst.frc.team467.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

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
	@Override
    public void robotInit() {
    	System.out.println("Blah");
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
	@Override
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
	@Override
    public void teleopPeriodic() {
    	System.out.println("Periodic");
    	updateButtons();
    	drive();
    }
    
    /**
     * This function is called periodically during test mode
     */
	@Override
    public void testPeriodic() {
    
    }
    
    public void drive()
    {
    	if (mode == DriveMode.Tank){
    		double left = leftStick.getY();
    		double right = rightStick.getY();
    		leftMotor.set(left);
    		rightMotor.set(right);
//    		System.out.println(left + ", " + right);
    	}
    	
    	else if (mode == DriveMode.Straight)
    	{
    		double speed = leftStick.getY();
    		leftMotor.set(speed);
    		rightMotor.set(speed);
    		SmartDashboard.putNumber("Speed:", speed);
    	}
    	else if (mode == DriveMode.Rotate)
    	{
    		double speed = leftStick.getTwist();
    		leftMotor.set(-speed);
    		rightMotor.set(speed);
    	}
    	else if (mode == DriveMode.Both)
    	{
    		double speed = leftStick.getY();
    		double turn = leftStick.getX();
    		leftMotor.set(speed -= turn);
    		rightMotor.set(speed += turn);
    		
    	}
    }
    
    public void updateButtons()
    {
    	if (leftStick.getRawButton(2))
    	{
    		mode = DriveMode.Rotate;
    	}
    	else
    	{
    		mode = DriveMode.Straight;
    	}
//    	else if leftStick.getRawButton(button)
    }
    
}
