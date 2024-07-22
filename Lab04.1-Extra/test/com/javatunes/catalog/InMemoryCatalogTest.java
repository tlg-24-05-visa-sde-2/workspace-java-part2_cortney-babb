package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    // object under test - "fixture"
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
       catalog = new InMemoryCatalog();
    }

//    @Test
//    public void name() {
//    }

    @Test
    public void findByCategory_shouldReturnCollectionWithCategory_categoryFound() {
        Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.POP);

        assertEquals(4, popItems.size());

        for (MusicItem item : popItems) {
            assertEquals(MusicCategory.POP, item.getMusicCategory());
        }
    }

    @Test
    public void findById_shouldReturnMusicItemWithThatId_idFound() {
        MusicItem item = catalog.findById(18L);
        assertEquals(18L, item.getId().longValue()); // extracts the long from the Long
    }

    @Test
    public void findById_shouldReturnNullIfCatalog_IsNotFound() {
        MusicItem item = catalog.findById(1001L);
        assertNull(item);
    }
}