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
    public void findByBrands_shouldReturnPopulatedMap_brandsPassed() {
        Map<String, Collection<Television>> tvMap = Catalog.findByBrands("Sony", "NOT-FOUND");
        assertEquals(2, tvMap.size());  //should return a map of two rows

        Collection<Television> sonyTvs = tvMap.get("Sony");
        assertEquals(7, sonyTvs.size());     //the collection next to Sony in the map should have 7 Television objects
        for(Television tv : sonyTvs){
            assertEquals("Sony", tv.getBrand());   //each Television should have a brand of "Sony"
        }

        Collection<Television> notFoundTvs = tvMap.get("NOT-FOUND");
        assertEquals(0, notFoundTvs.size());  //should be empty
    }

    @Test
    public void findByBrands_shouldReturnEmptyMap_noBrandsPassed() {
        Map<String, Collection<Television>> tvMap = Catalog.findByBrands();
        assertNotNull(tvMap); //not necessary because .size() won't work if null and it will fail
        assertEquals(0, tvMap.size()); //should be 0 if map is empty
        assertTrue(tvMap.isEmpty());  //alternative check to see if map is empty
    }

    @Test
    public void findByBrand_shouldReturnPopulatedCollection_brandFound() {
        Collection<Television> tvs = Catalog.findByBrand("Sony");
        assertEquals(7, tvs.size());
        for (Television tv : tvs){
            assertEquals("Sony", tv.getBrand());
        }
    }

    /**
     * Contract: a no-matches result should be an empty collection (not null).
     */
    @Test
    public void findByBrand_shouldReturnEmptyCollection_brandNotFound() {
        Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
        assertNotNull(tvs);  //should not be null
        assertTrue(tvs.isEmpty());  //should not be empty
    }
}