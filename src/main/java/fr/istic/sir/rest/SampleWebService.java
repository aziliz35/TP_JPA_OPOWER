package fr.istic.sir.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.PersonDao;
import domain.Chauffage;
import domain.EquipementE;
import domain.Personne;
import domain.Residence;
import servlet.data;

@Path("/hello")
public class SampleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }
    
    
    
    @GET
    @Path("/home")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Residence> getHome() {
    	Residence h = new Residence();
        h.setNomh("toto");
        Chauffage h1 = new Chauffage();
        h1.setConso(500);
        EquipementE h2 = new EquipementE();
        h2.setConso(600);
        h.addDevice(h1);
        h.addDevice(h2);
        Collection<Residence> r = new ArrayList<Residence>();
        r.add(h);
        return r;
    }
    
    @GET
    @Path("/Personne")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Personne> getPersonne() {
    	Personne p = new Personne();
        p.setNom("MELLALI");
        p.setPrenom("Ismail");
        p.setEmail("ismail@mail.com");
        
        Collection<Personne> pers = new ArrayList<Personne>();
        pers.add(p);
        return pers;
    }

    @GET
    @Path("/listePersonne")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personne> getListPerson() {
    
    	List<Personne> personnes = data.ListePersonne();
	    return personnes;
    }
}
