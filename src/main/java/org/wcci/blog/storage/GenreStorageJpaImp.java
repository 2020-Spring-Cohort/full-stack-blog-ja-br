package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.GenreNotFoundException;
import org.wcci.blog.models.Genre;
import org.wcci.blog.storage.repositories.GenreRepository;

import java.util.Collection;
@Service
public class GenreStorageJpaImp implements GenreStorage{

    private GenreRepository genreRepo;


    public GenreStorageJpaImp(GenreRepository genreRepo) {
        this.genreRepo = genreRepo;
    }

    @Override
    public void store(Genre genreToSave){
        genreRepo.save(genreToSave);
    }

    @Override
    public Collection<Genre> findAllGenres(){
        return (Collection<Genre>) genreRepo.findAll();
    }

    @Override
    public Genre findGenreByName(String genreToFind){
        Genre retrievedGenre;
        try{
            retrievedGenre = genreRepo.findGenreByName(genreToFind).get();
        } catch (Exception e){
            throw new GenreNotFoundException(e.getMessage());
        }
        return retrievedGenre;

//        return genreRepo.findGenreByName(genreToFind).get();
    }

}
