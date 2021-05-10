/*
Global Variable Class
by Jack
Defenition of global variables
*/

import DMTools.*;

public class Global {
	public static String currentGame = "";//Current Game chosen
	public static String contentDirectory = "";//ContentDirectory
	public static boolean running = true;
	public static pth_FileParser fileParser = null;
	public static pth_Logger log = null;


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
}
