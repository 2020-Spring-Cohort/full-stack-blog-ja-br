package org.wcci.blog.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.models.Author;
import org.wcci.blog.models.BlogPost;
import org.wcci.blog.models.Genre;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.BlogStorage;
import org.wcci.blog.storage.GenreStorage;
import org.wcci.blog.storage.repositories.GenreRepository;
import org.wcci.blog.storage.repositories.TagRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BlogControllerTest {
    private BlogController underTest;
    private Model model;
    private BlogStorage blogStorage;
    private BlogPost testBlog;
    private TagRepository tagRepo;
    private AuthorStorage authorStorage;
    private GenreStorage genreStorage;
    private GenreRepository genreRepo;

    @BeforeEach
    void setUp(){
        blogStorage = mock(BlogStorage.class);
        tagRepo = mock(TagRepository.class);
        underTest = new BlogController(blogStorage, tagRepo, authorStorage, genreStorage, genreRepo);
        model = mock(Model.class);
        Genre testGenre = new Genre("Stuff");
        Author testAuthor = new Author("Tom", "Black");
        testBlog = new BlogPost("Title", "Yee dee doo daa", testGenre, testAuthor);
        when(blogStorage.findBlogById(1l)).thenReturn(testBlog);
    }

    @Test
    public void displayBlogReturnsBlogsTemplate(){
        String result = underTest.displayBlog(1l, model);
        assertThat(result).isEqualTo("blogs-view");
    }

    @Test
    public void displayBlogInteractsWithDependenciesCorrectly(){
        underTest.displayBlog(1l, model);
        verify(blogStorage).findBlogById(1l);
        verify(model).addAttribute("blog", testBlog);
    }

    @Test
    public void displayBlogMappingIsCorrect() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/blogs/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("blogs-view"))
                .andExpect(model().attributeExists("blog"))
                .andExpect(model().attribute("blog", testBlog));
    }
}
