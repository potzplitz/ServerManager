package deleter;

import java.io.File;

import gui.Gui;

public class ServerResetter {

	@SuppressWarnings("static-access")
	public void delete() {
		
		Gui gui = new Gui();
		
if(gui.serverselect == 1) {
	
	File theDir = new File("D:\\server\\temp");
	if (!theDir.exists()){
	    theDir.mkdirs();
	}
	
		File move = new File("D:\\server\\1.7.10\\server.jar");
		move.renameTo(new File("D:\\server\\temp\\server.jar"));
		
		File bat = new File("D:\\server\\1.7.10\\server starten.bat");
		bat.renameTo(new File("D:\\server\\temp\\server starten.bat"));
			
			String ops = "D:\\server\\1.7.10";
		
			
			System.out.println("move");
			File file = new File(ops);

			String[]entries = file.list();
			for(String s : entries) {
				File current = new File(file.getPath(), s);
				current.delete();
			}
			
			File move1 = new File("D:\\server\\temp\\server.jar");
		move1.renameTo(new File("D:\\server\\1.7.10\\server.jar"));
		
		File bat1 = new File("D:\\server\\temp\\server starten.bat");
		bat1.renameTo(new File("D:\\server\\1.7.10\\server starten.bat"));
			
			
		}else if(gui.serverselect == 2) {
			
			File move = new File("D:\\server\\1.10.2\\server.jar");
			move.renameTo(new File("D:\\server\\temp\\server.jar"));
			
			File bat = new File("D:\\server\\1.10.2\\server starten.bat");
			bat.renameTo(new File("D:\\server\\temp\\server starten.bat"));
				
				String ops = "D:\\server\\1.10.2";
			
				
				System.out.println("move");
				File file = new File(ops);

				String[]entries = file.list();
				for(String s : entries) {
					File current = new File(file.getPath(), s);
					current.delete();
				}
				
				File move1 = new File("D:\\server\\temp\\server.jar");
			move1.renameTo(new File("D:\\server\\1.10.2\\server.jar"));
			
			File bat1 = new File("D:\\server\\temp\\server starten.bat");
			bat1.renameTo(new File("D:\\server\\1.10.2\\server starten.bat"));
			
		}else if(gui.serverselect == 3){
			
			File move = new File("D:\\server\\1.12.2\\server.jar");
			move.renameTo(new File("D:\\server\\temp\\server.jar"));
			
			File bat = new File("D:\\server\\1.12.2\\server starten.bat");
			bat.renameTo(new File("D:\\server\\temp\\server starten.bat"));
				
				String ops = "D:\\server\\1.12.2";
			
				
				System.out.println("move");
				File file = new File(ops);

				String[]entries = file.list();
				for(String s : entries) {
					File current = new File(file.getPath(), s);
					current.delete();
				}
				
				File move1 = new File("D:\\server\\temp\\server.jar");
			move1.renameTo(new File("D:\\server\\1.12.2\\server.jar"));
			
			File bat1 = new File("D:\\server\\temp\\server starten.bat");
			bat1.renameTo(new File("D:\\server\\1.12.2\\server starten.bat"));

		}else if(gui.serverselect == 4) {
			
			File move = new File("D:\\server\\1.14.4\\server.jar");
			move.renameTo(new File("D:\\server\\temp\\server.jar"));
			
			File bat = new File("D:\\server\\1.14.4\\server starten.bat");
			bat.renameTo(new File("D:\\server\\temp\\server starten.bat"));
				
				String ops = "D:\\server\\1.14.4";
			
				
				System.out.println("move");
				File file = new File(ops);

				String[]entries = file.list();
				for(String s : entries) {
					File current = new File(file.getPath(), s);
					current.delete();
				}
				
				File move1 = new File("D:\\server\\temp\\server.jar");
			move1.renameTo(new File("D:\\server\\1.14.4\\server.jar"));
			
			File bat1 = new File("D:\\server\\temp\\server starten.bat");
			bat1.renameTo(new File("D:\\server\\1.14.4\\server starten.bat"));
				
		}else if(gui.serverselect == 5) {
			
			File move = new File("D:\\server\\1.15.2\\server.jar");
			move.renameTo(new File("D:\\server\\temp\\server.jar"));
			
			File bat = new File("D:\\server\\1.15.2\\server starten.bat");
			bat.renameTo(new File("D:\\server\\temp\\server starten.bat"));
				
				String ops = "D:\\server\\1.15.2";
			
				
				System.out.println("move");
				File file = new File(ops);

				String[]entries = file.list();
				for(String s : entries) {
					File current = new File(file.getPath(), s);
					current.delete();
				}
				
				File move1 = new File("D:\\server\\temp\\server.jar");
			move1.renameTo(new File("D:\\server\\1.15.2\\server.jar"));
			
			File bat1 = new File("D:\\server\\temp\\server starten.bat");
			bat1.renameTo(new File("D:\\server\\1.15.2\\server starten.bat"));
			
		}else if(gui.serverselect == 6) {
			
			File move = new File("D:\\server\\1.16.5\\server.jar");
			move.renameTo(new File("D:\\server\\temp\\server.jar"));
			
			File bat = new File("D:\\server\\1.16.5\\server starten.bat");
			bat.renameTo(new File("D:\\server\\temp\\server starten.bat"));
				
				String ops = "D:\\server\\1.16.5";
			
				
				System.out.println("move");
				File file = new File(ops);

				String[]entries = file.list();
				for(String s : entries) {
					File current = new File(file.getPath(), s);
					current.delete();
				}
				
				File move1 = new File("D:\\server\\temp\\server.jar");
			move1.renameTo(new File("D:\\server\\1.16.5\\server.jar"));
			
			File bat1 = new File("D:\\server\\temp\\server starten.bat");
			bat1.renameTo(new File("D:\\server\\1.16.5\\server starten.bat"));
			
		}else if(gui.serverselect == 7) {
			
			File move = new File("D:\\server\\1.17\\server.jar");
			move.renameTo(new File("D:\\server\\temp\\server.jar"));
			
			File bat = new File("D:\\server\\1.17\\server starten.bat");
			bat.renameTo(new File("D:\\server\\temp\\server starten.bat"));
				
				String ops = "D:\\server\\1.17";
			
				
				System.out.println("move");
				File file = new File(ops);

				String[]entries = file.list();
				for(String s : entries) {
					File current = new File(file.getPath(), s);
					current.delete();
				}
				
				File move1 = new File("D:\\server\\temp\\server.jar");
			move1.renameTo(new File("D:\\server\\1.17\\server.jar"));
			
			File bat1 = new File("D:\\server\\temp\\server starten.bat");
			bat1.renameTo(new File("D:\\server\\1.17\\server starten.bat"));
			
			
			
		}
		
	}
	
}
