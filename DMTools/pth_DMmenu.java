/*
pth_DMmenu
Written by Jack

Purpose of this class is to handle the introduction and interface with the various DMTools avaliable
*/

package DMTools;

import java.io.*;
import java.util.*;

public class pth_DMmenu{
	//Variables
	private ArrayList<dmTool> openTools = new ArrayList<dmTool>();

	//Constructors
	public pth_DMmenu(){
		openTools.add(new pth_file_generator());
	}

	//Functions

	//entry point for DMTools Menu
	public void start(){
		try{
			dmClearScreen();
			System.out.println("Welcome to DM Tools" + "\n");

			System.out.println("These tools are put here for the express purpose of building and configuring the modules avaliable to you.");
			System.out.println("Please DO NOT USE these tools unless you know what you are doing." + "\n\n");
			System.out.println("Here is a list of avaliable Tools:");

			generateListOfTools();
			toolSelect();
		}
		catch(Exception ex)
		{
			System.out.println("Error in DM Tools: " + ex.toString());
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
		for(dmTool tool:openTools)
		{
			System.out.println(tool.toolName);
		}


	}

	private void toolSelect()
	{
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();

		for(dmTool tool:openTools){
			if (s.equalsIgnoreCase(tool.toolName))
			{
				System.out.println("Matches Tool Name. Starting Tool...");
				tool.startTool();
			}
			else
			{
				System.out.println("Does not match: "+s.toString());
			}
		}
	}

}