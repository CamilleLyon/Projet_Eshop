package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenericDao;
import fr.adaming.model.Client;

@Service("clientServiceBean")
@Transactional 
public class ClientServiceImpl implements IClientService {

	
	@Autowired 
	private IGenericDao<Client> clDao;

	
	public void setClDao(IGenericDao<Client> clDao) {
		this.clDao = clDao;
	}

	@Override
	public void add(Client cl) {
		clDao.add(cl);

	}

	@Override
	public List<Client> getAll() {

		return clDao.getAll();
	}

	@Override
	public Client getByName(String name_cl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Client cl) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id_cl) {
		// TODO Auto-generated method stub

	}

}
