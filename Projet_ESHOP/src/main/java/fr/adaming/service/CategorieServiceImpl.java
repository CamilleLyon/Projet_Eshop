package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenericDao;
import fr.adaming.model.Categorie;

@Service("categorieServiceBean")
@Transactional
public class CategorieServiceImpl implements ICategorieService{
	
	@Autowired
	private IGenericDao<Categorie> caDao;
	
	

	public void setCaDao(IGenericDao<Categorie> caDao) {
		this.caDao = caDao;
	}

	@Override
	public void add(Categorie ca) {

caDao.add(ca);
		
	}

	@Override
	public List<Categorie> getAll() {
		
		return caDao.getAll();
	}

	@Override
	public Categorie getByName(String name_ca) {
		
		return caDao.getByName(name_ca);
	}

	@Override
	public void update(Categorie ca) {

caDao.update(ca);
		
	}

	@Override
	public void delete(Long id_ca) {
		
		caDao.delete(id_ca);
	}

}
