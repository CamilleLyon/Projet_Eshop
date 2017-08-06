package fr.adaming.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Produit;

@Repository
public class PanierDaoImpl implements IPanierDao<Produit> {

	@Autowired
	private SessionFactory sf;

	// pour l'injection de dépendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public boolean add(Produit o) {
		try {
			// ouvrir une session (bus qui véhicule les données vers la Db)
			Session s = sf.getCurrentSession();

			// ajouter le client dans le context Hibernate
			s.save(o);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Produit o) {
		try {
			// ouvrir une session (bus qui véhicule les données vers la Db)
			Session s = sf.getCurrentSession();

			// modifier le client dans le context Hibernate
			s.saveOrUpdate(o);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Produit o) {
		try {
			// ouvrir une session (bus qui véhicule les données vers la Db)
			Session s = sf.getCurrentSession();

			// modifier l'employé dans le context Hibernate
			s.delete(o);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Produit> getAll() {
		// ouvrir une session (bus qui véhicule les données vers la Db)
		Session s = sf.getCurrentSession();
		// requete HQL
		String req = "FROM Produit";

		Query query = s.createQuery(req);

		// envoie de la requète et récupération du résultat
		@SuppressWarnings("unchecked")
		List<Produit> listeProduits = query.list();

		return listeProduits;
	}

	@Override
	public Produit getById(int id) {

		// ouvrir une session (bus qui véhicule les données vers la Db)
		Session s = sf.getCurrentSession();
		Produit produit = (Produit) s.get(Produit.class, id);

		return produit;
	}

}
