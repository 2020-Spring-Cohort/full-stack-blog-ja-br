package org.wcci.blog.storage;

import org.wcci.blog.models.Blog;
import org.wcci.blog.storage.repositories.BlogRepository;

public class BlogStorageJpaImp implements BlogStorage {
    private BlogRepository blogRepo;

    public BlogStorageJpaImp(BlogRepository blogRepo){
        this.blogRepo = blogRepo;
    }

    @Override
    public Blog findBlogById(long id) {
        return blogRepo.findById(id).get();
    }

    @Override
    public void store(Blog blogToStore){
        blogRepo.save(blogToStore);
    }

}
