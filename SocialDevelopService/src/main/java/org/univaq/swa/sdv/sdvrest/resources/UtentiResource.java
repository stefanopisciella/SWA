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
import java.net.URI;
import org.univaq.swa.sdv.sdvrest.data.UtenteManager;
import org.univaq.swa.sdv.sdvrest.model.*;

@Path("utenti")
public class UtentiResource {
    
    /**
     * OP 2 - GET [BASE]/utenti
     * Metodo per l'estrazione della lista di utenti noti al sistema,
     * con filtro opzionale sulle skills (2 skill al massimo).
     * @param s1    skill 1
     * @param s2    skill 2
     * @param from  from (paginazione)
     * @param to    to (paginazione)
     * @return
     * @throws RESTWebApplicationException
     */
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(
            @QueryParam("skill1") Integer s1,
            @QueryParam("skill2") Integer s2,
            @QueryParam("from") Integer from,
            @QueryParam("to") Integer to) throws RESTWebApplicationException {

        // controllo dei valori assegnati ai parametri FROM e TO
        if (from == null) {
            from = 1;
        }
        if (to == null) {
            to = 9;
        }
        if (from > to) {
            int swap = from;
            from = to;
            to = swap;
        }
        
        UtenteManager.initilizeDataMinimale();
        List<UtenteMinimale> u = UtenteManager.utentiMinimali;
        return Response.ok(u).build();
    }
    
    /**
     * OP 3 - POST [BASE]/utenti
     * Metodo per l'inserimento di un nuovo utente nel sistema
     * @param uriinfo
     * @param u
     * @return
     * @throws RESTWebApplicationException 
     */
    @Logged
    @POST
    @Consumes("application/json")
    public Response addUser(
            @Context UriInfo uriinfo,
            Utente u) throws RESTWebApplicationException {

        Utente utente = Utente.dummyUtente(u.getId(), u.getNome(), u.getCognome(), u.getEmail(), u.getTelefono(), u.getUsername(), u.getPassword(), null);
        UtenteManager.utenti.add(utente);
        
        // costruzione della URL di risposta per l'utente appena inserito
        URI uri = uriinfo.getBaseUriBuilder()
            .path(getClass())
            .path(getClass(), "getUser")
            .build(utente.getId());
        
        return Response.created(uri).build();

    }
    
    
    
    /**
     * Estensione del path per gestire le operazioni su singolo utente
     * @param id
     * @return 
     */
    @Path("{id: [1-9][0-9]*}")
    public UtenteResource getUser(
            @PathParam("id") Integer idUtente
    ) {
        
        Utente u = new Utente();
        u.setId(idUtente);
        return new UtenteResource(u);
    }
    
}
