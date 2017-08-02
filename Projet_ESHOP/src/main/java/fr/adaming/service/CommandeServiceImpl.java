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
		// TODO Auto-generated method stub

	}

	@Override
	public List<Commande> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande getByName(String name_co) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Commande co) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id_co) {
		// TODO Auto-generated method stub

	}

}
