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
		log = new File("log.txt");
		
		if(!log.exists()) {
			try {
				log.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			fw = new FileWriter(log);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		bw = new BufferedWriter(fw);
	}
	
	public void append(String val) {
		try {
			bw.write(val);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
