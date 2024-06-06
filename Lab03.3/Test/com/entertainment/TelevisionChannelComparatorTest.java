package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
    //you need 3 things in the fixutre
    //tv1
    //tv2
    //a comparator
    Television tv1;
    Television tv2;
    TelevisionChannelComparator channelComparator;

    @Before
    public void setUp() {
        tv1 = new Television("Sony", 12, DisplayType.LED);
        tv2 = new Television("Sony", 12, DisplayType.LED);
        channelComparator = new TelevisionChannelComparator();
    }

    @Test
    public void televisionChannelComparator() {
        assertEquals(0, channelComparator.compare(tv1, tv2));
    }

    //do 2 more cases- 1 with tv1 greater than tvb and the reverse

}