/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Map;

import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

    @Test
    public void findByBrands_shouldReturnPopulatedMap_oneRowPerBrandPassed_severalBrands() {
        Map<String, Collection<Television>> tvMap =
                Catalog.findByBrands("Sony", "Hitachi", "NOT-FOUND");
        assertEquals(3, tvMap.size());
    }

    @Test
    public void findByBrands_shouldReturnPopulatedMapWith_oneRowPerBrandPassed_oneBrand() {
        Map<String, Collection<Television>> tvMap = Catalog.findByBrands("Sony");
        assertEquals(1, tvMap.size());

        Collection<Television> sonyTvs = tvMap.get("Sony");
        assertEquals(7, sonyTvs.size());

        for (Television tv : sonyTvs) {
            assertEquals("Sony", tv.getBrand());
        }
    }

    /**
     * Contract: a no-matches result should be an empty collection (not null).
     */
    @Test
    public void findByBrand_shouldReturnEmptyCollection_brandNotFound() {
        Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
        // assertNotNull(tvs);
        assertTrue(tvs.isEmpty());
    }

    @Test
    public void findByBrand_shouldReturnCollection_withMatchingBrand_brandFound() {
        Collection<Television> tvs = Catalog.findByBrand("Sony");
        assertEquals(7, tvs.size());

        for (Television tv : tvs) {
            assertEquals("Sony", tv.getBrand());
        }
    }
}