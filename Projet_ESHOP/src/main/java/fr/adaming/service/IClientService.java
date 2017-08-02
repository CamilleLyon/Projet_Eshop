package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {

	public void add(Client cl);

	public List<Client> getAll();

	public Client getByName(String name_cl);

	public void update(Client cl);

	public void delete(int id_cl);
}
