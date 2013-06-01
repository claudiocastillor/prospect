package cl.prospect.crm.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Conexion {
	
	protected String jndiBIB = WebServerProperties.JNDI_BIB();
	protected String jndiSIGPER = WebServerProperties.JNDI_BIB();
	protected java.sql.Connection connection;
	
	/**
	 * METODO que obtiene una conexion cualquiera desde el POOL de conexiones para JBoss.
	 * @param connectTo: nombre de la referencia al recurso JNDI que apunta al pool de conexiones deseada.
	 * @return una conexion a una base de datos lista para utilizar. Null en caso de error.
	 * */
	public java.sql.Connection connect(String jndiName){
	    InitialContext ctx = null;
	    javax.sql.DataSource ds = null;
	    java.sql.Connection conn = null;
	    
		try {
			ctx = new InitialContext();
			
			if(jndiName.equalsIgnoreCase("jndi_crm")){
				ds = (DataSource) ctx.lookup("java:"+this.jndiBIB);
			}
		} catch (NamingException e) {
			
			e.getMessage();
			e.printStackTrace();
		}			
		try {
			conn= ds.getConnection();
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		this.connection = conn;
		
		return conn;
	}
	
	/**
	 * Metodo que obtiene una conexion a LOGIN desde el POOL de conexiones para JBoss.
	 * @return una conexion a una base de datos lista para utilizar. Null en caso de error.
	 * */
		
	
	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (Exception ex) {
			System.out.println("ImsiDAO.closeConnection: Exception(" + ex + ")");
		}
	}
}