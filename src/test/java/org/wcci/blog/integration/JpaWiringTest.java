package org.wcci.blog.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.wcci.blog.models.Author;
import org.wcci.blog.models.BlogPost;
import org.wcci.blog.models.Genre;
import org.wcci.blog.models.Tag;
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

    @Test
    public void blogsShouldBeAbleToHaveMultipleTags(){
        Tag testTag1 = new Tag("lit");
        Tag testTag2 = new Tag("fam");
        Tag testTag3 = new Tag("buzz");
        Author testAuthor1 = new Author("Tom", "Black");

        Genre testGenre = new Genre("Basic");
        BlogPost testBlog = new BlogPost("Post1", "Buncha stuff goes here", testGenre, testAuthor1, testTag1, testTag2, testTag3);

        authorRepo.save(testAuthor1);
        tagRepo.save(testTag1);
        tagRepo.save(testTag2);
        tagRepo.save(testTag3);
        genreRepo.save(testGenre);
        blogRepo.save(testBlog);

        entityManager.flush();
        entityManager.clear();

        BlogPost retrievedBlog = blogRepo.findById(testBlog.getId()).get();
        Tag retrievedTag1 = tagRepo.findTagByTagName(testTag1.getTagName()).get();
        Tag retrievedTag2 = tagRepo.findTagByTagName(testTag2.getTagName()).get();
        Tag retrievedTag3 = tagRepo.findTagByTagName(testTag3.getTagName()).get();

        assertThat(retrievedBlog.getTags()).contains(retrievedTag1, retrievedTag2, retrievedTag3);

    }



}
