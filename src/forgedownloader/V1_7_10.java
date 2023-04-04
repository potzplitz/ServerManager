package forgedownloader;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class V1_7_10 {
	
	public void f1710() {
		File file1 = new File("D:\\server\\downloading");
		file1.mkdirs();
		
		URL url;
        URLConnection con;
        DataInputStream dis; 
        FileOutputStream fos; 
        byte[] fileData;  
        try {
            url = new URL("https://maven.minecraftforge.net/net/minecraftforge/forge/1.7.10-10.13.4.1614-1.7.10/forge-1.7.10-10.13.4.1614-1.7.10-installer.jar"); //ModLoader by FORGE (https://files.minecraftforge.net/net/minecraftforge/forge/)
            con = url.openConnection();
            dis = new DataInputStream(con.getInputStream());
            fileData = new byte[con.getContentLength()]; 
            for (int q = 0; q < fileData.length; q++) { 
                fileData[q] = dis.readByte();
            }
            dis.close();
            fos = new FileOutputStream(new File("D:\\server\\downloading\\forge_1.7.10.jar"));
            fos.write(fileData); 
            fos.close(); 
            System.out.println("fertig");
               
        }
        catch(Exception m) {
           
        }
		
	}

}
