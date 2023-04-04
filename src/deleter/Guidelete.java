package deleter;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Guidelete {
	
	public void GuiDeleter() {
		
		
	JFrame main = new JFrame("Server löschen...");
	main.setSize(500, 500);
	main.setResizable(false);
	main.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	main.setLayout(null);
	main.setVisible(true);
	
	JPanel content = new JPanel();
	content.setSize(500, 500);
	content.setLayout(null);
	content.setBackground(Color.LIGHT_GRAY);
	content.setVisible(true);
	main.add(content);
	
	JLabel label = new JLabel("Was möchtest du löschen?");
	label.setBounds(150, 10, 200, 30);
	label.setVisible(true);
	content.add(label);
	
	
	
	Button ban = new Button("Gebannte Spieler");
	ban.setBounds(10, 50, 150, 30);
	ban.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {	
		DeleteBan ban = new DeleteBan();
		ban.Ban();		
		}
	});
	ban.setVisible(true);
	content.add(ban);
	
	
	
	Button ops = new Button("Operatoren");
	ops.setBounds(165, 50, 150, 30);
	ops.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {	
			DeleteOps ops = new DeleteOps();
			ops.delete();
		}
	});
	ops.setVisible(true);
	content.add(ops);
	
	
	
	Button logs = new Button("Logs");
	logs.setBounds(322, 50, 150, 30);
	logs.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {	
			DeleteLogs logs = new DeleteLogs();
			logs.delete();
		}	
	});
	logs.setVisible(true);
	content.add(logs);
	
	
	
	Button players = new Button("Spieler");
	players.setBounds(10, 110, 150, 30);
	players.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			DeletePlayers players = new DeletePlayers();
			players.delete();
		}
	});
	players.setVisible(true);
	content.add(players);
	
	
	
	Button eula = new Button("EULA (nicht empfohlen)");
	eula.setBounds(165, 110, 150, 30);
	eula.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			DeleteEula eula = new DeleteEula();
			eula.delete();
		}
	});
	eula.setVisible(true);
	content.add(eula);
	
	
	
	Button settings = new Button("Einstellungen");
	settings.setBounds(322, 110, 150, 30);
	settings.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			DeleteSettings settings = new DeleteSettings();
			settings.delete();
		}
	});
	settings.setVisible(true);
	content.add(settings);
	
	
	
	Button whitelist = new Button("Whitelist");
	whitelist.setBounds(10, 170, 150, 30);
	whitelist.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			DeleteWhitelist whitelist = new DeleteWhitelist();
			whitelist.delete();
		}
	});
	whitelist.setVisible(true);
	content.add(whitelist);
	
	
	
	Button world = new Button("Welt");
	world.setBounds(165, 170, 150, 30);
	world.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			DeleteWorld world = new DeleteWorld();
			world.delete();
		}
	});
	world.setVisible(true);
	content.add(world);
	
	Button reset = new Button("Reset");
	reset.setBounds(322, 170, 150, 30);
	reset.addActionListener(new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			ServerResetter reset = new ServerResetter();
			reset.delete();
		}
	});
	reset.setVisible(true);
	content.add(reset);
	
	}
	

}
