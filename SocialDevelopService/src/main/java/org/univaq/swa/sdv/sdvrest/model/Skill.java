package org.univaq.swa.sdv.sdvrest.model;

/**
 *
 * @author stefa
 */
public class Skill {
    private int id;
    private String nome;
    private static int cont = 1;

    public Skill() {
        id = cont;
        cont++;
        nome = "";
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
}
