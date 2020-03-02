package org.wcci.blog.storage;

import org.wcci.blog.models.Author;

import java.util.Collection;

public interface AuthorStorage {
    void store(Author authorToStore);

    Collection<Author> findAllAuthors();

    Author findAuthorById(Long id);

    Author findAuthorByFullName(String authorName);
}
