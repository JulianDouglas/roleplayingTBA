/*
pth_RuleSetEngine_test
by Jack

Test class for pth_RuleSetEngine.java
Starting with small primary action processing
Input: [Attack,Goblin]
Rule: Action Attack 1d20 AC Damage
Output: [Attack,Goblin,Success]

Functions To Test:
Rule Generation
Primary Rule Processing
Secondary Rule Processing
Rule Generation Error Logging
Rule Processing Logging
*/
class pth_RuleSetEngine_test{
	//Variables
	public static pth_RulesetEngine RulesetEngine;
	public static String[] parsedInput =  {"Attack","Goblin"};
	public static String[] testRule =  {"Combat","Attack","Damage","1","20","Target:AC"};
	public static Rule loadedRule;

	//Constructors
	//Functions
	public static void main(String args[]){
		loadedRule = new Rule(testRule);
		RulesetEngine = new pth_RulesetEngine();

		System.out.println("Adding Rule");
		RulesetEngine.addPrimaryRule(loadedRule);
		System.out.println("Added Rule");
		System.out.println("Proccessing Rule");
		RulesetEngine.processPrimaryRule(parsedInput);
		System.out.println("Rule Processed");


		secondTest();
	};

	public static void secondTest(){
		
	}
}
