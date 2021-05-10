//Pathfinder Startup
//by Jack
//Meant to be the first and final point in the program

import java.io.File;
import java.util.Arrays;

class Pathfinder{
	public static pth_input playerInput;

	//Should return 0 or 1 for natural or unatural death
	public static void main(String[] args){
		pthfnder_initialize();
		pthfnder_gamestart();
	}

	private static void pthfnder_initialize(){
		//Load up dependencies
		Global Global = new Global();

		//Set Running Flag
		Global.running = true;
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
		pthfnder_initializeGame();
	};

	private static void pthfnder_initializeGame(){
		//Generate Ruleset Engine
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
	};

	private static void pthfnder_gamestart(){
		while(Global.running){
			//Retrieve Input (Parser)
			playerInput.pth_RetrieveInput();
			//Interpret Input (Action Engine)
			//Resolve Input (World Engine)
			//Generate Response (World Engine)
			Global.running = false;
		}
	}
}
