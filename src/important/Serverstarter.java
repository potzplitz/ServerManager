package important;

import java.io.File;
import java.io.IOException;

public class Serverstarter {
	
	public void start() {
		
		try {
			Process process = Runtime.getRuntime().exec(
					"cmd /c server_starten.bat", null, new File("D:\\server\\1.10.2"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
