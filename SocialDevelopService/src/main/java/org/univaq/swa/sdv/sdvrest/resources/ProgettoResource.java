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
import org.univaq.swa.sdv.sdvrest.model.*;

public class ProgettoResource {
    
    private final Progetto p;
    
    public ProgettoResource(Progetto p){
        this.p = p;
    }
    
    /**
     * OP 9 - GET [BASE]/progetti/id/dettaglio
     * @return 
     */
    @Path("dettaglio")
    @GET
    @Produces("application/json")
    public Response getProject() {
        
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
     * OP 10 - GET[BASE]/progetti/id/tasks
     * @return 
     * estensione del path e fattorizzazione con classe TasksResource
     */
    @Path("tasks")
    public TasksResource getTasks() {
        
        /*
        estrazione dei task associati al progetto dal DB
        */
        
        // TODO: costruzione risposta
        //return Response.ok(pIVA).build();
        Progetto p = new Progetto();
        return new TasksResource(p);
    }
    
    /***
     * OP 13 - GET [BASE]/progetti/id/messaggi
     * @return 
     */
    @Path("messaggi")
    public MessaggiResource getMessages() {
        
        /*
        estrazione dei messaggi associati al progetto dal DB
        */
        
        // TODO: costruzione risposta
        //return Response.ok(pIVA).build();
        return new MessaggiResource();
    }
    
}
