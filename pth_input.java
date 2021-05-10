//pth_Input
//Written by Jack
/**
Input class for Pathfinder User information
Generally Just Standard Java Scanner class
Some general stubs for future advanced parsing options
**/

import java.lang.String;
import java.util.Scanner;
import java.util.Arrays;

class pth_input{
	private String inputName;
	private Scanner scanner;
	private String[] parsedWordList;
	private boolean debug = false;
	//Parsing Variables
	private String parsedQuote;
	private int startIndex;
	private int lastIndex;
	private String[] parsedQuotes = new String[5];
	private int quoteCount;

	//Constructors
	public pth_input(){
		inputName = "Default Scanner Name";
		scanner = new Scanner(System.in);
	}

	public pth_input(String newName){
		inputName = newName;
		scanner = new Scanner(System.in);
	}

	public pth_input(String newName, boolean setDebug){
		inputName = newName;
		scanner = new Scanner(System.in);
		debug = setDebug;
	}

	//Getters and Setters
	public String getName(){return inputName;}
	public void setName(String newName){inputName = newName;}
	public boolean getDebug(){return debug;}
	public void toggleDebug(){debug = !debug;}

	//Functions
	public String pth_RetrieveInput(){
		String rawInput = "";

		rawInput = scanner.nextLine();
		try
		{
			parseInput(rawInput);
		}
		catch(Exception e)
		{
			System.out.println("Error reading line: " + e.toString());
		}
		return rawInput;
	}

	//Parses each word out and quotes.
	//Adds them to Parsed Word list for interpretation
	private void parseInput(String rawInput){
		quoteCount = 0;

		if(debug){System.out.println("Debug: Raw Data " + rawInput);}

		while(rawInput.indexOf('"')!=-1)
		{
			startIndex = rawInput.indexOf('"');
			lastIndex = rawInput.indexOf('"',startIndex+1);
			parsedQuote = rawInput.substring(startIndex,lastIndex+1);
			if(debug){System.out.println("Quote: "+ startIndex + " " + lastIndex + " " + parsedQuote);}

			parsedQuotes[quoteCount] = parsedQuote;

			quoteCount+=1;
			if(debug){System.out.println("Number of Quotes: " + quoteCount);}
			rawInput = rawInput.replace(parsedQuote,"/~?"+quoteCount+"?~/");
			if(debug){System.out.println("Quote Ripped: "+rawInput);}
		}

		parsedWordList = rawInput.split(" ");

		while(quoteCount>0)
		{
			for(int i=parsedWordList.length-1;i>=0;i--){
				if(parsedWordList[i].equals("/~?"+quoteCount+"?~/")){
					parsedWordList[i] = parsedQuotes[quoteCount-1];
				}
			}
			quoteCount = quoteCount-1;
		}

		if(debug){System.out.println("Debug: Split Data " + Arrays.toString(parsedWordList));}
	}
}

