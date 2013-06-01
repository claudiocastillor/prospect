package cl.prospect.crm.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import cl.prospect.crm.to.EstadoTo;

public interface IEstadoDao {

	public EstadoTo getById(Long id) throws SQLException;
	public List<EstadoTo> getAll() throws SQLException;
	public List<EstadoTo> getByParameters(String parameter,String value) throws SQLException;
	public Long save(EstadoTo p) throws SQLException;
	
}
