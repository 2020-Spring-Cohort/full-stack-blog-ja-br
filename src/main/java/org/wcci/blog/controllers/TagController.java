package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.models.BlogPost;
import org.wcci.blog.models.Genre;
import org.wcci.blog.models.Tag;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.BlogStorage;
import org.wcci.blog.storage.GenreStorage;
import org.wcci.blog.storage.TagStorage;

@Controller
public class TagController {

    private TagStorage tagStorage;

    public TagController(TagStorage tagStorage, AuthorStorage authorStorage, BlogStorage blogStorage){
        this.tagStorage = tagStorage;
    }

    @RequestMapping("/tags")
    public String displayTags(Model model){
        model.addAttribute("genres", tagStorage.findAllTags());
        return "tags-view";
    }

    @RequestMapping("/tags/{id}")
    public String displayBlog(@PathVariable Long id, Model model){
        Tag retrievedTag = tagStorage.findTagById(id);
        model.addAttribute("tags", tagStorage.findAllTags());
        model.addAttribute("tag", retrievedTag);
        return "tag-view";
    }

    @PostMapping("/add-tag")
    public String addTag(@RequestParam String name){
        tagStorage.store(new Tag(name));


        return "redirect:genres";
    }
}
