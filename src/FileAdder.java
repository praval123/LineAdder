import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
public class FileAdder {
	public static void main(String[] args) throws IOException {
		try {
		//load a properties file   
		Properties prop=new Properties();
		prop.load(new FileInputStream("config.properties"));
        //get the property value and print it out
		String UIInstallationDirectory=prop.getProperty("InstallationDirectory");
        String JNDI_PRINCIPAL=prop.getProperty("JNDI_PRINCIPAL");
		String JNDI_Credential=prop.getProperty("JNDI_Credential");
		File gh=new File(UIInstallationDirectory+File.separator+"public_html"+File.separator+"Web_INF"+File.separator+"ConfigGS"+File.separator+"DatabaseProperties.properties");
		System.out.println(gh);
		
		FileWriter fileWritter = new FileWriter(gh.getName(),true);
		System.out.println(gh.getName());
		/*if(!gh.exists()){
			gh.createNewFile();
		}*/
		
		BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write(JNDI_Credential);
        bufferWritter.write(JNDI_PRINCIPAL);
        bufferWritter.close();
		
        System.out.println("Done");
		} catch (IOException ex) {
	 		ex.printStackTrace();
	     }
		
	}
	
}

