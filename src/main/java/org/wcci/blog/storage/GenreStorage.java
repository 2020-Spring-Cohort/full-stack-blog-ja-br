package org.wcci.blog.storage;

import org.wcci.blog.models.Genre;

import java.util.Collection;

public interface GenreStorage {
    void store(Genre genreName);

    Collection<Genre> findAllGenres();

    Genre findGenreByName(String genreName);
}
