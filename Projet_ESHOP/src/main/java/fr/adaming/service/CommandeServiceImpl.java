package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenericDao;
import fr.adaming.model.Commande;

@Service("commandeServiceBean")
@Transactional
public class CommandeServiceImpl implements ICommandeService {

	@Autowired
	private IGenericDao<Commande> coDao;

	public void setCoDao(IGenericDao<Commande> coDao) {
		this.coDao = coDao;
	}

	@Override
	public void add(Commande co) {
		coDao.add(co);

	}

	@Override
	public List<Commande> getAll() {

		return coDao.getAll();
	}

	@Override
	public void update(Commande co) {
		coDao.update(co);

	}

	@Override
	public void delete(Long id_co) {

		coDao.delete(id_co);

	}

	@Override
	public Commande getById(Long id_co) {
		
		return coDao.getById(id_co);
	}

}
