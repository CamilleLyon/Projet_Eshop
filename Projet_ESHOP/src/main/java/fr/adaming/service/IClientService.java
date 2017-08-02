package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {

	public void addClient(Client cl);

	public List<Client> getAllClient();

	public Client getClientByName(int id_cl);

	public void updateClient(Client cl);

	public void deleteClient(int id_cl);
}
