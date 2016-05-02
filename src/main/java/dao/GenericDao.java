package dao;

import java.util.Collection;

public interface GenericDao<T> {
	T create(T entity);
    T delete(Object id);
    T find(Object id);
    T update(T entity);
    Collection<T> findAll();
}