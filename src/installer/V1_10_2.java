package installer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import gui.Gui;

public class V1_10_2 {
	
	public void fv1102() {
		
		@SuppressWarnings("unused")
		Gui gui = new Gui();
		
		PrintWriter pWriter = null;
    	try {
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.10.2\\eula.txt")));
            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
            pWriter.println("eula=true");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pWriter != null){
                pWriter.flush();
                pWriter.close();
            }
            
            PrintWriter pWriter1 = null;
            
            try {
	            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.10.2\\server starten.bat")));
	          //  pWriter1.println('"' + Files.readAllLines(Paths.get("D:\\server\\config\\config.txt")).get(3) + '"' + " -jar " + "-Xms2G -Xmx" + gui.ramslider.getValue() + "G -jar server.jar");
	            pWriter1.println("pause");
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        } finally {
	            if (pWriter1 != null){
	                pWriter1.flush();
	                pWriter1.close();
	            }
	           
	            
			}
	            
        } 
		
	}

}
