package settings;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import gui.DarkMode;
import gui.WhiteMode;

public class Settings {
	
	public void settings() throws IOException {
		
		JFrame einstellungen = new JFrame("Einstellungen");
		einstellungen.setSize(500, 400);
		einstellungen.setLayout(null);
		einstellungen.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		einstellungen.setResizable(false);
		einstellungen.setLocation(300, 0);
		einstellungen.setVisible(true);
		
		ImageIcon settingsico = new ImageIcon("rsc\\settings.png");
		einstellungen.setIconImage(settingsico.getImage());
		
		JButton javasubmit = new JButton("Speichern");
		javasubmit.setBounds(190, 60, 100, 30);
		javasubmit.setVisible(true);
		einstellungen.add(javasubmit);
		
		JTextField javas = new JTextField("");
		javas.setBackground(Color.WHITE);
		javas.setBounds(30, 60, 150, 30);
		javas.setVisible(true);
		einstellungen.add(javas);
		
		JButton settingsclose = new JButton("schließen");
		settingsclose.setBounds(333, 330, 150, 30);
		settingsclose.setVisible(true);
		einstellungen.add(settingsclose);
		
		JLabel settings_java = new JLabel("Java-Pfad festlegen:");
		settings_java.setBounds(30, 35, 300, 30);
		settings_java.setVisible(true);
		einstellungen.add(settings_java);
		
		
		
		JCheckBox darkmode = new JCheckBox("Dark Mode (Bei Änderung Neustart erforderlich)");
		darkmode.setBounds(30, 130, 300, 30);
		darkmode.setBackground(Color.LIGHT_GRAY);
		darkmode.setVisible(true);
		einstellungen.add(darkmode);
		
		String darkm = Files.readAllLines(Paths.get("D:\\server\\config\\config_darkmode.txt")).get(0);
		String compare = "darkmode = true";
		if(new String(darkm).equals(compare)) {
			darkmode.setSelected(true);
		}
		
		JLabel java_path = new JLabel();
		java_path.setBounds(30, 90, 500, 30);
		java_path.setVisible(true);
		einstellungen.add(java_path);
		
		JPanel selection1 = new JPanel();
		selection1.setBackground(Color.LIGHT_GRAY);
		selection1.setVisible(true);
		selection1.setSize(500, 400);
		einstellungen.add(selection1);
		
		settingsclose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				einstellungen.setVisible(false);
				
			}
				
		});
		javasubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			
			
				
		
		if(javas.getText().isEmpty()) {
			
			
		}else {
		
		PrintWriter pWriter = null;
		
		try {
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\config\\config.txt")));
            pWriter.println("#config file for the server installer");
            pWriter.println("----------------------------------------");
            pWriter.println("java path:");
            pWriter.println(javas.getText() + "\\javaw.exe");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pWriter != null){
                pWriter.flush();
                pWriter.close();
            }
            
        }
		
		try {
			String javapath = null;
			
        	 javapath = Files.readAllLines(Paths.get("D:\\server\\config\\config.txt")).get(3);	
			System.out.println(javapath);
				}catch(IOException e1 ) {
					System.out.println(e1);
				}
	
		try {
			java_path.setText("Aktueller Pfad: " + Files.readAllLines(Paths.get("D:\\server\\config\\config.txt")).get(3));
		} catch (IOException e3) {
			
			e3.printStackTrace();
		}	
	}	
			
	}
		});
		
		try {
			java_path.setText("Aktueller Pfad: " + Files.readAllLines(Paths.get("D:\\server\\config\\config.txt")).get(3));
		} catch (IOException e3) {
			
			e3.printStackTrace();
		
	}
		
		//Dark Mode
		DarkMode dark = new DarkMode();
		WhiteMode white = new WhiteMode();
		
		darkmode.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				
				if(e.getStateChange() == ItemEvent.SELECTED) {
				 try {
					dark.darkmode();
				} catch (IOException e1) {
				
					e1.printStackTrace();
				}
				 
				}else {
				try {
					white.whitemode();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
					
				}
				
			}
				
		});
		
		
	}
}


