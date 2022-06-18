package org.univaq.swa.sdv.sdvrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author stefa
 */
public class Progetto {
    private int id;
    private String nome;
    private String descrizione;
    private static int cont = 1;
    
    private List<Task> tasks;
    private List<Messaggio> messaggi; // lista di messaggi postati nel Progetto
    private UtenteMinimale coordinatore;


    public Progetto () {
        id = cont;
        cont++;
        
        nome = "";
        descrizione = "";
        coordinatore = new UtenteMinimale();

        tasks = new ArrayList<>();
        messaggi = new ArrayList<>();
    }
    
    @JsonIgnore
    public int getId() {
        return id;
    }

    @JsonIgnore
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

    @JsonIgnore
    public void setTasks(List<Task> task) {
        this.tasks = task;
    }

    @JsonIgnore
    public List<Messaggio> getMessaggi() {
        return messaggi;
    }

    @JsonIgnore
    public void setMessaggi(List<Messaggio> messaggio) {
        this.messaggi = messaggio;
    }

    public UtenteMinimale getCoordinatore() {
        return coordinatore;
    }

    public void setCoordinatore(UtenteMinimale coordinatore) {
        this.coordinatore = coordinatore;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Progetto other = (Progetto) obj;
        return Objects.equals(this.nome, other.nome);
    }

    @Override
    public String toString() {
        return "Progetto{" + "id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + 
                ", nome coordinatore=" + coordinatore.getNome() + ", cognome coordinatore=" + coordinatore.getCognome() + '}';
    }

    
    public static Progetto dummyProgetto (String nome, String descrizione) {
        
        Progetto p = new Progetto();
        //p.setId(id);
        p.setNome(nome);
        p.setDescrizione(descrizione);
        
        return p;
    }
}
