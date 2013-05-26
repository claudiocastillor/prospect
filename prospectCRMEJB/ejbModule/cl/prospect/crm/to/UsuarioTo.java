package cl.prospect.crm.to;

public class UsuarioTo {
	private long id;
	private String nombre;
	private String clave;
	private RolTo rol;
	private EstadoTo estado;
	private PersonaTo persona;
	private SedeTo sede;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public RolTo getRol() {
		return rol;
	}

	public void setRol(RolTo rol) {
		this.rol = rol;
	}

	public EstadoTo getEstado() {
		return estado;
	}

	public void setEstado(EstadoTo estado) {
		this.estado = estado;
	}

	public PersonaTo getPersona() {
		return persona;
	}

	public void setPersona(PersonaTo persona) {
		this.persona = persona;
	}

	public SedeTo getSede() {
		return sede;
	}

	public void setSede(SedeTo sede) {
		this.sede = sede;
	}

}
