/*
pth_DMmenu
Written by Jack

Purpose of this class is to handle the introduction and interface with the various DMTools avaliable
*/

package DMTools;

import java.io.*;

public class pth_DMmenu{
	//Variables

	//Constructors
	public pth_DMmenu(){
	}

	//Functions

	//entry point for DMTools Menu
	public void start(){
		try{
			dmClearScreen();
			System.out.println("Welcome to DM Tools" + "\n");

			System.out.println("These tools are put here for the express purpose of building and configuring the modules avaliable to you.");
			System.out.println("Please DO NOT USE these tools unless you know what you are doing." + "\n\n\n");
			System.out.println("Here is a list of avaliable Tools:");

			generateListOfTools();
		}
		catch(Exception ex)
		{

		}
	}

	public void dmClearScreen()
	{
		try{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
	}

	private void generateListOfTools(){
		
	}

}