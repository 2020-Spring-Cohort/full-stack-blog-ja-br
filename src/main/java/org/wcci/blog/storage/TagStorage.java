package org.wcci.blog.storage;

import org.wcci.blog.models.Tag;

public interface TagStorage {
    void store(Tag testTag);

    Tag findTagByName(String name);
}
