package org.wcci.blog.models;


import javax.persistence.Entity;

@Entity

public class Genre {

    private String name;

    public Genre(){};
    public Genre(String name){
        this.name = name;
    }
}
