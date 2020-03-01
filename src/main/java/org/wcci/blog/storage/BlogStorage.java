package org.wcci.blog.storage;

import org.wcci.blog.models.BlogPost;

public interface BlogStorage {
    BlogPost findBlogById(long id);

    void store(BlogPost blogPostToStore);
}
