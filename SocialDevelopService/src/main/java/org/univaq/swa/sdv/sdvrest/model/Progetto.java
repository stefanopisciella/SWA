package org.univaq.swa.sdv.sdvrest.model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author stefa
 */
public class Progetto {
    int id;
    String nome;
    String descrizione;
    
    List<Task> tasks;
    List<Messaggio> messaggi; // lista di messaggi postati nel Progetto

    public Progetto () {
        id = 0;
        nome = "";
        descrizione = "";

        tasks = new ArrayList<>();
        messaggi = new ArrayList<>();
    }
    
    public Progetto(int id, String nome, String descrizione){
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        tasks = new ArrayList<>();
        messaggi = new ArrayList<>();
    }
    
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> task) {
        this.tasks = task;
    }

    public List<Messaggio> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio> messaggio) {
        this.messaggi = messaggio;
    }
    
    public static Progetto dummyProgetto (int id, String nome, String descrizione) {
        
        Progetto p = new Progetto();
        p.setId(id);
        p.setNome(nome);
        p.setDescrizione(descrizione);
        
        return p;
    }
}
