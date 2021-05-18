/*
Class for file generation and encryption
Written by Jack

Meant to generate monsters, items, locations, and NPC files
Purely a CORE action behind a DM password lock
*/

package DMTools;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;


public class pth_file_generator extends dmTool{
	//Variables
	private String fileName;
	private int seedValue;
	private String currentLine;
	private FileWriter fileWriter;
	private ArrayList<String> pendingFileOutput = new ArrayList<String>();
	private Scanner currentScanner = new Scanner(System.in);
	private String tempString="";

	//Constructors
	public pth_file_generator(){
		super.toolName = "File Generator";
	}

	//Functions
	@Override
	public void startTool()
	{
		try{
			pfg_Initialize();
			pfg_WriteText();
			pfg_VerifyText();
			System.out.println("File Written Successfully");
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
	}

	private void pfg_Initialize() throws IOException{
		System.out.println("Select Directory or File at current directory");
		fileName = currentScanner.nextLine();
		File file = new File(fileName);
		while(file.isDirectory()){
			System.out.println("Select Directory, File to load, or List name of New File:");
			fileName = fileName+ "/"  + currentScanner.nextLine();
			file = new File(fileName);
			if(!file.isFile()&&!file.isDirectory()){
				System.out.println("File does not exist, create it?(Y/N)");
				tempString = currentScanner.nextLine();
				tempString = tempString.toLowerCase();
				if(!tempString.equals("y")){
					System.exit(0);
				}
			}
		}
		file = new File(fileName);
		fileWriter = new FileWriter(fileName.toString());
	}

	//Function to pull all Text to write to file (DOES NOT WRITE TO FILE)
	private void pfg_WriteText() throws IOException{
		System.out.println("Write to File (Wite 'end file' to finalize)");
		while(tempString.toLowerCase().equals("end file")!=true){
			tempString = currentScanner.nextLine();
			pendingFileOutput.add(tempString.toString());
		}
	}

	//Quick function to verify the file output generated in pfg_WriteText()
	private void pfg_VerifyText() throws IOException{
		System.out.println("Please Verfiy Output to File(y/n) \n");
		for(int i=0;i<pendingFileOutput.size()-1;i++){
			System.out.println(pendingFileOutput.get(i));
		}
		System.out.println("");
		while(tempString.toLowerCase().equals("y")!=true &&
			tempString.toLowerCase().equals("n")!=true){
			tempString = currentScanner.nextLine();
		}
		if (tempString.equals("y"))
		{
			System.out.println("Would you like to encrypt your file(y/n)?");
			tempString = currentScanner.nextLine();
			if(tempString.equals("y"))
			{
				System.out.println("Encrypting File");
				pfg_EncryptText();
			}
			pfg_ToFile();
		}
	}

	//Encrypts Text in simple random seed based encryption
	private void pfg_EncryptText(){
		String tempString2 = "";
		char asciiEncode=' ';
		Random rnd = new Random(System.currentTimeMillis());
		rnd = new Random(rnd.nextLong());
		Long seed = rnd.nextLong();
		StringBuilder returnString;

		pendingFileOutput.add(0,seed.toString());
		for(int i=1;i<pendingFileOutput.size()-1;i++){
			tempString = pendingFileOutput.get(i);
			asciiEncode=' ';
			tempString2=null;
			returnString = new StringBuilder(tempString);

			for(int j=0;j<tempString.length();j++){
				//asciiEncode=
				//asciiEncode=(char)((Math.abs((int)tempString.charAt(j)*seed)%97)+33);
				seed = Math.abs(seed)%97;
				System.out.print(tempString.charAt(j));
				if(((int)tempString.charAt(j)+seed)>97){
					asciiEncode=(char)((((int)tempString.charAt(j)+seed)-97)+33);
				}
				else
				{
					asciiEncode=(char)((((int)tempString.charAt(j)+seed))+33);
				}
				System.out.println(" "+asciiEncode);
				//System.out.println(tempString.charAt(j)+" "+(int)tempString.charAt(j) + " " + asciiEncode);
				//tempString=tempString.substring(0,j-1)+asciiEncode+tempString.substring(j+1);
				returnString.setCharAt(j,asciiEncode);
			}
			pendingFileOutput.set(i, returnString.toString());
		}
	}

	//Write encrypted text to file
	private void pfg_ToFile() throws IOException{
		System.out.println("Saving To File");
		//System.out.println(Arrays.toString(pendingFileOutput.toArray(new String[pendingFileOutput.size()])));
		for(int i=0;i<pendingFileOutput.size()-1;i++){
			//System.out.println(pendingFileOutput.get(i));
			fileWriter.write(pendingFileOutput.get(i).toString());
			fileWriter.write("\n");
		}
		fileWriter.close();
	}
}
