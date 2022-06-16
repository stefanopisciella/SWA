/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.univaq.swa.sdv.sdvrest.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import org.univaq.swa.sdv.sdvrest.model.Messaggio;

/**
 *
 * @author nicola
 */
public class MessaggioSerializer extends JsonSerializer<Messaggio> {

    @Override
    public void serialize(Messaggio m, JsonGenerator jsonGenerator, SerializerProvider sp) throws IOException {
        
        
        
    }
    
}
