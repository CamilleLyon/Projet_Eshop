package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;

@Repository
public class LigneCommandeDaoImpl implements IGenericDao<LigneCommande>{

	@Autowired
	private SessionFactory sf;

	// pour l'injection de dépendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void add(LigneCommande li) {
		// ouvrir une session (bus qui véhicule les données vers la Db)
				Session s = sf.getCurrentSession();

				// ajouter le client dans le context Hibernate
				s.save(li);
			}

	@Override
	public void update(LigneCommande li) {
		// ouvrir une session (bus qui véhicule les données vers la Db)
				Session s = sf.getCurrentSession();

				// modifier le client dans le context Hibernate
				s.saveOrUpdate(li);
			}

	@Override
	public void delete(Long id_li) {
		// ouvrir une session (bus qui véhicule les données vers la Db)
				Session s = sf.getCurrentSession();

				// modifier l'employé dans le context Hibernate
				s.delete(s.get(Commande.class, id_li));
			}

	@Override
	public List<LigneCommande> getAll() {
		// ouverture de la session
				Session s = sf.getCurrentSession();

				// requete HQL
				String req = "FROM LigneCommande";

				Query query = s.createQuery(req);

				// envoie de la requète et récupération du résultat
				@SuppressWarnings("unchecked")
				List<LigneCommande> liste = query.list();

				return liste;
			}

	@Override
	public LigneCommande getByName(String name_t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LigneCommande getById(Long id_li) {
		Session s = sf.getCurrentSession();

		return (LigneCommande) s.get(LigneCommande.class, id_li);

	}

}
