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
import java.net.URI;
import org.univaq.swa.sdv.sdvrest.model.*;

/**
 *
 * @author nicola
 */
@Path("progetti")
public class ProgettiResource {
    
    /**
     * OP 7 - GET[BASE]/progetti
     * Metodo per l'estrazione di tutti i progetti nel sistema,
     * con filtri opzionali su nome e skills (massimo 2)
     * @param nome
     * @param s1
     * @param s2
     * @param from
     * @param to
     * @return
     * @throws RESTWebApplicationException 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(
            @QueryParam("nome") String nome,
            @QueryParam("skill1") String s1,
            @QueryParam("skill2") String s2,
            @QueryParam("from") String from,
            @QueryParam("to") String to) throws RESTWebApplicationException {

        List<String> l = new ArrayList();
        
        /**
         * riempire lista con oggetti 'progetti' e ritornarla
         */

        return Response.ok(l).build();
    }
    
    /***
     * OP 8 - POST [BASE]/progetti
     * Metodo per l'inserimento di un nuovo progetto nel sistema
     * @param uriinfo
     * @param p
     * @return
     * @throws RESTWebApplicationException 
     */
    @Logged
    @POST
    @Consumes("application/json")
    public Response addProject(
            @Context UriInfo uriinfo,
            Progetto p) throws RESTWebApplicationException {

        /*
        Inserimento nuovo progetto nel sistema
        */
        
        /*
        Costruzione della URL di risposta per il progetto appena inserito
        */
        
        // TODO: da sistemare la costruzione della URL!!
        URI uri = uriinfo.getBaseUriBuilder()
                .path(getClass())
                .path(getClass(), "getItem")
                .build(f.getData().get(Calendar.YEAR), f.getNumero());
        
        return Response.created(uri).build();
    }
    
    /**
     * Estensione del path per gestire le operazioni su singolo progetto
     * @param id
     * @return 
     */
    @Path("{id: [1-9]+}")
    public UtenteResource getProject(
            @PathParam("id") int id
    ) {
        
        /**
         * estrazione del progetto con ID=id dal DB
         */
        
        // TODO: sistemare!!
        Progetto p = ...;
        return new ProgettoResource(p);
        
        /*if (anno >= 2020) {
            //...prelevare la fattura f dal sistema...
            Fattura f = Fattura.dummyFattura(numero, anno);
            return new UtenteResource(f);
        } else {
            //throw new RESTWebApplicationException(404, "Fattura non trovata");
            return null; //ritornare null da un metodo che restituisce una sotto-risorsa equivale a un 404
        }*/
    }
    
}
