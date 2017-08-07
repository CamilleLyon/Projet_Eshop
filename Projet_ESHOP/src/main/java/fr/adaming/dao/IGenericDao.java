package fr.adaming.dao;

import java.util.List;

/**
 * Interface Générique de DAO pour le CRUD
 * 
 * @author Projet Camille
 *
 * @param <T>
 *            - Classe utilisée dans la méthode
 */

public interface IGenericDao<T> {

	/**
	 * Méthode générique pour ajouter
	 * 
	 * @param t
	 *            - ajout d'une entité complète
	 */
	public void add(T t);

	/**
	 * Méthode générique pour modifier
	 * 
	 * @param t
	 *            - modification d'une entité complète
	 */
	public void update(T t);

	/**
	 * Méthode générique pour modifier
	 * 
	 * @param id_cl
	 *            - suppression par l'id id_cl
	 */
	public void delete(Long id_cl);

	/**
	 * Méthode générique pour afficher une liste d'entités
	 * 
	 * @return la liste
	 */
	public List<T> getAll();

	/**
	 * Méthode générique de recherche par nom
	 * 
	 * @param name_t
	 *            - le nom utilisé pour la recherche
	 * @return l'entité recherchée
	 */
	public T getByName(String name_t);

	/**
	 * Méthode générique de recherche par id
	 * 
	 * @param id_cl
	 *            - id utilisé pour la recherche
	 * @return l'entité recherchée
	 */
	public T getById(Long id_cl);

}
