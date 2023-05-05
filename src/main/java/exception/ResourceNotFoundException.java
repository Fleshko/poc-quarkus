package exception;


import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class ResourceNotFoundException extends WebApplicationException {
    public ResourceNotFoundException(String resource, String field, String value) {
        super(Response.status(Response.Status.NOT_FOUND)
                .entity("Not found: " + resource + " with " + field + "=" + value)
                .build());
    }
}
