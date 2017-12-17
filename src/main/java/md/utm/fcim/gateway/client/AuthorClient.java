package md.utm.fcim.gateway.client;

import md.utm.fcim.gateway.view.AuthorView;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("data-warehouse")
public interface AuthorClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/author/{id}")
    @Cacheable(value = "author")
    Object findById(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/api/author")
    @Cacheable(value = "authors")
    Object findAll();

    @RequestMapping(method = RequestMethod.GET, value = "/api/author/pages")
    @Cacheable(value = "authorPage")
    Object findPage(@RequestParam("page") Integer page, @RequestParam("size") Integer size);

    @RequestMapping(method = RequestMethod.POST, value = "/api/author", consumes = "application/json")
    AuthorView create(AuthorView authorView);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/author/{id}", consumes = "application/json")
    AuthorView edit(@PathVariable("id") Long id, AuthorView authorView);
}
