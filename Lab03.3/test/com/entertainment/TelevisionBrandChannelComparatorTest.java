package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionBrandChannelComparatorTest {
    private Television tv;
    private Television tv2;
    private TelevisionBrandChannelComparator comparator;

    @Before
    public void setUp() {
        comparator = new TelevisionBrandChannelComparator();
        tv = new Television();
        tv2 = new Television();
    }

    @Test
    public void comparator_ShouldReturnZero_sameBrand_sameChannel_() {
        int result = comparator.compare(tv, tv2);
        assertEquals(0, result);
    }
}