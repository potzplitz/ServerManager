package writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Darkmodedoc {
	
	public void darkdoc() throws IOException {
		
		File file1 = new File("D:\\server\\config");
		file1.mkdirs();
		
		PrintWriter pWriter = null;
		
		
		
        pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\config\\config_darkmode.txt")));
        pWriter.println("darkmode = false");
        if (pWriter != null){
            pWriter.flush();
            pWriter.close();
        
		
	}

}
}
