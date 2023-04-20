package dev.sagar.graphqldemo.repository;

import dev.sagar.graphqldemo.model.Author;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class AuthorRepository {
    private List<Author> authors;

    public List<Author> findAll() {
        return authors;
    }

    public Author findById(int id){
        return authors.stream()
                .filter(author -> author.id() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @PostConstruct
    private void init() {
        authors = Arrays.asList(new Author(1, "Joshua", "Bloch"),
                new Author(2, "Douglas", "Adams"),
                new Author(3, "Bill", "Bryson"));
    }
}
