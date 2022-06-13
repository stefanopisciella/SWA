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
import org.univaq.swa.sdv.sdvrest.model.*;


public class UtenteResource {
    
    // OPPURE UTENTE MINIMALE? NON POSSO TORNARE LA SUA PASSWORD
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
        
        /*
        estrae l'utente dal DB (ma non capisco come prendere l'ID)
        */
        
        /*try {
            return Response.ok(f)
                    //possiamo aggiungere alla Response vari elementi, ad esempio header...
                    .header("X-fattura-app-version", "1.0")
                    .build();
        } catch (Exception e) {
            //gestione delle eccezioni (business):
            //Modalità 1: creazione response di errore
//            return Response.serverError()
//                    .entity(e.getMessage()) //mai in produzione
//                    .build();
            //Modalità 2: incapsulamento in eccezione JAXRS compatibile
            throw new RESTWebApplicationException(e);
        }*/
    }
    
    /***
     * OP 5 - PUT [BASE]/utenti/id
     * @param u
     * @return 
     */
    @Logged
    @PUT
    @Consumes("application/json")
    public Response updateUser(Utente u) {
        
        /*
        aggiornamento dati dell'utente  con l'input u
        */
        
        return Response.noContent().build();
    }
    
    /***
     * OP 6 - DELETE [BASE]/utenti/id
     * @return 
     */
    @Logged
    @DELETE
    @Produces("application/json")
    public Response deleteUser() {
        
        /*
        eliminazione utente
        */
        
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
        
        /*
        estrazione dei progetti ai quali l'utente con ID=id lavora/ha lavorato
        */
        
        // TODO: costruzione risposta
        //return Response.ok(pIVA).build();
    }
}
