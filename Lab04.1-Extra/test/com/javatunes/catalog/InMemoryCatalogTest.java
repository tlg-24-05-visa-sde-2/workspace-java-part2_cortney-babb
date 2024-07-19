package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    // object under test - "fixture"
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
       catalog = new InMemoryCatalog();
    }

    @Test
    public void name() {
    }
}