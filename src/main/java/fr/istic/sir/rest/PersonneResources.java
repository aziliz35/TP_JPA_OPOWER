package fr.istic.sir.rest;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.PersonDao;
import databaseHelper.DatabaseHelper;
import domain.Personne;

@Path("/humain")
public class PersonneResources {


	public PersonneResources() {
		DatabaseHelper.getInstance();
	}

	@GET
	@Path("/list")
    @Produces({MediaType.APPLICATION_JSON})
    public String listPerson(){
        PersonDao dao = new PersonDao();
        return dao.findAll().toString();
    }
	
	
	
	
	@POST
	@Path("/create")
	/*public Person addPerson(@FormParam("name") String name, 
    @FormParam("firstname") String firstname*/
	@Consumes(MediaType.APPLICATION_JSON)
	public Personne Postperson(Personne pers) {
		PersonDao p=new PersonDao();
		return p.create(pers);
		
	}
}

