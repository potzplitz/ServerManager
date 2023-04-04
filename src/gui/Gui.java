package gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.NumericShaper.Range;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.time.temporal.ValueRange;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultEditorKit;

import deleter.DeleteBan;
import deleter.Guidelete;
import deleter.Reinstaller;
import deleter.ServerResetter;
import important.Serverstarter;
import settings.Settings;
import writer.Darkmodedoc;

@SuppressWarnings("unused")
public class Gui{
	
	// random public variables, getters/setters
	
	private int enabled = 0; // sets the enabled value to 1 if forge is enabled
	private String fv = "";  // empty string for various reasons
	public int darkmode = 0; // sets the darkmode value to 1 if dark mode is enabled
	
	public int getDarkmode() {  // getter for the dark mode value
		return darkmode;
	}


	public void setDarkmode(int darkmode) {  // setter for the dark mode value
		this.darkmode = darkmode;
	}


	public static Integer getServerselect() { // getter for the serverselect value
		return serverselect;
	}


	public static void setServerselect(Integer serverselect) { // setter for the serverselect value
		Gui.serverselect = serverselect;
	}


	public static Integer serverselect = 0; 
	
	
	public void payload() throws IOException, InterruptedException { // payload
		

		
		
		
		
		
		
		System.out.println("load"); // debug line
		
		// Gui Building stuff
		
		Consolemessage message = new Consolemessage();      // public Console debug messenger (can be used in the whole project)
		
		

		File file1 = new File("D:\\server\\config");        // adds a config file for various settings
		file1.mkdirs();
	
		JFrame main = new JFrame("Serververwaltung");      // creates the main window
		main.setSize(1000, 650);
		main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		main.setLayout(null);
		main.setVisible(true);
		main.setResizable(false);
		
		ImageIcon imgi = new ImageIcon("rsc\\icon.png");  // adds an icon for the application
		main.setIconImage(imgi.getImage());

		JFrame addserver = new JFrame("Server Hinzuf�gen...");  // initializes the server adder window
		addserver.setSize(500, 200);
		addserver.setLocation(0, 300);
		addserver.setResizable(false);
		addserver.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addserver.setLayout(null);
		addserver.setVisible(false);
		
		ImageIcon addico = new ImageIcon("rsc\\green_plus.png");  //adds an icon to the server adder window
		addserver.setIconImage(addico.getImage());
		
		JPanel control = new JPanel();  // creates the settings window
		control.setSize(1000, 30);
		control.setBackground(Color.WHITE);
		control.setLayout(null);
		                     
		JPanel plog = new JPanel();         // user feedback line in the application window  
		plog.setBounds(251, 31, 748, 620); // 748, 620
		plog.setLayout(null);
		plog.setVisible(true);
		main.add(plog);
		
		Button save = new Button("Speichern");  // save button for the server.properties file
		save.setBounds(600, 548, 130, 30);
		save.setVisible(true);
		plog.add(save);
		
		JPanel selection = new JPanel();  // panel for the server installer window
		selection.setSize(250, 650);
		selection.setLayout(null);
		selection.setBackground(Color.LIGHT_GRAY);
		
		JPanel bound = new JPanel();   // boundary for the main window
		bound.setBounds(250, 30, 1, 650);
		bound.setBackground(Color.BLACK);
		bound.setVisible(true);
		main.add(bound);
		
		JPanel bound1 = new JPanel();   // boundary for the main window
		bound1.setBounds(250, 30, 1000, 1);
		bound1.setBackground(Color.BLACK);
		
		JLabel raminfo = new JLabel("RAM festlegen"  + " (" + "8" + " GB empfohlen)");  // user feedback line for the ram info
		raminfo.setBounds(165, 0, 190, 15);
		raminfo.setVisible(true);
		addserver.add(raminfo);
		
		JFrame forgeguide = new JFrame("Forge guide"); // TODO forge guide überarbeiten
		forgeguide.setLayout(null);                    //forge guide for the users to explain how to use the forge installer
		forgeguide.setResizable(false);
		forgeguide.setSize(700, 150);
		forgeguide.setVisible(false);
		
		JLabel forgeguidet1 = new JLabel();
		forgeguidet1.setText("Willkommen bei dem Forge installations guide!");
		forgeguidet1.setBounds(1, 1, 500, 15);
		forgeguidet1.setVisible(true);
		forgeguide.add(forgeguidet1);
		
		JLabel forgeguidet2 = new JLabel();
		forgeguidet2.setText("Hier wird gezeigt, wie man den forge installer benutzt.");
		forgeguidet2.setBounds(1, 20, 500, 15);
		forgeguidet2.setVisible(true);
		forgeguide.add(forgeguidet2);
		
		JLabel forgeguidet3 = new JLabel();
		forgeguidet3.setText("1. F�ge den folgenden pfad in die daf�r Vorgesehene Zeile ein: D:\\server\\<installierte minecraft-version>_modded");
		forgeguidet3.setBounds(1, 50, 700, 15);
		forgeguidet3.setVisible(true);
		forgeguide.add(forgeguidet3);
		
		JLabel forgeguidet4 = new JLabel();
		forgeguidet4.setText("2. W�hle die Option 'install server'");
		forgeguidet4.setBounds(1, 70, 600, 15);
		forgeguidet4.setVisible(true);
		forgeguide.add(forgeguidet4);
		
		JLabel forgeguidet5 = new JLabel();
		forgeguidet5.setText("3. Klicke auf OK.");
		forgeguidet5.setBounds(1, 90, 600, 15);
		forgeguidet5.setVisible(true);
		forgeguide.add(forgeguidet5);
		
		JSlider ramslider = new JSlider();  // JSlider for the slider to select the ram value in the server install window
		ramslider.setLabelTable(null);
		ramslider.setBounds(160, 14, 200, 50);
		ramslider.setMinimum(1);
		ramslider.setMaximum(16);
		ramslider.setValue(8);
		ramslider.setMajorTickSpacing(3);
		ramslider.setMinorTickSpacing(1);
		ramslider.createStandardLabels(1);
		ramslider.setPaintTicks(true);
		ramslider.setPaintLabels(true);
		ramslider.setForeground(Color.GREEN);
	
		
		int ftmp = 0;
		final int[] farray = new int[1];
		farray[0] = ftmp;
		new Runnable() {

			@Override
			public void run() {
				farray[0] = 0;
				
			}
			
			
		};
		
		

		
		// Server adder / ramslider color manager
		
		ramslider.addChangeListener(new ChangeListener() { // Listener for change in the slider

			@Override
			public void stateChanged(ChangeEvent e) {
				
				int ram = ramslider.getValue(); // gets the value of the sliderPos
				
				if(ValueRange.of(1, 8).isValidIntValue(ram)) { // if the value of sliderPos is between 1-8
					
					ramslider.setForeground(Color.GREEN);    
					
				}
				
				if (ValueRange.of(9, 12).isValidIntValue(ram)) { // if the value of sliderPos is between 9-12
					
					ramslider.setForeground(Color.ORANGE);
					
				}
				
				if(ValueRange.of(13, 16).isValidIntValue(ram)) { // if the value of sliderPos is between 13-16
					
					ramslider.setForeground(Color.RED);
					
				}
				
			}
			
			
		});
		
		ramslider.setVisible(true); // sets the slider to visible
		addserver.add(ramslider);
		
	
		JLabel con = new JLabel("Bitte server ausw�hlen oder installieren"); // creates the JLabel console in the main window
		con.setBounds(120, 1, 500, 30);
		con.setVisible(true);
		control.add(con);
		
		String[] modechooserstr = {"Vanilla", "Forge", "Plugin"};
		
		@SuppressWarnings("unchecked")
		JComboBox modechooser = new JComboBox(modechooserstr);
		modechooser.setBounds(20,  53, 100, 30);
		modechooser.setVisible(true);
		addserver.add(modechooser);
		
		if(modechooser.getSelectedItem().equals("Forge")) {
			
			farray[0] = 1;
			
		}
		
		

		
		JButton chooser = new JButton("Serverdaten herunterladen"); // creates the button to download the server data
		chooser.setBounds(20, 90, 300, 30);
		chooser.setVisible(true);
		
	File cconfig = new File("D:\\server\\config\\config.txt");  // creates a file in the root folder for the config

	
	if(cconfig.exists() == false) {                             // if the file doesn't exist you have to select your java directory
		con.setText("Bitte lege zuerst deinen Javapfad in den Einstellungen fest!");
		
	}
		
	
	
	
	
		
		// -- W�hlkn�pfe -- //
		
		
		
	System.out.println("Building chooserbuttons..."); // debug message
		
		
		Button bv1710 = new Button("1.7.10 (nicht installiert)");   
		bv1710.setBounds(47, 36, 150, 30);
		bv1710.setEnabled(false);
		bv1710.setVisible(true);
		selection.add(bv1710);
		
		Button bv1102 = new Button("1.10.2 (nicht installiert)");
		bv1102.setBounds(47, 86, 150, 30);
		bv1102.setEnabled(false);
		bv1102.setVisible(true);
		selection.add(bv1102);
		
		Button bv1122 = new Button("1.12.2 (nicht installiert)");
		bv1122.setBounds(47, 136, 150, 30);
		bv1122.setEnabled(false);
		bv1122.setVisible(true);
		selection.add(bv1122);
		
		Button bv1144 = new Button("1.14.4 (nicht installiert)");
		bv1144.setBounds(47, 186, 150, 30);
		bv1144.setEnabled(false);
		bv1144.setVisible(true);
		selection.add(bv1144);
		
		Button bv1152 = new Button("1.15.2 (nicht installiert)");
		bv1152.setBounds(47, 236, 150, 30);
		bv1152.setEnabled(false);
		bv1152.setVisible(true);
		selection.add(bv1152);
		
		Button bv1165 = new Button("1.16.5 (nicht installiert)");
		bv1165.setBounds(47, 286, 150, 30);
		bv1165.setEnabled(false);
		bv1165.setVisible(true);
		selection.add(bv1165);
		
		Button bv117 = new Button("1.17 (nicht installiert)");
		bv117.setBounds(47, 336, 150, 30);
		bv117.setEnabled(false);
		bv117.setVisible(true);
		selection.add(bv117);
		
		Button bv118 = new Button("1.18 (nicht installiert)");
		bv118.setBounds(47, 386, 150, 30);
		bv118.setEnabled(false);
		bv118.setVisible(true);
		selection.add(bv118);
		
		JTextArea settingsfile = new JTextArea();
		settingsfile.setSize(735, 540);
		settingsfile.setLineWrap(true);
		
		JScrollPane settingst = new JScrollPane(settingsfile, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		settingst.setSize(735, 540);
		
		plog.add(settingst);
		
		JCheckBox vanilla = new JCheckBox("Forge");
		vanilla.setBounds(880, 0, 57, 30);
	
	
		vanilla.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					enabled = 1;
					
					
				}else {
					enabled = 0;
				
				}
				
			}
			
			
		});
		vanilla.setVisible(true);
		control.add(vanilla);
		
		
		System.out.println("success");
		
		System.out.println("building action listeners (filereader)");
		
		bv1710.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				bv1710.setBackground(Color.LIGHT_GRAY);
				bv1102.setBackground(Color.WHITE);
				bv1122.setBackground(Color.WHITE);
				bv117.setBackground(Color.WHITE);
				bv1152.setBackground(Color.WHITE);
				bv1165.setBackground(Color.WHITE);
				bv1144.setBackground(Color.WHITE);
				
				if(enabled == 1) {
				
					settingsfile.setText(" ");
					
					String file = "D:\\server\\1.7.10_modded\\server.properties";
					
					try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					    String line;
					    while ((line = br.readLine()) != null) {
					   
					      settingsfile.append(line + "\n");
					  
					      settingsfile.repaint();
					    }
					   
					} catch (IOException err) {
						
						err.printStackTrace();
						con.setText("server.properties nicht vorhanden! (bitte server zuerst starten!)");
					}
					serverselect = 1;
				
				}else {
					
					settingsfile.setText(" ");
					
					String file = "D:\\server\\1.7.10\\server.properties";
					
					try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					    String line;
					    while ((line = br.readLine()) != null) {
					   
					      settingsfile.append(line + "\n");
					  
					      settingsfile.repaint();
					    }
					   
					} catch (IOException err) {
						
						err.printStackTrace();
						con.setText("server.properties nicht vorhanden! (bitte server zuerst starten!)");
					}
					serverselect = 1;
				}
				
			}
		});
		
		
		bv1102.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bv1710.setBackground(Color.WHITE);
				bv1122.setBackground(Color.WHITE);
				bv117.setBackground(Color.WHITE);
				bv1144.setBackground(Color.WHITE);
				bv1165.setBackground(Color.WHITE);
				bv1152.setBackground(Color.WHITE);
				bv1102.setBackground(Color.LIGHT_GRAY);
				if(enabled == 1) {
					
					
				
				
						settingsfile.setText(" ");
				
				String file = "D:\\server\\1.10.2_modded\\server.properties";
				
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				    String line;
				    while ((line = br.readLine()) != null) {
				   
				      settingsfile.append(line + "\n");
				  
				      settingsfile.repaint();
				    }
				   
				} catch (IOException err) {
					
					err.printStackTrace();
					con.setText("server.properties nicht vorhanden! (bitte server zuerst starten!)");
				}
				serverselect = 2;
			
				}else {
					
					settingsfile.setText(" ");
					
					String file = "D:\\server\\1.10.2\\server.properties";
					
					try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					    String line;
					    while ((line = br.readLine()) != null) {
					   
					      settingsfile.append(line + "\n");
					  
					      settingsfile.repaint();
					    }
					   
					} catch (IOException err) {
						
						err.printStackTrace();
						con.setText("server.properties nicht vorhanden! (bitte server zuerst starten!)");
					}
					serverselect = 2;
				}
			}	
			
		});
		
		bv1122.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bv1102.setBackground(Color.WHITE);
				bv1710.setBackground(Color.WHITE);
				bv1165.setBackground(Color.WHITE);
				bv117.setBackground(Color.WHITE);
				bv1152.setBackground(Color.WHITE);
				bv1144.setBackground(Color.WHITE);
				bv1122.setBackground(Color.LIGHT_GRAY);
					if(enabled == 1) {
settingsfile.setText(" ");
				
				String file = "D:\\server\\1.12.2_modded\\server.properties";
				
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				    String line;
				    while ((line = br.readLine()) != null) {
				   
				      settingsfile.append(line + "\n");
				  
				      settingsfile.repaint();
				    }
				   
				} catch (IOException err) {
					
					err.printStackTrace();
					con.setText("server.properties nicht vorhanden! (bitte server zuerst starten!)");
				}
				serverselect = 3;
				
					}else {
						settingsfile.setText(" ");
						
						String file = "D:\\server\\1.12.2\\server.properties";
						
						try (BufferedReader br = new BufferedReader(new FileReader(file))) {
						    String line;
						    while ((line = br.readLine()) != null) {
						   
						      settingsfile.append(line + "\n");
						  
						      settingsfile.repaint();
						    }
						   
						} catch (IOException err) {
							
							err.printStackTrace();
							con.setText("server.properties nicht vorhanden! (bitte server zuerst starten!)");
						}
						serverselect = 3;
						
					}
			}
		});
		
		
		bv1144.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
settingsfile.setText(" ");

bv1144.setBackground(Color.LIGHT_GRAY);
bv1152.setBackground(Color.WHITE);
bv1165.setBackground(Color.WHITE);
bv117.setBackground(Color.WHITE);
bv1122.setBackground(Color.WHITE);
bv1710.setBackground(Color.WHITE);
bv1102.setBackground(Color.WHITE);

			if(enabled == 1) {
				
				
				
				String file = "D:\\server\\1.14.4_modded\\server.properties";
				
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				    String line;
				    while ((line = br.readLine()) != null) {
				   
				      settingsfile.append(line + "\n");
				  
				      settingsfile.repaint();
				    }
				   
				} catch (IOException e1) {
					
					e1.printStackTrace();
					con.setText("server.properties nicht vorhanden! (bitte server zuerst starten!)");
				}
				serverselect = 4;
				
			
			}else {
	String file = "D:\\server\\1.14.4\\server.properties";
				
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				    String line;
				    while ((line = br.readLine()) != null) {
				   
				      settingsfile.append(line + "\n");
				  
				      settingsfile.repaint();
				    }
				   
				} catch (IOException e1) {
					
					e1.printStackTrace();
					con.setText("server.properties nicht vorhanden! (bitte server zuerst starten!)");
				}
				
			}
			}
		});
		
		bv1152.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
settingsfile.setText(" ");

bv1152.setBackground(Color.LIGHT_GRAY);
bv1165.setBackground(Color.WHITE);
bv1144.setBackground(Color.WHITE);
bv117.setBackground(Color.WHITE);
bv1122.setBackground(Color.WHITE);
bv1102.setBackground(Color.WHITE);
bv1710.setBackground(Color.WHITE);

				if(enabled == 1) {
				
				String file = "D:\\server\\1.15.2_modded\\server.properties";
				
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				    String line;
				    while ((line = br.readLine()) != null) {
				   
				      settingsfile.append(line + "\n");
				  
				      settingsfile.repaint();
				    }
				   
				} catch (IOException err) {
					
					err.printStackTrace();
					con.setText("server.properties nicht vorhanden! (bitte server zuerst starten!)");
				}
				
				}else {
					String file = "D:\\server\\1.15.2\\server.properties";
					
					try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					    String line;
					    while ((line = br.readLine()) != null) {
					   
					      settingsfile.append(line + "\n");
					  
					      settingsfile.repaint();
					    }
					   
					} catch (IOException err) {
						
						err.printStackTrace();
						con.setText("server.properties nicht vorhanden! (bitte server zuerst starten!)");
					}
					
				}
				serverselect = 5;
			}	
		});
		
		bv1165.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					settingsfile.setText(" ");
					
					bv1165.setBackground(Color.LIGHT_GRAY);
					bv1152.setBackground(Color.WHITE);
					bv117.setBackground(Color.WHITE);
					bv1144.setBackground(Color.WHITE);
					bv1122.setBackground(Color.WHITE);
					bv1102.setBackground(Color.WHITE);
					bv1710.setBackground(Color.WHITE);
					
					
					
					if(enabled == 1) {
				
				String file = "D:\\server\\1.16.5_modded\\server.properties";
				
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				    String line;
				    while ((line = br.readLine()) != null) {
				   
				      settingsfile.append(line + "\n");
				  
				      settingsfile.repaint();
				   
				    }
				   
				} catch (IOException err) {
					
					con.setText("server.properties nicht vorhanden! (bitte server zuerst starten!)");
					
					err.printStackTrace();
				}
				
					}else {
						String file = "D:\\server\\1.16.5\\server.properties";
						
						try (BufferedReader br = new BufferedReader(new FileReader(file))) {
						    String line;
						    while ((line = br.readLine()) != null) {
						   
						      settingsfile.append(line + "\n");
						  
						      settingsfile.repaint();
						   
						    }
						   
						} catch (IOException err) {
							
							con.setText("server.properties nicht vorhanden! (bitte server zuerst starten!)");
							
							err.printStackTrace();
						}
						
					}
				serverselect = 6;
			}
		});
		
		bv117.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
settingsfile.setText(" ");

bv117.setBackground(Color.LIGHT_GRAY);
bv1165.setBackground(Color.WHITE);
bv1152.setBackground(Color.WHITE);
bv1144.setBackground(Color.WHITE);
bv1122.setBackground(Color.WHITE);
bv1102.setBackground(Color.WHITE);
bv1710.setBackground(Color.WHITE);
				
			if(enabled == 1) {

				String file = "D:\\server\\1.17_modded\\server.properties";
				
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				    String line;
				    while ((line = br.readLine()) != null) {
				   
				      settingsfile.append(line + "\n");
				  
				      settingsfile.repaint();
				    }
				   
				} catch (IOException err) {
					
					err.printStackTrace();
					con.setText("server.properties nicht vorhanden! (bitte server zuerst starten!)");
				}
				
			}else {

				String file = "D:\\server\\1.17\\server.properties";
				
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				    String line;
				    while ((line = br.readLine()) != null) {
				   
				      settingsfile.append(line + "\n");
				  
				      settingsfile.repaint();
				    }
				   
				} catch (IOException err) {
					
					err.printStackTrace();
					con.setText("server.properties nicht vorhanden! (bitte server zuerst starten!)");
				}
				
				
			}
				serverselect = 7;
			}
		});
		
		System.out.println("success");
		
		System.out.println("searching for existing servers...");
		
		
		if(Files.isDirectory(Paths.get("D:\\server\\1.7.10"), LinkOption.NOFOLLOW_LINKS)) {
			bv1710.setEnabled(true);
			bv1710.setLabel("1.7.10 (installiert)");
		}
			
		if(Files.isDirectory(Paths.get("D:\\server\\1.7.10_modded"), LinkOption.NOFOLLOW_LINKS)) {
			bv1710.setEnabled(true);
			bv1710.setLabel("1.7.10 (installiert)");
		}
			
		if(Files.isDirectory(Paths.get("D:\\server\\1.10.2"), LinkOption.NOFOLLOW_LINKS)) {
			bv1102.setEnabled(true);
			bv1102.setLabel("1.10.2 (installiert)");
		}
			
		if(Files.isDirectory(Paths.get("D\\server\\1.10.2_modded"), LinkOption.NOFOLLOW_LINKS)) {
			bv1102.setEnabled(true);
			bv1102.setLabel("1.10.2 (installiert)");
		}
			
	   if(Files.isDirectory(Paths.get("D:\\server\\1.12.2"), LinkOption.NOFOLLOW_LINKS)) {
			bv1122.setEnabled(true);
			bv1122.setLabel("1.12.2 (installiert)");
		}
			
		if(Files.isDirectory(Paths.get("D:\\server\\1.12.2_modded"), LinkOption.NOFOLLOW_LINKS)) {
			bv1122.setEnabled(true);
			bv1122.setLabel("1.12.2 (installiert)");
		}
			
		if(Files.isDirectory(Paths.get("D:\\server\\1.14.4"), LinkOption.NOFOLLOW_LINKS)) {
			bv1144.setEnabled(true);
			bv1144.setLabel("1.14.4 (installiert)");
		}
		
		if(Files.isDirectory(Paths.get("D:\\server\\1.14.4_modded"), LinkOption.NOFOLLOW_LINKS)) {
			bv1144.setEnabled(true);
			bv1144.setLabel("1.14.4 (installiert)");
		}
		
		if(Files.isDirectory(Paths.get("D:\\server\\1.15.2"), LinkOption.NOFOLLOW_LINKS)) {
			bv1152.setEnabled(true);
			bv1152.setLabel("1.15.2 (installiert)");
		}
		
		if(Files.isDirectory(Paths.get("D:\\server\\1.15.2_modded"), LinkOption.NOFOLLOW_LINKS)) {
			bv1152.setEnabled(true);
			bv1152.setLabel("1.15.2 (installiert)");
		}
		
		if(Files.isDirectory(Paths.get("D:\\server\\1.16.5"), LinkOption.NOFOLLOW_LINKS)) {
			bv1165.setEnabled(true);
			bv1165.setLabel("1.16.5 (installiert)");
		}
		
		if(Files.isDirectory(Paths.get("D:\\server\\1.16.5_modded"), LinkOption.NOFOLLOW_LINKS)) {
			bv1165.setEnabled(true);
			bv1165.setLabel("1.16.5 (installiert)");
		}
		
		if(Files.isDirectory(Paths.get("D:\\server\\1.17"), LinkOption.NOFOLLOW_LINKS)) {
			bv117.setEnabled(true);
			bv117.setLabel("1.17 (installiert)");
		}
		
		if(Files.isDirectory(Paths.get("D:\\server\\1.17_modded"), LinkOption.NOFOLLOW_LINKS)) {
			bv117.setEnabled(true);
			bv117.setLabel("1.17 (installiert)");
		}
		
		if(Files.isDirectory(Paths.get("D:\\server\\1.18"), LinkOption.NOFOLLOW_LINKS)) {
			bv117.setEnabled(true);
			bv117.setLabel("1.18 (installiert)");
		}
		
		if(Files.isDirectory(Paths.get("D:\\server\\1.18_modded"), LinkOption.NOFOLLOW_LINKS)) {
			bv117.setEnabled(true);
			bv117.setLabel("1.19 (installiert)");
		}
		
		
		System.out.println("done");
		
			//31, 300
		
		System.out.println("building additional gui stuff...");
		
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				con.setText("Einstellungen gespeichert!");
				
					if(serverselect == 1) {
						
						if(enabled == 1) {
							
							 PrintWriter pWriter1 = null;
					            
					            try {
						            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.7.10_modded\\server.properties")));
						            pWriter1.println(settingsfile.getText() + "\n");
						         
						        } catch (IOException ioe) {
						            ioe.printStackTrace();
						        } finally {
						            if (pWriter1 != null){
						                pWriter1.flush();
						                pWriter1.close();
						            }
						           
						            
								}
							
						}else {
					
					
					 PrintWriter pWriter1 = null;
			            
			            try {
				            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.7.10\\server.properties")));
				            pWriter1.println(settingsfile.getText() + "\n");
				         
				        } catch (IOException ioe) {
				            ioe.printStackTrace();
				        } finally {
				            if (pWriter1 != null){
				                pWriter1.flush();
				                pWriter1.close();
				            }
				           
				            
						}
						}
					}else if(serverselect == 2) {
						
						if (enabled == 1) {
							
							
							
							 PrintWriter pWriter1 = null;
					            
					            try {
						            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.10.2_modded\\server.properties")));
						            pWriter1.println(settingsfile.getText() + "\n");
						         
						        } catch (IOException ioe) {
						            ioe.printStackTrace();
						        } finally {
						            if (pWriter1 != null){
						                pWriter1.flush();
						                pWriter1.close();
						            }
						           
						        }
							
						}else {
							
						
				 PrintWriter pWriter1 = null;
		            
		            try {
			            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.10.2\\server.properties")));
			            pWriter1.println(settingsfile.getText() + "\n");
			         
			        } catch (IOException ioe) {
			            ioe.printStackTrace();
			        } finally {
			            if (pWriter1 != null){
			                pWriter1.flush();
			                pWriter1.close();
			            }
			           
			        }
					}
						}else if(serverselect == 3) {
							
							if(enabled == 1) {
								
								 PrintWriter pWriter1 = null;
								  try {
							            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.12.2_modded\\server.properties")));
							            pWriter1.println(settingsfile.getText() + "\n");
							         
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter1 != null){
							                pWriter1.flush();
							                pWriter1.close();
							            }
							           
							            
									}
								
							}else {
								
							
							 PrintWriter pWriter1 = null;
							  try {
						            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.12.2\\server.properties")));
						            pWriter1.println(settingsfile.getText() + "\n");
						         
						        } catch (IOException ioe) {
						            ioe.printStackTrace();
						        } finally {
						            if (pWriter1 != null){
						                pWriter1.flush();
						                pWriter1.close();
						            }
						           
						            
								}
							}
						}else if(serverselect == 4) {
							
							if(enabled == 1) {
								 PrintWriter pWriter1 = null;
								  try {
							            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.14.4_modded\\server.properties")));
							            pWriter1.println(settingsfile.getText() + "\n");
							         
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter1 != null){
							                pWriter1.flush();
							                pWriter1.close();
							            }
							           
							            
									}
								
							}else {
							
							 PrintWriter pWriter1 = null;
							  try {
						            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.14.4\\server.properties")));
						            pWriter1.println(settingsfile.getText() + "\n");
						         
						        } catch (IOException ioe) {
						            ioe.printStackTrace();
						        } finally {
						            if (pWriter1 != null){
						                pWriter1.flush();
						                pWriter1.close();
						            }
						           
						            
								}
							}
						}else if(serverselect == 5) {
							
							if(enabled == 1) {
							
								 PrintWriter pWriter1 = null;
								  try {
							            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.15.2_modded\\server.properties")));
							            pWriter1.println(settingsfile.getText() + "\n");
							         
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter1 != null){
							                pWriter1.flush();
							                pWriter1.close();
							            }
							           
							            
									}
								
							}else {
							
							 PrintWriter pWriter1 = null;
							  try {
						            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.15.2\\server.properties")));
						            pWriter1.println(settingsfile.getText() + "\n");
						         
						        } catch (IOException ioe) {
						            ioe.printStackTrace();
						        } finally {
						            if (pWriter1 != null){
						                pWriter1.flush();
						                pWriter1.close();
						            }
						           
						            
								}
							}
						}else if(serverselect == 6) {
							
							if(enabled == 1) {
								
								 PrintWriter pWriter1 = null;
								  try {
							            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.16.5_modded\\server.properties")));
							            pWriter1.println(settingsfile.getText() + "\n");
							         
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter1 != null){
							                pWriter1.flush();
							                pWriter1.close();
							            }
							           
							            
									}
								
							}else {
							
							 PrintWriter pWriter1 = null;
							  try {
						            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.16.5\\server.properties")));
						            pWriter1.println(settingsfile.getText() + "\n");
						         
						        } catch (IOException ioe) {
						            ioe.printStackTrace();
						        } finally {
						            if (pWriter1 != null){
						                pWriter1.flush();
						                pWriter1.close();
						            }
						           
						            
								}
							}
						}else if(serverselect == 7) {
							
							if(enabled == 1) {
								
								 PrintWriter pWriter1 = null;
								  try {
							            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.17_modded\\server.properties")));
							            pWriter1.println(settingsfile.getText() + "\n");
							         
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter1 != null){
							                pWriter1.flush();
							                pWriter1.close();
							            }
							           
							            
									
								}
								
							}else{
							
							 PrintWriter pWriter1 = null;
							  try {
						            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.17\\server.properties")));
						            pWriter1.println(settingsfile.getText() + "\n");
						         
						        } catch (IOException ioe) {
						            ioe.printStackTrace();
						        } finally {
						            if (pWriter1 != null){
						                pWriter1.flush();
						                pWriter1.close();
						            }
						           
						            
						        }
							}
						}else if(serverselect == 8){
						
							if(enabled == 1) {
								
								 PrintWriter pWriter1 = null;
								  try {
							            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.18_modded\\server.properties")));
							            pWriter1.println(settingsfile.getText() + "\n");
							         
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter1 != null){
							                pWriter1.flush();
							                pWriter1.close();
							            }
							           
							            
									}
								
						
						
							}else{
							
							 PrintWriter pWriter1 = null;
							  try {
						            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.18\\server.properties")));
						            pWriter1.println(settingsfile.getText() + "\n");
						         
						        } catch (IOException ioe) {
						            ioe.printStackTrace();
						        } finally {
						            if (pWriter1 != null){
						                pWriter1.flush();
						                pWriter1.close();
						            }
						           
						          
						        }
							}
							
						}
			}
	
			
		});
		
		Button reinstall = new Button("Server neuinstallieren");
		reinstall.setBounds(310, 548, 130, 30);
		reinstall.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Reinstaller reinstaller = new Reinstaller();
				reinstaller.reinstall();
			}
			
			
		});
		reinstall.setVisible(true);
		plog.add(reinstall);
		
		Button eula = new Button("Mods installieren");
		eula.setBounds(164, 548, 130, 30);
		eula.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
						
				gui.ModDownloader gui = new gui.ModDownloader();
				
				gui.advanced();
				
			}
			
			
		});
		eula.setVisible(true);
		plog.add(eula);
		
		Button start = new Button("Server Starten");
		start.setBounds(20, 548, 130, 30);
		start.setBackground(Color.GREEN);
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				con.setText("Funktion noch nicht implementiert!");
				
				Serverstarter server = new Serverstarter();
				server.start();
				
			}
			
			
		});
		
		
	
	
		
		start.setVisible(true);
		plog.add(start);
		
		
		
	
		
		
		
	
		BufferedImage creditsbutton = ImageIO.read(new FileInputStream("rsc\\credits.jpg"));
		JLabel creditsbuttont = new JLabel(new ImageIcon(creditsbutton));
		creditsbuttont.setBounds(0, 0, 16, 16);
		Credits credits = new Credits();
		
		JPanel creditsd = new JPanel();
		creditsd.setBounds(960, 6, 16, 16);
		creditsd.setLayout(null);
		creditsd.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
			credits.credits();
			
			}
		});
		
		
		
		creditsd.setVisible(true);
		creditsd.add(creditsbuttont);
		control.add(creditsd);
		
		BufferedImage helpbutton = ImageIO.read(new FileInputStream("rsc\\help.png"));
		JLabel helpbuttont = new JLabel(new ImageIcon(helpbutton));
		helpbuttont.setBounds(0, 0, 16, 16);
		Credits help = new Credits();
		
		JPanel helpd = new JPanel();
		helpd.setBounds(69, 6, 16, 16);
		helpd.setLayout(null);
		helpd.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
			Help help = new Help();
			try {
				help.help();
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
			}
		});
		helpd.setVisible(true);
		helpd.add(helpbuttont);
		control.add(helpd);
		
		
		
		
	
		
		 /*JCheckBox forge = new JCheckBox("Forge installieren");
		forge.setBounds(10, 55, 130, 30);
		forge.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
				 farray[0] = 1;
				 
				}else {
				 farray[0] = 0; 
					
				}
				
			}
				
		});
	
		
		forge.setVisible(true);
		addserver.add(forge);
	*/	
		//Deleter
		
		Button startserver = new Button("Server Löschen...");
		startserver.setBounds(455, 548, 130, 30);
		startserver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Guidelete gui = new Guidelete();
				gui.GuiDeleter();
				
			}
		});
		
		startserver.setVisible(true);
		plog.add(startserver);
		
		
		
		BufferedImage settingsbutton = ImageIO.read(new FileInputStream("rsc\\settings.png"));
		JLabel settingsbuttont = new JLabel(new ImageIcon(settingsbutton));
		settingsbuttont.setBounds(0, 0, 16, 16);
		
		Settings settings2 = new Settings();
		
		JPanel settings = new JPanel();
		settings.setBounds(40, 6, 16, 16);
		settings.setLayout(null);
		settings.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				try {
					settings2.settings();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
				
				
					
				}	
			});
			settings.add(settingsbuttont);
		control.add(settings);
		
		Button schliessen = new Button("abbrechen/schlie�en");
		schliessen.setBounds(45, 100, 150, 30);
		schliessen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
				
			}	
		});
	
		schliessen.setVisible(false);
		selection.add(schliessen);
		
		String combobox[] = {"1.7.10", "1.10.2", "1.12.2", "1.14.4", "1.15.2", "1.16.5", "1.17", "1.18", "1.19"};
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox server = new JComboBox(combobox);
		server.setBounds(20, 20, 100, 30);
		server.setVisible(true);
		addserver.add(server);
		
		
		forgedownloader.V1_7_10 vdf1V1_7_10 = new forgedownloader.V1_7_10();
		downloader.V1_7_10 v1710 = new downloader.V1_7_10();
		
		forgedownloader.V1_10_2 vdf1V1_10_2 = new forgedownloader.V1_10_2();
		downloader.V1_10_2 v1102 = new downloader.V1_10_2();
		
		forgedownloader.V1_12_2 vdf1V1_12_2 = new forgedownloader.V1_12_2();
		downloader.V1_12_2 v1122 = new downloader.V1_12_2();
		
		forgedownloader.V1_14_4 vdf1V1_14_4 = new forgedownloader.V1_14_4();
		downloader.V1_14_4 v1144 = new downloader.V1_14_4();
		
		forgedownloader.V1_15_2 vdf1V1_15_2 = new forgedownloader.V1_15_2();
		downloader.V1_15_2 v1152 = new downloader.V1_15_2();
		
		forgedownloader.V1_16_5 vdf1V1_16_5 = new forgedownloader.V1_16_5();
		downloader.V1_16_5 v1165 = new downloader.V1_16_5();
		
		forgedownloader.V1_17 vdf1V1_17 = new forgedownloader.V1_17();
		downloader.V1_17 v117 = new downloader.V1_17();
		
		forgedownloader.V1_18 vdf1V1_18 = new forgedownloader.V1_18();
		downloader.V1_18 v118 = new downloader.V1_18();
		
		
		
		
		
		
		chooser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				File file = new File("D:\\server");
				file.mkdirs();
				
				
				
				
				
				
				
				if(server.getSelectedItem() == "1.7.10") {
					
					if(farray[0] == 1) {
						
						
					vdf1V1_7_10.f1710();

					}else {
						v1710.V1710();
						
						
					}
					
				}else if(server.getSelectedItem() == "1.10.2") {
					
					if(farray[0] == 1) {
						
						vdf1V1_10_2.V1102();
						
					}else {
					
					v1102.V1102();
					
					}
					
				} else if(server.getSelectedItem() == "1.12.2") {
					
					if(farray[0] == 1) {
						
						vdf1V1_12_2.V1122();
							
					}else {
					
						v1122.V1122();
					
					}
			            
				} else if(server.getSelectedItem() == "1.14.4") {
					
					if(farray[0] == 1) {
						
						vdf1V1_14_4.V1144();
						
					}else {
					
						v1144.V1144();
					
					}
					
				} else if(server.getSelectedItem() == "1.15.2") {
					
					if(farray[0] == 1) {
						
						vdf1V1_15_2.v1152();
						
					}else {
					
						v1152.v1152();
						
				}
			            
				} else if(server.getSelectedItem() == "1.16.5") {
					
					if(farray[0] == 1) {
						
						vdf1V1_16_5.v1165();
						
					}else {
					
					v1165.V1165();
					
					}   
			            
				} else if(server.getSelectedItem() == "1.17") {
					
					if(farray[0] == 1) {
						
						vdf1V1_17.V117();
						
					}else {
						
						v117.V117();
						
					}
				
			
			}else if(server.getSelectedItem() == "1.18") {
				

				if(farray[0] == 1) {
					
					vdf1V1_18.V118();
					
				}else {
					
					v118.V118();
					
				}
				
			}
			
			}
			
		});
		addserver.add(chooser);
		
		BufferedImage addbutton = ImageIO.read(new FileInputStream("rsc\\green_plus.png"));
		JLabel addbuttont = new JLabel(new ImageIcon(addbutton));
		addbuttont.setBounds(0, 0, 16, 16);
		
		JPanel add = new JPanel();
		
		
		add.setBounds(10, 5, 16, 16);
		add.setLayout(null);
		add.setVisible(true);
		add.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				addserver.setVisible(true);
				
				
			
				
				JButton terminate = new JButton("abbrechen");
				terminate.setBounds(20, 130, 150, 30);
				terminate.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						addserver.setVisible(false);
						
					}
					
					
				});
				terminate.setVisible(true);
				addserver.add(terminate);
				
				JButton closeadd = new JButton("Server Installieren");
				closeadd.setBounds(333, 130, 150, 30);
				closeadd.setEnabled(false);
				closeadd.setVisible(true);
				
				JCheckBox eula = new JCheckBox("Ich akzeptiere die EULA von Mojang.");
				eula.setBounds(160, 57, 250, 30);
				eula.setVisible(true);
				addserver.add(eula);
				
				closeadd.setEnabled(false);
				
				eula.addItemListener(new ItemListener() {
				
					
					
				@Override
				 public void itemStateChanged(ItemEvent e) {
				   
					if(eula.isSelected()) {
						closeadd.setEnabled(true);
			            
			        }else {
			        	
			        	closeadd.setEnabled(false);
			        }
				
				 }
				});
					
					
				
				
				
				closeadd.addActionListener(new ActionListener() {
					
					/*forgeinstaller.V1_7_10 v1710 = new forgeinstaller.V1_7_10();
					installer.V1_7_10 fv1710 = new installer.V1_7_10();
					forgeinstaller.V1_10_2 v1102 = new forgeinstaller.V1_10_2();
					installer.V1_10_2 vv1102 = new installer.V1_10_2();
					*/
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						
						addserver.setVisible(false);
						
					
						if(server.getSelectedItem() == "1.7.10") {
							
							bv1710.setEnabled(true);
							bv1710.setLabel("1.7.10 (installiert)");
							
							if(farray[0] == 1) {
								
								
								
							}else {
								PrintWriter pWriter = null;
								try {
						            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.7.10\\eula.txt")));
						            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
						            pWriter.println("eula=true");
						        } catch (IOException ioe) {
						            ioe.printStackTrace();
						        } finally {
						            if (pWriter != null){
						                pWriter.flush();
						                pWriter.close();
						            }
						            
						            PrintWriter pWriter1 = null;
						            
						            
						            try {
						            
						            	
							            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.7.10\\server starten.bat")));
							            pWriter1.println('"' + Files.readAllLines(Paths.get("D:\\server\\config\\config.txt")).get(3) + '"' + " -jar " + "-Xms2G -Xmx" + ramslider.getValue() + "G server.jar");
							            pWriter1.println("pause");
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter1 != null){
							                pWriter1.flush();
							                pWriter1.close();
							            }
							           
							            
									}
							            
						        } 
						 
							}
						 		
					        }else if(server.getSelectedItem() == "1.10.2") {
					        	bv1102.setEnabled(true);
					        	bv1102.setLabel("1.10.2 (installiert)");
					        	PrintWriter pWriter = null;
					        	
					        	if(farray[0] == 1) {
					        		
									//^1
					        		forgeguide.setVisible(true);
									
									File file1 = new File("D:\\server\\1.10.2_modded");
									file1.mkdirs();
									
									forgeguide.setVisible(true);									
									
									
									try {
							            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.10.2_modded\\eula.txt")));
							            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
							            pWriter.println("eula=true");
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter != null){
							                pWriter.flush();
							                pWriter.close();
							            }
							            
							            PrintWriter pWriter1 = null;
							            
							            try {
								            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.10.2_modded\\server starten.bat")));
								            pWriter1.println('"' + Files.readAllLines(Paths.get("D:\\server\\config\\config.txt")).get(3) + '"' + " -jar" + "-Xms2G -Xmx" + ramslider.getValue() + "G -jar forge-1.10.2-12.18.3.2511-universal.jar");
								            pWriter1.println("pause");
								        } catch (IOException ioe) {
								            ioe.printStackTrace();
								        } finally {
								            if (pWriter1 != null){
								                pWriter1.flush();
								                pWriter1.close();
								            }
								           
								            
										}
								          
							        } 
									
									try {
										Runtime.
										   getRuntime().
										   exec("cmd /C java -jar D:\\server\\downloading\\forge_1.10.2.jar");
										System.out.println("1.10.2");
									} catch (IOException e1) {
										
										System.out.println(e1);
									}
					        		
					        	}else {
					        	
					        	try {
						            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.10.2\\eula.txt")));
						            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
						            pWriter.println("eula=true");
						        } catch (IOException ioe) {
						            ioe.printStackTrace();
						        } finally {
						            if (pWriter != null){
						                pWriter.flush();
						                pWriter.close();
						            }
						            
						            PrintWriter pWriter1 = null;
						            
						            try {
							            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.10.2\\server starten.bat")));
							            pWriter1.println('"' + Files.readAllLines(Paths.get("D:\\server\\config\\config.txt")).get(3) + '"' + " -jar " + "-Xms2G -Xmx" + ramslider.getValue() + "G -jar server.jar");
							            pWriter1.println("pause");
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter1 != null){
							                pWriter1.flush();
							                pWriter1.close();
							            }
							           
							            
									}
							            
						        } 
					        	
					        	}
					        	
					        	
					        }else if(server.getSelectedItem() == "1.12.2") {
					        	bv1122.setEnabled(true);
					        	bv1122.setLabel("1.12.2 (installiert)");
					        	PrintWriter pWriter = null;
					        	
					        	if(farray[0] == 1) {
					        		File file1 = new File("D:\\server\\1.12.2_modded");
									file1.mkdirs();
									
									forgeguide.setVisible(true);									
									
									
									try {
							            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.12.2_modded\\eula.txt")));
							            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
							            pWriter.println("eula=true");
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter != null){
							                pWriter.flush();
							                pWriter.close();
							            }
							            
							            PrintWriter pWriter1 = null;
							            
							            try {
								            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.12.2_modded\\server starten.bat")));
								            pWriter1.println('"' + Files.readAllLines(Paths.get("D:\\server\\config\\config.txt")).get(3) + '"' + " -jar " + "-Xms2G -Xmx" + ramslider.getValue() + "G -jar forge-1.12.2-14.23.5.2855.jar");
								            pWriter1.println("pause");
								        } catch (IOException ioe) {
								            ioe.printStackTrace();
								        } finally {
								            if (pWriter1 != null){
								                pWriter1.flush();
								                pWriter1.close();
								            }
								           
								            
										}
								            
							        } 
									
									try {
										Runtime.
										   getRuntime().
										   exec("cmd /C java -jar D:\\server\\downloading\\forge_1.12.2.jar");
									} catch (IOException e1) {
										
										e1.printStackTrace();
									}
					        		
					        	}else {
					        	
					        	try {
						            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.12.2\\eula.txt")));
						            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
						            pWriter.println("eula=true");
						        } catch (IOException ioe) {
						            ioe.printStackTrace();
						        } finally {
						            if (pWriter != null){
						                pWriter.flush();
						                pWriter.close();
						            }
						            
						            PrintWriter pWriter1 = null;
						            
						            try {
							            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.12.2\\server starten.bat")));
							            pWriter1.println("java -Xms2G -Xmx" + ramslider.getValue() + "G -jar server.jar");
							            pWriter1.println("pause");
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter1 != null){
							                pWriter1.flush();
							                pWriter1.close();
							            }
							           
							            
									}
							            
						        }
					        }	
					        	
					        } else if(server.getSelectedItem() == "1.14.4") {
					        	bv1144.setEnabled(true);
					        	bv1144.setLabel("1.14.4 (installiert)");
					        	PrintWriter pWriter = null;
					        	
					        	if(farray[0] == 1) {
					        		File file1 = new File("D:\\server\\1.14.4_modded");
									file1.mkdirs();
									
									forgeguide.setVisible(true);									
									
									
									try {
							            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.14.4_modded\\eula.txt")));
							            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
							            pWriter.println("eula=true");
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter != null){
							                pWriter.flush();
							                pWriter.close();
							            }
							            
							           
							            PrintWriter pWriter1 = null;
							            
							            try {
							            	pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.14.4_modded\\server starten.bat")));
							            	pWriter1.println('"' + Files.readAllLines(Paths.get("D:\\server\\config\\config.txt")).get(3) + '"' + " -jar " + "-Xms2G -Xmx" + ramslider.getValue() + "G -jar forge-1.14.4-28.2.23.jar");
								            pWriter1.println("pause");
								        } catch (IOException ioe) {
								            ioe.printStackTrace();
								        } finally {
								            if (pWriter1 != null){
								                pWriter1.flush();
								                pWriter1.close();
								            }
								           
								            
										}
								            
							        } 
									
									try {
										Runtime.
										   getRuntime().
										   exec("cmd /C java -jar D:\\server\\downloading\\forge_1.14.4.jar");
									} catch (IOException e1) {
										
										e1.printStackTrace();
									}
					        		
					        	}else {
					        	
					        	try {
						            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.14.4\\eula.txt")));
						            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
						            pWriter.println("eula=true");
						        } catch (IOException ioe) {
						            ioe.printStackTrace();
						        } finally {
						            if (pWriter != null){
						                pWriter.flush();
						                pWriter.close();
						            }
						            
						            PrintWriter pWriter1 = null;
						            
						            try {
							            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.14.4\\server starten.bat")));
							            pWriter1.println("java -Xms2G -Xmx" + ramslider.getValue() + "G -jar server.jar");
							            pWriter1.println("pause");
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter1 != null){
							                pWriter1.flush();
							                pWriter1.close();
							            }
							           
							            
									}
							          
						            
						        }
						        }
					        } else if(server.getSelectedItem() == "1.15.2") {
					        	bv1152.setEnabled(true);
					        	bv1152.setLabel("1.15.2 (installiert)");
					        	PrintWriter pWriter = null;
					        	
					        	if(farray[0] == 1) {
					        		File file1 = new File("D:\\server\\1.15.2_modded");
									file1.mkdirs();
									
									forgeguide.setVisible(true);									
									
									
									try {
							            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.15.2_modded\\eula.txt")));
							            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
							            pWriter.println("eula=true");
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter != null){
							                pWriter.flush();
							                pWriter.close();
							            }
							            
							            PrintWriter pWriter1 = null;
							            
							            try {
							            	pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.15.2_modded\\server starten.bat")));
							            	pWriter1.println('"' + Files.readAllLines(Paths.get("D:\\server\\config\\config.txt")).get(3) + '"' + " -jar " + "-Xms2G -Xmx" + ramslider.getValue() + "G -jar forge-1.15.2-31.2.50.jar");
								            pWriter1.println("pause");
								        } catch (IOException ioe) {
								            ioe.printStackTrace();
								        } finally {
								            if (pWriter1 != null){
								                pWriter1.flush();
								                pWriter1.close();
								            }
								           
								            
										}
								            
							        } 
									
									try {
										Runtime.
										   getRuntime().
										   exec("cmd /C java -jar D:\\server\\downloading\\forge_1.15.2.jar");
									} catch (IOException e1) {
										
										e1.printStackTrace();
									}
					        		
					        	}else {
					        	
					        	try {
						            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.15.2\\eula.txt")));
						            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
						            pWriter.println("eula=true");
						        } catch (IOException ioe) {
						            ioe.printStackTrace();
						        } finally {
						            if (pWriter != null){
						                pWriter.flush();
						                pWriter.close();
						            }
						            
						            PrintWriter pWriter1 = null;
						            
						            try {
							            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.15.2\\server starten.bat")));
							            pWriter1.println("java -Xms2G -Xmx" + ramslider.getValue() + "G -jar server.jar");
							            pWriter1.println("pause");
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter1 != null){
							                pWriter1.flush();
							                pWriter1.close();
							            }
							           
							            
									}
							            
						        }
					        	
					        	}
					        	
					        } else if(server.getSelectedItem() == "1.16.5") {
					        	bv1165.setEnabled(true);
					        	bv1165.setLabel("1.16.5 (installiert)");
					        	PrintWriter pWriter = null;
					        	
					        	if(farray[0] == 1) {
					        		File file1 = new File("D:\\server\\1.16.5_modded");
									file1.mkdirs();
									
									forgeguide.setVisible(true);									
									
									
									try {
							            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.16.5_modded\\eula.txt")));
							            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
							            pWriter.println("eula=true");
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter != null){
							                pWriter.flush();
							                pWriter.close();
							            }
							            
							            PrintWriter pWriter1 = null;
							            
							            try {
							            	pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.16.5_modded\\server starten.bat")));
							            	pWriter1.println('"' + Files.readAllLines(Paths.get("D:\\server\\config\\config.txt")).get(3) + '"' + " -jar " + "-Xms2G -Xmx" + ramslider.getValue() + "G -jar forge-1.16.5-36.1.24.jar");
								            pWriter1.println("pause");
								        } catch (IOException ioe) {
								            ioe.printStackTrace();
								        } finally {
								            if (pWriter1 != null){
								                pWriter1.flush();
								                pWriter1.close();
								            }
								           
								            
										}
								            
							        } 
									
									try {
										Runtime.
										   getRuntime().
										   exec("cmd /C java -jar D:\\server\\downloading\\forge_1.16.5.jar");
									} catch (IOException e1) {
										
										e1.printStackTrace();
									}
					        		
					        	}else {
					        	
					        	try {
						            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.16.5\\eula.txt")));
						            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
						            pWriter.println("eula=true");
						        } catch (IOException ioe) {
						            ioe.printStackTrace();
						        } finally {
						            if (pWriter != null){
						                pWriter.flush();
						                pWriter.close();
						            }
						            
						            PrintWriter pWriter1 = null;
						            
						            try {
							            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.16.5\\server starten.bat")));
							            pWriter1.println('"' + Files.readAllLines(Paths.get("D:\\server\\config\\config.txt")).get(3) + '"' + " -jar " + "-Xms2G -Xmx" + ramslider.getValue() + "G -jar server.jar");
							            pWriter1.println("pause");
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter1 != null){
							                pWriter1.flush();
							                pWriter1.close();
							            }
							           
							            
									}
						            
						        }
					        	
					        	}
							            
						        }else if(server.getSelectedItem() == "1.17") {
						        	bv117.setEnabled(true);
						        	bv117.setLabel("1.17 (installiert)");
						        	PrintWriter pWriter = null;
						        	
						        	
						        	if(farray[0] == 1) {
						        		
						        		try {
								            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.17_modded\\eula.txt")));
								            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
								            pWriter.println("eula=true");
								        } catch (IOException ioe) {
								            ioe.printStackTrace();
								        } finally {
								            if (pWriter != null){
								                pWriter.flush();
								                pWriter.close();
								            }
								            
								            PrintWriter pWriter1 = null;
								            
								            try {
									            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.17_modded\\server starten.bat")));
									            pWriter1.println("java -Xms2G -Xmx" + ramslider.getValue() + "G -jar server.jar");
									            pWriter1.println("pause");
									        } catch (IOException ioe) {
									            ioe.printStackTrace();
									        } finally {
									            if (pWriter1 != null){
									                pWriter1.flush();
									                pWriter1.close();
									            }
									           
									            
											}
								            
								        }
						        		
						        	}else {
						        	
						        	try {
							            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.17\\eula.txt")));
							            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
							            pWriter.println("eula=true");
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter != null){
							                pWriter.flush();
							                pWriter.close();
							            }
							            
							            PrintWriter pWriter1 = null;
							            
							            try {
								            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.17\\server starten.bat")));
								            pWriter1.println("java -Xms2G -Xmx" + ramslider.getValue() + "G -jar server.jar");
								            pWriter1.println("pause");
								        } catch (IOException ioe) {
								            ioe.printStackTrace();
								        } finally {
								            if (pWriter1 != null){
								                pWriter1.flush();
								                pWriter1.close();
								            }
								           
								            
										}
							            
							        }
							        
						        }
						    }  else if(server.getSelectedItem() == "1.18") {
						    	
						    	bv118.setEnabled(true);
					        	bv118.setLabel("1.18 (installiert)");
					        	PrintWriter pWriter = null;
					        	
					        	
					        	if(farray[0] == 1) {
					        		
					        		try {
							            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.18_modded\\eula.txt")));
							            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
							            pWriter.println("eula=true");
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter != null){
							                pWriter.flush();
							                pWriter.close();
							            }
							            
							            PrintWriter pWriter1 = null;
							            
							            try {
								            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.18_modded\\server starten.bat")));
								            pWriter1.println("java -Xms2G -Xmx" + ramslider.getValue() + "G -jar server.jar");
								            pWriter1.println("pause");
								        } catch (IOException ioe) {
								            ioe.printStackTrace();
								        } finally {
								            if (pWriter1 != null){
								                pWriter1.flush();
								                pWriter1.close();
								            }
								           
								            
										}
							            
							        }
					        		
					        	}else {
					        	
					        	try {
						            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.18\\eula.txt")));
						            pWriter.println("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
						            pWriter.println("eula=true");
						        } catch (IOException ioe) {
						            ioe.printStackTrace();
						        } finally {
						            if (pWriter != null){
						                pWriter.flush();
						                pWriter.close();
						            }
						            
						            PrintWriter pWriter1 = null;
						            
						            try {
							            pWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\server\\1.18\\server starten.bat")));
							            pWriter1.println("java -Xms2G -Xmx" + ramslider.getValue() + "G -jar server.jar");
							            pWriter1.println("pause");
							        } catch (IOException ioe) {
							            ioe.printStackTrace();
							        } finally {
							            if (pWriter1 != null){
							                pWriter1.flush();
							                pWriter1.close();
							            }
							           
							            
									}
						            
						        }
						        
					        }
						    }
					    }
				
					
					
				});
				
				addserver.add(closeadd);
				
			
			
				
				
				
			}
			
			
			
		});
		
		
		
		// DARK MODE SETTER / WHITE MODE SETTER //
		
		
	
		
		String value = Files.readAllLines(Paths.get("D:\\server\\config\\config_darkmode.txt")).get(0);
		String compare = "darkmode = true";
		
		
		
		Gui gui = new Gui();
			if(new String(value).equals(compare)) {
			settingsfile.setBackground(Color.BLACK);
			settingst.setBackground(Color.BLACK);
			settingsfile.setForeground(Color.WHITE);
			control.setBackground(Color.DARK_GRAY);
			bound.setBackground(Color.WHITE);
			plog.setBackground(Color.GRAY);
			selection.setBackground(Color.GRAY);
			vanilla.setBackground(Color.DARK_GRAY);
			vanilla.setForeground(Color.WHITE);
			con.setBackground(Color.DARK_GRAY);
			con.setForeground(Color.WHITE);
			helpbuttont.setBackground(Color.DARK_GRAY);
			creditsd.setBackground(Color.DARK_GRAY);
			
			System.out.println("DarkMode on");
			
			}else {
				
				System.out.println("DarkMode off");
				
			}
			
		// ----------------------------------- //
			
			
			
			   
			  
			   
			
			
			
			
			
		add.add(addbuttont);
		main.add(add);
		main.add(control);
		control.setVisible(true);
		add.setVisible(true);
		main.add(selection);
		selection.setVisible(true);
		control.repaint();
		
	
		
		main.repaint();
		
		System.out.println("system.finish");
		message.message();
	
			
			
	
	
	}
	
	
}
// Made by potzplitz (Discord: potzplitz#4319)