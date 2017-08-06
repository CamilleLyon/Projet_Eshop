package fr.adaming.dao;

import java.util.List;

public interface IPanierDao<T> {

	public boolean add(T o);

    public boolean update(T o);

    public boolean delete(T o);

    public List<T> getAll();

    public T getById(int id);

}
