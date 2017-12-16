package md.utm.fcim.gateway.error;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class IllegalArgumentExceptionMapper
        implements ExceptionMapper<IllegalArgumentException> {

    public Response toResponse(IllegalArgumentException e) {
        return Response.status(e.getStatus())
                .entity(e.getMessage())
                .build();
    }
}