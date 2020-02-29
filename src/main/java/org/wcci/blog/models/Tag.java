package org.wcci.blog.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Tag {
    @Id
    @GeneratedValue
    private Long Id;
    private String tagName;

    @ManyToMany(mappedBy = "tags")
    private Collection<Blog> blogs;

    public Tag(){};

    public Tag(String tagName) {
        this.tagName = tagName;
        blogs = new ArrayList<>();
    }

    public Long getId() {
        return Id;
    }

    public String getTagName() {
        return tagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;
        Tag tag = (Tag) o;
        return Objects.equals(Id, tag.Id) &&
                Objects.equals(tagName, tag.tagName) &&
                Objects.equals(blogs, tag.blogs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, tagName, blogs);
    }
}
