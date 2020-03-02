package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.models.Genre;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.BlogStorage;
import org.wcci.blog.storage.GenreStorage;

@Controller
public class GenreController {

    private GenreStorage genreStorage;

    public GenreController(GenreStorage genreStorage, AuthorStorage authorStorage, BlogStorage blogStorage){
        this.genreStorage = genreStorage;
    }

    @RequestMapping("/genres")
    public String displayGenres(Model model){
        model.addAttribute("genres", genreStorage.findAllGenres());
        return "genres-view";
    }

    @RequestMapping("/genres/{name}")
    public String displayGenre(@PathVariable String name, Model model){
        Genre retrievedGenre = genreStorage.findGenreByName(name);
        model.addAttribute("genres", genreStorage.findAllGenres());
        model.addAttribute("genre", retrievedGenre);
        return "genre-view";
    }

    @PostMapping("/add-genre")
    public String addGenre(@RequestParam String name){
        genreStorage.store(new Genre(name));


        return "redirect:genres";
    }
}
