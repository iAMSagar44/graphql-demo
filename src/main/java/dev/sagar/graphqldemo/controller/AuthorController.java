package dev.sagar.graphqldemo.controller;

import dev.sagar.graphqldemo.model.Author;
import dev.sagar.graphqldemo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @QueryMapping
    public List<Author> allAuthors(){
        return authorRepository.findAll();
    }
}
