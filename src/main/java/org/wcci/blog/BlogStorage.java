package org.wcci.blog;

public interface BlogStorage {
    Blog findBlogById(long id);

    void store(Blog blogToStore);
}
