package org.wcci.blog;

public class TagStorageJpaImp implements TagStorage {
    private TagRepository tagRepo;

    public TagStorageJpaImp(TagRepository tagRepo) {
        this.tagRepo = tagRepo;
    }
}
