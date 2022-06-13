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

public class TasksResource {
    
    private Progetto p;
    
    public TasksResource(Progetto p) {
        this.p = p;
    }
    
    /**
     * OP 10 - GET[BASE]/progetti/id/tasks
     * @return 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() throws RESTWebApplicationException {

        List<String> l = new ArrayList();
        
        /**
         * riempire lista con oggetti 'tasks' e ritornarla
         */

        return Response.ok(l).build();
    }
    
    /**
     * OP 11 - GET [BASE]/progetti/id/tasks/id/collaboratori
     * @param riga
     * @return 
     */
    @GET
    @Path("{id: [1-9]+}/collaboratori")
    @Produces("application/json")
    public Response getCollabs(@PathParam("id") int riga) {
        
        // cerca nel DB il task di ID= id
        // ritorna gli utenti associati a quel task
        return Response.ok().build();
    }
    
}
