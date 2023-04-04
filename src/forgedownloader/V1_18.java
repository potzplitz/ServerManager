package forgedownloader;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;

public class V1_18 {
	
	public void V118() {
		
System.out.println("version noch nicht verfügbar!");
		
		File file1 = new File("D:\\server\\1.18_modded");
		file1.mkdirs();
	
	 URL url;
        URLConnection con;
        DataInputStream dis; 
        FileOutputStream fos; 
        byte[] fileData;  
        try {
            url = new URL("<link zur 1.18>");
            con = url.openConnection(); 
            dis = new DataInputStream(con.getInputStream());
            fileData = new byte[con.getContentLength()]; 
            for (int q = 0; q < fileData.length; q++) { 
                fileData[q] = dis.readByte();
            }
            dis.close(); 
            fos = new FileOutputStream(new File("D:\\server\\1.18_modded\\server.jar")); 
            fos.write(fileData);  
            fos.close(); 
            
            System.out.println("lädt trzdm runter");
            
            
        }
        catch(Exception m) {
        	JOptionPane connection = new JOptionPane();
            JOptionPane.showMessageDialog(connection, "Es konnte keine Verbindung zum Server aufgebaut werden! (version noch nicht verfügbar)", "Serverdownloader Fehlermeldung", JOptionPane.ERROR_MESSAGE);
            connection.setSize(300, 150);
            connection.setLayout(null);
            connection.setVisible(true);
        }
		
		
	}

}
