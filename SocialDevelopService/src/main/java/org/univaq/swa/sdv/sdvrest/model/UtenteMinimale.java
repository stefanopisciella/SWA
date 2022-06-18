package org.univaq.swa.sdv.sdvrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

/**
 *
 * @author nicola
 */
public class UtenteMinimale {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    
    private static int cont = 1;
    
    public UtenteMinimale() {
        id = cont;
        cont ++;
        
        nome = "";
        cognome = "";
        email = "";
    }

    @JsonIgnore
    public void setId(int id) {
        this.id = id;
    }
    
    @JsonIgnore
    public int getId(){
        return this.id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public static UtenteMinimale dummyUtente (int id, String nome, String cognome, String email) {
        UtenteMinimale utente = new UtenteMinimale();
        
        utente.setId(id);
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setEmail(email);
        
        return utente;
    }
    
}
