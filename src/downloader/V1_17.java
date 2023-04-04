package downloader;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;

public class V1_17 {

	public void V117() {
		File file1 = new File("D:\\server\\1.17");
		file1.mkdirs();
		
		 URL url;
            URLConnection con;
            DataInputStream dis; 
            FileOutputStream fos; 
            byte[] fileData;  
            try {
                url = new URL("https://launcher.mojang.com/v1/objects/0a269b5f2c5b93b1712d0f5dc43b6182b9ab254e/server.jar"); 
                con = url.openConnection(); 
                dis = new DataInputStream(con.getInputStream());
                fileData = new byte[con.getContentLength()]; 
                for (int q = 0; q < fileData.length; q++) { 
                    fileData[q] = dis.readByte();
                }
                dis.close(); 
                fos = new FileOutputStream(new File("D:\\server\\1.17\\server.jar")); 
                fos.write(fileData);  
                fos.close(); 
            }
            catch(Exception m) {
            	JOptionPane connection = new JOptionPane();
                JOptionPane.showMessageDialog(connection, "Es konnte keine Verbindung zum Server aufgebaut werden!", "Verbindungsfehler", JOptionPane.ERROR_MESSAGE);
                connection.setSize(300, 150);
                connection.setLayout(null);
                connection.setVisible(true);
            }
	
	System.out.println("as");
		
	}
	
}
