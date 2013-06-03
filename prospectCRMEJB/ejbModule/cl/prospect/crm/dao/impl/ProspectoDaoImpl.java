package cl.prospect.crm.dao.impl;

import java.sql.SQLException;
import java.util.List;

import cl.prospect.crm.dao.interfaces.IProspectoDao;
import cl.prospect.crm.to.ProspectoTo;

public class ProspectoDaoImpl implements IProspectoDao{

	IProspectoDao iprospectoDao;
	
	@Override
	public ProspectoTo getById(Long id) throws SQLException {
		return this.iprospectoDao.getById(id);
	}

	@Override
	public List<ProspectoTo> getAll() throws SQLException {
		return this.iprospectoDao.getAll();
	}

	@Override
	public List<ProspectoTo> getByParameters(String parameter, String value)
			throws SQLException {
		return this.getByParameters(parameter, value);
	}

	@Override
	public Long save(ProspectoTo p) throws SQLException {
		return this.iprospectoDao.save(p);
	}

}
