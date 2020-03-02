package org.wcci.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wcci.blog.models.BlogPost;
import org.wcci.blog.models.Tag;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.BlogStorage;
import org.wcci.blog.storage.GenreStorage;
import org.wcci.blog.storage.repositories.GenreRepository;
import org.wcci.blog.storage.repositories.TagRepository;

import java.util.Optional;

@Controller
public class BlogController {


    private final GenreRepository genreRepo;
    private BlogStorage blogStorage;
    private TagRepository tagRepo;
    private AuthorStorage authorStorage;
    private GenreStorage genreStorage;

    public BlogController(BlogStorage blogStorage, TagRepository tagRepo, AuthorStorage authorStorage, GenreStorage genreStorage, GenreRepository genreRepo){
        this.blogStorage = blogStorage;
        this.tagRepo = tagRepo;
        this.authorStorage = authorStorage;
        this.genreStorage = genreStorage;
        this.genreRepo = genreRepo;
    }


    @RequestMapping("/blogs")
    public String displayBlogs(Model model){
        model.addAttribute("genres", genreStorage.findAllGenres());
        model.addAttribute("authors", authorStorage.findAllAuthors());
        model.addAttribute("blogs", blogStorage.findAllBlogs());
        return "blogs-view";
    }

    @RequestMapping("/blogs/{id}")
    public String displayBlog(@PathVariable Long id, Model model){
        BlogPost retrievedBlogPost = blogStorage.findBlogById(id);
        model.addAttribute("blogs", blogStorage.findAllBlogs());
        model.addAttribute("blog", retrievedBlogPost);
        return "blog-view";
    }

    @PostMapping("/add-blog")
    public String addNewBlog(@RequestParam String blogTitle, @RequestParam String blogBody, @RequestParam String genre){
        blogStorage.store(new BlogPost(blogTitle, blogBody, genreStorage.findGenreByName(genre), authorStorage.findAuthorByFullName("Kathy Sierra")));
        return "redirect:blogs";
    }

    @PostMapping("/blogs/{id}/add-hashtag")
    public String addTagToBlog(@RequestParam String tagName, @PathVariable Long id){
        Tag tagToAddToBlog;
        Optional<Tag> tagToAddOpt = tagRepo.findTagByTagName(tagName);
        if (tagToAddOpt.isEmpty()) {
            tagToAddToBlog = new Tag(tagName);
            tagRepo.save(tagToAddToBlog);
        } else {
            tagToAddToBlog = tagToAddOpt.get();
        }
        BlogPost blogPostToAddTagTo = blogStorage.findBlogById(id);
        blogPostToAddTagTo.addTag(tagToAddToBlog);
        blogStorage.store(blogPostToAddTagTo);
        return "redirect:/blogs/" + id;
    }
}
