package fr.adaming.dao;

import java.util.List;

public interface IGenericDao<T> {

	public void add(T t);

	public void update(T t);

	public void delete(Long id_cl);

	public List<T> getAll();

	public T getByName(String name_t);

}
