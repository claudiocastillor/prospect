package cl.prospect.crm.to;

import java.io.Serializable;

public class DireccionTo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String calle;
	private String numero;
	private ComunaTo comuna;
	private RegionTo region;
	private PaisTo pais;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public ComunaTo getComuna() {
		return comuna;
	}

	public void setComuna(ComunaTo comuna) {
		this.comuna = comuna;
	}

	public RegionTo getRegion() {
		return region;
	}

	public void setRegion(RegionTo region) {
		this.region = region;
	}

	public PaisTo getPais() {
		return pais;
	}

	public void setPais(PaisTo pais) {
		this.pais = pais;
	}

}
