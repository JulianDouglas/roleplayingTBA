/*
Rule
By Jack

Base class for rules used in all game modes
*/

class Rule{
	//Variables
	private String state;
	private String name;
	private String destination; //Rule to process after this
	private int numberOfDice;
	private int typeOfDice;
	private String comparisonAttribute;

	//Constructor
	public Rule(String[] ruleAttributes){
		state = ruleAttributes[0];
		name = ruleAttributes[1];
		destination = ruleAttributes[2];
		numberOfDice = Integer.parseInt(ruleAttributes[3]);
		typeOfDice = Integer.parseInt(ruleAttributes[4]);
		comparisonAttribute = ruleAttributes[5];
	};

	//Function
	public String getName(){
		return name;
	}
}
