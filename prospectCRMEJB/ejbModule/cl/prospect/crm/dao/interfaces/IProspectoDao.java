package cl.prospect.crm.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import cl.prospect.crm.to.ProspectoTo;

public interface IProspectoDao {

	public ProspectoTo getById(Long id) throws SQLException;
	public List<ProspectoTo> getAll() throws SQLException;
	public List<ProspectoTo> getByParameters(String parameter,String value) throws SQLException;
	public Long save(ProspectoTo p) throws SQLException;
}
