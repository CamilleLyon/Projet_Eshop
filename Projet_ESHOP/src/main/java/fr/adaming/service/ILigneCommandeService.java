package fr.adaming.service;

import java.util.List;

import fr.adaming.model.LigneCommande;

public interface ILigneCommandeService {

	public void add(LigneCommande li);

	public List<LigneCommande> getAll();

	public void update(LigneCommande li);

	public void delete(Long id_li);

	public LigneCommande getById(Long id_li);
}
