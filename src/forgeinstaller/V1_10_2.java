package forgeinstaller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import gui.Gui;

public class V1_10_2 {
	
	public void f1102() {
		
		PrintWriter pWriter = null;
		
		
		File file1 = new File("D:\\server\\1.10.2_modded");
		file1.mkdirs();
		
		@SuppressWarnings("unused")
		Gui gui = new Gui();							
		
		
		try {
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.10.2_modded\\eula.txt")));
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
	            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.10.2_modded\\server starten.bat")));
	           // pWriter1.println('"' + Files.readAllLines(Paths.get("D:\\server\\config\\config.txt")).get(3) + '"' + " -jar" + "-Xms2G -Xmx" + gui.ramslider.getValue() + "G -jar forge-1.10.2-12.18.3.2511-universal.jar");
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
		
		try {
			Runtime.
			   getRuntime().
			   exec("cmd /C java -jar D:\\server\\downloading\\forge_1.10.2.jar");
			System.out.println("1.10.2");
		} catch (IOException e1) {
			
			System.out.println(e1);
		}
		
	}

}
