package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    
    private Television tv;
    private Television tv2;

    @Before
    public void setUp() {
        tv = new Television();
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

    // TODO needs try catch exception for the invalids
//    @Test
//    public void changeChannel_shouldNotStoreValue_whenInvalid_lowerBound() throws InvalidChannelException {
//        tv.changeChannel(1);
//
//    }
//
//    @Test
//    public void changeChannel_shouldNotStoreValue_whenInvalid_upperBound() throws Exception {
//        tv.changeChannel(1000);
//
//    }

//    @Test
//    public void testSetVolume_shouldNotStoreValue_whenInvalid_lowerBound() {
//        tv.setVolume(-1);
//
//    }
//
//    @Test
//    public void testSetVolume_shouldNotStoreValue_whenInvalid_upperBound() {
//        tv.setVolume(101);
//
//    }
}