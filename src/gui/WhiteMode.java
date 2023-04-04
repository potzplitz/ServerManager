package gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WhiteMode {
	
	public void whitemode() throws IOException {
		

		
	
		
		PrintWriter pWriter = null;
		
		
		
        pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\config\\config_darkmode.txt")));
        pWriter.println("darkmode = false");
        if (pWriter != null){
            pWriter.flush();
            pWriter.close();
	}
}
}
