package org.wcci.blog.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.models.Genre;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.BlogStorage;
import org.wcci.blog.storage.GenreStorage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GenreControllerTest {
    private MockMvc mockMvc;
    private GenreController underTest;
    private GenreStorage genreStorage;
    private Model mockModel;
    private BlogStorage blogStorage;
    private AuthorStorage authorStorage;
    private Genre testGenre;

    @BeforeEach
    public void setUp(){
        mockModel = mock(Model.class);
        genreStorage = mock(GenreStorage.class);
        authorStorage = mock(AuthorStorage.class);
        underTest = new GenreController(genreStorage, authorStorage, blogStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        testGenre = new Genre("TestGenre");
    }

    @Test
    public void displayGenresReturnsGenresTemplate(){
        String result = underTest.displayGenres(mockModel);
        assertThat(result).isEqualTo("genres-view");
    }

    @Test
    public void displayBlogsOfGenreShouldRedirectToGenresEndPoint(){
        String result = underTest.displayGenre(testGenre.getName(), mockModel);
        assertThat(result).isEqualTo("redirect:genres");
    }

//    @Test
//    public void addCampusShouldRedirectToCampusesEndPoint() {
//        String result = underTest.addCampus("Testville");
//        assertThat(result).isEqualTo("redirect:campuses");
//    }

}

