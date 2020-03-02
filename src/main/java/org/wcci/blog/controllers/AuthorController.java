package org.wcci.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wcci.blog.models.Author;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.repositories.AuthorRepository;

import java.util.Optional;

@Controller
public class AuthorController {

    private AuthorRepository authorRepo;
    private AuthorStorage authorStorage;

    public AuthorController(AuthorStorage authorStorage){
        this.authorStorage = authorStorage;
    }


    @RequestMapping("/authors")
    public String displayAuthors(Model model){
        model.addAttribute("authors", authorStorage.findAllAuthors());
        return "authors-view";
    }

    @RequestMapping("/authors/{id}")
    public String displayAuthor(@PathVariable Long id, Model model){
        Author retrievedAuthor = authorStorage.findAuthorById(id);
        model.addAttribute("authors", authorStorage.findAllAuthors());
        model.addAttribute("author", retrievedAuthor);
        return "author-view";
    }

    @PostMapping("/add-author")
    public String addAuthor(@RequestParam String authorFirstName, @RequestParam String authorLastName){
        authorStorage.store(new Author(authorFirstName, authorLastName));


        return "redirect:authors";
    }
}
