package org.univaq.swa.sdv.sdvrest.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

/**
 *
 * @author stefa
 */

/*@JsonAutoDetect(
    fieldVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE
)*/

public class Messaggio {
    private int id;
    //@JsonProperty
    private String testo;
    //@JsonProperty
    private LocalDateTime dataOra;
    //@JsonProperty
    private boolean pubblico;
    
    // contatore per autoincrement dell'id
    private static int cont = 1;
    
    Utente mittente; // Utente che scrive il messaggio

    public Messaggio() {
        id = cont;
        cont++;
        testo = "";
        //dataOra = LocalDateTime.now();
        pubblico = false;
        //mittente = new Utente();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    public boolean isPubblico() {
        return pubblico;
    }

    public void setPubblico(boolean pubblico) {
        this.pubblico = pubblico;
    }

    public Utente getMittente() {
        return mittente;
    }

    public void setMittente(Utente mittente) {
        this.mittente = mittente;
    }
}
