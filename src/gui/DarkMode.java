package gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DarkMode {
	
	public void darkmode() throws IOException {
		
		
	
		
		PrintWriter pWriter = null;
		
		
		
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\config\\config_darkmode.txt")));
            pWriter.println("darkmode = true");
            if (pWriter != null){
                pWriter.flush();
                pWriter.close();
            
		
		
		
		
       }
	}

}
