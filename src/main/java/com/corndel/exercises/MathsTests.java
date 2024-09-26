package com.corndel.exercises;

import com.corndel.exercises.Maths;
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
}