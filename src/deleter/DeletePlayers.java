package deleter;

import java.io.File;

import gui.Gui;

public class DeletePlayers {
	
	@SuppressWarnings("static-access")
	public void delete() {
		
Gui gui = new Gui();
		
		
		if(gui.serverselect == 1) {
			
			String ops = "D:\\server\\1.7.10\\usercache.json";
			
			File file = new File(ops);
			file.delete();
			
		}else if(gui.serverselect == 2) {
			
			String ops = "D:\\server\\1.10.2\\usercache.json";
			
			File file = new File(ops);
			file.delete();
			
		}else if(gui.serverselect == 3){
			
			String ops = "D:\\server\\1.12.2\\usercache.json";
		
			File file = new File(ops);
			file.delete();

		}else if(gui.serverselect == 4) {
			
			String ops = "D:\\server\\1.14.4\\usercache.json";
			
			File file = new File(ops);
			file.delete();
				
		}else if(gui.serverselect == 5) {
			
			String ops = "D:\\server\\1.15.2\\usercache.json";
			
			File file = new File(ops);
			file.delete();
			
		}else if(gui.serverselect == 6) {
			
			String ops = "D:\\server\\1.16.5\\usercache.json";
			
			File file = new File(ops);
			file.delete();
			
		}else if(gui.serverselect == 7) {
			
			String ops = "D:\\server\\1.17\\usercache.json";
			
			File file = new File(ops);
			file.delete();
			
			
			
		}
		
	}

}
