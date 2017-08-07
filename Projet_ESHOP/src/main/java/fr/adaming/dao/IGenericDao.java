package fr.adaming.dao;

import java.util.List;

/**
 * Interface G�n�rique de DAO pour le CRUD
 * 
 * @author Projet Camille
 *
 * @param <T>
 *            - Classe utilis�e dans la m�thode
 */

public interface IGenericDao<T> {

	/**
	 * M�thode g�n�rique pour ajouter
	 * 
	 * @param t
	 *            - ajout d'une entit� compl�te
	 */
	public void add(T t);

	/**
	 * M�thode g�n�rique pour modifier
	 * 
	 * @param t
	 *            - modification d'une entit� compl�te
	 */
	public void update(T t);

	/**
	 * M�thode g�n�rique pour modifier
	 * 
	 * @param id_cl
	 *            - suppression par l'id id_cl
	 */
	public void delete(Long id_cl);

	/**
	 * M�thode g�n�rique pour afficher une liste d'entit�s
	 * 
	 * @return la liste
	 */
	public List<T> getAll();

	/**
	 * M�thode g�n�rique de recherche par nom
	 * 
	 * @param name_t
	 *            - le nom utilis� pour la recherche
	 * @return l'entit� recherch�e
	 */
	public T getByName(String name_t);

	/**
	 * M�thode g�n�rique de recherche par id
	 * 
	 * @param id_cl
	 *            - id utilis� pour la recherche
	 * @return l'entit� recherch�e
	 */
	public T getById(Long id_cl);

}
