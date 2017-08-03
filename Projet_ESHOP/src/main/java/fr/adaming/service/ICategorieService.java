package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieService {

	public void add(Categorie ca);

	public List<Categorie> getAll();

	public Categorie getByName(String name_ca);

	public void update(Categorie ca);

	public void delete(Long id_ca);

}
