//Pathfinder Startup
//by Jack
//Meant to be the first and final point in the program

import java.io.File;
import java.util.Arrays;

class Pathfinder{
	public static pth_input playerInput;
	public static Global Global;

	//Should return 0 or 1 for natural or unatural death
	public static void main(String[] args){
		pthfnder_initialize();
		pthfnder_gamestart();
	}

	private static void pthfnder_initialize(){
		//Load up dependencies
		Global = new Global();

		//Set Running Flag
		Global.running = true;
		Global.clearScreen();
		//Start with Input class
		playerInput = new pth_input("Player Input Parser",false);

		//Retrieve game select
		pthfnder_pullAvaliableGames();

		//Initialize game setup
		if(Global.currentGame != "")
		{
			pthfnder_initializeGame();
		}
		else
		{
			System.out.print("Please choose a listed game");
			//To Do: Add looped input for choosing game
		}
	};

	private static void pthfnder_initializeGame(){
		//Generate Ruleset Engine
		System.out.println("Starting engine");
		Global.startEngine();
	};

	private static void pthfnder_pullAvaliableGames(){
		File listedRules = new File(System.getProperty("user.dir")+"/Content");
		String gameInput;

		String[] listedRuleSets = listedRules.list();

		Menu.PlayerInputAction playerInputAction = Menu.printMenuAndGetPlayerInput(
			"Welcome to House Rules\n" +
			"Created by Julian Douglas\n\n" +
			"Please select a listed game", listedRuleSets, playerInput);
		
		if (playerInputAction.playerInput.equalsIgnoreCase("DMTools"))
		{
			Global.startDMmode();
		}
		else if (playerInputAction.actionIndex != -1)
		{
			Global.currentGame=listedRuleSets[playerInputAction.actionIndex];
			Global.contentDirectory=listedRules.getPath();
			Global.contentDirectory+="/"+Global.currentGame;
			System.out.println(Global.currentGame);
			System.out.println(Global.contentDirectory);
		}
	};

	private static void pthfnder_gamestart(){
		while(Global.running && Global.currentGame != ""){
			//Retrieve Input (Parser)
			//Interpret Input (Action Engine)
			Global.currentEngine.interpretInput(playerInput.pth_RetrieveInput()); 
			//Resolve Input (World Engine)
			//Generate Response (World Engine)
			//Global.running = false;
		}
	}
}
