package org.wcci.blog.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.blog.models.BlogPost;
import org.wcci.blog.models.Genre;
//import org.wcci.blog.models.Tag;
import org.wcci.blog.storage.repositories.BlogRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class BlogPostStorageJpaImpTest {
    private BlogRepository blogRepo;
    private BlogStorage underTest;
    private BlogPost testBlogPost;

    @BeforeEach
    void setUp(){
        blogRepo = mock(BlogRepository.class);
        underTest = new BlogStorageJpaImp(blogRepo);
        Genre testGenre = new Genre("Test Genre");
        testBlogPost = new BlogPost();
    }

    @Test
    public void shouldFindBlogById(){
        when(blogRepo.findById(1L)).thenReturn(Optional.of(testBlogPost));
        BlogPost retrievedBlogPost = underTest.findBlogById(1L);
        assertThat(retrievedBlogPost).isEqualTo(testBlogPost);
    }

    @Test
    public void shouldStoreBlog(){
        underTest.store(testBlogPost);
        verify(blogRepo).save(testBlogPost);
    }
}
