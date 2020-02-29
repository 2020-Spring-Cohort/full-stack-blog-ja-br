package org.wcci.blog;

public class BlogStorageJpaImp extends BlogStorage {
    private BlogRepository blogRepo;

    Blog findBlogById(long id) {
        return blogRepo.findById(id).get();
    }

}
