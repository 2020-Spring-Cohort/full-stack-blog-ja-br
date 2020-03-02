package org.wcci.blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.models.Author;
import org.wcci.blog.models.BlogPost;
import org.wcci.blog.models.Genre;
import org.wcci.blog.models.Tag;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.BlogStorage;
import org.wcci.blog.storage.GenreStorage;
import org.wcci.blog.storage.TagStorage;


@Component
public class Populator implements CommandLineRunner {

    private final GenreStorage genreStorage;
    private final AuthorStorage authorStorage;
    private final BlogStorage blogStorage;
    private final TagStorage tagStorage;

    public Populator(GenreStorage genreStorage, AuthorStorage authorStorage, BlogStorage blogStorage, TagStorage tagStorage) {
        this.genreStorage = genreStorage;
        this.authorStorage = authorStorage;
        this.blogStorage = blogStorage;
        this.tagStorage = tagStorage;
    }

    @Override
    public void run(String... args) {
        Genre litGenre = new Genre("Lit");
        genreStorage.store(litGenre);
        Genre famGenre = new Genre("Fam");
        genreStorage.store(famGenre);
        Genre yeetGenre = new Genre("Yeet");
        genreStorage.store(yeetGenre);
        Author kathy = new Author("Kathy", "Sierra");
        authorStorage.store(kathy);
        Author bates = new Author("Burt", "Bates");
        authorStorage.store(bates);
        Author kent = new Author("Kent", "Beck");
        authorStorage.store(kent);
        Author martin = new Author("Martin", "Fowler");
        authorStorage.store(martin);
        Author micah = new Author("Micah", "Martin");
        authorStorage.store(micah);
        Author neil = new Author("Neil", "Armstrong");
        authorStorage.store(neil);
        BlogPost firstBlogPost = new BlogPost("First Blog", "FIRST", yeetGenre, kathy);
        blogStorage.store(firstBlogPost);
        BlogPost anotherBlogPost = new BlogPost("Not First Blog", "OMG", litGenre, kent);
        blogStorage.store(anotherBlogPost);
        BlogPost yabbaDabba = new BlogPost("Yabba Dabba", "DOOOOOOOOOOO", yeetGenre, micah);
        blogStorage.store(yabbaDabba);
        BlogPost okieDokily = new BlogPost("Longest post", "Lorem ipsum, dolor sit amet consectetur " +
                "adipisicing elit. Modi, earum vero fugit maiores qui rem totam blanditiis fuga porro quaerat eos " +
                "repellendus exercitationem sapiente necessitatibus aliquid doloremque. Illo delectus, exercitationem " +
                "error at magnam maxime iusto debitis natus maiores earum nulla accusantium optio dolorem necessitatibus " +
                "enim quisquam fugiat quaerat, ut, perspiciatis laboriosam? Ab hic voluptatum, unde laborum recusandae quae " +
                "necessitatibus animi quos accusantium facilis aliquid suscipit pariatur accusamus laudantium quas ea quisquam " +
                "tempore quis neque nulla deleniti. Nesciunt enim cumque debitis distinctio consectetur delectus, voluptatem" +
                " natus sequi magnam accusamus. Rem, recusandae dolorum, provident modi, vitae ratione minima quam facere quia" +
                " a corporis. Officia autem voluptates sequi neque error veritatis dolor debitis architecto molestiae laboriosam " +
                "excepturi quod eveniet dicta consequuntur quam quidem at, nemo harum ipsa earum dolore numquam voluptatem?" +
                " Voluptates, corporis rerum, eaque sapiente dolores reprehenderit optio repellendus culpa expedita nobis, " +
                "fugiat cupiditate aliquid molestias fugit exercitationem iste eveniet ratione pariatur perspiciatis et tempora! " +
                "Debitis temporibus rem beatae dolorum voluptatibus ipsum nobis illum blanditiis nulla incidunt. Minima quaerat " +
                "ratione excepturi maxime nihil repudiandae vel, sed doloribus dolore quas error eligendi, commodi praesentium." +
                " Nesciunt beatae nostrum culpa voluptatem magni voluptate iusto natus! Expedita, tempore et eum nostrum doloribus" +
                " voluptate, nulla, excepturi error incidunt amet velit deserunt dolores obcaecati nemo? Officiis aperiam aliquid " +
                "ab pariatur odio sit distinctio ex magni blanditiis, eius nam facere tempora atque mollitia laboriosam? Officiis " +
                "nihil delectus totam suscipit excepturi, enim praesentium provident quibusdam consequatur nulla nisi deserunt " +
                "molestiae quae alias aut dolorem saepe earum in itaque quisquam quis eum eius dolore id! Modi, recusandae veritatis.", famGenre, bates);
        blogStorage.store(okieDokily);
        Tag tag1 = new Tag("Cheese");
        tagStorage.store(tag1);
        Tag tag2 = new Tag("Nope");
        tagStorage.store(tag2);
        Tag tag3 = new Tag("Nap");
        tagStorage.store(tag3);
        Tag tag4 = new Tag("Cool");
        tagStorage.store(tag4);
    }



}
