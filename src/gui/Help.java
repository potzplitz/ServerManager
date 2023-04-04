package gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Help {
	
	public void help() throws FileNotFoundException, IOException {
		
		JFrame help = new JFrame("Hilfecenter");
		help.setSize(500, 500);
		help.setLayout(null);
		help.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		help.setResizable(false);
		help.setVisible(true);
		
		JPanel content = new JPanel();
		content.setSize(500, 500);
		content.setLayout(null);
		content.setBackground(Color.LIGHT_GRAY);
		content.setVisible(true);
		help.add(content);
		
		JPanel selection = new JPanel();
		selection.setBounds(0, 0, 150, 500);
		selection.setBackground(Color.GRAY);
		selection.setVisible(true);
		content.add(selection);
		
		JLabel info = new JLabel("Hilfecenter");
		info.setBounds(267, 30, 300, 30);
		info.setFont(info.getFont().deriveFont(20f));
		info.setVisible(true);
		content.add(info);
		
		JPanel switches = new JPanel();
		switches.setBounds(150, 0, 1000, 500);
		switches.setLayout(null);
		switches.setBackground(Color.LIGHT_GRAY);
		switches.setVisible(false);
		content.add(switches);
		
		JPanel installer = new JPanel();
		installer.setBounds(150, 0, 350, 500);
		installer.setBackground(Color.LIGHT_GRAY);
		installer.setLayout(null);
		installer.setVisible(false);
		content.add(installer);
		
		JPanel javap = new JPanel();
		javap.setBounds(150, 0, 350, 500);
		javap.setBackground(Color.LIGHT_GRAY);
		javap.setLayout(null);
		javap.setVisible(false);
		content.add(javap);
		
		JLabel java1 = new JLabel("1. Klicke Auf das Zahnrad");
		java1.setBounds(10, 20, 300, 30);
		java1.setVisible(true);
		javap.add(java1);
		
		JLabel java2 = new JLabel("2. Navigiere zu deinem Java-Verzeichnis");
		java2.setBounds(10, 40, 300, 30);
		java2.setVisible(true);
		javap.add(java2);
		
		JLabel java3 = new JLabel("3. Wähle das jre - Verzeichnis aus");
		java3.setBounds(10, 60, 300, 30);
		java3.setVisible(true);
		javap.add(java3);
		
		JLabel java4 = new JLabel("4. navigiere in 'bin' und kopiere den Dateipfad");
		java4.setBounds(10, 80, 300, 30);
		java4.setVisible(true);
		javap.add(java4);
		
		JLabel java5 = new JLabel("5. Füge den kopierten Pfad im Einstellungsmenu ein.");
		java5.setBounds(10, 100, 300, 30);
		java5.setVisible(true);
		javap.add(java5);
		
		JLabel java6 = new JLabel("6. Klicke auf Speichern");
		java6.setBounds(10, 120, 300, 30);
		java6.setVisible(true);
		javap.add(java6);
		
		JLabel install1 = new JLabel("1. Auf das grüne Plus klicken");
		install1.setBounds(10, 20, 300, 30);
		install1.setVisible(true);
		installer.add(install1);
		
		JLabel install2 = new JLabel("2. Version auswählen");
		install2.setBounds(10, 40, 300, 30);
		install2.setVisible(true);
		installer.add(install2);
		
		JLabel install3 = new JLabel("3. RAM Zuweisen");
		install3.setBounds(10, 60, 300, 30);
		install3.setVisible(true);
		installer.add(install3);
		
		JLabel install4 = new JLabel("4. Auswählen ob Forge-Server oder Vanilla Server");
		install4.setBounds(10, 80, 400, 30);
		install4.setVisible(true);
		installer.add(install4);
		
		JLabel install5 = new JLabel("5. Serverdaten Herunterladen");
		install5.setBounds(10, 100, 200, 30);
		install5.setVisible(true);
		installer.add(install5);
		
		JLabel install6 = new JLabel("6. Der Minecraft-EULA zustimmen");
		install6.setBounds(10, 120, 200, 30);
		install6.setVisible(true);
		installer.add(install6);
		
		JLabel install7 = new JLabel("7. Server Installieren");
		install7.setBounds(10, 140, 200, 30);
		install7.setVisible(true);
		installer.add(install7);
		
		
		BufferedImage addbutton = ImageIO.read(new FileInputStream("rsc\\settings.gui.jpg"));
		JLabel addbuttont = new JLabel(new ImageIcon(addbutton));
		addbuttont.setSize(700, 500);
		
		JPanel add = new JPanel();
		
		
		add.setSize(1000, 500);
		add.setLayout(null);
		add.setVisible(true);
		add.add(addbuttont);
		switches.add(add);
		
		JLabel info1 = new JLabel("Hier findest du alle Informationen die du brauchst, um");
		info1.setBounds(170, 70, 330, 30);
		info1.setVisible(true);
		content.add(info1);
		
		JLabel info2 = new JLabel("Minecraft-Server erfolgreich zu Installieren und ");
		info2.setBounds(190, 90, 340, 30);
		info2.setVisible(true);
		content.add(info2);
		
		JLabel info3 = new JLabel("einzustellen.");
		info3.setBounds(280, 110, 100, 30);
		info.setVisible(true);
		content.add(info3);
		
		Button general = new Button("Schaltflächen");
		general.setBounds(30, 30, 100, 30);
		general.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				content.setSize(830, 500);
				help.setSize(830, 500);
				switches.setVisible(true);
				info.setVisible(false);
				
				
				
			}
			
		});
		
		general.setVisible(true);
		selection.add(general);
		
		Button install = new Button("Server installieren");
		install.setBounds(30, 50, 100, 30);
		
		install.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				content.setSize(500, 500);
				help.setSize(500, 500);
				switches.setVisible(false);
				installer.setVisible(true);
				info.setVisible(false);
			}
			
		});
		
		install.setVisible(true);
		selection.add(install);
		
		Button java = new Button("Java-Pfad festlegen");
		java.setBounds(30, 70, 100, 30);
		java.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				content.setSize(500, 500);
				help.setSize(500, 500);
				switches.setVisible(false);
				installer.setVisible(false);
				info.setVisible(false);
				javap.setVisible(true);
				
			}
			
		});
		
		
		java.setVisible(true);
		selection.add(java);
		
		
		
		content.repaint();
		
		
		
	}
	
}
