package org.univaq.swa.sdv.sdvrest.model;

import java.util.List;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stefa
 */
public class Task {
    int id;
    String nome;
    String descrizione;
    boolean attivo;
    
    List<Skill> skill_richieste;
    List<Utente> collaboratori;

    public Task() {
        id = 0;
        nome = "";
        descrizione = "";
        attivo = true;

        skill_richieste = new ArrayList<>();
        collaboratori = new ArrayList<>();
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

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public List<Skill> getSkill_richiesti() {
        return skill_richieste;
    }

    public void setSkill_richiesti(List<Skill> skill_richiesti) {
        this.skill_richieste = skill_richiesti;
    }

    public List<Utente> getCollaboratori() {
        return collaboratori;
    }

    public void setCollaboratori(List<Utente> collaboratori) {
        this.collaboratori = collaboratori;
    }
}
