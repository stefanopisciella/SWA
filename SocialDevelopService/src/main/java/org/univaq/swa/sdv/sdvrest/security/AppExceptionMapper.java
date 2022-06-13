package org.univaq.swa.sdv.sdvrest.security;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.univaq.swa.sdv.sdvrest.CustomException;

/**
 *
 * @author didattica
 */
@Provider
public class AppExceptionMapper implements ExceptionMapper<CustomException> {

    @Override
    public Response toResponse(CustomException exception) {
        //possiamo trasformare queste eccezioni in una risposta formattata, se non le catturiamo all'origine...
        return Response.serverError().entity(exception.getMessage()).type(MediaType.APPLICATION_JSON).build();
    }

}
