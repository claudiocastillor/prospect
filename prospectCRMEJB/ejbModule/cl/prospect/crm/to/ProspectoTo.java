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
	private String rutDv;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String sexo;

//	public enum sexo {
//		M, F
//	};

	private Date fechaNacimiento;
	private String nacionalidad;
	private String estadoCivil;
	private double tipoSalud;
	private ColegioTo colegio;
	private int anioEgresoMedia;
	private String documentado;
	private Date fechaModificacion;
	private boolean matriculado;
	private Date matriculaFecha;
	private int matriculaAnio;
	private Date fechaRegistro;
	private DireccionTo direccion;

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

	public String getRutDv() {
		return rutDv;
	}

	public void setRutDv(String rutDv) {
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public ColegioTo getColegio() {
		return colegio;
	}

	public void setColegio(ColegioTo colegio) {
		this.colegio = colegio;
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

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fecha_registro) {
		this.fechaRegistro = fecha_registro;
	}

}
