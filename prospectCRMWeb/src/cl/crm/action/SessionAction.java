package cl.crm.action;

import com.opensymphony.xwork2.ActionSupport;

public class SessionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3273639402580764648L;
	private String error;
	private String info;
	private String exito;
	private String res;
	
	
	public String index(){
		this.setRes("../login.jsp");
		return SUCCESS;
	}
	
	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public String getExito() {
		return exito;
	}


	public void setExito(String exito) {
		this.exito = exito;
	}


	public String getRes() {
		return res;
	}


	public void setRes(String res) {
		this.res = res;
	}
}
