package org.wcci.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wcci.blog.models.Blog;
import org.wcci.blog.models.Tag;
import org.wcci.blog.storage.BlogStorage;
import org.wcci.blog.storage.repositories.TagRepository;

import java.util.Optional;

@Controller
public class BlogController {


    private BlogStorage blogStorage;
    private TagRepository tagRepo;

    public BlogController(BlogStorage blogStorage, TagRepository tagRepo){
        this.blogStorage = blogStorage;
        this.tagRepo = tagRepo;
    }

    @RequestMapping("/blogs/{id}")
    public String displayBlog(@PathVariable Long id, Model model){
        Blog retrievedBlog = blogStorage.findBlogById(id);
        model.addAttribute("blog", retrievedBlog);
        return "blogs-view";
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
        Blog blogToAddTagTo = blogStorage.findBlogById(id);
        blogToAddTagTo.addTag(tagToAddToBlog);
        blogStorage.store(blogToAddTagTo);
        return "redirect:/blogs/" + id;
    }
}