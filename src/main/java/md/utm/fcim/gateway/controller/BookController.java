package md.utm.fcim.gateway.controller;

import io.swagger.annotations.Api;
import md.utm.fcim.gateway.view.BookView;
import md.utm.fcim.gateway.constants.OffsetLimitHelper;
import org.springframework.cache.annotation.Cacheable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/book")
@Api(value = "BOOK Controller Resource Endpoint")
public interface BookController {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response findById(@PathParam("id") Long id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response findAll();

    @GET
    @Path("/pages")
    @Produces(MediaType.APPLICATION_JSON)
    Response findPage(@QueryParam("page") @DefaultValue(OffsetLimitHelper.PAGE) Integer page,
                      @QueryParam("size") @DefaultValue(OffsetLimitHelper.SIZE) Integer size);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response create(BookView bookView);

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response edit(@PathParam("id") Long id, BookView bookView);
}
