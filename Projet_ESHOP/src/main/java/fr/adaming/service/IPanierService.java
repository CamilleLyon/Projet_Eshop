package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Panier;

public interface IPanierService {

	public void add(Panier pa);

	public List<Panier> getAll();

	public void update(Panier pa);

	public void delete(Long id_pa);

	public Panier getById(Long id_pa);
}
