package org.wcci.blog.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.models.Tag;

import java.util.Optional;

public interface TagRepository extends CrudRepository<Tag,Long> {

    Optional<Tag> findTagByTagName(String tagName);



}
