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
import jakarta.ws.rs.WebApplicationException;
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
        
        /*if (p.getTasks().isEmpty()) {
            // istanzio qualche oggetto Task di prova
        
            // per farlo, istanzio qualche oggetto utente, di prova
            // u1 partecipa al task del progetto p1
            Utente u1 = new Utente();
            u1.setNome("Adbul");
            u1.setCognome("Murat");
            u1.setEmail("amurat@mail.com");
            u1.setUsername("a_mur");

            // u2, u3 e u4 partecipano ai tasks del progetto p2
            Utente u2 = new Utente();
            u2.setNome("Claire");
            u2.setCognome("Benway");
            u2.setEmail("clben@mail.com");
            u2.setUsername("claire_ben_1");
            // 3 e 4 partecipano ai tasks del progetto p2
            Utente u3 = new Utente();
            u1.setNome("Florence");
            u1.setCognome("Gore");
            u1.setEmail("flogo@mail.com");
            u1.setUsername("gflo");
            Utente u4 = new Utente();
            u1.setNome("Hanna");
            u1.setCognome("Diaz");
            u1.setEmail("hannadiaz@mail.com");
            u1.setUsername("hdiaz778");

            // lista per collaboratori task1
            ArrayList<Utente> l1 = new ArrayList<>();        
            // task relativi al progetto p1
            Task t1 = new Task();
            t1.setAttivo(true);
            t1.setNome("task 1 (progetto p1)");
            t1.setDescrizione("descrizione per il task 1");
            l1.add(u1);
            t1.setCollaboratori(l1);

            if (p.getId() == 1) {
                p.getTasks().add(t1);
            }

            // task relativi al progetto p2

            ArrayList<Utente> l2 = new ArrayList<>();
            Task t2 = new Task();
            t2.setAttivo(false);
            t2.setNome("task 2 (progetto p2)");
            t2.setDescrizione("descrizione per il task 2");
            l2.add(u2);
            l2.add(u3);
            l2.add(u4);        
            t2.setCollaboratori(l2);

            ArrayList<Utente> l3 = new ArrayList<>();
            Task t3 = new Task();
            t3.setAttivo(true);
            t3.setNome("task 3 (progetto p2)");
            t3.setDescrizione("descrizione per il task 3");
            l3.add(u3);
            l3.add(u4);
            t3.setCollaboratori(l3);

            if (p.getId() == 2) {
                p.getTasks().add(t2);
                p.getTasks().add(t3);
            }
        }
        
        return Response.ok(p.getTasks()).build();*/
        return Response.ok().build();
    }
    
    /**
     * OP 11 - GET [BASE]/progetti/id/tasks/id/collaboratori
     * @param riga
     * @return 
     */
    @GET
    @Path("{id: [1-9]+}/collaboratori")
    @Produces("application/json")
    public Response getCollabs(@PathParam("id") int idTask) throws WebApplicationException {
        
        /*if (p.getTasks().isEmpty()) {
            // istanzio qualche oggetto Task di prova
        
            // per farlo, istanzio qualche oggetto utente, di prova
            // u1 partecipa al task del progetto p1
            Utente u1 = new Utente();
            u1.setNome("Adbul");
            u1.setCognome("Murat");
            u1.setEmail("amurat@mail.com");
            u1.setUsername("a_mur");

            // u2, u3 e u4 partecipano ai tasks del progetto p2
            Utente u2 = new Utente();
            u2.setNome("Claire");
            u2.setCognome("Benway");
            u2.setEmail("clben@mail.com");
            u2.setUsername("claire_ben_1");
            // 3 e 4 partecipano ai tasks del progetto p2
            Utente u3 = new Utente();
            u1.setNome("Florence");
            u1.setCognome("Gore");
            u1.setEmail("flogo@mail.com");
            u1.setUsername("gflo");
            Utente u4 = new Utente();
            u1.setNome("Hanna");
            u1.setCognome("Diaz");
            u1.setEmail("hannadiaz@mail.com");
            u1.setUsername("hdiaz778");

            // lista per collaboratori task1
            ArrayList<Utente> l1 = new ArrayList<>();        
            // task relativi al progetto p1
            Task t1 = new Task();
            t1.setAttivo(true);
            t1.setNome("task 1 (progetto p1)");
            t1.setDescrizione("descrizione per il task 1");
            l1.add(u1);
            t1.setCollaboratori(l1);

            if (p.getId() == 1) {
                p.getTasks().add(t1);
            }

            // task relativi al progetto p2

            ArrayList<Utente> l2 = new ArrayList<>();
            Task t2 = new Task();
            t2.setAttivo(false);
            t2.setNome("task 2 (progetto p2)");
            t2.setDescrizione("descrizione per il task 2");
            l2.add(u2);
            l2.add(u3);
            l2.add(u4);        
            t2.setCollaboratori(l2);

            ArrayList<Utente> l3 = new ArrayList<>();
            Task t3 = new Task();
            t3.setAttivo(true);
            t3.setNome("task 3 (progetto p2)");
            t3.setDescrizione("descrizione per il task 3");
            l3.add(u3);
            l3.add(u4);
            t3.setCollaboratori(l3);

            if (p.getId() == 2) {
                p.getTasks().add(t2);
                p.getTasks().add(t3);
            }
            
            if (idTask == 1) {
                if (p.getId() == 2) return Response.serverError().build();
                return Response.ok(p.getTasks().get(p.getTasks().indexOf(t1))).build();
            }
            if (idTask == 2) {
                if (p.getId() == 1) return Response.serverError().build();
                return Response.ok(p.getTasks().get(p.getTasks().indexOf(t2))).build();
            }
            if (idTask == 3) {
                if (p.getId() == 1) return Response.serverError().build();
                return Response.ok(p.getTasks().get(p.getTasks().indexOf(t3))).build();
            }
        }
        
        else{
            if (idTask == 1) {
                if (p.getId() == 2) return Response.serverError().build();
                return Response.ok(p.getTasks().get(p.getTasks().indexOf(t1))).build();
            }
            if (idTask == 2) {
                if (p.getId() == 1) return Response.serverError().build();
                return Response.ok(p.getTasks().get(p.getTasks().indexOf(t2))).build();
            }
            if (idTask == 3) {
                if (p.getId() == 1) return Response.serverError().build();
                return Response.ok(p.getTasks().get(p.getTasks().indexOf(t3))).build();
            }
        }*/
        return Response.ok().build();
    }
    
}
