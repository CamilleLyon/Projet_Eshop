package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Panier;

/**
 * Implémentations IGeneric DAO pour Panier
 * 
 * @author Projet Camille
 * 
 */
@Repository
public class PanierDaoImpl implements IGenericDao<Panier> {

	@Autowired
	private SessionFactory sf;

	// pour l'injection de dépendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void add(Panier pa) {
		Session s = sf.getCurrentSession();

		s.save(pa);
	}

	@Override
	public void update(Panier pa) {
		Session s = sf.getCurrentSession();

		s.saveOrUpdate(pa);
	}

	@Override
	public void delete(Long id_pa) {
		Session s = sf.getCurrentSession();

		// modifier l'employé dans le context Hibernate
		s.delete(s.get(Panier.class, id_pa));

	}

	@Override
	public List<Panier> getAll() {
		Session s = sf.getCurrentSession();

		// requete HQL
		String req = "FROM Panier";

		Query query = s.createQuery(req);

		// envoie de la requète et récupération du résultat
		@SuppressWarnings("unchecked")
		List<Panier> liste = query.list();

		return liste;
	}

	@Override
	public Panier getByName(String name_t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Panier getById(Long id_pa) {

		Session s = sf.getCurrentSession();

		return (Panier) s.get(Panier.class, id_pa);

	}

}
