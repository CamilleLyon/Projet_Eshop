package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IPanierDao;
import fr.adaming.model.Produit;

@Service("panierServiceBean")
@Transactional
public class PanierServiceImpl implements IPanierService<Produit> {

	@Autowired
	private IPanierDao<Produit> paDao;

	
	public void setPaDao(IPanierDao<Produit> paDao) {
		this.paDao = paDao;
	}

	@Override
	public boolean add(Produit o) {
		paDao.add(o);
		return false;
	}

	@Override
	public boolean update(Produit o) {
		paDao.update(o);
		return false;
	}

	@Override
	public boolean delete(Produit o) {
		paDao.delete(o);
		return false;
	}

	@Override
	public List<Produit> getAll() {
		
		return paDao.getAll();
	}

	@Override
	public Produit getById(int id) {
		
		return paDao.getById(id);
	}

}
