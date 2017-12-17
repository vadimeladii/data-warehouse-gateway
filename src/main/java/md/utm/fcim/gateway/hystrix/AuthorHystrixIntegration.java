package md.utm.fcim.gateway.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import md.utm.fcim.gateway.client.AuthorClient;
import md.utm.fcim.gateway.view.AuthorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.core.Response;
import java.util.Collections;

@Component
public class AuthorHystrixIntegration {

    @Autowired
    private AuthorClient authorClient;

    public Response findAllDefault() {
        return Response.serverError().entity(Collections.emptyList()).build();
    }

    public Response findOneDefault(Long id) {
        return Response.serverError().entity(null).build();
    }

    @HystrixCommand(fallbackMethod = "findAllDefault")
    public Response findAll() {
        return Response.ok().entity(authorClient.findAll()).build();
    }

    public Response create(@RequestBody AuthorView authorView) {
        return Response.status(Response.Status.CREATED).entity(authorClient.create(authorView)).build();
    }

    @HystrixCommand(fallbackMethod = "findOneDefault")
    public Response findById(Long id) {
        return Response.ok().entity(authorClient.findById(id)).build();
    }

    public Response findPage(Integer page, Integer size) {
        return Response.ok().entity(authorClient.findPage(page, size)).build();
    }

    public Response edit(Long id, AuthorView authorView) {
        return Response.ok().entity(authorClient.edit(id, authorView)).build();
    }

}
