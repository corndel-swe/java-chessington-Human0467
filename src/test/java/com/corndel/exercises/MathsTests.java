package com.corndel.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathsTests {
    @Test
    public void PIholdsCorrectValue() {
        assertEquals(3.14, Maths.PI);
    }

    @Test
    public void MaxReturnsLargestNumber() {
        assertEquals(10, Maths.max(10, 8));
    }

    @Test
    public void MaxWorksWhenLargestNumberSecond(){
        assertEquals(10, Maths.max(8, 10));
        assertEquals(10, Maths.max(10,8));
    }

    @Test
    public void MaxReturnsNumberWhenBothEqual(){
        assertEquals(6.5, Maths.max(6.5, 6.5));
    }

    @Test
    public void RoundReturnsSameNumberWhenGivenWhole(){
        assertEquals(6.0, Maths.round(6.0));
    }

    @Test
    public void RoundsDownCorrectly(){
        assertEquals(10.0, Maths.round(10.346));
    }

    @Test
    public void RoundsUpCorrectly(){
        assertEquals(1.0, Maths.round(0.50001));
    }

    @Test
    public void FloorReturnsSameNumberWhenGivenWholeNumber(){
        assertEquals(14.0, Maths.floor(14.0));
    }

    @Test
    public void FloorReturnsCorrectNumberWhenGivenDecimal(){
        assertEquals(3.0, Maths.floor(3.4));
        assertEquals(3.0, Maths.floor(3.6));
    }

    @Test
    public void FloorHandlesNegatives(){
        assertEquals(-4.0, Maths.floor(-3.16));
    }

    @Test
    public void FloorHandlesNegativeNumbers(){
        assertEquals(-7.0, Maths.floor(-7.17638));
    }

    @Test
    public void CeilReturnsSameNumberWhenGivenWhole(){
        assertEquals(1.0, Maths.ceil(1.0));
    }

    @Test
    public void CeilReturnsCorrectNumberWhenGivenDecimal(){
        assertEquals(8.0, Maths.ceil(7.1));
    }

    @Test
    public void CeilHandlesNegatives(){
        assertEquals(-7, Maths.ceil(-7.6));
    }
}