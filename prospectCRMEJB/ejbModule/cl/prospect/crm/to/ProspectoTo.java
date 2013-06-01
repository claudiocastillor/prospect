package cl.prospect.crm.to;

import java.io.Serializable;
import java.util.Date;

public class ProspectoTo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private int rut;
	private int rutDv;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;

	public enum sexo {
		M, F
	};

	private String fecha_nacimiento;
	private String nacionalidad;
	private String estadoCivil;
	private double tipoSalud;
	private double idColegio;
	private int anioEgresoMedia;
	private String documentado;
	private Date fechaModificacion;
	private boolean matriculado;
	private Date matriculaFecha;
	private int matriculaAnio;
	private Date fecha_registro;

	// private DireccionTo direccion;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public int getRutDv() {
		return rutDv;
	}

	public void setRutDv(int rutDv) {
		this.rutDv = rutDv;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public double getTipoSalud() {
		return tipoSalud;
	}

	public void setTipoSalud(double tipoSalud) {
		this.tipoSalud = tipoSalud;
	}

	public double getIdColegio() {
		return idColegio;
	}

	public void setIdColegio(double idColegio) {
		this.idColegio = idColegio;
	}

	public int getAnioEgresoMedia() {
		return anioEgresoMedia;
	}

	public void setAnioEgresoMedia(int anioEgresoMedia) {
		this.anioEgresoMedia = anioEgresoMedia;
	}

	public String getDocumentado() {
		return documentado;
	}

	public void setDocumentado(String documentado) {
		this.documentado = documentado;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public boolean isMatriculado() {
		return matriculado;
	}

	public void setMatriculado(boolean matriculado) {
		this.matriculado = matriculado;
	}

	public Date getMatriculaFecha() {
		return matriculaFecha;
	}

	public void setMatriculaFecha(Date matriculaFecha) {
		this.matriculaFecha = matriculaFecha;
	}

	public int getMatriculaAnio() {
		return matriculaAnio;
	}

	public void setMatriculaAnio(int matriculaAnio) {
		this.matriculaAnio = matriculaAnio;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

}
