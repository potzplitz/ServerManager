package forgedownloader;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class V1_15_2 {
	
	public void v1152() {
		
		File file1 = new File("D:\\server\\downloading");
		file1.mkdirs();
		
		 URL url;
            URLConnection con;
            DataInputStream dis; 
            FileOutputStream fos; 
            byte[] fileData;  
            try {
                url = new URL("https://maven.minecraftforge.net/net/minecraftforge/forge/1.15.2-31.2.50/forge-1.15.2-31.2.50-installer.jar"); //ModLoader by FORGE (https://files.minecraftforge.net/net/minecraftforge/forge/)
                con = url.openConnection(); 
                dis = new DataInputStream(con.getInputStream());
                fileData = new byte[con.getContentLength()]; 
                for (int q = 0; q < fileData.length; q++) { 
                    fileData[q] = dis.readByte();
                }
                dis.close();
                fos = new FileOutputStream(new File("D:\\server\\downloading\\forge_1.15.2.jar"));
                fos.write(fileData);  
                fos.close(); 
            }
            catch(Exception m) {
                System.out.println(m);
            }
	}

}
