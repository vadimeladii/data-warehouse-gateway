package md.utm.fcim.gateway.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import md.utm.fcim.gateway.view.BookView;
import md.utm.fcim.gateway.client.BookClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.core.Response;
import java.awt.print.Book;
import java.util.Collections;

@Component
public class BookHystrixIntegration {

    @Autowired
    private BookClient bookClient;

    public Response findAllDefault() {
        return Response.serverError().entity(Collections.emptyList()).build();
    }

    public Response findOneDefault(Long id) {
        return Response.serverError().entity(null).build();
    }

    @HystrixCommand(fallbackMethod = "findAllDefault")
    public Response findAll() {
        return Response.ok().entity(bookClient.findAll()).build();
    }

    public Response create(@RequestBody BookView bookView) {
        return Response.status(Response.Status.CREATED).entity(bookClient.create(bookView)).build();
    }

    @HystrixCommand(fallbackMethod = "findOneDefault")
    public Response findById(Long id) {
        return Response.ok().entity(bookClient.findById(id)).build();
    }

    public Response findPage(Integer page, Integer size) {
        return Response.ok().entity(bookClient.findPage(page, size)).build();
    }

    public Response edit(Long id, BookView bookView) {
        return Response.ok().entity(bookClient.edit(id, bookView)).build();
    }
}
