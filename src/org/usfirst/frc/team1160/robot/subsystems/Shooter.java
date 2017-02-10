//accidentally wrote the gear pickup code in the shooter code
//so like replace this whenever -kyle

package org.usfirst.frc.team1160.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.CANTalon;
/**
 *
 */
public class Shooter extends Subsystem {
	private static Shooter instance;
	private Spark spark;
	private CANTalon talon;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static Shooter getInstance()
	{
		if (instance == null)
		{
			instance = new Shooter();
		}
		return instance;
	}
	private Shooter()
	{
		spark = new Spark(0);
		talon = new CANTalon(0);
	}
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

