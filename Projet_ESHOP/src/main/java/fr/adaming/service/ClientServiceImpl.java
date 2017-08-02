package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IEmployeDao;
import fr.adaming.dao.IGenericDao;
import fr.adaming.model.Client;

@Service("ClientServiceBean") // l'annotation pour la définition d'un bean de
// service spécifique à
// Spring IoC
@Transactional // annotation pour spécifier que la méthode est transactionnelle.
// On peut la mettre sur la classe pour que toutes les méthodes
// le soit !!
public class ClientServiceImpl implements IClientService {

	// transformation de l'association UML en Java
	@Autowired // annotation pour l'injection de dépendance
	private IGenericDao<Client> clDao;

	// pour l'injeciton par modificateur
	public void setClDao(IGenericDao<Client> clDao) {
		this.clDao = clDao;
	}

	@Override
	public void addClient(Client cl) {
		// appel de la méthode de DAO
				clDao.add(cl);

			}

	@Override
	public List<Client> getAllClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getClientByName(int id_cl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateClient(Client cl) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteClient(int id_cl) {
		// TODO Auto-generated method stub

	}

}
