/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.univaq.swa.sdv.sdvrest.data;

import java.util.ArrayList;
import java.util.List;
import org.univaq.swa.sdv.sdvrest.model.Utente;

/**
 *
 * @author stefa
 */
public class UtenteManager {
    public static List<Utente> utenti = new ArrayList<Utente>();
    
    public void initilizeData(){
        Utente utente1 = new Utente();
        utente1.setNome("Stefano");
        utente1.setCognome("Pisciella");
        utente1.setEmail("stefano@gmail.com");
        utente1.setTelefono("3880581680");
        utente1.setUsername("stefa");
        utente1.setPassword("stefa");
        
        
        utenti.add(utente1);
        
        
        
    }
}


