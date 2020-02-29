package org.wcci.blog.storage;

import org.wcci.blog.GenreNotFoundException;
import org.wcci.blog.models.Genre;
import org.wcci.blog.storage.repositories.GenreRepository;

import java.util.Collection;

public class GenreStorageJpaImp implements GenreStorage{

    private GenreRepository genreRepo;
    private GenreRepository genreRepository;


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
//        Genre retrievedGenre;
//        try{
//            retrievedGenre = genreRepository.findGenreByName(genreName).get();
//        } catch (Exception e){
//            throw new GenreNotFoundException(e.getMessage());
//        }
//        return retrievedGenre;

        return genreRepository.findGenreByName(genreToFind).get();
    }

}
