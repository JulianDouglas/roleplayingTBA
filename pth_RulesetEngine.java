/*
pth_RulesetEngine
by Jack

Rule processing engine. Meant to process rules from parsed input
as well as adjust world actor attributes
*/

/** Not Currently in Use, but may be repurposed for story engine **/

import java.io.File;
import java.util.ArrayList;

class pth_RulesetEngine implements pth_Engine{
	//Variables
	private ArrayList<Rule> primaryRules;
	private ArrayList<Rule> secondaryRules;
	private Rule currentRule;
	private String[] tempParsedFile;

	public void addPrimaryRule(Rule newRule){primaryRules.add(newRule);};
	public void addSecondaryRule(Rule newRule){secondaryRules.add(newRule);};

	//Constructors
	pth_RulesetEngine(){
		primaryRules = new ArrayList<Rule>();
		secondaryRules = new ArrayList<Rule>();
		//engineParseFile("Rules");
	};

	//Functions
	public void processPrimaryRule(String[] actionToProcess){
		for(int i=0;i<primaryRules.size();i++){
			currentRule=primaryRules.get(i);
			if(actionToProcess[0].equals(currentRule.getName())){
				i = primaryRules.size()+1;
			}
		}
		System.out.println(currentRule.getName()+":Finished Processing");
	};

	public void engineParseFile(String fileName){
		//tempParsedFile = Global.fileParser.parseFile(fileName);

		
	};
}

/** POSSIBLE DEPRICATION **/