package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import misc.Version;

public class Credits {
	
	public void credits() {
		
		Version version = new Version();
		
		ImageIcon creditsi = new ImageIcon("rsc\\credits.jpg");
		
		JFrame credits = new JFrame("Credits");
		credits.setSize(300, 300);
		credits.setIconImage(creditsi.getImage());
		credits.setLayout(null);
		credits.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		credits.setResizable(false);
		credits.setVisible(true);
		
		JPanel content = new JPanel();
		content.setSize(300, 300);
		content.setLayout(null);
		content.setBackground(Color.LIGHT_GRAY);
		content.setVisible(true);
		credits.add(content);
		
		JLabel credits1 = new JLabel("Credits:");
		credits1.setBounds(100, 20, 150, 50);
		credits1.setFont(credits1.getFont().deriveFont(20f));
		credits1.setVisible(true);
		content.add(credits1);
		
		JLabel credits2 = new JLabel("Modded Server von Forge");
		credits2.setBounds(65, 60, 150, 30);
		credits2.setVisible(true);
		content.add(credits2);
		
		JLabel credits3 = new JLabel("Vanilla Server von Minecraft by Mojang");
		credits3.setBounds(25, 80, 230, 30);
		credits.setVisible(true);
		content.add(credits3);
		
		JLabel credits4 = new JLabel("Programmiert von potzplitz");
		credits4.setBounds(57, 100, 200, 30);
		credits4.setVisible(true);
		content.add(credits4);
		
		JLabel credits5 = new JLabel("Version " + version.getVersion());
		credits5.setBounds(102, 120, 130, 30);
		credits5.setVisible(true);
		content.add(credits5);
		
		JButton closecredits = new JButton("Schlieﬂen");
		closecredits.setBounds(90, 228, 100, 30);
		closecredits.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				credits.setVisible(false);
			}	
		});
		closecredits.setVisible(true);
		content.add(closecredits);
	}

}
