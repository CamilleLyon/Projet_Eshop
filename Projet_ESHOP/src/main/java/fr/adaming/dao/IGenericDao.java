package fr.adaming.dao;

import java.util.List;

public interface IGenericDao<T> {

	public void add(T t);

	public void update(T t);

	public void delete(int t);

	public List<T> getAll();

	public T getByName(String t);

}
