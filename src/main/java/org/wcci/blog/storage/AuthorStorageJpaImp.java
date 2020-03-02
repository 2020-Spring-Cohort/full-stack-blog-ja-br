package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.AuthorNotFoundException;
import org.wcci.blog.models.Author;
import org.wcci.blog.storage.repositories.AuthorRepository;

import java.util.Collection;

@Service
public class AuthorStorageJpaImp implements AuthorStorage {

    private final AuthorRepository authorRepo;

    public AuthorStorageJpaImp(AuthorRepository authorRepo){
        this.authorRepo = authorRepo;
    }

    @Override
    public void store(Author authorToStore){
        authorRepo.save(authorToStore);
    }

    @Override
    public Collection<Author> findAllAuthors(){
        return (Collection<Author>) authorRepo.findAll();
    }

    @Override
    public Author findAuthorById(Long id){
        return authorRepo.findById(id).get();
    }

    @Override
    public Author findAuthorByFullName(String authorToFind){
        Author retrievedAuthor;
        try{
            retrievedAuthor = authorRepo.findByFullName(authorToFind).get();
        } catch (Exception e){
            throw new AuthorNotFoundException(e.getMessage());
        }
        return retrievedAuthor;

    }
}
