package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
    // need 3 things here:
    // 2 television objects (tv & tv2) private fields
    // and also independent agent, comparator object
    // tv has a channel of 3 (default)
    // tv2 has a channel of 4
    private Television tv;
    private Television tv2;
    private TelevisionChannelComparator comparator;

    @Before
    public void setUp() {
        comparator = new TelevisionChannelComparator();
        tv = new Television();
        tv2 = new Television();
    }

    @Test
    public void comparator_ShouldReturnZero_sameChannelsEqual() {
        int result = comparator.compare(tv, tv2);
        assertEquals(0, result);
    }

    @Test
    public void comparator_ShouldReturnPositive_currentChannelsNotEqual_firstGreaterThanSecond() throws Exception {
        tv.changeChannel(999);
        int result = comparator.compare(tv, tv2);
        assertTrue(result > 0);
    }

    @Test
    public void comparator_ShouldReturnNegative_currentChannelsNotEqual_firstLessThanSecond() {
        try {
            tv.changeChannel(-1);
            fail("Expected InvalidChannelException was not thrown");
        } catch (InvalidChannelException e) {
            String expectedMsg = "Invalid channel: -1. Allowed range: [1,999].";
            assertEquals(expectedMsg, e.getMessage());
        }
    }


}