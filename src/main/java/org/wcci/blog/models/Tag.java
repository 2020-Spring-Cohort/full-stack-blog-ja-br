package org.wcci.blog.models;


import javax.persistence.Entity;

@Entity
public class Tag {
    private String tagName;

    public Tag(String tagName) {
        this.tagName = tagName;
    }
}
