/*
pth_Logger_test
by Jack

Test class for logger
*/
//package Pathfinder.DMTools;
import DMTools.pth_Logger;

class pth_Logger_test{
	//Variables
	static Global testGlobal;
	static pth_Logger testLogger;

	//Functions
	public static void main(String args[]){
		testGlobal = new Global();
		testLogger = new pth_Logger();

		testLogger.log("Error","Test Logger");
		Global.log("Test File","Something to write about");

	}
}
