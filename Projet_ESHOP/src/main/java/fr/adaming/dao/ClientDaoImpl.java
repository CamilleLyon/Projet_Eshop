package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository // l'annotation pour la d�finition d'un bean de DAO de Spring IoC
public class ClientDaoImpl  implements IGenericDao<Client>{

	// attribut sessionFactory
		@Autowired // pour l'injection du bean sessionFactory. Elle est sp�cifique �
					// SPRING
		private SessionFactory sf;

		// pour l'injection de d�pendance
		public void setSf(SessionFactory sf) {
			this.sf = sf;
		}
	@Override
	public void add(Client cl) {
		// ouvrir une session (bus qui v�hicule les donn�es vers la Db)
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

				// envoie de la requ�te et r�cup�ration du r�sultat
				@SuppressWarnings("unchecked")
				List<Client> liste = query.list();

				return liste;
	}

	@Override
	public Client getByName(String cl) {
		Session s = sf.getCurrentSession();

		return (Client) s.get(Client.class, cl);

	}

}
