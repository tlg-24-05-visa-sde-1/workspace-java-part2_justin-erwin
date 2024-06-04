/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog.test;

import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.Collection;

class InMemoryCatalogTest {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
        // testFindById();
        //testFindByKeyword();
        // testFindByCategory();
        // testSize();
        // testGetAll();

        //testCheapRock();
        // testSelfTitled();
        //testGenreCount();
        //testAvgPrice();
    }


    private static void testAvgPrice(){
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.avgPrice());
    }
    private static void testGenreCount() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.genreCount(MusicCategory.POP));
    }

    private static void testSelfTitled() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> selfTitled = catalog.findSelfTitled();
        dump(selfTitled);
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();
//        System.out.println(catalog.findById(6L));
        MusicItem item = catalog.findById(6L);
        System.out.println(item);
//        System.out.println(catalog.findById(110L));
        MusicItem item2 = catalog.findById(110L);
        System.out.println(item2);

    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        dump(catalog.findByKeyword("Y"));
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        //return type is a Collection<MusicItem>
        Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.POP);
//        System.out.println(popItems);
        dump(popItems);

        Collection<MusicItem> jazzItems = catalog.findByCategory(MusicCategory.JAZZ);
        dump(jazzItems);
    }

    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.size());
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        dump(catalog.getAll());
    }

    private static void testCheapRock() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        dump(catalog.cheapRock(12.00));
    }

    private static void dump(Collection<MusicItem> items) {
        for (MusicItem item : items) {
            System.out.println(item);
        }
    }
}