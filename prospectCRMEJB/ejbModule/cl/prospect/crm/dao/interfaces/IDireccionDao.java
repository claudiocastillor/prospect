package cl.prospect.crm.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import cl.prospect.crm.to.DireccionTo;

public interface IDireccionDao {

	public DireccionTo getById(Long id) throws SQLException;
	public List<DireccionTo> getAll() throws SQLException;
	public List<DireccionTo> getByParameters(String parameter,String value) throws SQLException;
	public Long save(DireccionTo direccion) throws SQLException;
}
