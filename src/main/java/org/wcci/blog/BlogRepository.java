package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BlogRepository extends CrudRepository<Blog,Long> {

    Optional<Blog> findById(String blogTitle);



}
