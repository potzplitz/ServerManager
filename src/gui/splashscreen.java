 package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import misc.Version;
import preload.Datachecker;

public class splashscreen {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("system.start");
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		JFrame splash = new JFrame();
		splash.setSize(400, 200);
		splash.setLayout(null);
		splash.setUndecorated(true);
		splash.setLocation(dim.width/2-splash.getSize().width/2, dim.height/2-splash.getSize().height/2);
		splash.setDefaultCloseOperation(splash.DO_NOTHING_ON_CLOSE);
		splash.setVisible(true);
		
		ImageIcon imgi = new ImageIcon("rsc\\icon.png");
		splash.setIconImage(imgi.getImage());
		
		JPanel panel = new JPanel();
		panel.setSize(400, 400);
		panel.setBackground(Color.LIGHT_GRAY);
		splash.add(panel);
		
		JLabel label = new JLabel("Minecraft Servermanager");
		label.setBounds(80, 20, 300, 100);
		label.setFont(label.getFont().deriveFont(20f));
		label.setVisible(true);
		panel.add(label);
		
		JLabel label1 = new JLabel("by potzplitz");
		label1.setBounds(170, 80, 200, 30);
		label1.setVisible(true);
		panel.add(label1);
		
		Version version = new Version();
		
		JLabel label2 = new JLabel("Version " + version.getVersion());
		label2.setBounds(343, 179, 60, 30);
		label2.setFont(label.getFont().deriveFont(9f));
		label2.setVisible(true);
		panel.add(label2);
		
		
	
		System.out.println("starting filescanner...");
		
		Gui gui = new Gui();
		Datachecker checker = new Datachecker();
		checker.dataCheck();
		
		
		
				splash.setVisible(false);
				
				
				gui.payload();
				
				
			
			
		
		
	}

}
