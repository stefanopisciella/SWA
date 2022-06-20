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
import jakarta.ws.rs.container.ContainerRequestContext;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.univaq.swa.sdv.sdvrest.model.*;

@Path("progetti")
public class ProgettiResource {
        
    /**
     * OP 7 - GET[BASE]/progetti
     * Metodo per l'estrazione di tutti i progetti nel sistema,
     * con filtri opzionali su nome e skills (massimo 2)
     * @param uriinfo
     * @param nome
     * @param s1
     * @param s2
     * @param from
     * @param to
     * @return
     * @throws RESTWebApplicationException 
     */
    @GET
    @Produces("application/json")
    public Response getAll(
            @Context UriInfo uriinfo,
            @QueryParam("nomeProgetto") String nome,
            @QueryParam("skill1") String s1,
            @QueryParam("skill2") String s2,
            @QueryParam("from") Integer from,
            @QueryParam("to") Integer to) throws RESTWebApplicationException {
        
        if (from == null) {
            from = 1;
        }
        if (to == null) {
            to = 10; 
        }
        if (from > to) { 
            int swap = from;
            from = to;
            to = swap;
        }     
        
        List<Map<String, Object>> listaProgetti = new ArrayList();
        //per i che va da from a to creo oggetti di tipo Progetto
        for (int i = from; i <= to; i++) {
            Progetto p = Progetto.dummyProgetto("p" + i, "d" + i);
            // il progetto p non ha task, quindi p.getTask torna una lista vuota a cui aggiungo un task i  
            List<Task> listaTask = p.getTasks(); 
            Task t = Task.dummyTask("task" + i);
            // il task t non ha skill, quindi t.getSkill torna una lista vuota a cui aggiungo
            // la skill1 se i è minore o uguale a 5, la skill2 se i è maggiore
            if (i <= 5) {
                t.getSkills().add(Skill.dummySkills("skill1"));
            } else {
                t.getSkills().add(Skill.dummySkills("skill2"));
            }
            listaTask.add(t);
            Map<String, Object> progetto = new HashMap<>();
            progetto.put("nome", p.getNome());
            progetto.put("descrizione", p.getDescrizione());
     
        // creazione url per vedere il dettaglio
            URI uri = uriinfo.getBaseUriBuilder()
                    .path(getClass())
                    .path(getClass(), "getProject")
                    .build(i);
            progetto.put("url", uri.toString());
            listaProgetti.add(progetto);
                
        }
                
        ArrayList<Map<String, Object>> res = new ArrayList<>();
               
        if (s1 != null && s2 != null) {
            throw new RESTWebApplicationException(404, "progetto inesistente");
        } else if (s1 == null && s2 == null) {
            res = new ArrayList<>(listaProgetti);
        }
        
        if (s1 != null && s1.equals("skill1")) {
            for (int i = from; i <= 5; i++) {
                res.add(listaProgetti.get(i - from));
            }
        } 
        
        if (s2 != null && s2.equals("skill2")) {
            if (from <= 5) {
                for (int i = 6; i <= to; i++) {
                    res.add(listaProgetti.get(i - from));
                }
            } else {
                for (int i = from; i <= to; i++) {
                    res.add(listaProgetti.get(i - from));
                }
            }
        }
        
        if (nome != null) {
            // vedo se il nome NON contiene il nome che passo come query param,
            // in caso affermativo (non lo contiene), lo rimuovo da res
            Iterator<Map<String, Object>> itr = res.iterator();
            while (itr.hasNext()) {
                Map<String, Object> temp = itr.next();
                for (Map.Entry<String, Object> entry : temp.entrySet()) {
                    if (entry.getKey().equals("nome")) {
                        String name = (String)entry.getValue();
                        if (!name.contains(nome)) {
                            itr.remove();
                        }
                    }
                }
            }   
        }
        if (res.isEmpty()) {
             throw new RESTWebApplicationException(404, "progetto inesistente");
        }     
        return Response.ok(res).build();
    }
    
    /***
     * OP 8 - POST [BASE]/progetti
     * Metodo per l'inserimento di un nuovo progetto nel sistema
     * @param uriinfo
     * @param p
     * @param req
     * @return
     * @throws RESTWebApplicationException 
     */
    @Logged
    @POST
    @Consumes("application/json")
    public Response addProject(@Context UriInfo uriinfo,
            Progetto p, @Context ContainerRequestContext req) throws RESTWebApplicationException {

        //creo il nuovo utente e progetto
        UtenteMinimale coordinatore = new UtenteMinimale();
        coordinatore.setId((Integer)req.getProperty("id"));
        coordinatore.setNome("Beatrice");
        coordinatore.setCognome("Tomassi");
        coordinatore.setEmail("beatom@gmail.com");
        
        Progetto nuovoProg = new Progetto();
        nuovoProg.setNome(p.getNome());
        nuovoProg.setDescrizione(p.getDescrizione());
        nuovoProg.setCoordinatore(coordinatore);
        nuovoProg.setId(20);
        
        System.out.println(nuovoProg);
        
        URI uri = uriinfo.getBaseUriBuilder()
                .path(getClass())
                .path(getClass(), "getProject")
                .build(nuovoProg.getId());

        return Response.created(uri).build();
    }
    
    /**
     * Estensione del path per gestire le operazioni su singolo progetto
     * @param id
     * @return 
     */
    @Path("{id: [1-9]+}")
    public ProgettoResource getProject(@PathParam("id") int id) {
        
        Progetto p = null;
        
        if (id > 2) throw new RESTWebApplicationException(404, "progetto inesistente");
        
        if (id == 1) {
            p = new Progetto();
            p.setId(id);
            p.setNome("p1");
            p.setDescrizione("Progetto p1");
        }
        
        if (id == 2) {
            p = new Progetto();
            p.setId(id);
            p.setNome("p2");
            p.setDescrizione("Progetto p2");
        }
        return new ProgettoResource(p);
    }
    
}
