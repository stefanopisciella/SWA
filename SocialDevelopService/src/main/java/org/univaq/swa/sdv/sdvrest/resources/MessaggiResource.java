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
import java.time.*;
import java.time.format.DateTimeFormatter;
import org.univaq.swa.sdv.sdvrest.data.MessaggioManager;

public class MessaggiResource {
    
    private final Progetto p;
    private int from, to;
    private LocalDate dataInizio, dataFine;
    
    public MessaggiResource(Progetto p, int from, int to, String dI, String dF){
        this.p = p;
        this.from = from;
        this.to = to;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (dI != null) dataInizio = LocalDate.parse(dI, formatter);
        if (dF != null) dataFine = LocalDate.parse(dF, formatter);
    }
    
    /***
     * OP 13 - [BASE]/progetti/id/messaggi
     * @param idProgetto
     * @return
     * @throws RESTWebApplicationException 
     */
    @GET
    @Produces("application/json")
    public Response getAll() throws RESTWebApplicationException {
        /*
        Nel test si mette come parametri di query dataInizio=01/05/2021 e dataFine=31/12/2021
        Così il riusltato di questo metodo dovrebbe essere la lista composta da: m2 ed m4
        */
        
        /*
        Istanzio 5 messaggi, di cui 3 pubblici e 2 privati.
        Suppongo di avere 2 progetti, p1 e p2
        In p1 ci sono 2 messaggi pubblici e 1 privato e in p2 c'è 1 messaggio pubblico e 1 privato
        */
        boolean inizio = (dataInizio == null),
                fine = (dataFine == null);
        
        // pubblici
        Messaggio m1 = new Messaggio();
        m1.setPubblico(true);
        m1.setTesto("messaggio 1");
        m1.setDataOra(LocalDateTime.of(2021, Month.MARCH, 12, 22, 10));
        // TODO: aggiungere mittente
        //m1.setMittente(mittente);
        
        Messaggio m2 = new Messaggio();
        m2.setPubblico(true);
        m2.setTesto("messaggio 2");
        m2.setDataOra(LocalDateTime.of(2021, Month.JULY, 23, 10, 00));
        // TODO: aggiungere mittente

        Messaggio m3 = new Messaggio();
        m3.setPubblico(true);
        m3.setTesto("messaggio 3");
        m3.setDataOra(LocalDateTime.of(2021, Month.DECEMBER, 1, 16, 19));
        // TODO: aggiungere mittente
        
        // privati
        Messaggio m4 = new Messaggio();
        m4.setPubblico(false);
        m4.setTesto("messaggio 4");
        m4.setDataOra(LocalDateTime.of(2021, Month.MAY, 24, 22, 10));
        // TODO: aggiungere mittente
        
        Messaggio m5 = new Messaggio();
        m5.setPubblico(false);
        m5.setTesto("messaggio 5");
        m5.setDataOra(LocalDateTime.of(2021, Month.APRIL, 20, 11, 17));
        // TODO: aggiungere mittente
        
        // TODO: aggiungere controllo per autenticazione
        
        // aggiunta messaggi nei rispettivi progetti
        ArrayList<Messaggio> l = new ArrayList<>();
        
        // in base all'id passato (che può essere 1 o 2) restituisco la Response contente la lista di messaggi relativi a quel progetto
        if (p.getId() == 1){
            
            p.getMessaggi().add(m1);
            p.getMessaggi().add(m2);
            p.getMessaggi().add(m4);
            
            if (inizio && fine) {
                l.addAll(p.getMessaggi());
                return Response.ok(l).build();
            }
            
            if (!inizio && !fine){
                for (Messaggio m : p.getMessaggi()) {
                    if ((m.getDataOra().toLocalDate().equals(dataInizio) || m.getDataOra().toLocalDate().isAfter(dataInizio)) && (m.getDataOra().toLocalDate().equals(dataFine) || m.getDataOra().toLocalDate().isBefore(dataFine))) {l.add(m);}
                }
                return Response.ok(l).build();
            }
            
            if (!inizio && fine) {
                for (Messaggio m : p.getMessaggi()) {
                    if (m.getDataOra().toLocalDate().equals(dataInizio) || m.getDataOra().toLocalDate().isAfter(dataInizio))   l.add(m);
                }
                return Response.ok(l).build();
            }
            
            if (inizio && !fine) {
                for (Messaggio m : p.getMessaggi()) {
                    if (m.getDataOra().toLocalDate().equals(dataFine) || m.getDataOra().toLocalDate().isBefore(dataInizio))   l.add(m);
                }
                return Response.ok(l).build();
            }
        }
        
        if (p.getId() == 2) {
            
            p.getMessaggi().add(m3);
            p.getMessaggi().add(m5);
            
            if (inizio && fine) {
                l.addAll(p.getMessaggi());
                return Response.ok(l).build();
            }
            
            if (!inizio && fine) {
                for (Messaggio m : p.getMessaggi()) {
                    if (m.getDataOra().toLocalDate().equals(dataInizio) || m.getDataOra().toLocalDate().isAfter(dataInizio))   l.add(m);
                }
                return Response.ok(l).build();
            }
            
            if (inizio && !fine) {
                for (Messaggio m : p.getMessaggi()) {
                    if (m.getDataOra().toLocalDate().equals(dataFine) || m.getDataOra().toLocalDate().isBefore(dataInizio))   l.add(m);
                }
                return Response.ok(l).build();
            }
            
            if (!inizio && !fine){
                for (Messaggio m : p.getMessaggi()) {
                    if (m.getDataOra().toLocalDate().equals(dataInizio) || m.getDataOra().toLocalDate().isAfter(dataInizio) && 
                        m.getDataOra().toLocalDate().equals(dataFine) || m.getDataOra().toLocalDate().isBefore(dataFine))   l.add(m);
                }
                return Response.ok(l).build();
            }
        }
        
        throw new RESTWebApplicationException(404, "Progetto non trovato");
    }
    
    /***
     * OP 14 - [BASE]/progetti/ID/messaggi
     * @param uriinfo
     * @param m
     * @param idProgetto
     * @return
     * @throws RESTWebApplicationException 
     */
    @Logged
    @POST
    @Consumes("application/json")
    public Response addMessage(
            @Context UriInfo uriinfo,
            Messaggio m/*,
            int idProgetto*/) throws RESTWebApplicationException {

        /*
        Inserimento nuovo messaggio nel sistema
        */
        //MessaggioManager.getInstance().getMessaggi().add(m);
        
        p.getMessaggi().add(m);
        /*
        Costruzione della URL di risposta per il messaggio appena inserito
        */
        URI uri = uriinfo.getBaseUriBuilder()
                .path(getClass())
                .path(getClass(), "addMessage")
                .build(p.getId(), m.getId());
        
        return Response.created(uri).build();
    }
}
