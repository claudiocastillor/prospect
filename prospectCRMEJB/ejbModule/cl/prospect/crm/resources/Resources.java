package cl.prospect.crm.resources;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Esta clase se encarga de mantener los mensajes que utilizara el sistema,
 * devolviendo los properties en UTF8 encoding
 * 
 * @author claudiocastillo
 * 
 */
public class Resources {

	private static final String ApplicationPropertiesFile = "/cl/prospect/crm/resources/ApplicationResources.properties";
	private static final String MessagePropertiesFile = "/cl/prospect/crm/resources/MessageResources.properties";
	private static final String AlternatePropertiesFile = "/cl/prospect/crm/resources/AlternateApplicationResources.properties";

	/**
	 * @return Returns the alternate.
	 */
	public static ResourceBundle getAlternate() {
		return getBundle(AlternatePropertiesFile);
	}

	/**
	 * @return Returns the application.
	 */
	public static ResourceBundle getApplication() {
		return getBundle(ApplicationPropertiesFile);
	}

	public static ResourceBundle getMessage() {
		return getBundle(MessagePropertiesFile);
	}

	private static ResourceBundle getBundle(String nameFile) {
		try {
			InputStreamReader isr = new InputStreamReader(Resources.class
					.getResourceAsStream(nameFile), "UTF-8");
			PropertyResourceBundle prb = new PropertyResourceBundle(isr);
			return prb;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
