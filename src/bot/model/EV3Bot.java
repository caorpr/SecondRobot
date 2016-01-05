package bot.model;


import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.utility.Delay;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;





public class EV3Bot 
{

	private String botMessage;
	private int xPosition;
	private int yPosition;
	private long waitTime;
	
	
	public EV3Bot()
	{
		this.botMessage = "claytoni clates claytonbot";
		this.xPosition = 50;
		this.yPosition = 50;
		this.waitTime = 4000;
		
		setupPilot();
	}
	
	public void driveRoom()
	{
		botPilot.travel(254.12);
	}
	
	private void setupPilot()
	{
		Wheel leftWheel = WheeledChassis.modelWheel(Motor.A,  43.2).offset(-72);
		Wheel rightWheel = WheeledChassis.modelWheel(Motor.B, 43.2).offset(72);
		Chassis baseChassis = new WheeledChassis(new Wheel []{leftWheel, rightWheel}, WheeledChassis.TYPE_DIFFERENTIAL);
		botPilot = new MovePilot(baseChassis);
	}
	
	public void start()
	{
		LCD.drawString(message, xPosition, yPosition);
		Delay.msDelay(waitTime);
		
		claytonBot.driveRoom();
	}
	
	private void displayMessage()
	{
		LCD.drawString()
	}
	
	private void displayMessage(String message)
	{
		
	}
}
