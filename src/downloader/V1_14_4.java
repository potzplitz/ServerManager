package downloader;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;

public class V1_14_4 {
	
	public void V1144() {
		File file1 = new File("D:\\server\\1.14.4");
		file1.mkdirs();
		
		 URL url;
            URLConnection con;
            DataInputStream dis; 
            FileOutputStream fos; 
            byte[] fileData;  
            try {
                url = new URL("https://launcher.mojang.com/v1/objects/3dc3d84a581f14691199cf6831b71ed1296a9fdf/server.jar");
                con = url.openConnection(); 
                dis = new DataInputStream(con.getInputStream());
                fileData = new byte[con.getContentLength()]; 
                for (int q = 0; q < fileData.length; q++) { 
                    fileData[q] = dis.readByte();
                }
                dis.close(); 
                fos = new FileOutputStream(new File("D:\\server\\1.14.4\\server.jar")); 
                fos.write(fileData); 
                fos.close();
            }
            catch(Exception m) {
            	JOptionPane connection = new JOptionPane();
                JOptionPane.showMessageDialog(connection, "Es konnte keine Verbindung zum Server aufgebaut werden!", "Serverdownloader Fehlermeldung", JOptionPane.ERROR_MESSAGE);
                connection.setSize(300, 150);
                connection.setLayout(null);
                connection.setVisible(true);
            }
		
	}

}
