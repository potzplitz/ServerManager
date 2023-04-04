package gui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Termcontrol {
	
	public void termcontrol() throws MalformedURLException {
		
		System.out.println(">");
		
		
		while(true) {
			
			
			Scanner sc = new Scanner(System.in);
			String inp = sc.next();
			
			
			if(inp.equals("help")) {
				System.out.println("Befehle: install, exit, home");
				System.out.println(">");
				inp = "";	
			
			
			}else if(inp.equals("install")) {
				System.out.println("Select Version:\n1 - 1.7.10 | 2 - 1.10.2 | 3 - 1.12.2 | 4 - 1.14.4 | 5 - 1.15.2 | 6 - 1.16 | 7 - 1.17 | 8 - 1.18 | 9 - 1.19");
				System.out.println(">");
				inp = "";
				
					Scanner sc1 = new Scanner(System.in);
					String inp1 = sc1.next();

					
					URL eula = new URL("https://www.minecraft.net/en-us/eula");
					
					switch(Integer.parseInt(inp1)) {
					
					case 1:
						
						System.out.println("bist du mit der Mojang EULA einverstanden?  <J/N>" + " (Hier kannst du die EULA nachlesen: " + eula + ")");
						inp1 = sc.next();
						
						if(inp1.equalsIgnoreCase("J")) {
						    inp1 = "";
							System.out.println("1.7.10 wird installiert.");
						} else if(inp1.equalsIgnoreCase("N")) {
							System.out.println("Server wurde nicht installiert.");
							inp1 = "";
						}else {
							System.out.println("Eingabe wurde nicht erkannt!");
							inp1 = "";
							
						}

						inp = "";
						break;
						
					case 2:
						System.out.println("1.10.2 wird installiert.");
						inp = "";
						break;
					
					case 3:
						System.out.println("1.12.2 wird installiert.");
						inp = "";
						break;
					
					case 4:
						System.out.println("1.14.4 wird installiert.");
						inp = "";
						break;
						
					case 5: 
						System.out.println("1.15.2 wird installiert.");
						inp = "";
						break;
						
					case 6: 
						System.out.println("1.16 wird installiert.");
						inp = "";
						break;
					case 7:
						System.out.println("1.17 wird installiert.");
						inp = "";
						break;
						
					case 8:
						System.out.println("1.18 wird installiert.");
						inp = "";
						break;
						
					case 9: 
						System.out.println("1.19 wird installiert.");
						inp = "";
						break;
						
					default:
						System.out.println("Eingabe wurde nicht erkannt!");
						inp = "";
						break;
						
					      
					}
					
						
						
			}else if(inp.equals("exit")) {
				
				System.out.println("bist du dir sicher, dass du den Vorgang beenden möchtest? (J/N)");
				System.out.println(">");
				inp = "";
				
				@SuppressWarnings("resource")
				Scanner sc2 = new Scanner(System.in);
				String inp2 = sc2.next();
				
				if(inp2.equalsIgnoreCase("J")) {
				
				System.out.println("Programm wird beendet...");
				System.exit(0);
				
				} else if(inp2.equalsIgnoreCase("N")) {
					
					System.out.println("Beenden wurde abgebrochen.");
					System.out.println(">");
					inp2 = "";
					
				}else {
					
					System.out.println("eingabe wurde nicht erkannt!");
					System.out.println(">");
					inp2 = "";
					
				}
				
			}else {
				
				System.out.println("Eingabe wurde nicht erkannt!");
				System.out.println(">");
				
			}
		
		}
	}
}


