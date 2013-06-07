package cl.prospect.crm.dao.impl;

import java.sql.SQLException;
import java.util.List;

import cl.prospect.crm.dao.interfaces.IColegioDao;
import cl.prospect.crm.to.ColegioTo;

public class ColegioDaoImpl implements IColegioDao {

	IColegioDao icolegioDao;
	
	@Override
	public ColegioTo getById(Long id) throws SQLException {
		return this.icolegioDao.getById(id);
	}

	@Override
	public List<ColegioTo> getAll() throws SQLException {
		return this.icolegioDao.getAll();
	}

	@Override
	public List<ColegioTo> getByParameters(String parameter, String value)
			throws SQLException {
		return this.icolegioDao.getByParameters(parameter, value);
	}

	@Override
	public Long save(ColegioTo colegio) throws SQLException {
		return this.icolegioDao.save(colegio);
	}

}
