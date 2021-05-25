/*
pth_FileParser
by Jack

Class for parsing files. Needs to have multiple parse functions based on file type
*/

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class pth_FileParser{
	//Variable
	private long seed;
	private File fileToParse;
	private Scanner scanner;
	private ArrayList<String> currentFile = new ArrayList<String>();
	private boolean validFile = false;
	private String unencryptedLine;
	private String firstLine;
	private StringBuilder returnString;

	//Constructors
	public pth_FileParser(){

	};

	//Functions
	public String[] parseFile(String fileType, String fileName){
		currentFile.clear();
		System.out.println("Parsing File Name: "+fileName);
		try{
			fileToParse = new File(Global.contentDirectory+"/"+fileType+"/"+fileName);
			if (fileToParse.isFile()&&fileToParse.canRead()){
				System.out.println("Valid File");
				validFile = true;
				scanner = new Scanner(fileToParse);
				firstLine = scanner.nextLine();
				if(numericCheck(firstLine))
				{
					seed = Long.parseLong(firstLine);
					//currentFile.add(unencryptLine(firstLine));
				}
				else
				{
					seed = 0;
					currentFile.add(firstLine);
				}
			}
			while(validFile&&scanner.hasNextLine())
			{
				System.out.println("Reading Line");
				unencryptedLine = scanner.nextLine();
				if(seed != 0)
				{
					currentFile.add(unencryptLine(unencryptedLine));
				}
				else
				{
					currentFile.add(unencryptedLine);
				}
			}
			return currentFile.toArray(new String[0]);
		}
		catch(Exception ex)
		{
			Global.log.log("Error","Parser:"+fileType+"/"+fileName+" Error:"+ex.toString());
			return null;
		}
	};

	//Reverses the encryption on a file
	private String unencryptLine(String lineToUnencrypt){
		Random rnd = new Random(seed);
		char asciiDecode = ' ';
		returnString = new StringBuilder(lineToUnencrypt);
		seed = Math.abs(seed)%97;
		for(int i=0;i<lineToUnencrypt.length();i++){
			asciiDecode = ' ';
			if(((int)lineToUnencrypt.charAt(i)-33)+97<=126+seed)
			{
				asciiDecode =((char)(((((int)lineToUnencrypt.charAt(i)-33)+(97))-seed)));
			}
			else
			{
				asciiDecode =((char)(((((int)lineToUnencrypt.charAt(i)-33))-seed)));
			}
			returnString.setCharAt(i,asciiDecode);
		}
		return returnString.toString();
	};

	private boolean numericCheck(String stringToCheck){
		try{
			long l = Long.parseLong(stringToCheck);
			System.out.println(stringToCheck + " is a number");
			return true;
		}
		catch(NumberFormatException ex)
		{
			System.out.println(stringToCheck + " is not a number");
			return false;
		}
		catch(Exception ex)
		{
			Global.log.log("Error", "Error: Engine Parse Numeric Check Failure");
			System.out.println("Error Logged: Check Log");
			return false;
		}
	}
}

