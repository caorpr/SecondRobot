package bot.model;


import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.utility.Delay;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;





public class EV3Bot 
{

	private String botMessage;
	private int xPosition;
	private int yPosition;
	private long waitTime;
	
	private MovePilot botPilot;
	private EV3UltrasonicSensor distanceSensor;
	private EV3TouchSensor backTouch;
	
	private float [] ultrasonicSamples;
	
	
	public EV3Bot()
	{
		this.botMessage = "claytoni clates claytonbot"; //Heh heh, his was "cody codes codybot"
		this.xPosition = 0;
		this.yPosition = 5;
		this.waitTime = 4000;
		
		distanceSensor = new EV3UltrasonicSensor(LocalEV3.get().getPort("S1"));
		backTouch = new EV3TouchSensor(LocalEV3.get().getPort("S2"));
		
		
		
		setupDistanceArray();
		setupPilot();
		
		
		displayMessage();
	}
	
	
	private void setupDistanceArray()
	{
		//roomDistance[0] = (12 * 2.54 * 3);
		//roomDistance[1] = (12 * 254 * 10.5);
		//random stuff from Mr. H!
	}
	
	
	// Initializes a MovePilot object outside the constructor
	private void setupPilot()
	{
		Wheel leftWheel = WheeledChassis.modelWheel(Motor.A,  43.2).offset(-72);
		Wheel rightWheel = WheeledChassis.modelWheel(Motor.B, 43.2).offset(72);
		Chassis baseChassis = new WheeledChassis(new Wheel []{leftWheel, rightWheel}, WheeledChassis.TYPE_DIFFERENTIAL);
		botPilot = new MovePilot(baseChassis);
	}
	
	
	
	
	
	
	
	
	public void driveRoom()
	{
		ultrasonicSamples = new float [distanceSensor.sampleSize()];
		distanceSensor.fetchSample(ultrasonicSamples,  0);
		if(ultrasonicSamples[0] < 2.5) // 2.5 is not the real number, you must figure it out!
		{
			displayMessage("Short Drive");
			
			 
			
		}
		
		botPilot.travel(254.12);
		botPilot.rotateLeft();
		botPilot.rotateRight();
	}
	
	
	
	
	
	
	public void start()
	{
		LCD.drawString(botMessage, xPosition, yPosition);
		Delay.msDelay(waitTime);
		
		
	}
	
	private void displayMessage()
	{
		LCD.drawString(botMessage, xPosition, yPosition);
	}
	
	private void displayMessage(String message)
	{
		LCD.drawString(message, xPosition, yPosition);
	}
}
