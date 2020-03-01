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
    public void blogsShouldHaveAnAuthor(){

        Tag testTag1 = tagRepo.save(new Tag("lit"));
        Tag testTag2 = tagRepo.save(new Tag("fam"));
        Tag testTag3 = tagRepo.save(new Tag("buzz"));
        Author testAuthor1 = authorRepo.save(new Author("Tom", "Black"));
        Genre testGenre = genreRepo.save(new Genre("Basic"));
        BlogPost testBlog1 = blogRepo.save(new BlogPost("Post1", "Buncha stuff goes here", testGenre, testAuthor1));
        blogRepo.save(testBlog1);
        entityManager.flush();
        entityManager.clear();

        BlogPost retrievedBlog = blogRepo.findById(testBlog1.getId()).get();
        Author retrievedAuthor = authorRepo.findById(testAuthor1.getId()).get();
        assertThat(retrievedBlog.getAuthor()).isEqualTo(retrievedAuthor);

    }
    @Test
    public void blogShouldHaveTags(){
        Tag testTag1 = tagRepo.save(new Tag("lit"));
        Tag testTag2 = tagRepo.save(new Tag("fam"));
        Tag testTag3 = tagRepo.save(new Tag("buzz"));
        Author testAuthor1 = authorRepo.save(new Author("Tom", "Black"));
        Genre testGenre = genreRepo.save(new Genre("Basic"));
        BlogPost testBlog1 = blogRepo.save(new BlogPost("Post1", "Buncha stuff goes here", testGenre, testAuthor1));
        BlogPost testBlog2 = blogRepo.save(new BlogPost("Post2", "Buncha stuff goes here", testGenre, testAuthor1));
        testBlog1.addTag(testTag1);
        testBlog2.addTag(testTag2);
        testBlog2.addTag(testTag3);
        blogRepo.save(testBlog1);
        blogRepo.save(testBlog2);
        entityManager.flush();
        entityManager.clear();

        BlogPost retrievedBlog1 = blogRepo.findById(testBlog1.getId()).get();
        BlogPost retrievedBlog2 = blogRepo.findById(testBlog2.getId()).get();

        assertThat(retrievedBlog1.getTags()).contains(testTag1);
        assertThat(retrievedBlog2.getTags()).contains(testTag2, testTag3);





    }



}
