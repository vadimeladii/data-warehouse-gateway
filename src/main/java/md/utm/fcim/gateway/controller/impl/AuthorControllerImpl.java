package md.utm.fcim.gateway.controller.impl;

import md.utm.fcim.gateway.controller.AuthorController;
import md.utm.fcim.gateway.hystrix.AuthorHystrixIntegration;
import md.utm.fcim.gateway.view.AuthorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
public class AuthorControllerImpl implements AuthorController {

    @Autowired
    private AuthorHystrixIntegration hystrixIntegration;

    @Override
    public Response findAll() {
        return hystrixIntegration.findAll();
    }

    @Override
    public Response findPage(Integer page, Integer size) {
        return hystrixIntegration.findPage(page, size);
    }

    @Override
    public Response findById(Long id) {
        return hystrixIntegration.findById(id);
    }

    @Override
    public Response create(AuthorView authorView) {
        return hystrixIntegration.create(authorView);
    }

    @Override
    public Response edit(Long id, AuthorView authorView) {
        return hystrixIntegration.edit(id, authorView);
    }
}
