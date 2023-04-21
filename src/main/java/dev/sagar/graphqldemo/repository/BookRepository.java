package dev.sagar.graphqldemo.repository;

import dev.sagar.graphqldemo.model.Book;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepository {
    private List<Book> books;
    private static final Logger LOGGER = LoggerFactory.getLogger(BookRepository.class);
    public List<Book> retrieveBooks(){
        return books;
    }

    public Book findBook (int id){
        return books.stream()
                .filter(book -> book.id() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @PostConstruct
    private void init(){
        LOGGER.info("Initializing Books array");
        books = Arrays.asList(new Book(1, "Effective Java", 416, 1),
                new Book(2, "Hitchhiker's Guide to the Galaxy", 208, 2),
                new Book(3, "Down Under", 436, 3));
    }

}
