package org.univaq.swa.sdv.sdvrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProgettoUtente {
    private UtenteMinimale utente;
    private Progetto progetto;
    private int valutazione;

    public ProgettoUtente() {
    }

    @JsonIgnore
    public UtenteMinimale getUtente() {
        return utente;
    }

    public void setUtente(UtenteMinimale utente) {
        this.utente = utente;
    }

    public Progetto getProgetto() {
        return progetto;
    }

    public void setProgetto(Progetto progetto) {
        this.progetto = progetto;
    }

    public int getValutazione() {
        return valutazione;
    }

    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }
    
    
}
