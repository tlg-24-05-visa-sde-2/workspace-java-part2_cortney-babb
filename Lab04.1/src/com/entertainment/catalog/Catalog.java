/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.entertainment.Television;

public class Catalog {
    // in-memory catalog of Televisions
    private static final Collection<Television> catalog = new ArrayList<>(30);

    // prevent direct instantiation, this is an all-static class
    private Catalog() {
    }

    /**
     * Searches catalog by brand, and returns a collection of matching Televisions.
     * A no-matches result should be an empty collection (not null).
     */
    public static Collection<Television> findByBrand(String brand) {
        Collection<Television> result = new ArrayList<>();
        // for each over catalog and look for matching brands
        for (Television tv : catalog) {
            if (tv.getBrand().equals(brand)) {
                result.add(tv);
            }
        }
        return result;
    }

    /**
     * Searches catalog by one or more brands, and returns a map with an entry for each brand supplied,
     * with a corresponding collection of matching Televisions for that brand.
     * A no-brands-passed result should be an empty map (not null).
     *
     * if client says:
     * Catalog.findByBrands("Sony")    first will be Sony, rest is empty array
     * Catalog.findByBrands("Sony", "RCA")  first Sony, rest will be array of length 1
     */
    public static Map<String,Collection<Television>> findByBrands(String first, String... rest) {
        Map<String, Collection<Television>> map = new HashMap<>();

        /* TODO :
         * 1. call findByBrand() method with your 'first', this returns Collection<Television>
         *      put() the value of 'first' and this collection in the map
         * 2. for-each String in 'rest' call the findByBrand() method, get Collection back
         *      put() that String and this Collection in the map
         */


        return map;
    }

    /**
     * Returns entire catalog.
     * NOTE: returning a direct reference to it has consequences!
     * A client can manipulate it, since it has a direct reference to it.
     * Sometimes this is okay, but not here.
     * 
     * TODO: change this to return a read-only view of the catalog.
     * 
     * You should explore the Javadoc for the java.util.Collections *class*.
     *  This is an all-static utility class, not the java.util.Collection interface.
     */
    public static Collection<Television> getInventory() {
        return catalog;
    }

    /*
     * Loads catalog.
     * Static initializers execute when the class is loaded into the JVM.
     */
    static {
        catalog.add(new Television("Zenith", 0));
        catalog.add(new Television("Sony", 4));
        catalog.add(new Television("Sony", 50));
        catalog.add(new Television("Zenith", 33));
        catalog.add(new Television("RCA", 50));
        catalog.add(new Television("Zenith", 86));
        catalog.add(new Television("Hitachi", 13));
        catalog.add(new Television("Hitachi", 40));
        catalog.add(new Television("Zenith", 46));
        catalog.add(new Television("RCA", 50));
        catalog.add(new Television("Sony", 94));
        catalog.add(new Television("RCA", 50));
        catalog.add(new Television("Sony", 50));
        catalog.add(new Television("Hitachi", 50));
        catalog.add(new Television("Zenith", 37));
        catalog.add(new Television("RCA", 31));
        catalog.add(new Television("Sony", 87));
        catalog.add(new Television("Hitachi", 39));
        catalog.add(new Television("Zenith", 27));
        catalog.add(new Television("Zenith", 12));
        catalog.add(new Television("RCA", 10));
        catalog.add(new Television("Hitachi", 50));
        catalog.add(new Television("RCA", 4));
        catalog.add(new Television("RCA", 50));
        catalog.add(new Television("RCA", 50));
        catalog.add(new Television("Sony", 28));
        catalog.add(new Television("Zenith", 50));
        catalog.add(new Television("Zenith", 77));
        catalog.add(new Television("Sony", 22));
        catalog.add(new Television("RCA", 50));
    }
}