package org.wcci.blog.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.wcci.blog.models.Author;
import org.wcci.blog.models.BlogPost;
import org.wcci.blog.models.Genre;
import org.wcci.blog.storage.repositories.AuthorRepository;
import org.wcci.blog.storage.repositories.BlogRepository;
import org.wcci.blog.storage.repositories.GenreRepository;
import org.wcci.blog.storage.repositories.TagRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext
@DataJpaTest
public class JpaWiringTest {
    @Autowired
    private BlogRepository blogRepo;
    @Autowired
    private GenreRepository genreRepo;
    @Autowired
    private TagRepository tagRepo;
    @Autowired
    private AuthorRepository authorRepo;
    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void genreShouldHaveAListOfBlogs(){
        Genre testGenre = new Genre("Test Genre");
        Author testAuthor = new Author("John", "Smith");
        BlogPost testBlogPost = new BlogPost("Title", "BlogPost Text Goes Here",testGenre, testAuthor);
        genreRepo.save(testGenre);
        blogRepo.save(testBlogPost);
        authorRepo.save(testAuthor);

        entityManager.flush();
        entityManager.clear();
        Optional<Genre> retrievedGenreOptional = genreRepo.findById(testGenre.getId());
        Genre retrievedGenre = retrievedGenreOptional.get();
        BlogPost retrievedBlogPost = blogRepo.findById(testBlogPost.getId()).get();

        assertThat(retrievedGenre.getBlogPosts()).contains(testBlogPost);




    }



}
