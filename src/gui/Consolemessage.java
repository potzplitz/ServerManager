package gui;

import java.net.MalformedURLException;

import misc.Version;

public class Consolemessage {
	
	public void message() throws InterruptedException, MalformedURLException {
		
		Version version = new Version();
		
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("|                              Servermanager                            |");
		System.out.println("|                by potzplitz (Discord potzplitz#4319)                  |");
		System.out.println("|                              Version " + version.getVersion() + "                              |");
		System.out.println("|-----------------------------------------------------------------------|");
		System.out.println("|                               Credits:                                |");
		System.out.println("|                       Modded Server von Forge                         |");
		System.out.println("|              Vanilla Server von Minecraft by Mojang                   |");
		System.out.println("|-----------------------------------------------------------------------|");
		System.out.println("|        Wenn du auf einem Betriebssystem ohne desktop bist,            |");
		System.out.println("|             kannst du die Konsole zum Steuern nutzen!                 |");
		System.out.println("|-----------------------------------------------------------------------|");
		System.out.println("|                     Für Hilfe, Schreibe 'help'!                       |");
		System.out.println("-------------------------------------------------------------------------");
		
		Termcontrol termc = new Termcontrol();
		termc.termcontrol();
		
	}
	

}
