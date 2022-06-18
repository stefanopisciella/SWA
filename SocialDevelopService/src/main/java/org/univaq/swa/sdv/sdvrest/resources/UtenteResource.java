package org.univaq.swa.sdv.sdvrest.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;
import org.univaq.swa.sdv.sdvrest.RESTWebApplicationException;
import org.univaq.swa.sdv.sdvrest.security.Logged;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PUT;
import java.util.HashMap;
import java.util.Map;
import org.univaq.swa.sdv.sdvrest.data.UtenteManager;
import org.univaq.swa.sdv.sdvrest.model.*;


public class UtenteResource {
    
    private final Utente u;
    
    UtenteResource(Utente u) {
        this.u = u;
    }
    
    /***
     * OP 4 - GET [BASE]/utenti/id/dettaglio
     * @return 
     */
    @Path("dettaglio")
    @GET
    @Produces("application/json")
    public Response getUserDetail() {
        try {
            List<Skill> skills = new ArrayList<Skill>(); 
            skills.add(Skill.dummySkills("Programmazione Java Sockets"));
            skills.add(Skill.dummySkills(("programmazione in C")));
            
            Utente utente = Utente.dummyUtente(u.getId(), "Stefano", "Pisciella", "stefano@gmail.com", "3880581680", "stefano", "stefano", skills);
            
            return Response.ok(utente).build();
        } catch (Exception e) {
            throw new RESTWebApplicationException(e);
        }
    }
    
    /***
     * OP 5 - PUT [BASE]/utenti/id
     * @param utente_nuovo
     * @return 
     */
    @Logged
    @PUT
    @Consumes("application/json")
    public Response updateUser(Utente utente_nuovo) {
        
        u.setNome(utente_nuovo.getNome());
        u.setCognome(utente_nuovo.getCognome());
        u.setEmail(utente_nuovo.getEmail());
        u.setUsername(utente_nuovo.getUsername());
        u.setPassword(utente_nuovo.getPassword());
        u.setTelefono(utente_nuovo.getTelefono());     
        u.setSkills(utente_nuovo.getSkills());    

        return Response.noContent().build();
    }
    
    /***
     * OP 6 - DELETE [BASE]/utenti/id
     * @return 
     */
    @Logged
    @DELETE
    public Response deleteUser() {
        
        // rimuovo dalla lista di utenti del sistema l'utente u se l'ID esiste
        if(u.getId() > 0) {
            System.out.println(u);
            UtenteManager.utenti.remove(u);  
        }
        
        return Response.noContent().build();
    }
    
    /***
     * OP 12 - GET [BASE]/utenti/id/progetti
     * @return 
     */
    @Path("progetti")
    @GET
    @Produces("application/json")
    public Response getProjects() {
        
        if (u.getId() == 4) throw new RESTWebApplicationException(404, "utente non trovato");
        
        ArrayList<ProgettoUtente> res = new ArrayList<>();
        
        for (int i = 1; i <= 3; i++){
            
            UtenteMinimale uM = new UtenteMinimale();
            uM.setNome("Nome " + i);
            uM.setCognome("Cognome " + i);
            uM.setEmail("coord" + i + "@mail.com");
            
            Progetto p = new Progetto();
            p.setNome("progetto " + i + " utente " + u.getId());
            p.setDescrizione("descrizione progetto" + i + " utente " + u.getId());
            p.setCoordinatore(uM);
            
            ProgettoUtente pU = new ProgettoUtente();
            pU.setProgetto(p);
            pU.setValutazione(10 - (i + 2));
            res.add(pU);
        }
        
        return Response.ok(res).build();
    }
    
}