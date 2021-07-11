/*
pth_Engine
By Jack

Default engine class
Contains default file parsing calls
*/

import java.util.ArrayList;
import java.util.Random;

public class pth_Engine{
	//Variables
	private int mainDiceCap = 0;
	public String engineType = "";
	public ArrayList<String[]> ruleSet = new ArrayList<String[]>();
	public ArrayList<String[]> commandSet = new ArrayList<String[]>();
	private String[] tempIndividualRule;
	private String[] splitPlayerInput;
	private int splitCount;

	//Constructors
	pth_Engine(String game){
		engineType = game;
	}

	//Functions for retrieving structure to parse content into
	//Starts relevant agents for running the engine (i.e. Ruleset; Load Config Files; Load Game/Generate Character)
	public void initialiseEngine(String gameToStart){
		engineParseFile("Rules","Rules", ruleSet);
		engineParseFile("Rules","Commands", commandSet);

		interpretEngineRules();

		System.out.println("...Engine Loaded");
	}

	//Parses the rule files using Global Function
	public void engineParseFile(String type, String fileName, ArrayList<String[]> structuretoadd){
		tempIndividualRule = Global.fileParser.parseFile(type, fileName);

		for (String rule : tempIndividualRule)
		{
			splitCount = 0;
			for(int i=0; i<rule.length();i++)
			{
				if(rule.charAt(i)==' ')
				{
						splitCount +=1;
				}
			}
			//System.out.println(rule);
			structuretoadd.add(rule.split(" ",splitCount+1));
		}
	}

	//Adds the Rules to Engine variables
	private void interpretEngineRules()
	{
		for(String[] rule:ruleSet)
		{
			switch(rule[0])
			{
				case "dice": mainDiceCap = Integer.parseInt(rule[1]);
				break;
			}
		}
	}

	//Engine wide input interpretation
	public void interpretInput(String playerInput){
		if (playerInput.equalsIgnoreCase("quit") || playerInput.equalsIgnoreCase("quit game"))
		{
			Global.running = false;
		}
		else
		{
			splitCount = 0;
			for(int i=0; i<playerInput.length();i++)
			{
				if(playerInput.charAt(i)==' ')
				{
						splitCount +=1;
				}
			}
			splitPlayerInput = playerInput.split(" ", splitCount+1);

			for(String[] rule:commandSet)
			{
				System.out.println("Checking if " + rule[0].toString() + " equals " + splitPlayerInput[0]);
				if(rule[0].equalsIgnoreCase(splitPlayerInput[0]))
				{
					System.out.println(rule[0].toString());
					System.out.println("Rolling with Rule Cap: " + rollDice());
					System.out.println("Rolling with Custom Cap: " + rollDice(100));
				}
			}
		}
	}

	//Rolls the standard check Dice
	private int rollDice(){
		Random rn = new Random();

		return rn.nextInt(mainDiceCap);
	}

	//Rolls a specific Dice
	private int rollDice(int diceType){
		Random rn = new Random();

		return rn.nextInt(diceType);
	}
}
