package cl.prospect.crm.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import cl.prospect.crm.to.PermisoTo;

public interface IPermisoDao {

	public PermisoTo getById(Long id) throws SQLException;
	public List<PermisoTo> getByParameters(String parameter,String value) throws SQLException;
	
}
