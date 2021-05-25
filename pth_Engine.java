/*
pth_Engine
By Jack

Default engine class
Contains default file parsing calls
*/

public class pth_Engine{
	//Variables
	private int mainDiceCap = 0;
	public String engineType = "";

	//Constructors
	pth_Engine(String game){
		engineType = game;
	}

	//Functions for retrieving structure to parse content into
	//Starts relevant agents for running the engine (i.e. Ruleset; Load Config Files; Load Game/Generate Character)
	public void initialiseEngine(String gameToStart){

	}

	//Parses the rule files
	public void engineParseFile(String fileName){}
	
}
