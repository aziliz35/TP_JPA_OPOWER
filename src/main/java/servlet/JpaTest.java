package servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.BasicConfigurator;


import domain.Personne;

public class JpaTest {

	/**
	 * @param args
	 */
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private static EntityManager manager = factory.createEntityManager();
	private static EntityTransaction tx = manager.getTransaction();
	
	public static void main(String[] args) {
		BasicConfigurator.configure();
		
		HttpServletRequest request = null;
		
		
		tx.begin();
		try {	
			Personne p = new Personne("Martin");
			manager.persist(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		
		
		
		
//		System.err.println(((java.util.List) res).size());
//		System.err.println((res.get(0)).getNom());
		
		manager.close();
		factory.close();
	}
	
	public List<Personne> getPerson(){
		String s = "SELECT e FROM Personne as e where e.nom=:name";
		Query q = (Query) manager.createQuery(s,Personne.class);
		((TypedQuery<Personne>) q).setParameter("name", "Martin"); 
		List<Personne> res =   q.getResultList();	
		return res;
	}

}
