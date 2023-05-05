package controller;

import api.DefenseDTO;
import api.DefenseRequest;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.DefenseService;

@Path("/defense")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DefenseController {

    private final DefenseService defenseService;

    @Inject
    public DefenseController(DefenseService defenseService) {
        this.defenseService = defenseService;
    }

    @POST
    public Response createDefense(DefenseRequest defenseRequest) {
        return Response.status(Response.Status.CREATED)
                .entity(defenseService.createDefense(defenseRequest))
                .build();
    }

    @PUT
    @Path("/{defenseId}")
    public DefenseDTO updateDefense(@PathParam("defenseId") String defenseId, DefenseRequest defenseRequest) {
        return defenseService.updateDefense(defenseId, defenseRequest);
    }

    @DELETE
    @Path("/{defenseId}")
    public boolean deleteDefense(@PathParam("defenseId") String defenseId) {
        return defenseService.deleteDefense(defenseId);
    }
}
