package org.univaq.swa.sdv.sdvrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author stefa
 */
public class Progetto {
    private int id;
    private String nome;
    private String descrizione;
    private int valutazione;
    private Utente coordiatore;

    private static int cont = 1;
    
    private List<Task> tasks;
    private List<Messaggio> messaggi; // lista di messaggi postati nel Progetto

    public Progetto () {
        id = cont;
        cont++;
        
        nome = "";
        descrizione = "";

        tasks = new ArrayList<>();
        messaggi = new ArrayList<>();
    }
    
    @JsonIgnore
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
    @JsonIgnore
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> task) {
        this.tasks = task;
    }

    @JsonIgnore
    public List<Messaggio> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio> messaggio) {
        this.messaggi = messaggio;
    }
    
    public int getValutazione() {
        return valutazione;
    }

    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    public Utente getCoordiatore() {
        return coordiatore;
    }

    public void setCoordiatore(Utente coordiatore) {
        this.coordiatore = coordiatore;
    }
    
    public static Progetto dummyProgetto (int id, String nome, String descrizione) {
        
        Progetto p = new Progetto();
        p.setId(id);
        p.setNome(nome);
        p.setDescrizione(descrizione);
        
        return p;
    }
}
