package cl.prospect.crm.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import cl.prospect.crm.to.UsuarioTo;

public interface IUsuarioDao {

	public UsuarioTo getById(Long id) throws SQLException;
	public List<UsuarioTo> getAll() throws SQLException;
	public List<UsuarioTo> getByParameters(String parameter,String value) throws SQLException;
	public Long save(UsuarioTo p) throws SQLException;
}
