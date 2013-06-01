package cl.prospect.crm.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import cl.prospect.crm.to.RolTo;

public interface IRolDao {

	public RolTo getById(Long id) throws SQLException;
	public List<RolTo> getAll() throws SQLException;
	public List<RolTo> getByParameters(String parameter,String value) throws SQLException;
	public Long save(RolTo p) throws SQLException;
}
