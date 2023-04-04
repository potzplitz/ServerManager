package preload;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;

import writer.Darkmodedoc;

public class Datachecker {
	
	public int missing = 0;
	
	public void dataCheck() throws InterruptedException, IOException {
		
		JFrame gui = new JFrame("Check");
		gui.setSize(500, 200);
		gui.setLayout(null);
		gui.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		gui.setResizable(false);
		gui.setVisible(true);
		
		JLabel l1 = new JLabel("Daten werden auf Vollständigkeit geprüft...");
		l1.setBounds(100, 3, 250, 30);
		l1.setVisible(true);
		gui.add(l1);
		
		JLabel l2 = new JLabel("Dies kann einen Moment dauern.");
		l2.setBounds(125, 25, 200, 30);
		l2.setVisible(true);
		gui.add(l2);
		
		JLabel l3 = new JLabel();
		l3.setBounds(190, 60, 150, 30);
		l3.setVisible(true);
		gui.add(l3);
		
		JProgressBar progress = new JProgressBar(0, 100);
		progress.setMinimum(0);
		progress.setMaximum(8);
		progress.setBounds(5, 130, 475, 30);
		progress.setStringPainted(true);
		progress.setVisible(true);
		gui.add(progress);
		
		
		int sleep = 0;

		
		File f = new File("rsc\\credits.jpg");
		File f1 = new File("rsc\\green_plus.png");
		File f2 = new File("rsc\\help.png");
		File f4 = new File("rsc\\java.png");
		File f5 = new File("rsc\\settings.png");
		File f6 = new File("rsc\\copyright.txt");
		File f7 = new File("rsc\\settings.gui.jpg");
		
File fcheck = new File("D:\\server\\config\\config_darkmode.txt");
		
		if(fcheck.exists() && !fcheck.isDirectory()) {
			
			
		}else {
			;
			Darkmodedoc doc = new Darkmodedoc();
			doc.darkdoc();
		}
		
File fcheck1 = new File("D:\\server\\config\\config_darkmode.txt");
		
		if(fcheck1.exists() && !fcheck1.isDirectory()) {
			
			
		}else {
			Darkmodedoc doc = new Darkmodedoc();
			doc.darkdoc();
		}
		
		l3.setText("rsc\\credits.jpg");
		if(f.exists() && !f.isDirectory()) {
			progress.setValue(1);
		
			
		}else {
			
	      
			missing = 1;
			
		}
		l3.setText("rsc\\green_plus.png");
			if(f1.exists() && !f1.isDirectory()) {
			progress.setValue(2);
			
			System.out.println("green_plus.png exists");
			
		}else {
			JOptionPane error = new JOptionPane();
	        JOptionPane.showMessageDialog(error, "Resourcen sind nicht vollständig! Bitte installiere das Programm neu!", "Datachecker Fehlermeldung", JOptionPane.ERROR_MESSAGE);
	        error.setSize(300, 150);
	        error.setLayout(null);
	        error.setVisible(true);
			System.exit(0);
	      
			missing = 2;
			
		}
			Thread.sleep(sleep);
			l3.setText("rsc\\help.png");
			if(f2.exists() && !f2.isDirectory()) {
				System.out.println("help.png exists");
			progress.setValue(3);
			
			
		}else {
			JOptionPane error = new JOptionPane();
	        JOptionPane.showMessageDialog(error, "Resourcen sind nicht vollständig! Bitte installiere das Programm neu!", "Datachecker Fehlermeldung", JOptionPane.ERROR_MESSAGE);
	        error.setSize(300, 150);
	        error.setLayout(null);
	        error.setVisible(true);
			System.exit(0);
	      
			missing = 3;
			
		}
			
			Thread.sleep(sleep);
			l3.setText("rsc\\java.png");
			if(f4.exists() && !f4.isDirectory()) {
				System.out.println("java.png exists");
			progress.setValue(5);
			
		}else {
			JOptionPane error = new JOptionPane();
	        JOptionPane.showMessageDialog(error, "Resourcen sind nicht vollständig! Bitte installiere das Programm neu!", "Datachecker Fehlermeldung", JOptionPane.ERROR_MESSAGE);
	        error.setSize(300, 150);
	        error.setLayout(null);
	        error.setVisible(true);
			System.exit(0);
	      
			missing = 4;
			
		}
			Thread.sleep(sleep);
			l3.setText("rsc\\settings.png");
			if(f5.exists() && !f5.isDirectory()) {
				System.out.println("settings.png exists");
			progress.setValue(6);
			
			
		}else {
			JOptionPane error = new JOptionPane();
            JOptionPane.showMessageDialog(error, "Resourcen sind nicht vollständig! Bitte installiere das Programm neu!", "Datachecker Fehlermeldung", JOptionPane.ERROR_MESSAGE);
            error.setSize(300, 150);
            error.setLayout(null);
            error.setVisible(true);
			System.exit(0);
          
			missing = 5;
            
		}
			Thread.sleep(sleep);
			l3.setText("rsc\\copyright.txt");
			if(f6.exists() && !f6.isDirectory()) {
				progress.setValue(7);
				System.out.println("copyright.txt exists");
			
			}else {
				JOptionPane error = new JOptionPane();
	            JOptionPane.showMessageDialog(error, "Resourcen sind nicht vollständig! Bitte installiere das Programm neu!", "Datachecker Fehlermeldung", JOptionPane.ERROR_MESSAGE);
	            error.setSize(300, 150);
	            error.setLayout(null);
	            error.setVisible(true);
				System.exit(0);
				
				missing = 6;
				
			}
			
			Thread.sleep(sleep);
			l3.setText("rsc\\settings.gui.jpg");
			if(f7.exists() && !f7.isDirectory()) {
				progress.setValue(8);
				System.out.println("settings.gui.jpg exists");
			
			}else {
				JOptionPane error = new JOptionPane();
	            JOptionPane.showMessageDialog(error, "Resourcen sind nicht vollständig! Bitte installiere das Programm neu!", "Datachecker Fehlermeldung", JOptionPane.ERROR_MESSAGE);
	            error.setSize(300, 150);
	            error.setLayout(null);
	            error.setVisible(true);
				System.exit(0);
				
				missing = 7;
				
			}
			
			System.out.println("Done! ");
			System.out.println("executing main class...");
			
			progress.repaint();
		
		
		
		
		gui.setVisible(false);
		
	}

	

	
	
}
