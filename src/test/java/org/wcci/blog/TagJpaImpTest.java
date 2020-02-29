package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class TagJpaImpTest {
    private TagRepository tagRepo;
    private TagStorage underTest;
    private Tag testTag;

    @BeforeEach
    void setUp(){
        TagRepository tagRepo = mock(TagRepository.class);
        underTest = new TagStorageJpaImp(tagRepo);

    }

    @Test
    public void shouldStoreTag(){
    }
}
