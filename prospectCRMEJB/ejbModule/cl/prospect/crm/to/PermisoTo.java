package cl.prospect.crm.to;

import java.io.Serializable;

public class PermisoTo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private boolean agregarProspecto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isAgregarProspecto() {
		return agregarProspecto;
	}

	public void setAgregarProspecto(boolean agregarProspecto) {
		this.agregarProspecto = agregarProspecto;
	}

}
