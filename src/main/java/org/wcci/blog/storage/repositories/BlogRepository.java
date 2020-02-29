package org.wcci.blog.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.models.Blog;

import java.util.Optional;

public interface BlogRepository extends CrudRepository<Blog,Long> {



}
