package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Commande;

public interface ICommandeService {

	public void add(Commande co);

	public List<Commande> getAll();

	public void update(Commande co);

	public void delete(Long id_co);

	public Commande getById(Long id_co);
}
