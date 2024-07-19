/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog;

import java.util.Collection;

class InMemoryCatalogMain {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
//        System.out.println("Returns the item with the given id: ");
        // testFindById();
//        System.out.println("\nReturns result with given keyword from either title or artist:");
        // testFindByKeyword();
        // testFindByCategory();
//         testSize();
//         testGetAll();

//        System.out.println("\nTitle is same as artist: ");
//        testFindSelfTitled();
//
//        System.out.println("\nAll \"rock\" items whose price is less than or equal to specified price: ");
//        testFindRockLessThan();
//
//        System.out.println("\nReturns how many items of the specified genre (MusicCategory) we sell: ");
//        testGenreCount();
    }

    private static void testFindSelfTitled() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> titleSameAsArtist = catalog.findSelfTitled();
        dump(titleSameAsArtist);
    }

    public static void testFindRockLessThan() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> cheapRockItems = catalog.findRockLessThan(12.0); // should be 3

        dump(cheapRockItems);
    }

    public static void testGenreCount() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        int genreCount = catalog.genreSales(MusicCategory.POP);

        System.out.println("Number of " + MusicCategory.POP + " items: " + genreCount);
    }


    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        MusicItem item = catalog.findById(6L); // autobox primitive long to Long object
        System.out.println(item);

        MusicItem item2 = catalog.findById(66L); // music item not found, should return null
        System.out.println(item2);
    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> keyMatches = catalog.findByKeyword("Jonny");
        dump(keyMatches);
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);
        dump(items);

    }

    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        int size = catalog.size();
        System.out.println("Number of items in catalog: " + size);
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> readOnlyItems = catalog.getAll();

        for (MusicItem item : readOnlyItems) {
            System.out.println(item);
        }
    }

    private static void dump(Collection<MusicItem> items) {
        for (MusicItem item : items) {
            System.out.println(item);
        }
    }
}