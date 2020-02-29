package org.wcci.blog.storage;

import org.wcci.blog.models.Author;
import org.wcci.blog.storage.repositories.AuthorRepository;

public class AuthorStorageJpaImp implements AuthorStorage {

    private final AuthorRepository authorRepository;

    public AuthorStorageJpaImp(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public void store(Author authorToStore){
        authorRepository.save(authorToStore);
    }
}
