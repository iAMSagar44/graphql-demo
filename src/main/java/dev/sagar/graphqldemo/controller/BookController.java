package dev.sagar.graphqldemo.controller;

import dev.sagar.graphqldemo.model.Author;
import dev.sagar.graphqldemo.model.Book;
import dev.sagar.graphqldemo.repository.AuthorRepository;
import dev.sagar.graphqldemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    @Autowired
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    public List<Book> allBooks(){
        return bookRepository.retrieveBooks();
    }

    @QueryMapping
    public Book bookById(@Argument int id){
        return bookRepository.findBook(id);
    }

    @SchemaMapping
    public Author author(Book book){
        return authorRepository.findById(book.authorId());
    }
}
