package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BlogStorageJpaImpTest {
    private BlogRepository blogRepo;
    private BlogStorage underTest;
    private Blog testBlog;

    @BeforeEach
    void setUp(){
        blogRepo = mock(BlogRepository.class);
        underTest = new BlogStorageJpaImp(blogRepo);
        Genre testGenre = new Genre("Test Genre");
        Tag testTag = new Tag();
        testBlog = new Blog();
    }

    @Test
    public void shouldFindBlogByTitle(){
        when(blogRepo.findById(1L)).thenReturn(Optional.of(testBlog));
        Blog retrievedBlog = underTest.findBlogById(1L);
        assertThat(retrievedBlog).isEqualTo(testBlog);
    }
}
