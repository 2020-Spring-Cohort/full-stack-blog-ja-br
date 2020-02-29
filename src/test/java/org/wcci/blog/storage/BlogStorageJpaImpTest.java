package org.wcci.blog.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.blog.models.Blog;
import org.wcci.blog.models.Genre;
//import org.wcci.blog.models.Tag;
import org.wcci.blog.storage.repositories.BlogRepository;
import org.wcci.blog.storage.BlogStorage;
import org.wcci.blog.storage.BlogStorageJpaImp;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class BlogStorageJpaImpTest {
    private BlogRepository blogRepo;
    private BlogStorage underTest;
    private Blog testBlog;

    @BeforeEach
    void setUp(){
        blogRepo = mock(BlogRepository.class);
        underTest = new BlogStorageJpaImp(blogRepo);
        Genre testGenre = new Genre("Test Genre");
        testBlog = new Blog();
    }

    @Test
    public void shouldFindBlogById(){
        when(blogRepo.findById(1L)).thenReturn(Optional.of(testBlog));
        Blog retrievedBlog = underTest.findBlogById(1L);
        assertThat(retrievedBlog).isEqualTo(testBlog);
    }

    @Test
    public void shouldStoreBlog(){
        underTest.store(testBlog);
        verify(blogRepo).save(testBlog);
    }
}
