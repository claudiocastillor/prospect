package cl.prospect.crm.dao.interfaces;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import cl.prospect.crm.to.ColegioTo;

public interface IColegioDao extends Serializable {

	public ColegioTo getById(Long id) throws SQLException;
	public List<ColegioTo> getAll() throws SQLException;
	public List<ColegioTo> getByParameters(String parameter,String value) throws SQLException;
	public Long save(ColegioTo colegio) throws SQLException;
	
}
