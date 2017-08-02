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
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int idCl) {
		// TODO Auto-generated method stub

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

		return (Client) s.get(Client.class, name_cl);

	}

}
