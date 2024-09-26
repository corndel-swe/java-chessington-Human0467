package com.corndel.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathsTests {
    @Test
    public void testPIholdsCorrectValue() {
        assertEquals(3.14, Maths.PI);
    }

    @Test
    public void maxReturnsLargestNumber() {
        assertEquals(10, Maths.max(10, 8));
    }

    @Test
    public void maxWorksWhenLargestNumberSecond(){
        assertEquals(10, Maths.max(8, 10));
        assertEquals(10, Maths.max(10,8));
    }

    @Test
    public void maxReturnsNumberWhenBothEqual(){
        assertEquals(6.5, Maths.max(6.5, 6.5));
    }

    @Test
    public void roundReturnsSameNumberWhenGivenWhole(){
        assertEquals(6.0, Maths.round(6.0));
    }

    @Test
    public void roundsDownCorrectly(){
        assertEquals(10.0, Maths.round(10.346));
    }

    @Test
    public void roundsUpCorrectly(){
        assertEquals(1.0, Maths.round(0.50001));
    }

}