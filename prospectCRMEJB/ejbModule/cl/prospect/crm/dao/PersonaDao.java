package cl.prospect.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import cl.prospect.crm.conexion.Conexion;
import cl.prospect.crm.dao.interfaces.IPersonaDao;
import cl.prospect.crm.to.PersonaTo;

import com.mysql.jdbc.Statement;

public class PersonaDao implements IPersonaDao{

	private static Conexion con = new Conexion();
	PreparedStatement stmtSelect = null;
	Connection conn = null;
	String sqlString = null;
	private ResourceBundle sql = null;
	
	@Override
	public PersonaTo getById(Long id) throws SQLException {
		this.conn = this.con.connect("jndi_crm");
		
		ResultSet rs = null;
		PersonaTo persona = null;
		
		try{
			this.stmtSelect = this.conn.prepareStatement(this.sql.getString("SELECT_PERSONA_BY_ID"));
		
			this.stmtSelect.setLong(1, id);
		
			rs = this.stmtSelect.executeQuery();
			
			while (rs.next()){
				persona = new PersonaTo();
				
				persona.setId(rs.getLong("id"));
				persona.setRut(rs.getInt("rut"));
				persona.setRutDv(rs.getString("rut_dv"));
				persona.setNombres(rs.getString("nombres"));
				persona.setApellidoMaterno(rs.getString("apellido_materno"));
				persona.setApellidoPaterno(rs.getString("apellido_paterno"));
				persona.setTelefono(rs.getInt("telefono"));
				persona.setCorreo(rs.getString("correo"));
				persona.setMovil(rs.getInt("movil"));
				
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
		
		return persona;
	}

	@Override
	public List<PersonaTo> getAll() throws SQLException {
		
		this.conn = this.con.connect("jndi_crm");
		
		ResultSet rs = null;
		List<PersonaTo> lstpersonas = new ArrayList<PersonaTo>();
		
		try{
			this.stmtSelect = this.conn.prepareStatement(this.sql.getString("SELECT_PERSONA_GET_ALL"));
		
			rs = this.stmtSelect.executeQuery();
			
			while (rs.next()){
				lstpersonas.add(this.getById(rs.getLong("id")));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
			if(rs != null){
				rs.close();
			}
			
			this.conn.close();
		}
		
		return lstpersonas;
	}

	@Override
	public List<PersonaTo> getByParameters(String parameter, String value)
			throws SQLException {
		
		this.conn = this.con.connect("jndi_crm");
		
		ResultSet rs = null;
		List<PersonaTo> lstpersonas = new ArrayList<PersonaTo>();
		this.sqlString = "SELECT id FROM personas WHERE " + parameter + " = ?";
		
		
		try{
			this.stmtSelect = this.conn.prepareStatement(this.sqlString);
			this.stmtSelect.setString(1, value);
			rs = this.stmtSelect.executeQuery();
			
			while (rs.next()){
				lstpersonas.add(this.getById(rs.getLong("id")));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
			if(rs != null){
				rs.close();
			}
			
			this.conn.close();
		}
		
		
		return lstpersonas;
	}

	
	@Override
	public Long save(PersonaTo p) throws SQLException {

		this.conn = this.con.connect("jndi_crm");
		
		Long id = 0L;
		
		try {
			if(p.getId() == 0){
				this.stmtSelect = this.conn.prepareStatement(this.sql.getString("SELECT_PERSONA_GRABAR"), Statement.RETURN_GENERATED_KEYS);
				this.stmtSelect.setString(2, p.getNombres());
				this.stmtSelect.setString(3, p.getApellidoPaterno());
				this.stmtSelect.setString(4, p.getApellidoMaterno());
				this.stmtSelect.setInt(5, p.getRut());
				this.stmtSelect.setString(6, p.getRutDv());
				this.stmtSelect.setLong(7, p.getTelefono());
				this.stmtSelect.setLong(8, p.getMovil());
				
				this.stmtSelect.executeUpdate();
				
				ResultSet keys = this.stmtSelect.getGeneratedKeys();
				keys.next();
				id = keys.getLong(1);
				keys.close();
			}else{
				this.stmtSelect = this.conn.prepareStatement(this.sql.getString("SELECT_PERSONA_UPDATE"));
				this.stmtSelect.setString(2, p.getNombres());
				this.stmtSelect.setString(3, p.getApellidoPaterno());
				this.stmtSelect.setString(4, p.getApellidoMaterno());
				this.stmtSelect.setInt(5, p.getRut());
				this.stmtSelect.setString(6, p.getRutDv());
				this.stmtSelect.setLong(7, p.getTelefono());
				this.stmtSelect.setLong(8, p.getMovil());
				this.stmtSelect.setLong(9, p.getId());
				this.stmtSelect.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return id;
	}

}
