package cl.prospect.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import cl.prospect.crm.conexion.Conexion;
import cl.prospect.crm.dao.interfaces.IPermisoDao;
import cl.prospect.crm.to.PermisoTo;

import com.mysql.jdbc.Statement;

public class PermisoDao implements IPermisoDao{
	
	private static Conexion con = new Conexion();
	PreparedStatement stmtSelect = null;
	Connection conn = null;
	String sqlString = null;
	private ResourceBundle sql = null;
	
	@Override
	public PermisoTo getById(Long id) throws SQLException {
		this.conn = this.con.connect("jndi_crm");
		
		ResultSet rs = null;
		PermisoTo permiso = null;
		
		try{
			this.stmtSelect = this.conn.prepareStatement(this.sql.getString("SELECT_PERMISO_BY_ID"));
		
			this.stmtSelect.setLong(1, id);
		
			rs = this.stmtSelect.executeQuery();
			
			while (rs.next()){
				permiso = new PermisoTo();
				
				permiso.setId(rs.getLong("id"));
				permiso.setAgregarProspecto(rs.getBoolean("agregar_prospecto"));
//				int agregarProspecto = rs.getInt("agregar_prospecto");
//
//				permiso.setAgregarProspecto( (agregarProspecto == 0) ? false : true);
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
		
		return permiso;
	}


	@Override
	public List<PermisoTo> getByParameters(String parameter, String value)
			throws SQLException {
		
		this.conn = this.con.connect("jndi_crm");
		
		ResultSet rs = null;
		List<PermisoTo> lstPermisos = new ArrayList<PermisoTo>();
		this.sqlString = "SELECT id FROM Permisos WHERE " + parameter + " = ?";
		
		
		try{
			this.stmtSelect = this.conn.prepareStatement(this.sqlString);
			this.stmtSelect.setString(1, value);
			rs = this.stmtSelect.executeQuery();
			
			while (rs.next()){
				lstPermisos.add(this.getById(rs.getLong("id")));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
			if(rs != null){
				rs.close();
			}
			
			this.conn.close();
		}
		
		
		return lstPermisos;
	}


}
