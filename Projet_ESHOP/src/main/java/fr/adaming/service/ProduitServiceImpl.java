package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenericDao;
import fr.adaming.model.Produit;

@Service("produitServiceBean")
@Transactional
public class ProduitServiceImpl implements IProduitService {

	@Autowired
	private IGenericDao<Produit> pDao;

	public void setpDao(IGenericDao<Produit> pDao) {
		this.pDao = pDao;
	}

	@Override
	public void add(Produit p) {

		pDao.add(p);

	}

	@Override
	public List<Produit> getAll() {

		return pDao.getAll();
	}

	@Override
	public Produit getByName(String name_p) {

		return pDao.getByName(name_p);
	}

	@Override
	public void update(Produit p) {

		pDao.update(p);

	}

	@Override
	public void delete(Long id_p) {

		pDao.delete(id_p);

	}

}
