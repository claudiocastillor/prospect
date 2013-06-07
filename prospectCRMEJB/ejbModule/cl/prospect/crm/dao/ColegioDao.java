package cl.prospect.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import cl.prospect.crm.conexion.Conexion;
import cl.prospect.crm.dao.interfaces.IColegioDao;
import cl.prospect.crm.to.ColegioTo;
import cl.prospect.crm.to.EstadoTo;

public class ColegioDao implements IColegioDao {

	private static Conexion con = new Conexion();
	PreparedStatement stmtSelect = null;
	Connection conn = null;
	String sqlString = null;
	private ResourceBundle sql = null;
	
	@Override
	public ColegioTo getById(Long id) throws SQLException {
this.conn = this.con.connect("jndi_crm");
		
		ResultSet rs = null;
		ColegioTo colegio = null;
		
		try{
			this.stmtSelect = this.conn.prepareStatement(this.sql.getString("SELECT_COLEGIO_BY_ID"));
		
			this.stmtSelect.setLong(1, id);
		
			rs = this.stmtSelect.executeQuery();
			
			while (rs.next()){
				colegio = new ColegioTo();
				
				colegio.setId(rs.getString("id"));
				colegio.setNombre(rs.getString("nombre"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
			if(rs != null){
				rs.close();
			}
			
			this.stmtSelect.close();
			this.conn.close();
		}
		
		return colegio;
	}

	@Override
	public List<ColegioTo> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ColegioTo> getByParameters(String parameter, String value)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(ColegioTo colegio) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
