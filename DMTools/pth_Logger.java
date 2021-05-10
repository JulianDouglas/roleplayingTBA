/*
pth_Logger
by Jack

Logger Class to log errors and processes to files
Built to avoid using System.out.println() and keep console clean
*/

package DMTools;

import java.io.File;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class pth_Logger{
	//Variables
	private File logFile;
	private File logDirectory;
	private FileWriter writer;
	private DateTimeFormatter dtf;
	private LocalDateTime now;

	//Constructors
	public pth_Logger(){
		logDirectory = new File(System.getProperty("user.dir")+"/DMTools/Logs");
		dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	}

	//Functions
	public void log(String newlogFile, String logLine){
		try{
			logFile = new File(logDirectory,newlogFile);
			if(!logFile.exists()){
				logFile.createNewFile();
			}

			now = LocalDateTime.now();

			writer = new FileWriter(logFile, true);
			writer.write(dtf.format(now)+"| "+logLine);
			writer.write("\n");
			//writer.newLine();
			writer.flush();
			writer.close();
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
	}
}
