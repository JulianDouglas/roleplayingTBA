/*
Global Variable Class
by Jack
Defenition of global variables
*/


import DMTools.*;
import java.io.IOException;

public class Global {
	public static String currentGame = "";//Current Game chosen
	public static String contentDirectory = "";//ContentDirectory
	public static boolean running = true;
	public static pth_FileParser fileParser = null;
	public static pth_Engine currentEngine = null;
	public static pth_Logger log = null;
	private static boolean dmMode = false; //A flag for when the menu switches to DM Tools
	private static pth_DMmenu DMHandler = null;


	//Development Functions (DO NOT CALL OUTSIDE OF TEST CLASSES)
	public Global(){
		fileParser = new pth_FileParser();
		log = new pth_Logger();
	}

	public Global(String setCurrentGame){
		currentGame = setCurrentGame;
		contentDirectory = System.getProperty("user.dir")+"/Content/"+setCurrentGame;
		fileParser = new pth_FileParser();
		log = new pth_Logger();
	}

	//Initiate DMmode from anywhere
	public void startDMmode(){
		dmMode = true;
		DMHandler = new pth_DMmenu();
		DMHandler.start();
	}

	//Clear Screen from anywhere
	public static void clearScreen(){
		try{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
	}

	//Intiates game engine of given type
	public void startEngine(){
		currentEngine = new pth_Engine(currentGame);
		currentEngine.initialiseEngine(currentGame);
	}

	//Parses file
	public String[] parseFile(String type, String fileToParse)
	{
		return fileParser.parseFile(type, fileToParse);
	}
}
