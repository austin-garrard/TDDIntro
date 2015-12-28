package com.thoughtworks.tddintro.rover2;


import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GridMapTest {


    @Test
    public void shouldStoreBoundaries() {
        GridMap map = new GridMap(100, 80);
        assertThat(map.getXMax(), is(100));
        assertThat(map.getYMax(), is(80));
    }
}
