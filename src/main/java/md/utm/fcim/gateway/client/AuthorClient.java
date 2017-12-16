package md.utm.fcim.gateway.client;

import md.utm.fcim.gateway.view.AuthorView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("data-warehouse")
public interface AuthorClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/author/{id}")
    AuthorView findById(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/api/author")
    List<AuthorView> findAll();

    @RequestMapping(method = RequestMethod.GET, value = "/api/author/pages")
    Object findPage(@RequestParam("page") Integer page, @RequestParam("size") Integer size);

    @RequestMapping(method = RequestMethod.POST, value = "/api/author", consumes = "application/json")
    AuthorView create(AuthorView authorView);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/author/{id}", consumes = "application/json")
    AuthorView edit(@PathVariable("id") Long id, AuthorView authorView);
}
