package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Commande;

public interface ICommandeService {

	public void add(Commande co);

	public List<Commande> getAll();

	public Commande getByName(String name_co);

	public void update(Commande co);

	public void delete(Long id_co);
}
