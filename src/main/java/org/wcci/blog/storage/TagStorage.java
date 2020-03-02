package org.wcci.blog.storage;

import org.wcci.blog.models.Tag;

import java.util.Collection;

public interface TagStorage {
    void store(Tag testTag);

    Tag findTagByTagName(String tagNameToFind);

    Collection<Tag> findAllTags();

    Tag findTagById(Long id);
}
