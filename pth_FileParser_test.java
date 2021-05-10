/*
pth_FileParser_test
by Jack

Test class for FileParser
*/

class pth_FileParser_test{
	//Variables
	static pth_FileParser testParser = new pth_FileParser();
	static String[] returnString;
	static Global testGlobal = new Global("Pathfinder");

	//Functions
	public static void main(String args[]){
		returnString = testParser.parseFile("Rules","Rules");

		for (int i = 0; i< returnString.length;i++){
			System.out.println(returnString[i]);
		}
	}
}
