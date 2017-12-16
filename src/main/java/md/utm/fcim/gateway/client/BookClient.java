package md.utm.fcim.gateway.client;

import md.utm.fcim.gateway.view.BookView;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("data-warehouse")
public interface BookClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/book/{id}")
    @Cacheable(value = "book")
    Object findById(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/api/book")
    @Cacheable(value = "books")
    Object findAll();

    @RequestMapping(method = RequestMethod.GET, value = "/api/book/pages")
    @Cacheable(value = "bookPage")
    Object findPage(@RequestParam("page") Integer page, @RequestParam("size") Integer size);

    @RequestMapping(method = RequestMethod.POST, value = "/api/book", consumes = "application/json")
    BookView create(BookView bookView);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/book/{id}", consumes = "application/json")
    BookView edit(@PathVariable("id") Long id, BookView bookView);
}
