package bot.controller;

import bot.model.EV3Bot;


public class RobotController 
{

	private EV3Bot claytonBot;
	
	public RobotController()
	{
		claytonBot = new EV3Bot();
	}
	
	public void start()
	{
		claytonBot.driveRoom();
	}
	
}
