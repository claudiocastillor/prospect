package cl.prospect.crm.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import cl.prospect.crm.to.PersonaTo;

public interface IPersonaDao {

	public PersonaTo getById(Long id) throws SQLException;
	public List<PersonaTo> getAll() throws SQLException;
	public List<PersonaTo> getByParameters(String parameter,String value) throws SQLException;
	public Long save(PersonaTo p) throws SQLException;
}
