package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenericDao;
import fr.adaming.model.LigneCommande;

@Service("ligneCommandeServiceBean")
@Transactional
public class LigneCommandeServiceImpl implements ILigneCommandeService {

	@Autowired
	private IGenericDao<LigneCommande> liDao;

	public void setLiDao(IGenericDao<LigneCommande> liDao) {
		this.liDao = liDao;
	}

	@Override
	public void add(LigneCommande li) {
		liDao.add(li);

	}

	@Override
	public List<LigneCommande> getAll() {

		return liDao.getAll();
	}

	@Override
	public void update(LigneCommande li) {
		liDao.update(li);

	}

	@Override
	public void delete(Long id_li) {

		liDao.delete(id_li);

	}

	@Override
	public LigneCommande getById(Long id_li) {

		return liDao.getById(id_li);
	}

}
