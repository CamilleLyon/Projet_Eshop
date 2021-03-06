package fr.adaming.service;

/**
 * Interface pour les m�thodes Service de Client, m�mes m�thodes que DAO
 */
import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {

	public void add(Client cl);

	public List<Client> getAll();

	public Client getByName(String name_cl);

	public void update(Client cl);

	public void delete(Long id_cl);
}
