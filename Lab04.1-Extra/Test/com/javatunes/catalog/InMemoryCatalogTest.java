package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
        catalog= new InMemoryCatalog();
    }

    @Test
    public void getMusicItemsPre1980_shouldReturnCollectionOfMusicItemsUnder_SpecificPrice() {
        Collection<MusicItem> pre1980= catalog.getMusicItemsPre1980(12.00);
        for (MusicItem item : pre1980){
            assertTrue(item.getPrice() < 12.00);
            assertFalse(item.getPrice() > 12.00);
        }
    }

      @Test
    public void getPopItemTitles_shouldReturnListOfStrings_POPGenre() {
        List<String> test = new ArrayList<String>(Arrays.asList("Diva","Dream of the Blue Turtles", "Seal","So"));
        List<String> popItemTitles = new ArrayList();
        for(String title : catalog.getPopItemTitles()){
            popItemTitles.add(title);
            }
        assertEquals(4, catalog.getPopItemTitles().size());
        assertEquals(test, catalog.getPopItemTitles());
        assertEquals(test.get(0), popItemTitles.get(0) );
        }

    @Test
    public void isAllOverTen_shouldReturnFalse_allItemsPricedOverTen() {
        assertFalse(catalog.isAllOverTen());
    }

    @Test
    public void doWeSellGenre_shouldReturnTrue_categoryFound() {
        assertTrue(catalog.doWeSellGenre(MusicCategory.POP));
    }

    @Test
    public void findSelfTitled_shouldReturnCollection() {
        Collection<MusicItem> items = catalog.findSelfTitled();
        assertEquals(2, items.size());
        for (MusicItem item : items){
            assertTrue(item.getTitle().equals(item.getArtist()));
        }
    }

    @Test
    public void findByCategory_shouldReturnPopulatedCollection_categoryNotFound() {
        Collection<MusicItem> jazzItems = catalog.findByCategory(MusicCategory.JAZZ);
        assertNotNull(jazzItems);
        assertEquals(0, jazzItems.size());
        assertTrue(jazzItems.isEmpty());
    }

    @Test
    public void findByCategory_shouldReturnPopulatedCollection_categoryFound() {
        Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.POP);
        assertEquals(4, popItems.size()); //check size of Collection

        for(MusicItem item : popItems){
            assertEquals(MusicCategory.POP, item.getMusicCategory());  //expected, actual
        }
    }

    @Test
    public void findById_shouldReturnNull_idNotFound() {
        MusicItem item = catalog.findById(101L);
        assertNull(item);
    }

    @Test
    public void findById_shouldReturnMusicItem_idFound() {
        //make the business call and pass it an id, a non-null MusicItem should come back
       MusicItem item = catalog.findById(6L);
       assertNotNull(item); //probably not necessary b/c if the next one works, it's not null
       assertEquals(6L, item.getId().longValue());  // long, long before it was long, Long
    }
}