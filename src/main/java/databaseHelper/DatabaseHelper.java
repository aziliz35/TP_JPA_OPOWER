package databaseHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseHelper {
	
	private static EntityManagerFactory emf;
    private static javax.persistence.EntityManager em;
    private static String persistence_unit_name = "dev";
	
    public DatabaseHelper(){
    	emf = Persistence.createEntityManagerFactory(persistence_unit_name);
        em = emf.createEntityManager();
	}
	
	/*public static void getInstance(){
		
	}*/
    
    public static void setPersistenceUnitName(String persistence_unit_name){
    	DatabaseHelper.persistence_unit_name = persistence_unit_name;
    }
    
    public static String getPersistenceUnitName(){
        return DatabaseHelper.persistence_unit_name;
    }
    
    public static synchronized javax.persistence.EntityManager getInstance(){
        if(em == null)
            new DatabaseHelper();
        return em;
    }
    
    public static void close(){
        em.close();
        emf.close();
    }
}