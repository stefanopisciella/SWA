import java.util.List;

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
    
    List<Skill> skill_richiesti;
    List<Utente> collaboratori;

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
        return skill_richiesti;
    }

    public void setSkill_richiesti(List<Skill> skill_richiesti) {
        this.skill_richiesti = skill_richiesti;
    }

    public List<Utente> getCollaboratori() {
        return collaboratori;
    }

    public void setCollaboratori(List<Utente> collaboratori) {
        this.collaboratori = collaboratori;
    }
}
