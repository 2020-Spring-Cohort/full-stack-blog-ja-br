package org.wcci.blog.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.models.Genre;
//import org.wcci.blog.models.Tag;

import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre,Long> {

    Optional<Genre> findGenreByName(String genreName);

}
