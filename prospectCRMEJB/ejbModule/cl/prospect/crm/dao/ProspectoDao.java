package cl.prospect.crm.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.jdbc.Statement;

import cl.prospect.crm.conexion.Conexion;
import cl.prospect.crm.dao.interfaces.IColegioDao;
import cl.prospect.crm.dao.interfaces.IDireccionDao;
import cl.prospect.crm.dao.interfaces.IProspectoDao;
import cl.prospect.crm.to.ColegioTo;
import cl.prospect.crm.to.DireccionTo;
import cl.prospect.crm.to.ProspectoTo;

public class ProspectoDao implements IProspectoDao {

	private static Conexion con = new Conexion();
	PreparedStatement stmtSelect = null;
	Connection conn = null;
	String sqlString = null;
	private ResourceBundle sql = null;

	IColegioDao icolegioDao;
	IDireccionDao idireccionDao;
	
	SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
//	para ser usada en los métodos con fecha tipo Date
//	String fecha = (prospecto.getFecha() != null) ? formatoEntrada.format(prospecto.getFecha()) : null;
	
	@Override
	public ProspectoTo getById(Long id) throws SQLException {
		this.conn = this.con.connect("jndi_crm");

		ResultSet rs = null;
		ProspectoTo prospecto = null;

		try {
			this.stmtSelect = this.conn.prepareStatement(this.sql
					.getString("SELECT_PROSPECTO_BY_ID"));

			this.stmtSelect.setLong(1, id);

			rs = this.stmtSelect.executeQuery();

			while (rs.next()) {
				prospecto = new ProspectoTo();

				prospecto.setId(rs.getLong("id"));
				prospecto.setRut(rs.getInt("rut"));
				prospecto.setRutDv(rs.getString("rut_dv"));
				prospecto.setNombres(rs.getString("nombres"));
				prospecto.setApellidoMaterno(rs.getString("apellido_materno"));
				prospecto.setApellidoPaterno(rs.getString("apellido_paterno"));
				prospecto.setSexo(rs.getString("sexo"));//cambiar dato en base de datos a string
				prospecto.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
				prospecto.setNacionalidad(rs.getString("nacionalidad"));
				prospecto.setEstadoCivil(rs.getString("estado_civil"));
				prospecto.setTipoSalud(rs.getDouble("tipo_salud"));
				Long idColegio = (long) rs.getDouble("id_colegio");
				
				
				ColegioTo colegio = new ColegioTo();
				colegio = this.icolegioDao.getById(idColegio);
				
				prospecto.setColegio(colegio);
				
				prospecto.setAnioEgresoMedia(rs.getInt("anio_egreso_media"));
				prospecto.setDocumentado(rs.getString("documentado"));
				prospecto.setFechaModificacion(rs.getDate("fecha_modificacion"));
				prospecto.setMatriculado(rs.getBoolean("matriculado"));
				prospecto.setMatriculaFecha(rs.getDate("matricula_fecha"));
				prospecto.setMatriculaAnio(rs.getInt("matricula_anio"));
				prospecto.setFechaRegistro(rs.getDate("fecha_registro"));
				
				DireccionTo direccion = new DireccionTo();
				direccion = this.idireccionDao.getById(direccion.getId());
				
				prospecto.setDireccion(direccion);
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				rs.close();
			}

			this.stmtSelect.close();
			this.conn.close();
		}

		return prospecto;
	}

	@Override
	public List<ProspectoTo> getAll() throws SQLException {
		this.conn = this.con.connect("jndi_crm");

		ResultSet rs = null;
		List<ProspectoTo> lstprospectos = new ArrayList<ProspectoTo>();

		try {
			this.stmtSelect = this.conn.prepareStatement(this.sql
					.getString("SELECT_PROSPECTO_GET_ALL"));

			rs = this.stmtSelect.executeQuery();

			while (rs.next()) {
				lstprospectos.add(this.getById(rs.getLong("id")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				rs.close();
			}

			this.conn.close();
		}

		return lstprospectos;
	}

	@Override
	public List<ProspectoTo> getByParameters(String parameter, String value)
			throws SQLException {
		this.conn = this.con.connect("jndi_crm");

		ResultSet rs = null;
		List<ProspectoTo> lstprospectos = new ArrayList<ProspectoTo>();
		this.sqlString = "SELECT id FROM prospectos WHERE " + parameter
				+ " = ?";

		try {
			this.stmtSelect = this.conn.prepareStatement(this.sqlString);
			this.stmtSelect.setString(1, value);
			rs = this.stmtSelect.executeQuery();

			while (rs.next()) {
				lstprospectos.add(this.getById(rs.getLong("id")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				rs.close();
			}

			this.conn.close();
		}

		return lstprospectos;
	}

	@Override
	public Long save(ProspectoTo prospecto) throws SQLException {
		this.conn = this.con.connect("jndi_crm");

		Long id = 0L;

		try {
			if (prospecto.getId() == 0) {
				this.stmtSelect = this.conn.prepareStatement(
						this.sql.getString("SELECT_PROSPECTO_GRABAR"),
						Statement.RETURN_GENERATED_KEYS);
				this.stmtSelect.setInt(1, prospecto.getRut());
				this.stmtSelect.setString(2, prospecto.getRutDv());
				this.stmtSelect.setString(3, prospecto.getNombres());
				this.stmtSelect.setString(4, prospecto.getApellidoPaterno());
				this.stmtSelect.setString(5, prospecto.getApellidoMaterno());
				this.stmtSelect.setString(6, prospecto.getSexo());
				this.stmtSelect.setDate(7, prospecto.getFechaNacimiento());
				this.stmtSelect.setString(8, prospecto.getNacionalidad());
				this.stmtSelect.setString(9, prospecto.getEstadoCivil());
				this.stmtSelect.setDouble(10, prospecto.getTipoSalud());
				this.stmtSelect.setString(11, prospecto.getColegio().getId());
				this.stmtSelect.setInt(12, prospecto.getAnioEgresoMedia());
				this.stmtSelect.setString(13, prospecto.getDocumentado());
				this.stmtSelect.setDate(14, prospecto.getFechaModificacion());
				this.stmtSelect.setBoolean(15, prospecto.isMatriculado());
				this.stmtSelect.setDate(16, prospecto.getMatriculaFecha());
				this.stmtSelect.setInt(17, prospecto.getMatriculaAnio());
				this.stmtSelect.setDate(18, prospecto.getFechaRegistro());
				this.stmtSelect.setLong(19, prospecto.getDireccion().getId());

				this.stmtSelect.executeUpdate();

				ResultSet keys = this.stmtSelect.getGeneratedKeys();
				keys.next();
				id = keys.getLong(1);
				keys.close();
			} else {
				this.stmtSelect = this.conn.prepareStatement(this.sql
						.getString("SELECT_PROSPECTO_UPDATE"));

				this.stmtSelect.setLong(19, prospecto.getId());
				this.stmtSelect.setInt(1, prospecto.getRut());
				this.stmtSelect.setString(2, prospecto.getRutDv());
				this.stmtSelect.setString(3, prospecto.getNombres());
				this.stmtSelect.setString(4, prospecto.getApellidoPaterno());
				this.stmtSelect.setString(5, prospecto.getApellidoMaterno());
				this.stmtSelect.setString(6, prospecto.getSexo());
				this.stmtSelect.setDate(7, prospecto.getFechaNacimiento());
				this.stmtSelect.setString(8, prospecto.getNacionalidad());
				this.stmtSelect.setString(9, prospecto.getEstadoCivil());
				this.stmtSelect.setDouble(10, prospecto.getTipoSalud());
				this.stmtSelect.setString(11, prospecto.getColegio().getId());
				this.stmtSelect.setInt(12, prospecto.getAnioEgresoMedia());
				this.stmtSelect.setString(13, prospecto.getDocumentado());
				this.stmtSelect.setDate(14, prospecto.getFechaModificacion());
				this.stmtSelect.setBoolean(15, prospecto.isMatriculado());
				this.stmtSelect.setDate(16, prospecto.getMatriculaFecha());
				this.stmtSelect.setInt(17, prospecto.getMatriculaAnio());
				this.stmtSelect.setDate(18, prospecto.getFechaRegistro());
				this.stmtSelect.setLong(19, prospecto.getDireccion().getId());
				
				this.stmtSelect.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return id;
	}

}
