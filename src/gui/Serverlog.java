package gui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Serverlog {
	
	public void log() throws FileNotFoundException, IOException {
		
		JFrame plog = new JFrame();
		plog.setSize(735, 540);
		plog.setVisible(true);
		
		JTextArea settingsfile = new JTextArea();
		settingsfile.setSize(735, 540);
		settingsfile.setLineWrap(true);
		
		JScrollPane settingst = new JScrollPane(settingsfile, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		settingst.setSize(735, 540);
		
		plog.add(settingst);
		
		String file = "D:\\server\\1.7.10\\logs\\latest.log";
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    
		    while (true) {
		    
		    	
		      settingsfile.append(br.readLine() + "\n");
		  
		      settingsfile.repaint();
		    }
		   
		}
	}

}
