package md.utm.fcim.gateway.config.jersey;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import md.utm.fcim.gateway.config.filter.CORSResponseFilter;
import md.utm.fcim.gateway.controller.impl.AuthorControllerImpl;
import md.utm.fcim.gateway.controller.impl.BookControllerImpl;
import md.utm.fcim.gateway.error.IllegalArgumentExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerEndpoints();
    }

    @PostConstruct
    public void init() {
        // Register components where DI is needed
        this.configureSwagger();
    }

    private void registerEndpoints() {
        register(BookControllerImpl.class);
        register(AuthorControllerImpl.class);
        register(IllegalArgumentExceptionMapper.class);
        register(CORSResponseFilter.class);
    }

    private void configureSwagger() {
        // Available at localhost:port/swagger.json
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setConfigId("springboot-jersey-swagger-docker-example");
        config.setTitle("Data WareHouse");
        config.setVersion("v1");
        config.setContact("Eladii Vadim");
        config.setSchemes(new String[] { "http", "https" });
        config.setResourcePackage("md.utm.fcim.gateway");
        config.setPrettyPrint(true);
        config.setBasePath("/api");
        config.setScan(true);
    }
}
