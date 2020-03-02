package org.wcci.blog.storage;

import org.wcci.blog.models.BlogPost;

import java.util.Collection;

public interface BlogStorage {
    BlogPost findBlogById(long id);

    void store(BlogPost blogPostToStore);

    Collection<BlogPost> findAllBlogs();
}
