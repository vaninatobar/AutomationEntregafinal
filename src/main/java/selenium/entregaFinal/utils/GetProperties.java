package selenium.entregaFinal.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
	
	protected Properties prop = new Properties();	
	
	public GetProperties() {
		InputStream input = getClass().getResourceAsStream("/config.properties");
		try {
			prop.load(input);
		}catch (FileNotFoundException e) {
			System.out.println("The property file was not found");
		}catch(IOException e) {
			System.out.println("Can not reas the property file");
		}				
	}
	
	public String getString(String propertyName) {
		return prop.getProperty(propertyName);
	}
}