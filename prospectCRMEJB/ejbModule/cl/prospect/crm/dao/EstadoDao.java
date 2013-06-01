package cl.prospect.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import cl.prospect.crm.conexion.Conexion;
import cl.prospect.crm.dao.interfaces.IEstadoDao;
import cl.prospect.crm.to.EstadoTo;

public class EstadoDao implements IEstadoDao{

	private static Conexion con = new Conexion();
	PreparedStatement stmtSelect = null;
	Connection conn = null;
	String sqlString = null;
	private ResourceBundle sql = null;
	
	@Override
	public EstadoTo getById(Long id) throws SQLException {
		conn = con.connect("jndi_crm");
		
		
		
		conn.close();
		
		return null;
	}

	@Override
	public List<EstadoTo> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstadoTo> getByParameters(String parameter, String value)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(EstadoTo p) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
