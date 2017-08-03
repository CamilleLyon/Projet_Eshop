package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;

@Repository
public class CategorieDaoImpl implements IGenericDao<Categorie> {

	@Autowired
	private SessionFactory sf;

	// pour l'injection de dépendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void add(Categorie ca) {
		// ouvrir une session (bus qui véhicule les données vers la Db)
		Session s = sf.getCurrentSession();

		// ajouter le client dans le context Hibernate
		s.save(ca);
	}

	@Override
	public void update(Categorie ca) {
		// ouvrir une session (bus qui véhicule les données vers la Db)
		Session s = sf.getCurrentSession();

		// modifier le client dans le context Hibernate
		s.saveOrUpdate(ca);
	}

	@Override
	public void delete(Long id_ca) {
		// ouvrir une session (bus qui véhicule les données vers la Db)
		Session s = sf.getCurrentSession();

		// modifier l'employé dans le context Hibernate
		s.delete(s.get(Categorie.class, id_ca));
	}

	@Override
	public List<Categorie> getAll() {
		// ouverture de la session
		Session s = sf.getCurrentSession();

		// requete HQL
		String req = "FROM Categorie";

		Query query = s.createQuery(req);

		// envoie de la requète et récupération du résultat
		@SuppressWarnings("unchecked")
		List<Categorie> liste = query.list();

		return liste;
	}

	@Override
	public Categorie getByName(String name_ca) {
		Session s = sf.getCurrentSession();

		// requete HQL
		String req = "FROM Categorie as c WHERE c.nomCategorie=:pNom";

		Query query = s.createQuery(req);

		query.setParameter("pNom", name_ca);

		Categorie categorie_rec = (Categorie) query.uniqueResult();

		return categorie_rec;

	}

	@Override
	public Categorie getById(Long id_ca) {
		// TODO Auto-generated method stub
		return null;
	}

}
