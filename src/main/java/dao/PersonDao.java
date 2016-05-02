package dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import databaseHelper.DatabaseHelper;
import domain.Personne;

public class PersonDao implements GenericDao<Personne> {

	private EntityManager em;
	private EntityTransaction et;

	public PersonDao() {
		super();
		em = DatabaseHelper.getInstance();
		et = em.getTransaction();
	}

	public Personne create(Personne person) {
		if(person != null);
		{
			et.begin();
			em.persist(person);
			et.commit();
		}
		return person;
	}

	public Personne delete(Object id) {
		Personne p = em.getReference(Personne.class, id);
		if(p != null)
		{
			et.begin();
			em.remove(p);
			et.commit();
		}
		return p;
	}

	public Personne find(Object id) {  
		return (Personne)(em.find(Personne.class, id));
	}

	public Personne update(Personne entity) {
		if(entity != null)
		{
			et.begin();
			em.merge(entity);
			et.commit();
		}
		return entity;
	}

	public List<Personne> findAll() {
		CriteriaBuilder criteria = em.getCriteriaBuilder();
		CriteriaQuery<Personne> query = criteria.createQuery(Personne.class);
		Root<Personne> pers = query.from(Personne.class);
		CriteriaQuery<Personne> q = query.select(pers);
		return em.createQuery(q).getResultList();
	}
}