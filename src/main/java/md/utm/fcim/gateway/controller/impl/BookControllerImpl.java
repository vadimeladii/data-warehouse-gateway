package md.utm.fcim.gateway.controller.impl;

import md.utm.fcim.gateway.view.BookView;
import md.utm.fcim.gateway.controller.BookController;
import md.utm.fcim.gateway.hystrix.BookHystrixIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
public class BookControllerImpl implements BookController {

    @Autowired
    private BookHystrixIntegration hystrixIntegreation;

    @Override
    public Response findAll() {
        return hystrixIntegreation.findAll();
    }

    @Override
    public Response findPage(Integer page, Integer size) {
        return hystrixIntegreation.findPage(page, size);
    }

    @Override
    public Response findById(Long id) {
        return hystrixIntegreation.findById(id);
    }

    @Override
    public Response create(BookView bookView) {
        return hystrixIntegreation.create(bookView);
    }

    @Override
    public Response edit(Long id, BookView bookView) {
        return hystrixIntegreation.edit(id, bookView);
    }
}
