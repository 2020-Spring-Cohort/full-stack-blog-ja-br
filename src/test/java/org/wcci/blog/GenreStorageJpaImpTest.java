package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.blog.models.Genre;
import org.wcci.blog.storage.GenreStorageJpaImp;
import org.wcci.blog.storage.repositories.GenreRepository;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class GenreStorageJpaImpTest {
    private GenreRepository genreRepo;
    private GenreStorageJpaImp underTest;
    private Genre testGenre;


    @BeforeEach
    void setUp(){
        genreRepo = mock(GenreRepository.class);
        underTest = new GenreStorageJpaImp(genreRepo);
        testGenre = new Genre("Test Genre");
        underTest.store(testGenre);


    }

    @Test
    public void shouldFindAllGenres(){
        when(genreRepo.findAll()).thenReturn(Collections.singletonList(testGenre));
        verify(genreRepo).save(testGenre);
        assertThat(underTest.findAllGenres()).contains(testGenre);
    }

    @Test
    public void shouldFindGenreByName(){
        when(genreRepo.findGenreByName("Test Genre")).thenReturn(Optional.of(testGenre));
        Genre retrievedGenre = underTest.findGenreByName("Test Genre");
        assertThat(retrievedGenre).isEqualTo(testGenre);
    }

}
