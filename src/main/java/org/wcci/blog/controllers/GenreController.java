package org.wcci.blog.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.BlogStorage;
import org.wcci.blog.storage.GenreStorage;

public class GenreController {

    private GenreStorage genreStorage;

    public GenreController(GenreStorage genreStorage, AuthorStorage, BlogStorage blogStorage){
        this.genreStorage = genreStorage;
    }

    @RequestMapping({"/genres","/",""})
    public String displayGenres(Model model){
        model.addAttribute("genres" genreStorage.findAllGenres());
        return "genres-view";
    }
}
