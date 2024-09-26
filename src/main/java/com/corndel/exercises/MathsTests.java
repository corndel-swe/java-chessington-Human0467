package com.corndel.exercises;

import com.corndel.exercises.Maths;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathsTests {
    @Test
    public void testPIholdsCorrectValue() {
        assertEquals(3.14, Maths.PI);
    }
}