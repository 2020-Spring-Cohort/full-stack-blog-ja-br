package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.models.BlogPost;
import org.wcci.blog.storage.repositories.BlogRepository;

import java.util.Collection;

@Service
public class BlogStorageJpaImp implements BlogStorage {
    private BlogRepository blogRepo;

    public BlogStorageJpaImp(BlogRepository blogRepo){
        this.blogRepo = blogRepo;
    }

    @Override
    public BlogPost findBlogById(long id) {
        return blogRepo.findById(id).get();
    }

    @Override
    public void store(BlogPost blogPostToStore){
        blogRepo.save(blogPostToStore);
    }

    @Override
    public Collection<BlogPost> findAllBlogs(){
        return (Collection<BlogPost>) blogRepo.findAll();
    }

}
