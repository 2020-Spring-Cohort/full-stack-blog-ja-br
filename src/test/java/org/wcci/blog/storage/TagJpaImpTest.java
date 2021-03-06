package org.wcci.blog.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.blog.models.Tag;
import org.wcci.blog.storage.repositories.TagRepository;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class TagJpaImpTest {
    private TagRepository tagRepo;
    private TagStorage underTest;
    private Tag testTag;

    @BeforeEach
    void setUp(){
        tagRepo = mock(TagRepository.class);
        underTest = new TagStorageJpaImp(tagRepo);
        testTag = new Tag("Test Tag");

    }

    @Test
    public void shouldStoreTag(){
        underTest.store(testTag);
        verify(tagRepo).save(testTag);
    }

    @Test
    void shouldFindTagByName(){
        when(tagRepo.findTagByTagName("Test Tag")).thenReturn(Optional.of(testTag));
        Tag retrievedTag = underTest.findTagByTagName("Test Tag");
        assertThat(retrievedTag).isEqualTo(testTag);

    }

    @Test
    void shouldFindAllTags(){
        when(tagRepo.findAll()).thenReturn(Collections.singletonList(testTag));
        underTest.store(testTag);
        verify(tagRepo).save(testTag);
        assertThat(underTest.findAllTags()).contains(testTag);
    }
}
