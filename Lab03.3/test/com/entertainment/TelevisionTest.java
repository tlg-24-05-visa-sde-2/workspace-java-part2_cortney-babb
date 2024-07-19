package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static com.entertainment.Television.MAX_CHANNEL;
import static com.entertainment.Television.MIN_CHANNEL;
import static org.junit.Assert.*;

public class TelevisionTest {
    
    private Television tv;
    private Television tv2;

    @Before
    public void setUp() {
        tv = new Television("Sony", 50, DisplayType.PLASMA);
        tv2 = new Television("Sony", 50, DisplayType.PLASMA);
    }

    @Test
    public void testSetVolume_shouldStoreValue_whenValid_lowerBound() {
        tv.setVolume(0);
        assertEquals(0, tv.getVolume());
    }

    @Test
    public void testSetVolume_shouldStoreValue_whenValid_upperBound() {
        tv.setVolume(100);
        assertEquals(100, tv.getVolume());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws InvalidChannelException {
        tv.changeChannel(1);
        assertEquals(1, tv.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_upperBound() throws InvalidChannelException {
        tv.changeChannel(999);
        assertEquals(999, tv.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_lowerBound() {
        try {
            tv.changeChannel(0);
            fail("Should have thrown InvalidChannelException");
        } catch (InvalidChannelException e) {
            String expectedMsg = "Invalid channel: 0. Allowed range: [1,999].";
            assertEquals(expectedMsg, e.getMessage());
        }
    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_upperBound() {
        try {
            tv.changeChannel(1000);
            fail("Should have thrown InvalidChannelException");
        } catch (InvalidChannelException e) {
            String expectedMsg = "Invalid channel: 1000. Allowed range: [1,999].";
            assertEquals(expectedMsg, e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_lowerBound() {
        tv.setVolume(-1); //should throw an exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_upperBound() {
        tv.setVolume(101); //should throw an exception
    }

    @Test
    public void Hashcode_shouldBeEqual() {
        assertEquals(tv.hashCode(), tv2.hashCode());
    }

    @Test
    public void equals_shouldBeTrue() {
        assertEquals(tv, tv2);
    }

    @Test
    public void equals_shouldBeFalseWhen_differentBrand_sameVolume_sameDisplay() {
        tv2.setBrand("LG");
        assertNotEquals(tv, tv2);
    }

    @Test
    public void equals_shouldBeFalseWhen_sameBrand_differentVolume_sameDisplay() {
        tv2.setVolume(99);
        assertNotEquals(tv, tv2);
    }

    @Test
    public void equals_shouldBeFalseWhen_sameBrand_sameVolume_differentDisplay() {
        tv2.setDisplay(DisplayType.LED);
        assertNotEquals(tv, tv2);
    }

    @Test
    public void thisTelevisionBrand_shouldEqual_OtherTelevisionBrand_usingCompareTo() {
        assertEquals(tv.getBrand(), tv2.getBrand());
    }

}