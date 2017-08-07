package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenericDao;
import fr.adaming.model.Panier;

@Service("panierServiceBean")
@Transactional
public class PanierServiceImpl implements IPanierService {

	@Autowired
	private IGenericDao<Panier> paDao;

	public void setPaDao(IGenericDao<Panier> paDao) {
		this.paDao = paDao;
	}

	@Override
	public void add(Panier pa) {
		paDao.add(pa);

	}

	@Override
	public void update(Panier pa) {
		paDao.update(pa);

	}

	@Override
	public void delete(Long id_pa) {
		paDao.delete(id_pa);

	}

	@Override
	public Panier getById(Long id_pa) {
		
		return paDao.getById(id_pa);
	}

	@Override
	public List<Panier> getAll() {
		
		return paDao.getAll();
	}

}
