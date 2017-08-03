package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitService {
	
	public void add(Produit p);

	public List<Produit> getAll();

	public Produit getByName(String name_p);

	public void update(Produit p);

	public void delete(Long id_p);

}
