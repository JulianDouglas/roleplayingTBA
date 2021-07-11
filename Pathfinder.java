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

		//Prompt for game setup
		System.out.println("Welcome to House Rules");
		System.out.println("Created by Julian Douglas");
		System.out.print("\n");
		System.out.println("Please select what game you would like to play:");

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

		for (int i = 0;i<listedRuleSets.length;i++){
			System.out.println(listedRuleSets[i]);
		}
		System.out.print("\n");

		gameInput = playerInput.pth_RetrieveInput();

		if (gameInput.equalsIgnoreCase("DMTools"))
		{
			Global.startDMmode();
		}
		else
		{
			for(int i = 0;i<listedRuleSets.length;i++){
				if (gameInput.equals(listedRuleSets[i]))
				{
					Global.currentGame=listedRuleSets[i];
					Global.contentDirectory=listedRules.getPath();
					Global.contentDirectory+="/"+Global.currentGame;
					System.out.println(Global.currentGame);
					System.out.println(Global.contentDirectory);
				}
			}
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
