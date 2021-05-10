//test Class for pth_input
//Written by Jack

//import pth_input;


public class pth_input_test{

	static pth_input testInputClass;

	public static void main(String args[]){
		System.out.println("Testing: Name = 'First Test Input'");
		testInputClass = new pth_input("First Test Input");
		System.out.println(defaultNameTest("First Test Input"));

		System.out.println("Testing: Name = 'Default Scanner Name'");
		testInputClass = new pth_input();
		System.out.println(defaultNameTest("Default Scanner Name"));

		System.out.println("Testing: Input");
		testInputClass = new pth_input("Parsing Test", true);
		System.out.println(testInputClass.pth_RetrieveInput());
	}

	private static boolean defaultNameTest(String compareValue){
		if(testInputClass.getName().equals(compareValue)){
			return true;
		}
		else
		{
			return false;
		}
	}
}
