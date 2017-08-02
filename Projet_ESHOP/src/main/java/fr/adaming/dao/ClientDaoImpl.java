package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IGenericDao<Client> {

	@Autowired
	private SessionFactory sf;

	// pour l'injection de dépendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void add(Client cl) {
		// ouvrir une session (bus qui véhicule les données vers la Db)
		Session s = sf.getCurrentSession();

		// ajouter le client dans le context Hibernate
		s.save(cl);
	}

	@Override
	public void update(Client cl) {
		// ouvrir une session (bus qui véhicule les données vers la Db)
		Session s = sf.getCurrentSession();

		// modifier le client dans le context Hibernate
		s.saveOrUpdate(cl);
	}

	@Override
	public void delete(Long id_cl) {
		// ouvrir une session (bus qui véhicule les données vers la Db)
		Session s = sf.getCurrentSession();

		// modifier l'employé dans le context Hibernate
		s.delete(s.get(Client.class, id_cl));
	}

	@Override
	public List<Client> getAll() {
		// ouverture de la session
		Session s = sf.getCurrentSession();

		// requete HQL
		String req = "FROM Client";

		Query query = s.createQuery(req);

		// envoie de la requète et récupération du résultat
		@SuppressWarnings("unchecked")
		List<Client> liste = query.list();

		return liste;
	}

	@Override
	public Client getByName(String name_cl) {
		Session s = sf.getCurrentSession();

		// requete HQL
		String req = "FROM Client as c WHERE c.nomClient=:pNom";

		Query query = s.createQuery(req);

		query.setParameter("pNom", name_cl);

		Client client_rec = (Client) query.uniqueResult();

		return client_rec;

	}

	@Override
	public Client getById(Long id_cl) {
		// TODO Auto-generated method stub
		return null;
	}
}
