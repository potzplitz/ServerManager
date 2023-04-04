package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ModDownloader {
	
	public void advanced() {
		
		JFrame main = new JFrame("Mods installieren");
		main.setSize(500, 500);
		main.setResizable(false);
		main.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		main.setLayout(null);
		main.setVisible(true);
		
		JPanel start = new JPanel();
		start.setSize(500, 500);
		start.setLayout(null);
		start.setBackground(Color.LIGHT_GRAY);
		start.setVisible(true);
		main.add(start);
		
		JLabel wc = new JLabel("Bitte wähle eine Kategorie aus.");
		wc.setBounds(150, 10, 200, 30);
		wc.setVisible(true);
		start.add(wc);
		
		JButton gen = new JButton("Wold Gen");
		gen.setBounds(50, 50, 100, 30);
		gen.setVisible(true);
		start.add(gen);
		
		JButton tech = new JButton("Technik");
		tech.setBounds(180, 50, 100, 30);
		tech.setVisible(true);
		start.add(tech);
		
		JButton magic = new JButton("Magie");
		magic.setBounds(310, 50, 100, 30);
		magic.setVisible(true);
		start.add(magic);
		
		JButton storage = new JButton("Lager");
		storage.setBounds(50, 130, 100, 30);
		storage.setVisible(true);
		start.add(storage);
		
		JButton adv = new JButton("Erkunden");
		adv.setBounds(180, 130, 100, 30);
		adv.setVisible(true);
		start.add(adv);
		
		JButton map = new JButton("Karte");
		map.setBounds(310, 130, 100, 30);
		map.setVisible(true);
		start.add(map);
		
		JPanel genp = new JPanel();
		genp.setSize(500, 500);
		genp.setLayout(null);
		genp.setBackground(Color.LIGHT_GRAY);
		genp.setVisible(false);
		main.add(genp);
		
		JPanel techp = new JPanel();
		techp.setSize(500, 500);
		techp.setBackground(Color.LIGHT_GRAY);
		techp.setLayout(null);
		techp.setVisible(false);
		main.add(techp);
		
		JPanel magicp = new JPanel();
		magicp.setSize(500, 500);
		magicp.setBackground(Color.LIGHT_GRAY);
		magicp.setLayout(null);
		magicp.setVisible(false);
		main.add(magicp);
		
		JPanel storagep = new JPanel();
		storagep.setSize(500, 500);
		storagep.setBackground(Color.LIGHT_GRAY);
		storagep.setLayout(null);
		storagep.setVisible(false);
		main.add(storagep);
		
		JPanel advp = new JPanel();
		advp.setSize(500, 500);
		advp.setBackground(Color.LIGHT_GRAY);
		advp.setLayout(null);
		advp.setVisible(false);
		main.add(advp);
		
		JPanel mapp = new JPanel();
		mapp.setSize(500, 500);
		mapp.setBackground(Color.LIGHT_GRAY);
		mapp.setLayout(null);
		mapp.setVisible(false);
		main.add(mapp);
		
		JButton bgen = new JButton("zurück");
		bgen.setBounds(156, 420, 150, 30);
		bgen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start.setVisible(true);	
			}	
		});
		bgen.setVisible(true);
		genp.add(bgen);
		
		JButton btech = new JButton("zurück");
		btech.setBounds(156, 420, 150, 30);
		btech.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				start.setVisible(true);	
				techp.setVisible(false);
			}
		});
		btech.setVisible(true);
		techp.add(btech);
		
		JButton bmagic = new JButton("zurück");
		bmagic.setBounds(156, 420, 150, 30);
		bmagic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start.setVisible(true);	
			}
		});
		bmagic.setVisible(true);
		magicp.add(bmagic);
		
		
		
		
		
		gen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start.setVisible(false);
				techp.setVisible(false);
				magicp.setVisible(false);
				storagep.setVisible(false);
				advp.setVisible(false);
				mapp.setVisible(false);
				genp.setVisible(true);
				
				
			}
			
			
		});
		
		tech.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start.setVisible(false);
				genp.setVisible(false);
				magicp.setVisible(false);
				storagep.setVisible(false);
				advp.setVisible(false);
				mapp.setVisible(false);
				techp.setVisible(true);
				
				
			}
			
			
		});
		
		magic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start.setVisible(false);
				genp.setVisible(false);
				techp.setVisible(false);
				storagep.setVisible(false);
				advp.setVisible(false);
				mapp.setVisible(false);
				magicp.setVisible(true);
				
			}
			
			
		});
		
		storage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start.setVisible(false);
				genp.setVisible(false);
				techp.setVisible(false);
				magicp.setVisible(false);
				advp.setVisible(false);
				mapp.setVisible(false);
				storagep.setVisible(true);
				
			}
			
			
		});
		
		adv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start.setVisible(false);
				genp.setVisible(false);
				techp.setVisible(false);
				magicp.setVisible(false);
				mapp.setVisible(false);
				advp.setVisible(true);
				
			}
			
			
		});
		
		map.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start.setVisible(false);
				genp.setVisible(false);
				techp.setVisible(false);
				magicp.setVisible(false);
				advp.setVisible(false);
				mapp.setVisible(true);
				
			}
			
			
		});
		
	}

}
