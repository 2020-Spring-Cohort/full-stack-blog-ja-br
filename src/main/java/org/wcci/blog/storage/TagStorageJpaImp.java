package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.models.Tag;
import org.wcci.blog.storage.repositories.TagRepository;
import java.util.Collection;

@Service
public class TagStorageJpaImp implements TagStorage {
    private TagRepository tagRepo;

    public TagStorageJpaImp(TagRepository tagRepo) {
        this.tagRepo = tagRepo;
    }

    @Override
    public void store(Tag tagToStore){
        tagRepo.save(tagToStore);
    }
    @Override
    public Tag findTagByTagName(String nameToFind){
        return tagRepo.findTagByTagName(nameToFind).get();
    }

    @Override
    public Collection<Tag> findAllTags(){
        return (Collection<Tag>) tagRepo.findAll();
    }

}
