package cl.prospect.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.jdbc.Statement;

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
		this.conn = this.con.connect("jndi_crm");
		
		ResultSet rs = null;
		EstadoTo estado = null;
		
		try{
			this.stmtSelect = this.conn.prepareStatement(this.sql.getString("SELECT_ESTADO_BY_ID"));
		
			this.stmtSelect.setLong(1, id);
		
			rs = this.stmtSelect.executeQuery();
			
			while (rs.next()){
				estado = new EstadoTo();
				
				estado.setId(rs.getLong("id"));
				estado.setNombre(rs.getString("nombre"));
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
		
		return estado;
	}

	@Override
	public List<EstadoTo> getAll() throws SQLException {
		
		this.conn = this.con.connect("jndi_crm");
		
		ResultSet rs = null;
		List<EstadoTo> lstEstados = new ArrayList<EstadoTo>();
		
		try{
			this.stmtSelect = this.conn.prepareStatement(this.sql.getString("SELECT_ESTADO_GET_ALL"));
		
			rs = this.stmtSelect.executeQuery();
			
			while (rs.next()){
				lstEstados.add(this.getById(rs.getLong("id")));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
			if(rs != null){
				rs.close();
			}
			
			this.conn.close();
		}
		
		return lstEstados;
	}

	@Override
	public List<EstadoTo> getByParameters(String parameter, String value)
			throws SQLException {
		
		this.conn = this.con.connect("jndi_crm");
		
		ResultSet rs = null;
		List<EstadoTo> lstEstados = new ArrayList<EstadoTo>();
		this.sqlString = "SELECT id FROM estados WHERE " + parameter + " = ?";
		
		
		try{
			this.stmtSelect = this.conn.prepareStatement(this.sqlString);
			this.stmtSelect.setString(1, value);
			rs = this.stmtSelect.executeQuery();
			
			while (rs.next()){
				lstEstados.add(this.getById(rs.getLong("id")));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
			if(rs != null){
				rs.close();
			}
			
			this.conn.close();
		}
		
		
		return lstEstados;
	}

	
	@Override
	public Long save(EstadoTo p) throws SQLException {

		this.conn = this.con.connect("jndi_crm");
		
		Long id = 0L;
		
		try {
			if(p.getId() == 0){
				this.stmtSelect = this.conn.prepareStatement(this.sql.getString("SELECT_ESTADO_GRABAR"), Statement.RETURN_GENERATED_KEYS);
				this.stmtSelect.setLong(1, p.getId());
				this.stmtSelect.setString(2, p.getNombre());
				
				this.stmtSelect.executeUpdate();
				
				ResultSet keys = this.stmtSelect.getGeneratedKeys();
				keys.next();
				id = keys.getLong(1);
				keys.close();
			}else{
				this.stmtSelect = this.conn.prepareStatement(this.sql.getString("SELECT_ESTADO_UPDATE"));
				this.stmtSelect.setString(1, p.getNombre());
				this.stmtSelect.setLong(2, p.getId());
				this.stmtSelect.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return id;
	}

}
