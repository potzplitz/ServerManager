package writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import gui.Gui;

public class EulaRewrite {
	
	@SuppressWarnings("static-access")
	public void eularw() {
	
		Gui gui = new Gui();
		
		PrintWriter pWriter = null;
		
		if(gui.serverselect == 1) {
		
		try {
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.7.10\\eula.txt")));
            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
            pWriter.println("eula=true");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pWriter != null){
                pWriter.flush();
                pWriter.close();
            }
		
        }

		}else if(gui.serverselect == 2) {
			
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
			
	        }
			
		}else if(gui.serverselect == 3) {
			
			try {
	            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.12.2\\eula.txt")));
	            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
	            pWriter.println("eula=true");
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        } finally {
	            if (pWriter != null){
	                pWriter.flush();
	                pWriter.close();
	            }
			
	        }
			
		}else if(gui.serverselect == 4) {
			
			try {
	            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.14.4\\eula.txt")));
	            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
	            pWriter.println("eula=true");
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        } finally {
	            if (pWriter != null){
	                pWriter.flush();
	                pWriter.close();
	            }
			
	        }
			
		}else if(gui.serverselect == 5) {
			
			try {
	            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.15.2\\eula.txt")));
	            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
	            pWriter.println("eula=true");
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        } finally {
	            if (pWriter != null){
	                pWriter.flush();
	                pWriter.close();
	            }
			
	        }
			
		}else if(gui.serverselect == 6) {
			
			try {
	            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.16.5\\eula.txt")));
	            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
	            pWriter.println("eula=true");
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        } finally {
	            if (pWriter != null){
	                pWriter.flush();
	                pWriter.close();
	            }
			
	        }
			
		}else if(gui.serverselect == 7) {
			
			try {
	            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.17\\eula.txt")));
	            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
	            pWriter.println("eula=true");
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        } finally {
	            if (pWriter != null){
	                pWriter.flush();
	                pWriter.close();
	            }
			
	        }
			
		}
	}
}
