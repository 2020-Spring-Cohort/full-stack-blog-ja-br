package org.wcci.blog.models;


import javax.persistence.*;
import java.util.*;

@Entity
public class Blog {
    @Lob
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String blogText;
    @ManyToMany
    private Collection<Author> authors;
    @ManyToMany
    private Set<Tag> tags;
    @ManyToOne
    private Genre genre;


    public Blog(){};

    public Blog(String title, String blogText, Genre genre, Author... authors){
        this.title = title;
        this.blogText = blogText;
        this.authors = new ArrayList<>(Arrays.asList(authors));
        this.genre = genre;
        this.tags = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String getBlogText() {
        return blogText;
    }

    public Collection<Tag> getTags(){
        return tags;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", blogText='" + blogText + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Blog)) return false;
        Blog blog = (Blog) o;
        return Objects.equals(id, blog.id) &&
                Objects.equals(genre, blog.genre) &&
                Objects.equals(title, blog.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genre, title);
    }

    public void addTag(Tag tagToAdd){
        tags.add(tagToAdd);
    }



}
