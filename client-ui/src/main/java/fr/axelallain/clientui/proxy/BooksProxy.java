package fr.axelallain.clientui.proxy;

import fr.axelallain.clientui.model.Book;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.QueryParam;
import java.util.List;

@FeignClient(name = "zuul")
@RibbonClient(name = "books")
public interface BooksProxy {

    @GetMapping(value = "/books/books")
    Iterable<Book> books();

    @GetMapping(value = "/books/books/{id}")
    Book booksById(@PathVariable("id") int id);

    @GetMapping(value = "/books/books/search")
    List<Book> findByNameLike(@RequestParam("name") String name);
}
