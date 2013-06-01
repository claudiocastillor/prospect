package cl.prospect.crm.conexion;

import java.io.InputStream;
import java.util.Properties;

public class WebServerProperties {

	static protected String JNDI_BIB;
	
	static{
		try {
			String path ="";
			path ="WebServer.properties";
			InputStream in = WebServerProperties.class.getResourceAsStream(path);			
			Properties props = new Properties();    
			props.load(in);
			JNDI_BIB = props.getProperty("jndi_evaluaciones");
			
		} catch (Exception e) {		
			System.out.println("catch clase WebServerProperties");
			e.printStackTrace();
		}
	}
	static public String JNDI_BIB(){		
		if(JNDI_BIB==null)
			new WebServerProperties();
		return JNDI_BIB;	
	}
	
}
