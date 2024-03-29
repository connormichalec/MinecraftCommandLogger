package michalec.connor.sugunioncommandlogger.bungee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogfileHandler {
	//quick and dirty logger
	
	File log;
	FileWriter fw;
	BufferedWriter bw;
	
	public void init() {
		log = new File("plugins/SUGUnionCommandLogger/log.txt");
		
		if(!log.exists()) {
			try {
				log.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			fw = new FileWriter(log, true); //set true for append mode
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		bw = new BufferedWriter(fw);
	}
	
	public void append(String val) {
		try {
			bw.newLine();
			bw.write(val);
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cleanup() {
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
