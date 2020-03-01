package org.wcci.blog.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.models.BlogPost;

public interface BlogRepository extends CrudRepository<BlogPost,Long> {



}
