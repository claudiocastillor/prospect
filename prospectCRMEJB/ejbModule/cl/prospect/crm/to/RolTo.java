package cl.prospect.crm.to;

import java.io.Serializable;

public class RolTo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String nombre;
	private PermisoTo permiso;

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

	public PermisoTo getPermiso() {
		return permiso;
	}

	public void setPermiso(PermisoTo permiso) {
		this.permiso = permiso;
	}

}
