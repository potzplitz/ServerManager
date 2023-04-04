package deleter;

import java.io.File;
import gui.Gui;

public class DeleteBan {
	
	@SuppressWarnings("static-access")
	public void Ban() {
		
		Gui gui = new Gui();
		
		
		if(gui.serverselect == 1) {
			
			String ban = "D:\\server\\1.7.10\\banned-players.json";
			String banips = "D:\\server\\1.7.10\\banned-ips.json";
			
			File file = new File(ban);
			file.delete();
			
			File file1 = new File(banips);
			file1.delete();
			
		}else if(gui.serverselect == 2) {
			
			String ban = "D:\\server\\1.10.2\\banned-players.json";
			String banips = "D:\\server\\1.10.2\\banned-ips.json";
			
			File file = new File(ban);
			file.delete();
			
			File file1 = new File(banips);
			file1.delete();
			
		}else if(gui.serverselect == 3){
			
			String ban = "D:\\server\\1.12.2\\banned-players.json";
			String banips = "D:\\server\\1.12.2\\banned-ips.json";
			
			File file = new File(ban);
			file.delete();
			
			File file1 = new File(banips);
			file1.delete();
			
		}else if(gui.serverselect == 4) {
			
			String ban = "D:\\server\\1.14.4\\banned-players.json";
			String banips = "D:\\server\\1.1.14.4\\banned-ips.json";
			
			File file = new File(ban);
			file.delete();
			
			File file1 = new File(banips);
			file1.delete();
				
		}else if(gui.serverselect == 5) {
			
			String ban = "D:\\server\\1.15.2\\banned-players.json";
			String banips = "D:\\server\\1.15.2\\banned-ips.json";
			
			File file = new File(ban);
			file.delete();
			
			File file1 = new File(banips);
			file1.delete();
			
		}else if(gui.serverselect == 6) {
			
			String ban = "D:\\server\\1.16.5\\banned-players.json";
			String banips = "D:\\server\\1.16.5\\banned-ips.json";
			
			File file = new File(ban);
			file.delete();
			
			File file1 = new File(banips);
			file1.delete();
			
		}else if(gui.serverselect == 7) {
			
			String ban = "D:\\server\\1.17\\banned-players.json";
			String banips = "D:\\server\\1.17\\banned-ips.json";
			
			File file = new File(ban);
			file.delete();
			
			File file1 = new File(banips);
			file1.delete();
			
		}

	
	
	}
	
}
