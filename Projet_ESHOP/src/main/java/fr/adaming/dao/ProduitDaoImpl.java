package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Produit;

@Repository
public class ProduitDaoImpl implements IGenericDao<Produit> {

	@Autowired
	private SessionFactory sf;

	// pour l'injection de dépendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void add(Produit p) {
		// ouvrir une session (bus qui véhicule les données vers la Db)
				Session s = sf.getCurrentSession();

				// ajouter le client dans le context Hibernate
				s.save(p);
			}

	@Override
	public void update(Produit p) {
		// ouvrir une session (bus qui véhicule les données vers la Db)
				Session s = sf.getCurrentSession();

				// modifier le client dans le context Hibernate
				s.saveOrUpdate(p);
			}

	@Override
	public void delete(Long id_p) {
		// ouvrir une session (bus qui véhicule les données vers la Db)
				Session s = sf.getCurrentSession();

				// modifier l'employé dans le context Hibernate
				s.delete(s.get(Produit.class, id_p));
			}

	@Override
	public List<Produit> getAll() {
		// ouverture de la session
				Session s = sf.getCurrentSession();

				// requete HQL
				String req = "FROM Produit";

				Query query = s.createQuery(req);

				// envoie de la requète et récupération du résultat
				@SuppressWarnings("unchecked")
				List<Produit> liste = query.list();

				return liste;
			}

	@Override
	public Produit getByName(String name_p) {
		Session s = sf.getCurrentSession();

		// requete HQL
		String req = "FROM Produit as c WHERE c.designation=:pNom";

		Query query = s.createQuery(req);

		query.setParameter("pNom", name_p);

		Produit produit_rec = (Produit) query.uniqueResult();

		return produit_rec;

	}
	@Override
	public Produit getById(Long id_cl) {
		// TODO Auto-generated method stub
		return null;
	}

}
