package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Employe;

@Repository
public class CommandeDaoImpl implements IGenericDao<Commande>{

	@Autowired
	private SessionFactory sf;

	// pour l'injection de dépendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	
	@Override
	public void add(Commande co) {
		// ouvrir une session (bus qui véhicule les données vers la Db)
				Session s = sf.getCurrentSession();

				// ajouter le client dans le context Hibernate
				s.save(co);
			}

	@Override
	public void update(Commande co) {
		// ouvrir une session (bus qui véhicule les données vers la Db)
				Session s = sf.getCurrentSession();

				// modifier le client dans le context Hibernate
				s.saveOrUpdate(co);
			}

	@Override
	public void delete(Long id_co) {
		// ouvrir une session (bus qui véhicule les données vers la Db)
				Session s = sf.getCurrentSession();

				// modifier l'employé dans le context Hibernate
				s.delete(s.get(Client.class, id_co));
			}

	@Override
	public List<Commande> getAll() {
		// ouverture de la session
				Session s = sf.getCurrentSession();

				// requete HQL
				String req = "FROM Commande";

				Query query = s.createQuery(req);

				// envoie de la requète et récupération du résultat
				@SuppressWarnings("unchecked")
				List<Commande> liste = query.list();

				return liste;
			}

	@Override
	public Commande getByName(String name_co) {

		return null;

	}


	@Override
	public Commande getById(Long id_co) {
		Session s = sf.getCurrentSession();

		return (Commande) s.get(Commande.class, id_co);

	}
}
