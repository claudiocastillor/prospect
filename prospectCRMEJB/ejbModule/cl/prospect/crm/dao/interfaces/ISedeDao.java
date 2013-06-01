package cl.prospect.crm.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import cl.prospect.crm.to.SedeTo;

public interface ISedeDao {

	public SedeTo getById(Long id) throws SQLException;
	public List<SedeTo> getAll() throws SQLException;
	public List<SedeTo> getByParameters(String parameter,String value) throws SQLException;
	public Long save(SedeTo p) throws SQLException;
}
