package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() {
        tv1 = new Television("Sony", 12, DisplayType.LED);
        tv2 = new Television("Sony", 12, DisplayType.LED);
    }

    /*
     *BVT:
     * volume - check lowerBound invalid, lowerBound valid, upperBound valid, upperBound invalid
     * You need to check -1,0 and 100, 101;
     * channel
     * 0,1 and 999,1000
     */

    //equals cases - brand, volume, display

    @Test
    public void testHashCode_shouldReturnFalse_differentObjects() {
        tv2.setVolume(11);
        assertNotEquals(tv1.hashCode(),tv2.hashCode());
    }

    @Test
    public void testHashCode_shouldTrue_hashCodes_equalObjects() {
        assertEquals(tv1.hashCode(),tv2.hashCode());
    }

    @Test
    public void equalsTo_shouldReturnFalse_differentBrand_sameVolume_sameDisplay() {
        tv2.setBrand("DIFFERENT");
        assertNotEquals(tv1,tv2);
    }

    @Test
    public void equalsTo_shouldReturnFalse_sameBrand_differentVolume_sameDisplay() {
        tv2.setVolume(10);
        assertNotEquals(tv1,tv2);
    }

    @Test
    public void equalsTo_shouldReturnFalse_sameBrand_sameVolume_differentDisplay() {
        tv2.setDisplay(DisplayType.OLED);
        assertNotEquals(tv1,tv2);
    }

    @Test
    public void equalsTo_shouldReturnTrue_allPropertiesSame() {
        assertEquals(tv1,tv2 );
    }

    @Test
    public void compareTo_shouldReturnPositiveNumber_WhenTv1BrandGreaterBrand(){
        tv1.setBrand("B_greaterThan");
        tv2.setBrand("A_lessThan");
       assertTrue(tv1.compareTo(tv2)>0);
    }
    @Test
    public void compareTo_shouldReturnNegativeNumber_WhenTv2BrandGreaterThanTv2(){
        tv1.setBrand("A_lessThan");
        tv2.setBrand("B_greaterThan");
        assertTrue(tv1.compareTo(tv2)<0);
    }

    @Test
    public void compareTo_shouldReturnZero_sameBrand() {
        tv1.setBrand("Sony");
        tv2.setBrand("Sony");
        assertEquals(0, tv1.compareTo(tv2));
    }

    @Test
    public void changeChannel_shouldStoreValue_validInput_upperBound() throws InvalidChannelException {
        tv1.changeChannel(999);
        assertEquals(999, tv1.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreValue_validInput_lowerBound() throws InvalidChannelException {
        tv1.changeChannel(1);
        assertEquals(1, tv1.getCurrentChannel());
    }

    @Test(expected=InvalidChannelException.class) //write throws InvalidChannelException b/c it's a checked exception
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_lowerBound() throws InvalidChannelException {
        tv1.changeChannel(0);
        fail("Should have thrown IllegalArgumentException");
    }
    @Test(expected=InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_upperBound() throws InvalidChannelException {
        tv1.changeChannel(1000);
    }

    @Test //write throws InvalidChannelException b/c it's a checked exception
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_lowerBound2() throws InvalidChannelException {
        try {
            tv1.changeChannel(0);
        } catch (InvalidChannelException e) {
            assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
        }
    }
    @Test
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_upperBound2() throws InvalidChannelException {
        try {
            tv1.changeChannel(1000);
        } catch (InvalidChannelException e) {
            assertEquals("Invalid channel: 1000. Allowed range: [1,999].", e.getMessage());
        }
    }


    @Test(expected=IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_upperBound() {
        tv1.setVolume(101);
    }

    @Test(expected=IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_lowerBound() {
        tv1.setVolume(-1);
    }

    @Test
    public void setVolume_shouldStoreValue_validInput_lowerBound() {
        tv1.setVolume(0);
        assertEquals(0, tv1.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_validInput_upperBound() {

        tv1.setVolume(100);
        assertEquals(100, tv1.getVolume());
    }
}