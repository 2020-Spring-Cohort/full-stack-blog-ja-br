package org.wcci.blog.models;


import javax.persistence.*;
import java.util.*;

@Entity
public class BlogPost {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Lob
    private String blogText;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Genre genre;
    @ManyToMany
    private Set<Tag> tags;



    public BlogPost(){};

    public BlogPost(String title, String blogText, Genre genre, Author author){
        this.title = title;
        this.blogText = blogText;
        this.author = author;
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

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", blogText='" + blogText + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlogPost)) return false;
        BlogPost blogPost = (BlogPost) o;
        return Objects.equals(id, blogPost.id) &&
                Objects.equals(genre, blogPost.genre) &&
                Objects.equals(title, blogPost.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genre, title);
    }

    public void addTag(Tag tagToAdd){
        tags.add(tagToAdd);
    }



}
