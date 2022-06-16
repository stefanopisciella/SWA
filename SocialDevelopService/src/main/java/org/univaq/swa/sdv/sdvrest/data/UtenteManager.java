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
    
    public static void initilizeData(){
        Utente utente1 = new Utente();
        utente1.setNome("Stefano");
        utente1.setCognome("Pisciella");
        utente1.setId(1);
        utente1.setEmail("stefano@gmail.com");
        utente1.setTelefono("3880581680");
        utente1.setUsername("stefa");
        utente1.setPassword("stefa");
        
        Utente utente2 = new Utente();
        utente2.setNome("Beatrice");
        utente2.setCognome("Tomassi");
        utente2.setEmail("beatrice@gmail.com");
        utente2.setTelefono("3880581680");
        utente2.setUsername("beatrice");
        utente2.setPassword("beatrice");
        
        Utente utente3 = new Utente();
        utente2.setNome("Nicola");
        utente2.setCognome("Rossi");
        utente2.setEmail("nicola@gmail.com");
        utente2.setTelefono("3880581680");
        utente2.setUsername("nicola");
        utente2.setPassword("nicola");
        
        
        utenti.add(utente1);
        
        
        
    }
}


